
var existCookie = document.cookie.match(/^(.*;)?\s*tipCookie\s*=\s*[^;]+(.*)?$/);
var htmlNames = ["Importanttips.html","Secondarytips.html","Tertiarytips.html"];
var fileNames = ["https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6600ImportantTips.txt","https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6601SecondaryTips.txt", "https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6602TertiaryTips.txt"];


if (existCookie==null){
    // =========================================
    // Tip Information Gatherers
    // =========================================

    var firstTime = localStorage.getItem("first_time");
    if(!firstTime) {
        localStorage.setItem('tipCount',0);
        localStorage.setItem('priorityCount',0);
        
        //acquiring tipInformation
        for (let files=0; files<fileNames.length; files++){
            var request = new XMLHttpRequest();
            request.onreadystatechange = function () {
                if (this.readyState=4 && this.status==200){
                    allInfo=this.responseText;
                    allInfo=allInfo.split("<h2>");
                    var descrpt=[];
                    for (let i=0; i<allInfo.length; i++){
                        var t=[];
                        t.push(allInfo[i].substring(0, allInfo[i].indexOf("</h2>")));
                        var link="http://manual.umple.org/manual/"+htmlNames[files];
                        t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length-1)+'<span style="float: right; padding-right: 10px; display:block;"><a href='+link+' style="color:#4d4d4d; text-align:right; text-decoration:none;"><em>View All Tips</em></a></span>');
                        descrpt.push(t);
                    }
                    localStorage.setItem('tipInfo'+files, JSON.stringify(descrpt)); //adding items to local storage

                }
                
            };
            request.open('GET', fileNames[files], false);
            request.send();
        }
            
        //display tip
        localStorage.setItem("first_time","1");
    }

    // =========================================
    // Tip Pickers
    // =========================================


    var priority=this.localStorage.getItem('priorityCount');
    var tip = JSON.parse(localStorage.getItem('tipInfo'+priority));
    var num = parseInt(localStorage.getItem('tipCount'));

    if (tip!=null){
        document.getElementById('styleTip').innerHTML = "<br/>Tip: "+tip[num+1][0] + ' <span onclick="showExtra()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more</span>';
        document.getElementById('extraInfo').innerHTML = tip[num+1][1];
        if (num+2>=tip.length-1){
            if (parseInt(priority)+1>=3) //renew data
                for (let files=0; files<fileNames.length; files++){
                    var request = new XMLHttpRequest();
                    request.onreadystatechange = function () {
                        if (this.readyState=4 && this.status==200){
                            allInfo=this.responseText;                        
                            allInfo=allInfo.split("<h2>");
                            var descrpt=[];
                            let renew=false;
                            var oldContent=JSON.parse(localStorage.getItem('tipInfo'+files));
                            for (let i=0; i<allInfo.length; i++){
                                var t=[];
                                t.push(allInfo[i].substring(0, allInfo[i].indexOf("</h2>")));
                                var link="http://manual.umple.org/manual/"+htmlNames[files];
                                t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length-1)+'<span style="float: right; padding-right: 10px; display:block;"><a href='+link+' style="color:#4d4d4d; text-align:right; text-decoration:none;"><em>View All Tips</em></a></span>');
                                if (!oldContent.includes(t)){
                                    renew=true;
                                    descrpt.push(t);
                                }
                            }
                            if (renew){
                                localStorage.setItem('tipInfo'+files, JSON.stringify(descrpt)); //adding items to local storage
                            }
                            else{
                                localStorage.setItem('tipInfo'+files, null);
                            }
                        }
                    };
                    request.open('GET', fileNames[files], false);
                    request.send();
                    this.localStorage.setItem('priorityCount', '0');
                }
                
            else this.localStorage.setItem('priorityCount', parseInt(priority)+1);
            localStorage.setItem('tipCount','0');
        }
        else{
            localStorage.setItem('tipCount',num+1);
        }
    }
    let currentTime=new Date();
    currentTime.setTime(currentTime.getTime() + (24*60*60*1000));
    document.cookie="tipCookie=done; expires="+currentTime.toUTCString()+"; path=/";
}

// =========================================
// Hover Functions
// =========================================

function showExtra(){
    document.getElementById('extraInfo').classList.remove("fade-outInst");
    document.getElementById('extraInfo').classList.add("fade-in");
    setTimeout(function(){hideExtra();}, 8000);
}

function hideExtra(){
    document.getElementById('extraInfo').classList.remove("fade-in");
    document.getElementById('extraInfo').classList.add("fade-outInst");
}