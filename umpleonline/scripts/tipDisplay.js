let existCookie = document.cookie.match(/^(.*;)?\s*tipCookie\s*=\s*[^;]+(.*)?$/)
var htmlNames = ["Importanttips.html","Secondarytips.html","Tertiarytips.html"];
var fileNames = ["https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6600ImportantTips.txt","https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6601SecondaryTips.txt", "https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6602TertiaryTips.txt"];

if(existCookie===null) {
    // =========================================
    // Tip Information Gatherers
    // =========================================
    
    var firstTime = localStorage.getItem("first_time");
    if(!firstTime) {
        window.localStorage.setItem('tipCount',0);
        window.localStorage.setItem('priorityCount',0);
        window.localStorage.setItem('loopCount',0);
        //acquiring tipInformation
        for (let files=0; files<fileNames.length; files++){
            jQuery.ajax({
                url: fileNames[files],
                success: function(results){
                    let allInfo=results;
                    allInfo=allInfo.split("<h2>");
                    allInfo.shift();    //removes title+descrription element
                    var descrpt=[];
                    for (let i=0; i<allInfo.length; i++){
                        var t=[];
                        t.push(allInfo[i].substring(0, allInfo[i].indexOf("</h2>")));
                        var link="https://cruise.umple.org/umple/"+htmlNames[files];
                        var navbar='<div style="padding-right: 10px; padding-left: 10px; display:flex; justify-content:space-between;"><button class="lowerBarBtn" id="goLeft" onclick="onButtonPrevious()">&laquo <em>Previous</em></button><a href="'+link+'" class="bottomNav"><em> View All </em></a><button class="lowerBarBtn" id="goRight" onclick="onButtonNext()"><em>Next</em> &raquo</button></div>';
                        if (i==allInfo.length-1){
                            t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length)+navbar);    
                        }
                        else{
                            t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length-11)+navbar);
                        }
                        descrpt.push(t);
                    }
                    var inform=[];
                    inform[0]=descrpt;
                    window.localStorage.setItem('tipInfo'+files, JSON.stringify(inform)); //adding items to local storage
                },
                error: function(response){
                    descrpt.push(["couldn't access file",error]);
                },
            });
        }
        window.localStorage.setItem("first_time","1");
    }

    // =========================================
    // Tip Pickers
    // =========================================

    jQuery(document).ajaxStop(function(){allocateMessage()});

    let currentTime=new Date();
    currentTime.setTime(currentTime.getTime());
    currentTime.setHours(24, 0, 0, 0);
    document.cookie="tipCookie=done; expires="+currentTime.toUTCString()+"; path=/";
}

function allocateMessage() {
    var priority = window.localStorage.getItem('priorityCount');
    var tip = JSON.parse(window.localStorage.getItem('tipInfo'+priority));
    var num = parseInt(window.localStorage.getItem('tipCount'));
    var loop = parseInt(window.localStorage.getItem('loopCount'));

    if (tip[loop]!=null && tip[loop][num]!=null && tip[loop][num][0]!=null && tip[loop][num][1]!=null){
        document.getElementById('styleTip').innerHTML = "Tip: "+tip[loop][num][0] + ' <span onclick="showExtra()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more<br/></span>';
        jQuery('#styleTip a').attr('target', 'helppage');
        document.getElementById('extraInfo').innerHTML = tip[loop][num][1];
        jQuery('#extraInfo a').attr('target', 'helppage');

        setForNext(num, priority, tip, loop);
    }
};

// =========================================
// Display/Hide Functions
// =========================================

function onButtonNext(){
    if (document.getElementById("goRight").style.opacity!='0'){
        hideExtra();    
        setTimeout(function(){
            allocateMessage()
        }, 800);
    }
}

function onButtonPrevious(){
    if (document.getElementById("goLeft").style.opacity!='0'){
        hideExtra();    
        setTimeout(function(){
            showPrevious()
        }, 800);
    }
}


var hideWithDelay;

function showExtra(){
    document.getElementById('extraInfo').classList.remove("fade-outInst");
    document.getElementById('extraInfo').classList.add("fade-in");
    hideWithDelay = setTimeout(function(){hideExtra()}, calculateDelay());
    hideWithDelay;
}

function hideExtra(){
    clearTimeout(hideWithDelay);
    document.getElementById('extraInfo').classList.remove("fade-in");
    document.getElementById('extraInfo').classList.add("fade-outInst");
}

function calculateDelay(){
    sectionHtml=document.getElementById('extraInfo').innerHTML;
    sectionText=document.getElementById('extraInfo').textContent;

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

    if (sectionHtml.indexOf("href")>=0 && sectionHtml.indexOf("href")<sectionHtml.indexOf("lowerBarBtn")){
        sum += 5;
    }

    return sum*1000; // get Prev, Next, View All out of count, and turn into milliseconds
}

// =========================================
// Previous/Next Manipulators
// =========================================

function setForNext(num, priority, tip, loop){
    if (priority==0 && num==0 && loop==0){
        document.getElementById("goLeft").style.opacity=0;
        document.getElementById("goLeft").style.cursor="default";
    }
    else{
        document.getElementById("goLeft").style.opacity=1;
        document.getElementById("goLeft").style.cursor="pointer";
    }

    if (num>=tip[loop].length-1){
        if (parseInt(priority)==2){ //renew data
            loop++;
            for (let files=0; files<fileNames.length; files++){
                jQuery.ajax({
                    url: fileNames[files],
                    success: function(results){
                        let allInfo=results;
                        allInfo=allInfo.split("<h2>");
                        allInfo.shift();    //removes title+descrription element
                        var descrpt=[];
                        for (let i=0; i<allInfo.length; i++){
                            var t=[];
                            t.push(allInfo[i].substring(0, allInfo[i].indexOf("</h2>")));
                            var link="https://cruise.umple.org/umple/"+htmlNames[files];
                            var navbar='<div style="padding-right: 10px; padding-left: 10px; display:flex; justify-content:space-between;"><button class="lowerBarBtn" id="goLeft" onclick="onButtonPrevious()">&laquo <em>Previous</em></button><a href="'+link+'" class="bottomNav"><em> View All </em></a><button class="lowerBarBtn" id="goRight" onclick="onButtonNext()"><em>Next</em> &raquo</button></div>';
                            if (i==allInfo.length-1){
                                t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length)+navbar);    
                            }
                            else{
                                t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length-11)+navbar);
                            }
                            var info = window.localStorage.getItem("tipInfo"+files);
                            if (info[loop-1].includes(t)<0){
                                descrpt.push(t);
                            } 
                        }
                        info.push([descrpt]);
                        window.localStorage.setItem('tipInfo'+files, JSON.stringify(info));
                        },
                    error: function(response){
                        descrpt.push(["couldn't access file",error]);
                    }
                });
            }
            
            window.localStorage.setItem('priorityCount', '0');
            window.localStorage.setItem("loopCount", loop);
        }
        else window.localStorage.setItem('priorityCount', parseInt(priority)+1);
        window.localStorage.setItem('tipCount','0');
    }
    else{
        window.localStorage.setItem('tipCount',num+1);
    }

    if (tip[loop]==null || tip[loop][num]==null || tip[loop][num][0]==null || tip[loop][num][1]==null){
        document.getElementById("goRight").style.opacity=0;
        document.getElementById("goRight").style.cursor="default";
    }
    else{
        document.getElementById("goRight").style.opacity=1;
        document.getElementById("goRight").style.cursor="pointer";
    }
}

function showPrevious(){
    var priority = window.localStorage.getItem('priorityCount');
    var tip = JSON.parse(window.localStorage.getItem('tipInfo'+priority));
    var num = parseInt(window.localStorage.getItem('tipCount'));
    var loop = parseInt(window.localStorage.getItem('loopCount'));

    if (num-2 < 0){
        if (priority-1 >= 0 && (num === 0 || num === 1)){ //no change to tip otherwise
            priority--;
            window.localStorage.setItem('priorityCount',priority);
            tip = JSON.parse(window.localStorage.getItem('tipInfo'+priority));
            if (num === 0){
                num=tip[loop].length-2;
            }
            else {
                num=tip[loop].length-1;
            }
            window.localStorage.setItem('tipCount',num);

            document.getElementById('styleTip').innerHTML = "Tip: "+tip[loop][num][0] + ' <span onclick="showExtra()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more<br/></span>';
            jQuery('#styleTip a').attr('target', 'helppage');
            document.getElementById('extraInfo').innerHTML = tip[loop][num][1];
            jQuery('#extraInfo a').attr('target', 'helppage');
            
            setForNext(num, priority, tip, loop);
        }
        else if (loop-1 >= 0 && priority == 0){ //change versions
            priority=2;
            window.localStorage.setItem('priorityCount',priority);
            tip = JSON.parse(window.localStorage.getItem('tipInfo'+priority));
            loop--;
            window.localStorage.setItem('loopCount',loop);
            
            if (num === 0){
                num=tip[loop].length-2;
            }
            else {
                num=tip[loop].length-1;
            }
            window.localStorage.setItem('tipCount',num);

            document.getElementById('styleTip').innerHTML = "Tip: "+tip[loop][num][0] + ' <span onclick="showExtra()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more<br/></span>';
            jQuery('#styleTip a').attr('target', 'helppage');
            document.getElementById('extraInfo').innerHTML = tip[loop][num][1];
            jQuery('#extraInfo a').attr('target', 'helppage');
    
            setForNext(num, priority, tip, loop);
        }
    }
    else{
        document.getElementById('extraInfo').style.visibility = 'hidden';
        document.getElementById('styleTip').innerHTML = "Tip: "+tip[loop][num-2][0] + ' <span onclick="showExtra()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more<br/></span>';
        jQuery('#styleTip a').attr('target', 'helppage');
        document.getElementById('extraInfo').innerHTML = tip[loop][num-2][1];
        jQuery('#extraInfo a').attr('target', 'helppage');
        
        window.localStorage.setItem('tipCount',num-2);

        setForNext(num-2, priority, tip, loop);
    }
}