#!/bin/bash

to=$1
provisioningTo=$2
cont=$3
shift 3

# Bound create/start together. On cancellation the shell cannot issue a late start;
# a create still finishing in Docker can only leave a stopped container.
sudo timeout -s KILL "$provisioningTo" sh -c '
    cont=$1
    shift
    docker create --name "$cont" --cpus=0.5 --memory=150m "$@" >/dev/null &&
    exec docker start "$cont" >/dev/null
' sh "$cont" "$@" >/dev/null 2>&1
status=$?
if [ "$status" -ne 0 ]; then
    echo "Runner provisioning failed or timed out (limit $provisioningTo)." >&2
    status=125
else
    # The execution budget begins only after the runner has started.
    sudo timeout -s KILL "$to" docker wait "$cont" >/dev/null 2>&1
    status=$?
    case "$status" in
        124|137) status=124 ;;
        0) ;;
        *) echo "Unable to wait for execution runner." >&2 ;;
    esac
fi

# Force removal stops a timed-out runner. Bound cleanup too, so a stuck Docker
# cannot hang the response. Without confirmation, Node retains the output.
if sudo timeout -s KILL 5s docker rm -f "$cont" >/dev/null 2>&1; then
    echo removed
else
    echo "Unable to confirm runner removal; output retained." >&2
    if [ "$status" -eq 0 ]; then status=125; fi
fi
exit "$status"
