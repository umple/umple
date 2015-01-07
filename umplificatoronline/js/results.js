/*
 * Copyright (c) 2014 Jeremy S. Bradbury, Joseph Heron
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/* The root URL for REST api */
var rootURL = "http://git_data.dom/api";

$(document).ready(function () {
    /* Display the election results when page is loaded */
    
    if (checkIfGraphPage())
    {
        $('#commit_info_panel').hide();
        allCommits();
        plotSelectedValues();
    }
});

function checkIfGraphPage()
{
    if (window.location.pathname.match(/^\/index\.php$/) || window.location.pathname.match(/^\/$/))
    {
        return true;
    }
    else
    {
        return false;
    }
}

$('#level').click(function(event) {

    var lvl = $('#level').val();

    if (lvl == 'None') {
        $('#group_select').show();
    }
    else {
        $('#group_select').hide();
    }
});

$('#repo').click(function(event) {

    var repo = $('#repo').val(); 
    var pack = $('#package').val();
    var user = $('#committer').val();

    refreshPackage(repo, user, pack);
    refreshCommitter(repo, pack, user);
});

$('#committer').click(function(event) {
    var repo = $('#repo').val(); 
    var pack = $('#package').val();
    var user = $('#committer').val();

    refreshPackage(repo, user, pack);
});

$('#package').click(function(event) {

    var repo = $('#repo').val();
    var pack = $('#package').val();

    var user = $('#committer').val();

    refreshCommitter(repo, pack, user);
});

function refreshPackage(repo, user, path)
{

    var packageList = "";

    //console.log(path);
    if(path == '')
    {
        packageList = "<option selected=\"selected\">All Packages</option>";
    }
    else
    {
        packageList = "<option>All Packages</option>";
    }

    $.ajax({
        type: 'GET',
        url: rootURL + '/packages/' + repo + "/" + encodeURIComponent(user),
        dataType: "json", 
        success: function(data) {
            length = data.length;

            for (var i = 0; i < length; i++)
            {
                if (data[i] == path)
                {
                    packageList += "<option selected=\"selected\">"+data[i]+"</option>";
                }
                else
                {
                    packageList += "<option>"+data[i]+"</option>";
                }
            }

            //console.log(list);
            $('#package').html(packageList);
        }
    });   
}

function refreshCommitter(repo, pack, committer)
{
    var committerList = "";

    //console.log(committer);

    if(committer == '')
    {
        committerList = "<option selected=\"selected\">All Users</option>";
    }
    else
    {
        committerList = "<option>All Users</option>";
    }

    pack = pack.replace(/\//g, '!');

    //console.log(rootURL + '/committers/' + repo + "/" + encodeURIComponent(pack));

    $.ajax({
        type: 'GET',
        url: rootURL + '/committers/' + repo + "/" + encodeURIComponent(pack),
        dataType: "json", 
        success: function(data) {
            length = data.length;

            //console.log(data);
            for (var i = 0; i < length; i++)
            {
                if (data[i] == committer)
                {

                    committerList += "<option selected=\"selected\">"+data[i]+"</option>";
                }
                else
                {
                    committerList += "<option>"+data[i]+"</option>";
                }
            }

            //console.log(list);
            $('#committer').html(committerList);
        }
    });

}

function handleLevel(repo, pack, user) {

    var level = $('#level').val();

    var type;
    var title;

    if(level == 'Method')
    {
        type = 'method/';
        title = 'Method churn';
    }
    else if (level == 'Statement')
    {
        type = "statement/";
        title = 'Method statement churn';
    }
    else {
        // Handle default
        return false;
    }

    //console.log(rootURL + '/commits/' + type + repo + "/" + encodeURIComponent(user) + "/" + encodeURIComponent(pack));
    $.ajax({
        type: 'GET',
        url: rootURL + '/commits/' + type + repo + "/" + encodeURIComponent(user) + "/" + encodeURIComponent(pack),
        dataType: "json", // data type of response
        success: function(data) {
            //console.log(rootURL + '/commitsChurn/' + repo + "/" + group + "/" + encodeURIComponent(pack));
            var values = plotChurn(data, true);
            var statsArray = values[0];
            var tagArray = values[1];
            
            var series;
            if(level == 'Method') {
                series = getMethodSeries(statsArray, tagArray);
            }
            else {
                series = getStatementSeries(statsArray, tagArray);
            }
            areaPlotChurn("container", title, repo, series, getYAxis(false), 'normal');
        }
    });

    // True
    return true; 
}

function plotSelectedValues()
{
    /* Get the unique session id and POST data */
    var repo = $('#repo').val();
    var group = $('#group').val();
    var pack = $('#package').val();
    var user = $('#committer').val();
    
    /* Pass these values to the function that gets the data using
       REST and plots it */
    //console.log(pack)

    $('#commit_info_panel').hide();

    pack = pack.replace(/\//g, '!');

    if(!handleLevel(repo, pack, user)) {
        getChurn(repo, group, pack, user);
    }
    
    getStats(repo, pack);
}

$('#update').click(function(event) {
    
    plotSelectedValues();

    event.preventDefault();
});

$('#reset').click(function(event) {

    document.getElementById("repo").selectedIndex = 0;
    document.getElementById("group").selectedIndex = 0;
    document.getElementById("package").selectedIndex = 0;
    document.getElementById("committer").selectedIndex = 0;

    plotSelectedValues();

    event.preventDefault();
});

function getChurn(repo, group, pack, user) {
    //console.log(rootURL + '/commitsChurn/' + repo + "/" + group + "/" + encodeURIComponent(user) + "/" + encodeURIComponent(pack));
    $.ajax({
        type: 'GET',
        url: rootURL + '/commitsChurn/' + repo + "/" + group + "/" + encodeURIComponent(user) + "/" + encodeURIComponent(pack),
        dataType: "json", // data type of response
        success: function(data) {
            //console.log(rootURL + '/commitsChurn/' + repo + "/" + group + "/" + encodeURIComponent(pack));
            var values = plotChurn(data, false);
            var statsArray = values[0];
            var tagArray = values[1];
            var title = "Comments and Code Churn Per " + group;

            var series = getCommitSeries(statsArray, tagArray)
            areaPlotChurn("container", title, repo, series, getYAxis(true), null);
        }
    });
}

function plotChurn(data, level) {

    churnData = data[0];
    tagData = data[1];
    keys = Object.keys(churnData);
    //console.log(keys)
    dataLength = churnData[keys[0]].length;

    // Start from index one since the first is the date.
    var statsArray = {};
    first = true;
    for (var i = 0; i < keys.length; i++) {
        if (keys[i] != "date" && keys[i] != "committer_name" && keys[i] != "author_name" && keys[i] != "body")
        {
            statsArray[keys[i]] = new Array(dataLength);
        }
        else if (first)
        {
            statsArray["ExtraData"] = new Array(dataLength);

            //Fix for undefined error for days grouping
            //Since highcharts only checks the first value
            statsArray["ExtraData"][0] = {x: moment(churnData["date"][0], "YYYY-MM-DD HH:mm:ss").valueOf(), y: 0};
            first = false;
        }
    }

    var commit_level = $.inArray("committer_name", keys) != -1

    // Linearize the elements and add the date to them.
    for(var j = 0; j < dataLength; j++) {

        for (var k = 0; k < keys.length; k++) {
            if (keys[k] == "commentsDeleted" || keys[k] == "codeDeleted")
            {
                /*if (commit_level && keys[k] == "commentsAdded")
                {
                    statsArray[keys[k]][j] = {x: moment(churnData[keys[0]][j], "YYYY-MM-DD HH:mm:ss").valueOf(), y: (-1) * parseInt(churnData[keys[k]][j]), myData: [churnData["committer_name"][j], churnData["author_name"][j], churnData["body"][j]]};
                }  
                else
                {*/
                    statsArray[keys[k]][j] = {x: moment(churnData["date"][j], "YYYY-MM-DD HH:mm:ss").valueOf(), y: (-1) * parseInt(churnData[keys[k]][j])};
                //}
            }
            else if (keys[k] == "date" || keys[k] == "committer_name" || keys[k] == "author_name" || keys[k] == "body")
            {
                
            }
            else
            {
                /*if (commit_level && keys[k] == "commentsAdded")
                {
                    statsArray[keys[k]][j] = {x: moment(churnData[keys[0]][j], "YYYY-MM-DD HH:mm:ss").valueOf(), y: parseInt(churnData[keys[k]][j]), myData: [churnData["committer_name"][j], churnData["author_name"][j], churnData["body"][j]]};
                }
                else
                {*/
                    statsArray[keys[k]][j] = {x: moment(churnData["date"][j], "YYYY-MM-DD HH:mm:ss").valueOf(), y: parseInt(churnData[keys[k]][j])};
                //}
            }  

        }
        if (commit_level && !level)
        {
            //break;
            //user[moment(churnData[keys[0]][j], "YYYY-MM-DD HH:mm:ss").valueOf()] = churnData[keys[k]][j];
            statsArray["ExtraData"][j] = {x: moment(churnData["date"][j], "YYYY-MM-DD HH:mm:ss").valueOf(), y: j, myData: {com: churnData["committer_name"][j], aut: churnData["author_name"][j], body: churnData["body"][j]}};
        }
    }

    //console.log(statsArray);

    var tagArray = [];
    tagKeys = Object.keys(tagData);
    dataLength = tagData[tagKeys[0]].length;

    //console.log(tagData);
    /*for (var i = 0; i < tagKeys.length; i++) {
        tagArray[i] = {};
    }*/
    
    for (var i = 0; i < dataLength; i++) {

        if (tagData["desc"][i] == "")
        {
            tagData["desc"][i] = tagData["name"][i];
        }

        tagArray.push({
            x: moment(tagData[tagKeys[0]][i], "YYYY-MM-DD HH:mm:ss").valueOf(),
            title: tagData["name"][i],
            text: tagData["desc"][i]
        }); 
    }
    
    //console.log(tagArray);
    //areaPlotChurn("container", statsArray, repo, group, tagArray);
    return [statsArray, tagArray];
}

var PageHeight;
$(document).ready(function(){
    if(checkIfGraphPage())
    {
        if ($(window).height()*0.8 > 700)
        {
            $('#container').height($(window).height()*0.8);
        }
        PageHeight = $('#container').height();
        //console.log(PageHeight);
    }
});

function areaPlotChurn(id, title, repo, series, yaxis, stacked) {

    //
    var chart = $("#" + id).highcharts('StockChart', {
        chart: {
            //,
            //zoomType: 'x'
            //xAxis: data["date"]
        },
        title: {
            text: title
        },
        subtitle: {
            text: '<a href="http://github.com/' + repo + '" target="_blank">'+repo+'</a>',
            useHTML: true
        },
        xAxis: {
            type: 'datetime',
            //maxZoom: 14 * 24 * 3600000,

            labels: {
                enabled: true,
                //step: 2,
                //staggerLines: 2,
                formatter: function () {
                    return Highcharts.dateFormat('%b %d %Y', this.value);
                },
                dateTimeLabelFormats: {
                    month: '%b \'%y',
                    year: '%Y'
                }
            }
        },

        navigator: {
            enabled: true, 
            height: 20
        },

        legend:{
            enabled: true
        },

        rangeSelector:{
           enabled:true,
            buttons: [{ type: 'month', count: 1, text: 'S'
            }, { type: 'month', count: 3, text: 'M'
            }, { type: 'month', count: 6, text: 'L'
            }, { type: 'year', count: 1, text: '1Y'
            }, { type: 'all', text: 'All' }]
        },

        //TODO get the height of the container and store is as a varaible to use here
        yAxis: yaxis,
        tooltip: {
            formatter: function() {

                var s = '<b>'+ Highcharts.dateFormat('%A, %b %e, %Y', this.x) +'</b>';
                
                if (this.point == undefined)
                {
                    var index = this.points.length-1;
                    var y_point = Math.round(this.points[index].y);
                    //console.log(y_point);
                    
                    /*
                     * Check if the series is the index series. If it is plot the user names
                     */
                    if (this.points[index].series.name == "ExtraData" && this.points[index].series.userOptions.data[y_point] != undefined
                        && this.points[index].series.userOptions.data[y_point].myData != undefined)
                    {
                        s += '<br>Committed By: <b> ' + this.points[index].series.userOptions.data[y_point].myData["com"] + '</b></br>';
                        s += '<br>Authored By: <b> ' + this.points[index].series.userOptions.data[y_point].myData["aut"] + '</b></br>';

                        document.getElementById('commit_message').innerHTML = this.points[index].series.userOptions.data[y_point].myData["body"]
                        $('#commit_info_panel').show();
                    }

                    $.each(this.points, function(i, point) {
                        
                        if (point.series.name == 'Releases')
                        {
                            s += '<br>Release </br>';
                        }
                        else {
                            if(point.series.name !== 'Total Comments Column' && point.series.name !== 'Total Comments Modified Column'
                                && point.series.name !== 'Total Code Column' && point.series.name !== 'Total Code Modified Column'
                                && point.series.name !== 'ExtraData')
                            {
                                s += '<br>Number of Lines of ' + point.series.name + ': <b> ' + Math.round(point.y) + '</b></br>';
                            }
                        }
                    });
                }
                else
                {
                    s += '<br>' + this.series.name + ': <b> ' + this.point.text + '</b></br>';
                }
                return s;
            },
            shared: true 
        },
        plotOptions: {
            series: {
                turboThreshold: 0,
            },
            spline: {
                
                marker: {
                    enabled: false
                }
            },
            column: {
                stacking: stacked
            }
        },
        series: series
    }, function(chart){

            // apply the date pickers
            setTimeout(function () {
                $('input.highcharts-range-selector', $(chart.container).parent())
                    .datepicker();
            }, 0);
    });
}

$(function() {
    // Set the datepicker's date format
    $.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',
        onSelect: function(dateText) {
            this.onchange();
            this.onblur();
        }
    });
});

function getYAxis(showSecond) {

    if (showSecond) {
        return [{
            opposite: false,
            title: {
                text: 'Number of Lines'
            },
            labels: {

                formatter: function() {
                    return this.value / 1000 +'k';
                }
            },
            height: PageHeight*0.45,
            lineWidth: 2
        }, { // Secondary yAxis
            opposite: false,
            title: {
                text: 'Total Number of Lines'
            },
            labels: {
                formatter: function() {
                    return this.value / 1000 +'k';
                }
            },
            top: PageHeight*0.57,
            height: PageHeight*0.20,
            offset: 0,
            lineWidth: 2
        }];
    }
    return {
            opposite: false,
            title: {
                text: 'Number of Lines'
            },
            labels: {

                formatter: function() {
                    return this.value;
                }
            },
            height: PageHeight*0.65,
            lineWidth: 2
        };
}

function getCommitSeries(stats, tagInfo) {

    return [{
            type: 'spline',
            name: 'Comments Added',
            data: stats["commentsAdded"],
            color: 'rgba(205,92,92, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
            //color: 'rgba(255, 255, 255, 0.7)'
        }, {
            type: 'spline',
            name: 'Comments Deleted',
            data: stats["commentsDeleted"],
            color: 'rgba(220,20,60, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'spline',
            name: 'Comments Modified',
            data: stats["commentsModified"],
            color: 'rgba(139,0,0, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            id: 'codeadded',
            type: 'spline',
            name: 'Code Added',
            data: stats["codeAdded"],
            color: 'rgba(135,206,235, 0.9)',
            yAxis: 0,
            stack: 'code',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'spline',
            name: 'Code Deleted',
            data: stats["codeDeleted"],
            color: 'rgba(70,130,180, 0.9)',
            yAxis: 0,
            stack: 'code',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'spline',
            name: 'Code Modified',
            data: stats["codeModified"],
            color: 'rgba(0,0,128, 0.9)',
            yAxis: 0,
            stack: 'code',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            id: 'Total Comments',
            type: 'spline',
            name: 'Total Comments',
            data: stats["totalComments"],
            color: 'rgba(205,92,92, 0.9)',
            yAxis: 1,
            dataGrouping: {
                approximation: "average"
            }
        }, {
            linkedTo: 'Total Comments',
            type: 'column',
            name: 'Total Comments Column',
            data: stats["totalComments"],
            color: 'rgba(205,92,92, 0.3)',
            yAxis: 1,
            dataGrouping: {
                approximation: "average"
            }
        }, /*{
            id: 'Total Comments Modified',
            type: 'spline',
            name: 'Total Comments Modified',
            data: stats["totalCommentsModified"],
            color: 'rgba(139,0,0, 0.9)',
            yAxis: 1,
            dataGrouping: {
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Total Comments Modified Column',
            data: stats["totalCommentsModified"],
            color: 'rgba(139,0,0, 0.3)',
            yAxis: 1,
            linkedTo: 'Total Comments Modified',
            dataGrouping: {
                approximation: "average"
            }
        },*/ {
            id: 'Total Code',
            type: 'spline',
            name: 'Total Code',
            data: stats["totalCode"],
            color: 'rgba(70,130,180, 0.9)',
            yAxis: 1,
            dataGrouping: {
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Total Code Column',
            data: stats["totalCode"],
            color: 'rgba(70,130,180, 0.3)',
            yAxis: 1,
            linkedTo: 'Total Code',
            dataGrouping: {
                approximation: "average"
            }
        }, /*{
            id: 'Total Code Modified',
            type: 'spline',
            name: 'Total Code Modified',
            data: stats["totalCodeModified"],
            color: 'rgba(0,0,128, 0.9)',
            yAxis: 1,
            dataGrouping: {
                approximation: "average"
            }
        },  {
            type: 'column',
            name: 'Total Code Modified Column',
            data: stats["totalCodeModified"],
            color: 'rgba(0,0,128, 0.3)',
            yAxis: 1,
            linkedTo: 'Total Code Modified',
            dataGrouping: {
                approximation: "average"
            }
        },*/ {
            type: 'flags',
            data: tagInfo,
            shape: 'circlepin',
            title: "Releases",
            name: "Releases"
        }, {
            type: 'spline',
            name: 'ExtraData',
            data: stats["ExtraData"],
            color: 'rgba(255,255,255, 0.0)',
            //stack: 'comment',
            //visible: false,
            showInLegend: false,
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
            //color: 'rgba(255, 255, 255, 0.7)'
        }];
}

function getMethodSeries(stats, tagInfo) {

    return [{
            type: 'column',
            name: 'Added Methods',
            data: stats["newMethods"],
            color: 'rgba(0,204,0, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
            //color: 'rgba(255, 255, 255, 0.7)'
        }, {
            type: 'column',
            name: 'Deleted Methods',
            data: stats["deletedMethods"],
            color: 'rgba(204,0,0, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Modified Methods',
            data: stats["modifiedMethods"],
            color: 'rgba(0,0,204, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'flags',
            data: tagInfo,
            shape: 'circlepin',
            title: "Releases",
            name: "Releases"
        }, {
            type: 'spline',
            name: 'ExtraData',
            data: stats["ExtraData"],
            color: 'rgba(255,255,255, 0.0)',
            //stack: 'comment',
            //visible: false,
            showInLegend: false,
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
            //color: 'rgba(255, 255, 255, 0.7)'
        }];
}

function getStatementSeries(stats, tagInfo) {

    return [{
            type: 'column',
            name: 'New Code',
            data: stats["new_code"],
            color: 'rgba(0,102,0, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
            //color: 'rgba(255, 255, 255, 0.7)'
        }, {
            type: 'column',
            name: 'New Comments',
            data: stats["new_comment"],
            color: 'rgba(102,255,102, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Removed Code',
            data: stats["deleted_code"],
            color: 'rgba(153,0,0, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Removed Comments',
            data: stats["deleted_comment"],
            color: 'rgba(205,92,92, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
            //color: 'rgba(255, 255, 255, 0.7)'
        }, {
            type: 'column',
            name: 'Added Code',
            data: stats["modified_code_added"],
            color: 'rgba(0,204,204, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Added Comments',
            data: stats["modified_comment_added"],
            color: 'rgba(102,255,255, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Deleted Code',
            data: stats["modified_code_deleted"],
            color: 'rgba(153,0,76, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'column',
            name: 'Deleted Comments',
            data: stats["modified_comment_deleted"],
            color: 'rgba(255,102,178, 0.9)',
            yAxis: 0,
            stack: 'comment',
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
        }, {
            type: 'flags',
            data: tagInfo,
            shape: 'circlepin',
            title: "Releases",
            name: "Releases"
        }, {
            type: 'spline',
            name: 'ExtraData',
            data: stats["ExtraData"],
            color: 'rgba(255,255,255, 0.0)',
            //stack: 'comment',
            //visible: false,
            showInLegend: false,
            dataGrouping: {
                //enabled: false,
                approximation: "average"
            }
            //color: 'rgba(255, 255, 255, 0.7)'
        }];
}

/*function getTypeOfPie(type, repo)
{
    var url = '/pie_stats/';
    var seriesName = "";
    if (type == "Top Coders")
    {
        url += 'topCoder' + "/" + repo + "/" + false + "/";
        seriesName = "Top 5 Code Committers";
    }
    else if (type == "Top Commenters")
    {
        url += 'topCommenter' + "/" + repo + "/" + false + "/";
        seriesName = "Top 5 Comments Committers";
    }
    else if (type == "Top Committers")
    {
        url += 'topCommitter' + "/" + repo + "/" + false + "/";
        seriesName = "Top 5 Commiters";
    }
    else if (type == "Top Authors")
    {
        url += 'topAuthor' + "/" + repo + "/" + false + "/";
        seriesName = "Top 5 Authors";
    }
    else if (type == "Bottom Coders")
    {
        url += 'bottomCoders' + "/" + repo + "/" + true + "/";
        seriesName = "Bottom 5 Code Committers";
    }
    else if (type == "Bottom Commenters")
    {
        url += 'bottomCommenters' + "/" + repo + "/" + true + "/";
        seriesName = "Bottom 5 Comments Committers";
    }
    else if (type == "Comment To Code")
    {
        url += 'CommentCode' + "/" + repo + "/" + false + "/";
        seriesName = "Comment to Code";
    }
    return [url, seriesName];
}*/

/**
 *
 */
function getStats(repo, pack)
{
    pack = pack.replace(/\//g, '!');

    $.ajax({
        type: 'GET',
        url: rootURL + "/stats/" + repo + "/" + encodeURIComponent(pack),
        dataType: "json", 
        success: function(data) {
            plotMostCoder(data["CommentCode"], repo, "Comment to Code");
            fillTable(data["other"]);
        }
    });
}

function fillTable(data)
{
    var list = "";
    var authList = "";
    var deleList = "";
    keys = Object.keys(data);
    for (var i = 0; i < 5; i ++)
    {
        list += createRow(data, 0, 3, i);
        deleList += createRow(data, 3, 6, i);
        //modList += createRow(data, 3, 6, i);
        authList += createRow(data, keys.length-2, keys.length, i);
    }
    //console.log(Math.round(keys.length/2));
    //console.log(authList);
    
    $('#CodeComment').html(list);
    $('#CommitAuthor').html(authList);
    //$('#CommitAuthor').html(modList);
    $('#Deleters').html(deleList);
}

function createRow(data, starter, stopper, rowNumber)
{
    var list = "<tr>";

    keys = Object.keys(data);
    var empty = true;
    for (var i = starter; i < stopper; i++)
    {
        if (data[keys[i]][rowNumber] != undefined)
        {
            empty = false;
            list+= "<td>" + (rowNumber+1) + ". " + data[keys[i]][rowNumber][0] + " [<em>"+data[keys[i]][rowNumber][1] + "</em>]</td>";
        }
        else
        {
            list+= "<td>" + "</td>";
        }
    }
    list+="</tr>";

    if (empty)
    {
        return "";
    }
    return list;
}

/*
$('#pie_type').click(function(event) {
    var repo = $('#repo').val();
    var pack = $('#package').val();
    getStats(repo, pack);

});
*/

/*function getMostCoder(repo, pack) {
    var type = $('#pie_type').val();
    
    pack = pack.replace(/\//g, '!');

    var url = getTypeOfPie(type, repo);
    console.log(rootURL + url[0] + encodeURIComponent(pack));
    
    //console.log(url[1]);
    $.ajax({
        type: 'GET',
        url: rootURL + url[0] + encodeURIComponent(pack),
        dataType: "json", 
        success: function(data) {
            plotMostCoder(data, repo, url[1]);
        }
    });
}*/

function plotMostCoder(data, repo, name) {
    $('#code_pie').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: 'Project stats',
            useHTML: true
        },
        
        subtitle: {
            text: name + ' for <a href="http://github.com/' + repo + '" target="_blank">'+repo+'</a>',
            useHTML: true
        },
        tooltip: {
            formatter: function() {
                //if(this.point.name)
                //{
                    s = "";
                    s+='' + this.point.name + ': <b>' + this.point.y + '</b>';//,<b> ' + percentage + '%</b>';
                    return s;
                //}
            }
            //pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    inside: true,
                    formatter: function() {
                        s = "";
                        var percentage = (Math.round(this.point.percentage*10))/10
                        s+='' + this.point.name + ': ' + percentage + '%';
                        return s;
                    }
                    //format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: name,
            data: data
        }]
    });
}

$('#submit').click(function(event) {
    
    //plotSelectedValues();

    // Make api request 

    event.preventDefault();
});
