// =========================================
// Tip Information Gatherers
// =========================================

var firstTime = localStorage.getItem("first_time");
if(!firstTime) {
    localStorage.setItem('tipCount',0);
    localStorage.setItem('priorityCount',0);

    //acquiring tipInformation
    var allInfo;
    var fileNames = ["../build/reference/6600ImportantTips","../build/reference/6601SecondaryTips", "../build/reference/6602TertiaryTips"];
    
    for (let files=0; files<fileNames.length; files++){
        var request = new XMLHttpRequest();
        request.onload = function () {
            allInfo=this.responseText;
            allInfo=allInfo.split("<h2>");
            var descrpt=[];
            for (let i=0; i<allInfo.length; i++){
                var t=[];
                t.push(allInfo[i].substring(0, allInfo[i].indexOf("</h2>")));
                t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length-1)+'<span style="float: right; padding-right: 10px; display:block;"><a href="https://cruise.umple.org/umple/'+fileNames[files]+'" style="color:#4d4d4d; text-align:right; text-decoration:none;"><em>View All Tips</em></a></span>');
                descrpt.push(t);
            }
            localStorage.setItem('tipInfo'+files, JSON.stringify(descrpt)); //adding items to local storage

        };
        request.open('GET', fileNames[files]);
        request.send();
    }
        
    //display tip
    localStorage.setItem("first_time","1");
}

// =========================================
// Tip Pickers
// =========================================

window.addEventListener('load', function () {
    var priority=this.localStorage.getItem('priorityCount');
    var tip = JSON.parse(localStorage.getItem('tipInfo'+priority));
    var num = parseInt(localStorage.getItem('tipCount'));

    document.getElementById('styleTip').innerHTML = "Tip: "+tip[num+1][0] + ' <span onclick="showExtra()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more</span>';
    document.getElementById('extraInfo').innerHTML = tip[num+1][1] + '<script src="tips/tipDisplay.js"> </script>';
    if (num+2>=tip.length){
        if (parseInt(priority)+1>3) //loops over infinitely
            this.localStorage.setItem('priorityCount', '0');
        else this.localStorage.setItem('priorityCount', parseInt(priority)+1);
        localStorage.setItem('tipCount',0);
    }
    else{
        localStorage.setItem('tipCount',num+1);
    }
})

// =========================================
// Hover Functions
// =========================================

var extraTip = document.getElementById('extraInfo');

function showExtra(){
    extraTip.classList.remove("fade-outInst");
    extraTip.classList.add("fade-in");
    setTimeout(function(){hideExtra();}, 8000);
}

function hideExtra(){
    extraTip.classList.remove("fade-in");
    extraTip.classList.add("fade-outInst");
}

//ensuring document returns to original location
var loc=document.location;
document.location=loc.prototype.substring(0,loc.length-21);
