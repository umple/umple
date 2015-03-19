#!/bin/bash
# -------------------------------------------------------------------------------------
# Usage: 
#   1. Download a set of projects using dlproj (https://github.com/umple-ucosp/dlproj)
#   2. Build the Umplificator jar (from the main Umple project)
#     * ant -Dmyenv=local -f build.umple.xml build-umplificator
#   3. Start the script with two positional arguments, the first is the path
#      to the built umplificator, and the second is the path the to projects directory
#     * e.g. umplificator_all_prjects.sh ~/umplificator.jar ~/project_dir
#
# -------------------------------------------------------------------------------------

# Grab script arguments: umplificator script path, (optional) root directory
umplificator=$1
if [[ ! -z "$2" ]]; then
        rootdir=$2
else
        rootdir="."
fi

# Crawl the directory and build a list of projects to umplify
to_umplify=()
for org_dir in $rootdir/*; do
        if test -d $org_dir; then
                for proj_dir in $org_dir/*; do
                        for ver_dir in $proj_dir/*; do
                                # Only add projects that haven't already been tried by the umplificator
                                if ! test -e $ver_dir/*.Umplify.Score; then
                                        to_umplify+=($ver_dir/src)
                                fi
                        done
                done
        fi
done

# Umplify all projects
for dir in "${to_umplify[@]}"; do

        touch $dir/P.umplify.score

        # Try level 0
        java -jar $umplificator -level=0 -dir -path=$dir/umple_output $dir
        if [ $? -eq 0 ]; then 
                touch $dir/0.umplify.score
        else 
                touch $dir/F.umplify.score
                rm $dir/P.umplify.score
                continue
        fi

        # Try level 1
        java -jar $umplificator -level=1 -dir -path=$dir/umple_output $dir 
        if [ $? -eq 0 ]; then 
                touch $dir/1.umplify.score
        else 
                rm $dir/P.umplify.score
                continue
        fi

        # Try level 2
        java -jar $umplificator -level=2 -dir -path=$dir/umple_output $dir
        if [ $? -eq 0 ]; then 
                touch $dir/2.umplify.score
        else 
                rm $dir/P.umplify.score
                continue
        fi
done
