var existCookie = document.cookie.match(/^(.*;)?\s*tipCookie\s*=\s*[^;]+(.*)?$/);
var htmlNames = ["Importanttips.html","Secondarytips.html","Tertiarytips.html"];
var fileNames = ["https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6600ImportantTips.txt","https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6601SecondaryTips.txt", "https://raw.githubusercontent.com/umple/umple/Issue%231636_TOTD/build/reference/6602TertiaryTips.txt"];

if (existCookie==null){
    // =========================================
    // Tip Information Gatherers
    // =========================================
    
        var firstTime = localStorage.getItem("first_time");
        if(!firstTime) {
            window.localStorage.setItem('tipCount',0);
            window.localStorage.setItem('priorityCount',0);
            
            //acquiring tipInformation
            for (let files=0; files<fileNames.length; files++){
                jQuery.ajax({
                    url: fileNames[files],
                    success: function(results){
                        let allInfo=results;
                        allInfo=allInfo.split("<h2>");
                        var descrpt=[];
                        for (let i=0; i<allInfo.length; i++){
                            var t=[];
                            t.push(allInfo[i].substring(0, allInfo[i].indexOf("</h2>")));
                            var link="http://manual.umple.org/manual/"+htmlNames[files];
                            t.push(allInfo[i].substring(allInfo[i].indexOf("</h2>")+6, allInfo[i].length-11)+'<span style="float: right; padding-right: 10px; display:block;"><a href='+link+' style="color:#4d4d4d; text-align:right; text-decoration:none;"><em>View All Tips</em></a></span>');
                            descrpt.push(t);
                        }
                        window.localStorage.setItem('tipInfo'+files, JSON.stringify(descrpt)); //adding items to local storage
                        },
                    error: function(response){
                        descrpt.push(["couldn't access file",error]);
                    }
                })
            }
            window.localStorage.setItem("first_time","1");
        }
    
    
    // =========================================
    // Tip Pickers
    // =========================================

    jQuery(document).ajaxStop(function() {
        var priority=window.localStorage.getItem('priorityCount');
        var tip = JSON.parse(window.localStorage.getItem('tipInfo'+priority));
        var num = parseInt(window.localStorage.getItem('tipCount'));
        
        if (tip!=null){
            document.getElementById('styleTip').innerHTML = "<br/>Tip: "+tip[num+1][0] + ' <span onclick="showExtra()" style=" cursor: pointer; color: blue; text-decoration: underline;">Click for more</span>';
            jQuery('#styleTip a').attr('target', 'helppage');
            document.getElementById('extraInfo').innerHTML = tip[num+1][1];
            jQuery('#extraInfo a').attr('target', 'helppage');
            if (num+2>=tip.length-1){
                if (parseInt(priority)+1>=3) //renew data
                    for (let files=0; files<fileNames.length; files++){
                        jQuery.ajax({
                            url: fileNames[files],
                            success: function(results){
                                let allInfo=results;
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
                                },
                            error: function(response){
                                descrpt.push(["couldn't access file","error"]);
                            }
                        })
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
        currentTime.setTime(currentTime.getTime());
        currentTime.setHours(24, 0, 0, 0);
        document.cookie="tipCookie=done; expires="+currentTime.toString()+"; path=/";
    });


}

// =========================================
// Display/Hide Functions
// =========================================

function showExtra(){
    document.getElementById('extraInfo').classList.remove("fade-outInst");
    document.getElementById('extraInfo').classList.add("fade-in");
    setTimeout(function(){hideExtra();}, 10000);
}

function hideExtra(){
    document.getElementById('extraInfo').classList.remove("fade-in");
    document.getElementById('extraInfo').classList.add("fade-outInst");
}