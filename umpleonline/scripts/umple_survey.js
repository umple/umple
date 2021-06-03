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
    }

    if (window.randomSurveyRoll == 1){ // rolled 1 in umple.php file
        console.log("displaying...");
        // ensure user has not completed this survey yet by comparing URLs
        var surveySeen = window.localStorage.getItem("surveyShown");
        if (surveySeen == null || surveySeen != window.surveyData.SurveyURL){
            if (timeSurvey) // clear any loading setTimeout function
                clearTimeout(timeSurvey);
            console.log("wait "+window.surveyData.MinutesBeforePrompt+" mins");
            // set delay for MinutesBeforePrompt
            var timeSurvey = setTimeout(function(){if (!displayedText) displaySurvey()}, window.surveyData.MinutesBeforePrompt*60*1000);
            timeSurvey;
            //count number of edits made to page
            var beforeInstance = TabControl.getCurrentHistory().currentIndex;
            document.addEventListener("mouseover", function(){
                if (TabControl.getCurrentHistory().currentIndex-beforeInstance == window.surveyData.EditsBeforePrompt && !displayedText){
                    clearTimeout(timeSurvey);
                    displaySurvey();
                }
            })
        }
    }

    window.onbeforeunload = function(){ 
        //set timed cookies before the next appearance of the survey
        if (existSCookie("surveyPass") != null){ /*set nothing...*/ }
        else if(window.randomSurveyRoll != 1){
            console.log("set cookie for: 60 days");
            setSurveyCookie(60)
        }
        else if (clickedForMoreSurvey == false && clickedStartSurvey == false){ // ignored survey message
            console.log("set cookie for: 15 days");
            setSurveyCookie(15)
        }
        else if (clickedForMoreSurvey == true && clickedStartSurvey == false){ // checked out RecruitementMessage only
            console.log("set cookie for: 30 days");
            setSurveyCookie(30);
        }
        else {
            console.log("set cookie for: 60 days");
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
    surveyMessage.innerHTML='<span><a onmouseover="showRecruitementMessage()" onclick="countClicked() href="'+surveyData.SurveyURL+'" target="umplesurvey">'+surveyData.InvitationalMessage+'</a></span><br/>';
    surveyMessage.id="surveyMessage";
    surveyArea.appendChild(surveyMessage);

    //creating space for RecruitementMessage
    var surveyExtra = document.createElement("span");
    surveyExtra.innerHTML=surveyData.RecruitmentText +'<div style="text-align:center;"><a href="'+surveyData.SurveyURL+'" target="umplesurvey" style=" cursor: pointer; color: blue; text-decoration: underline;" onclick="countClicked()">Start Survey<br/></span></div>';
    surveyExtra.id="surveyExtra";
    surveyArea.appendChild(surveyExtra);

    surveyExtra.addEventListener("mouseleave", function(){hideRecruitementMessage()});
    surveyExtra.addEventListener("mouseover", function(){showRecruitementMessage()});
    console.log("done");
}

// Show/Hide Functions

function showRecruitementMessage(){
    clickedForMoreSurvey = true;
    document.getElementById('surveyExtra').classList.remove("fade-outInst");
    document.getElementById('surveyExtra').classList.add("fade-in");
    hideWithDelay = setTimeout(function(){hideRecruitementMessage()}, calculateDelay());
    hideWithDelay;
}

function hideRecruitementMessage(){
    clearTimeout(hideWithDelay);
    document.getElementById('surveyExtra').classList.remove("fade-in");
    document.getElementById('surveyExtra').classList.add("fade-outInst");
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