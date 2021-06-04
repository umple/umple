function existSCookie(name) {
    return document.cookie.match('(^|;)\\s*' + name + '\\s*=\\s*([^;]+)')
}

// checks if Recruitment Message has been seen
var clickedForMoreSurvey = false;
// checks if user followed survey URL
var clickedStartSurvey = false;

// ensures survey message has been displayed
var displayedText=false;

// confirm user hasn't completed any survey, is past the 15-/30-/60-day probation period (allocated onbeforeunload)
if (existSCookie("surveyCookie") == null && window.surveyData!=null){
    if (existSCookie("surveyPass") != null){ // if survey pass has been activated (by reload + "sp" + reload cmd)
        console.log("found survey pass");
        window.surveyData.MinutesBeforePrompt = 0.03;
        window.surveyData.EditsBeforePrompt = 1;
        displayText=false;
    }
    console.log("randomRoll: "+window.randomSurveyRoll);
    if (window.randomSurveyRoll == 1){ // rolled 1 in umple.php file
        // ensure user has not completed this survey yet by comparing URLs
        var surveySeen = window.localStorage.getItem("surveyShown");
        if (surveySeen == null || surveySeen != window.surveyData.SurveyURL){
            if (timeSurvey) // clear any loading setTimeout function
                clearTimeout(timeSurvey);
            console.log("wait "+window.surveyData.MinutesBeforePrompt+" mins");
            console.log("complete "+window.surveyData.EditsBeforePrompt+" edits");
            // set delay for MinutesBeforePrompt
            var timeSurveyUp = false;
            var timeSurvey = setTimeout(function(){timeSurveyUp = true;}, window.surveyData.MinutesBeforePrompt*60*1000);
            timeSurvey;
            //count number of edits made to page
            var beforeInstance = TabControl.getCurrentHistory().currentIndex;
            if (!displayedText){
                document.addEventListener("mouseover", function(){
                    console.log(TabControl.getCurrentHistory().currentIndex);
                    if (TabControl.getCurrentHistory().currentIndex-beforeInstance >= window.surveyData.EditsBeforePrompt && !displayedText && timeSurveyUp){
                        clearTimeout(timeSurvey);
                        displaySurvey();
                    }
                })
            }
        }
    }

    window.onbeforeunload = function(){ 
        //set timed cookies before the next appearance of the survey
        if (existSCookie("surveyPass") != null){ /*set nothing...*/ }
        else if(window.randomSurveyRoll != 1){
            setSurveyCookie(60)
        }
        else if (clickedForMoreSurvey == false && clickedStartSurvey == false){ // ignored survey message
            setSurveyCookie(15)
        }
        else if (clickedForMoreSurvey == true && clickedStartSurvey == false){ // checked out RecruitementMessage only
            setSurveyCookie(30);
        }
        else {
            setSurveyCookie(60)
        }
    };
}


function setSurveyCookie(days){
    let currentTime=new Date(Date.now() + days*24*60*60*1000);
    document.cookie="surveyCookie=done; expires="+currentTime.toUTCString()+"; path=/;";
}

// creates text nodes for survey message
function displaySurvey(){
    displayedText = true;
    var surveyArea = document.getElementById("mainSurveySpan");

    //creating space for InvitationalMessage
    var surveyMessage = document.createElement("span");
    surveyMessage.innerHTML='<span><a href="'+window.surveyData.SurveyURL+'" target="umplesurvey" onmouseover="showRecruitementMessage()">'+window.surveyData.InvitationalMessage+'</a></span><br/>';
    surveyMessage.id="surveyMessage";
    surveyArea.appendChild(surveyMessage);

    //creating space for RecruitementMessage
    var surveyExtra = document.createElement("span");
    surveyExtra.innerHTML=window.surveyData.RecruitmentText +'<div id="surveyPopUp"><span class="linkToSurvey"><a href="'+window.surveyData.SurveyURL+'" target="umplesurvey"class="linkToSurvey">Start Survey</a></span><span onclick="hideRecruitementMessage()" class="linkToNotSurvey">Not Today</span></div>';
    surveyExtra.id="surveyExtra";
    surveyArea.appendChild(surveyExtra);

    surveyExtra.addEventListener("mouseleave", function(){hideRecruitementMessage()});
    //surveyExtra.addEventListener("mouseover", function(){showRecruitementMessage()});
    surveyExtra.addEventListener("click", function(){countClicked()});
    surveyMessage.addEventListener("click", function(){countClicked()});
}

// Show/Hide Functions

function showRecruitementMessage(){
    clickedForMoreSurvey = true;
    if (!document.getElementById('surveyExtra').classList.contains("fade-in")){
        document.getElementById('surveyExtra').classList.remove("fade-outInst");
        document.getElementById('surveyExtra').classList.add("fade-in");
        hideWithDelay = setTimeout(function(){hideRecruitementMessage()}, calculateDelay());
        hideWithDelay;
    }
}

function hideRecruitementMessage(){
    clearTimeout(hideWithDelay);
    if (!document.getElementById('surveyExtra').classList.contains("fade-outInst")){
        document.getElementById('surveyExtra').classList.remove("fade-in");
        document.getElementById('surveyExtra').classList.add("fade-outInst");
    }
}

// confirms user has accessed survey URL
function countClicked(){
    if (existSCookie("surveyPass") == null)
        window.localStorage.setItem("surveyShown", window.surveyData.surveyURL);
    clickedStartSurvey = true;
}

function calculateDelay(){ // 5s + 1s/3words + 5s (iff link exists)
    sectionHtml=document.getElementById('surveyExtra').innerHTML;
    sectionText=document.getElementById('surveyExtra').textContent;

    if (sectionText==null){
        return null;
    }
    if (sectionText.length==0){
        return 0;
    }

    let sum=5;

    //counting words
    var rem=sectionText;
    rem=rem.replace(/\r?\n|\r/g, "");
    var wordCount=rem.split(" ").length;

    sum += Math.ceil((wordCount-5)/3);

    if (sectionHtml.indexOf("href")>=0){
        sum += 5;
    }

    return sum*1000;
}