function existSCookie(name) {
    return document.cookie.match('(^|;)\\s*' + name + '\\s*=\\s*([^;]+)')
}

function setCookieBeforeClose(mode){
    if (mode=="on"){
        window.onbeforeunload = function(){ 
            //set timed cookies before the next appearance of the survey
            if(window.randomSurveyRoll != 1){
                setSurveyCookie(60)
            }
            else if (notToday){
                setSurveyCookie(1);
            }
            else if (clickedForMoreSurvey == false && clickedStartSurvey == false){ // ignored survey message
                setSurveyCookie(15);
            }
            else if (clickedForMoreSurvey == true && clickedStartSurvey == false){ // checked out RecruitementMessage only
                setSurveyCookie(30);
            }
            else {
                setSurveyCookie(60)
            }
        };
    }
    else{
        window.onbeforeunload = function(){};
    }
}

function groupHideToday(){
    hideRecruitementMessage();
    if (document.getElementById("surveyMessage")!=null){
        document.getElementById("mainSurveySpan").removeChild(document.getElementById("surveyMessage"));
        document.getElementById("mainSurveySpan").removeChild(document.getElementById("surveyExtra"));
    }
    notToday=true;
}

// ##########
// MAIN
// ##########

// checks if Recruitment Message has been seen
var clickedForMoreSurvey = false;
// checks if user followed survey URL
var clickedStartSurvey = false;

// ensures survey message has been displayed
var displayedText=false;
var notToday=false;
var timeSurveyUp = false;

// confirm user hasn't completed any survey, is past the 15-/30-/60-day probation period (allocated onbeforeunload)
if (existSCookie("surveyCookie") == null && window.surveyData!=null){
    if (window.randomSurveyRoll == 1){ // rolled 1 in umple.php file
        // ensure user has not completed this survey yet by comparing URLs
        var surveySeen = window.localStorage.getItem("surveyShown");
        if (surveySeen == null || surveySeen != window.surveyData.SurveyURL){
            if (timeSurvey) // clear any loading setTimeout function
                clearTimeout(timeSurvey);
            // set delay for MinutesBeforePrompt
            var timeSurvey = setTimeout(function(){timeSurveyUp = true;}, window.surveyData.MinutesBeforePrompt*60*1000);
            timeSurvey;
            //count number of edits made to page
            var beforeInstance = TabControl.getCurrentHistory().currentIndex;
            if (!displayedText){
                document.addEventListener("mouseover", function(){
                    if (TabControl.getCurrentHistory().currentIndex-beforeInstance > window.surveyData.EditsBeforePrompt && !displayedText && timeSurveyUp){
                        displaySurvey();
                        this.removeEventListener('mouseover', arguments.callee);
                    }                        
                });
            }
        }
    }
    setCookieBeforeClose("on");
}

function setSurveyCookie(days){
    let currentTime=new Date(Date.now() + days*24*60*60*1000);
    document.cookie="surveyCookie=done; expires="+currentTime.toUTCString()+"; path=/;";
}

// creates text nodes for survey message
function displaySurvey(){
    displayedText = true;
    var surveyArea = document.getElementById("mainSurveySpan");

    if (!surveyArea.contains(document.getElementById("surveyMessage"))){
        //creating space for InvitationalMessage
        var surveyMessage = document.createElement("span");
        surveyMessage.innerHTML='<span><a href="'+window.surveyData.SurveyURL+'" target="umplesurvey" onmouseover="showRecruitementMessage()">'+window.surveyData.InvitationalMessage+'</a></span><br/>';
        surveyMessage.id="surveyMessage";
        surveyArea.appendChild(surveyMessage);

        //creating space for RecruitementMessage
        var surveyExtra = document.createElement("span");
        surveyExtra.innerHTML=window.surveyData.RecruitmentText +'<div id="surveyPopUp"><span class="linkToSurvey" onclick="countClicked()"><a href="'+window.surveyData.SurveyURL+'" target="umplesurvey"class="linkToSurvey">Start Survey</a></span><span onclick="groupHideToday()" class="linkToNotSurvey">Not Today</span></div>';
        surveyExtra.id="surveyExtra";
        surveyArea.appendChild(surveyExtra);

        surveyExtra.addEventListener("mouseleave", function(){hideRecruitementMessage()});
        surveyMessage.addEventListener("click", function(){countClicked()});

        sendToSurveyLog("SurveyRequested");
    }
}

// Show/Hide Functions

function showRecruitementMessage(){
    clickedForMoreSurvey = true;
    if (!document.getElementById('surveyExtra').classList.contains("fade-in")){
        document.getElementById('surveyExtra').classList.remove("fade-outInst");
        document.getElementById('surveyExtra').classList.add("fade-in");
    }
}

function hideRecruitementMessage(){
    if (!document.getElementById('surveyExtra').classList.contains("fade-outInst")){
        document.getElementById('surveyExtra').classList.remove("fade-in");
        document.getElementById('surveyExtra').classList.add("fade-outInst");
    }
}

// confirms user has accessed survey URL
function countClicked(){
    window.localStorage.setItem("surveyShown", window.surveyData.surveyURL);
    clickedStartSurvey = true;

    sendToSurveyLog("SurveyClicked");
}

function sendToSurveyLog(action){ // action is either SurveyRequested or SurveyClicked
    console.log("processing");
    let recordTime=new Date(Date.now()).toString();
    if (action=="SurveyRequested"){
        jQuery.ajax({
            url: 'umple.php',
            method: 'POST',
            data: {surveyLogInfo: "\n"+action+" "+recordTime},
            dataType: 'html',
        }).done(function(){
            console.log("Success: Files sent!");
        }).fail(function(){
            console.log("An error occurred, the files couldn't be sent!");
        });
    }
    if(action=="SurveyClicked"){
        jQuery.ajax({
            url: 'umple.php',
            method: 'POST',
            data: {surveyLogInfo2: "\n"+action+" "+recordTime},
            dataType: 'html',
        }).done(function(){
            console.log("Success: Files sent!");
        }).fail(function(){
            console.log("An error occurred, the files couldn't be sent!");
        });
    }
}