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
            data: [{
                type: "spline",
                showInLegend: true,
                yValueFormatString: "## p",
                name: "${user.username}",
                dataPoints: [
                    { label: "Day 1", y: 20.22 },
                    { label: "Day 2", y: 18.20 },
                    { label: "Day 3", y: 19.44 },
                    { label: "Day 4", y: 21.45 },
                    { label: "Day 5", y: 10.58 },
                    { label: "Day 6", y: 33.44 },
                    { label: "Day 7", y: 14.40 },
                    { label: "Day 8", y: 3.72 },
                    { label: "Day 9", y: 27.66 },
                    { label: "Day 10", y: 19.04 }
                ]
            },
                {
                    type: "spline",
                    showInLegend: true,
                    visible: false,
                    yValueFormatString: "## p",
                    name: "John Doe",
                    dataPoints: [
                        { label: "Day 1", y: 34.86 },
                        { label: "Day 2", y: 32.76 },
                        { label: "Day 3", y: 27.77 },
                        { label: "Day 4", y: 22.65 },
                        { label: "Day 5", y: 37.90 },
                        { label: "Day 6", y: 19.88 },
                        { label: "Day 7", y: 24.69 },
                        { label: "Day 8", y: 29.86 },
                        { label: "Day 9", y: 34.38 },
                        { label: "Day 10", y: 45.20 }
                    ]
                },
                {
                    type: "spline",
                    showInLegend: true,
                    visible: false,
                    yValueFormatString: "## p",
                    name: "Jane Doe",
                    dataPoints: [
                        { label: "Day 1", y: 24.37 },
                        { label: "Day 2", y: 21.27 },
                        { label: "Day 3", y: 23.72 },
                        { label: "Day 4", y: 39.87 },
                        { label: "Day 5", y: 36.35 },
                        { label: "Day 6", y: 17.50 },
                        { label: "Day 7", y: 20.84 },
                        { label: "Day 8", y: 27.13 },
                        { label: "Day 9", y: 24.22 },
                        { label: "Day 10", y: 18.39 }
                    ]
                },
                {
                    type: "spline",
                    showInLegend: true,
                    visible: false,
                    yValueFormatString: "## p",
                    name: "John Doe",
                    dataPoints: [
                        { label: "Day 1", y: 34.64 },
                        { label: "Day 2", y: 44.31 },
                        { label: "Day 3", y: 26.59 },
                        { label: "Day 4", y: 28.95 },
                        { label: "Day 5", y: 35.16 },
                        { label: "Day 6", y: 22.40 },
                        { label: "Day 7", y: 17.20 },
                        { label: "Day 8", y: 28.17 },
                        { label: "Day 9", y: 34.95 },
                        { label: "Day 10", y: 39.09 }
                    ]
                }]
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