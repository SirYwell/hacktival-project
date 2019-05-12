<html lang="en">
<#assign title="Leaderboard">
<#include "head.ftl">

<body>
    <#include "navbar.ftl">

    <div class="container">
        <h3>Leaderboard</h3>

        <div class="row">
            <div class="col-sm-6 leaderboard">
                <#list users as otherUser>
                    <div class="media border p-3">
                        <img src="images/img_avatar3.png" alt="John Doe" class="align-self-center mr-3 mt-3 rounded-circle" style="width:60px;">
                        <div class="media-body align-self-center">
                            <b>
                                <#if otherUser.username == currentUser>
                                    You
                                    <#else>
                                    ${otherUser.username}
                                </#if>
                                <small><i>Active since February 19, 2016</i></small></b>
                            <p>Total points this week: ${otherUser.getTotalPoints()}</p>
                        </div>
                    </div>
                </#list>
            </div>

            <div class="col-sm-6">
                <div id="chartContainer"></div>
            </div>
        </div>
    </div>
</body>

<script>
    $("#nav-leaderboard").attr('class', 'nav-item active');
</script>

<script>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            theme:"light2",
            animationEnabled: true,
            axisY :{
                includeZero: false,
                title: "Points",
                suffix: "p"
            },
            toolTip: {
                shared: "true"
            },
            legend:{
                cursor: "pointer",
                itemclick: toggleDataSeries
            },
            data: [
                <#list users as otherUser>
                {
                    type: "spline",
                    showInLegend: true,
                    yValueFormatString: "## p",
                    <#if otherUser.username != currentUser>
                    visible: false,
                    </#if>
                    name: "${otherUser.username}",
                    dataPoints: [
                        <#list otherUser.getPointsPerDay() as date, points>
                        { label: "${date}", y: ${points} },
                        </#list>
                    ]
                },
                </#list>
            ]
        });
        chart.render();

        function toggleDataSeries(e) {
            if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible ){
                e.dataSeries.visible = false;
            } else {
                e.dataSeries.visible = true;
            }
            chart.render();
        }

    }
</script>
</html>