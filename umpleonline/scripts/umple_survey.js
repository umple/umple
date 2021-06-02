function existSCookie(name) {
    return document.cookie.match('(^|;)\\s*' + name + '\\s*=\\s*([^;]+)')
}

var displayingSurvey;

var clickedForMoreSurvey;
clickedForMoreSurvey = false
var clickedStartSurvey;
clickedStartSurvey = false

var surveyData;

if (existSCookie("surveyCookie") == null){
    jQuery.ajax({
        sync: true,
        url: "ump/asurveyMessage.txt",
        success: function(data){
            surveyData = JSON.parse(data);
            //Math.random() * (max - min) + min --> number between 1 and the randomized freq: formula follows [min, max)
            //var randomRoll = Math.floor(Math.random() * ((surveyData.RandomizedFrequency+1) - 1) + 1);
            //window.randomRoll = parseInt(window.randomRoll);
            console.log("randomRoll: "+window.randomRoll);

            if (window.randomRoll == 1){
                console.log("displaying...");
                displayingSurvey = true;
                //displaySurvey();
                setTimeout(function(){displaySurvey()}, surveyData.MinutesBeforePrompt*60*1000);
            }
            else {
                console.log("cookie set for 60");
                setSurveyCookie(60);
            }

        },
        error: function(){
            console.log("cannot find file")
            console.log("cookie set for 60");
            setSurveyCookie(60);
        }
    });
}


document.addEventListener("beforeunload", function(){
    if (clickedForMoreSurvey == false && clickedStartSurvey == false){
        console.log("set cookie for: 15 days");
        setSurveyCookie(15)
    }
    else if (clickedForMoreSurvey == true && clickedStartSurvey == false){
        console.log("set cookie for: 30 days");
        setSurveyCookie(30);
    }
    else {
        console.log("set cookie for: 60 days");
        setSurveyCookie(60)
    }
})

function setSurveyCookie(days){
    let currentTime=new Date(Date.now() + days*24*60*60*1000);
    document.cookie="surveyCookie=done; expires="+currentTime.toUTCString()+"; path=/;";
}

function displaySurvey(){
    var surveyArea = document.getElementById("mainSurveySpan");
    if (surveyArea == null){
        console.log("can't locate parent");
    }

    //creating space for InvitationalMessage
    var surveyMessage = document.createElement("span");
    surveyMessage.innerHTML=surveyData.InvitationalMessage+' <span onclick="showRecruitementMessage()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more<br/></span>';
    surveyMessage.id="surveyMessage";
    jQuery('#surveyMessage a').attr('target', 'helppage');
    surveyArea.appendChild(surveyMessage);

    //creating space for RecruitementMessage
    var surveyExtra = document.createElement("span");
    surveyExtra.innerHTML=surveyData.RecruitmentText +'<div style="text-align:center;"><a href="'+surveyData.SurveyURL+'" style=" cursor: pointer; color: blue; text-decoration: underline;" onclick="countClicked()">Start Survey<br/></span></div>';
    surveyExtra.id="surveyExtra";
    jQuery('#surveyExtra a').attr('target', 'helppage');
    surveyArea.appendChild(surveyExtra);

    surveyExtra.addEventListener("mouseleave", function(){hideRecruitementMessage()});
    console.log("done");
}

// Show/Hide Functions

function showRecruitementMessage(){
    clickedForMoreSurvey = true;
    document.getElementById('surveyExtra').classList.remove("fade-outInst");
    document.getElementById('surveyExtra').classList.add("fade-in");
    hideWithDelay = setTimeout(function(){hideExtra()}, calculateDelay());
    hideWithDelay;
}

function hideRecruitementMessage(){
    clearTimeout(hideWithDelay);
    document.getElementById('surveyExtra').classList.remove("fade-in");
    document.getElementById('surveyExtra').classList.add("fade-outInst");
}

function countClicked(){
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