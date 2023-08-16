<?php
function pushUpdates($directoryName, $userSessionID){
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL,"{$GLOBALS['EXECUTION_SERVER']}/collab");
    curl_setopt($ch, CURLOPT_POST, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, "directory={$directoryName}&userID={$userSessionID}&operation={'pushUpdates'}");
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    $content = curl_exec($ch);
    if (curl_errno($ch)) {
        $error_msg = curl_error($ch);
    }
    curl_close($ch);

    if (isset($error_msg)) {
    return "Issue with Pushing Collab Updates.\n".$error_msg;
    } else {
        return $content;
    }
}
?>