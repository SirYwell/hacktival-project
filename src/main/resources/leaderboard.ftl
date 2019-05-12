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
                    { label: "Day 1", y: 2.22 },
                    { label: "Day 2", y: 2.20 },
                    { label: "Day 3", y: 2.44 },
                    { label: "Day 4", y: 2.45 },
                    { label: "Day 5", y: 2.58 },
                    { label: "Day 6", y: 2.44 },
                    { label: "Day 7", y: 2.40 },
                    { label: "Day 8", y: 2.72 },
                    { label: "Day 9", y: 2.66 },
                    { label: "Day 10", y: 3.04 }
                ]
            },
                {
                    type: "spline",
                    showInLegend: true,
                    yValueFormatString: "## p",
                    name: "John Doe",
                    dataPoints: [
                        { label: "Day 1", y: 3.86 },
                        { label: "Day 2", y: 3.76 },
                        { label: "Day 3", y: 3.77 },
                        { label: "Day 4", y: 3.65 },
                        { label: "Day 5", y: 3.90 },
                        { label: "Day 6", y: 3.88 },
                        { label: "Day 7", y: 3.69 },
                        { label: "Day 8", y: 3.86 },
                        { label: "Day 9", y: 3.38 },
                        { label: "Day 10", y: 4.20 }
                    ]
                },
                {
                    type: "spline",
                    showInLegend: true,
                    yValueFormatString: "## p",
                    name: "Jane Doe",
                    dataPoints: [
                        { label: "Day 1", y: 4.37 },
                        { label: "Day 2", y: 4.27 },
                        { label: "Day 3", y: 4.72 },
                        { label: "Day 4", y: 4.87 },
                        { label: "Day 5", y: 5.35 },
                        { label: "Day 6", y: 5.50 },
                        { label: "Day 7", y: 4.84 },
                        { label: "Day 8", y: 4.13 },
                        { label: "Day 9", y: 5.22 },
                        { label: "Day 10", y: 5.39 }
                    ]
                },
                {
                    type: "spline",
                    showInLegend: true,
                    yValueFormatString: "## p",
                    name: "John Doe",
                    dataPoints: [
                        { label: "Day 1", y: 6.64 },
                        { label: "Day 2", y: 6.31 },
                        { label: "Day 3", y: 6.59 },
                        { label: "Day 4", y: 6.95 },
                        { label: "Day 5", y: 7.16 },
                        { label: "Day 6", y: 6.40 },
                        { label: "Day 7", y: 7.20 },
                        { label: "Day 8", y: 7.17 },
                        { label: "Day 9", y: 6.95 },
                        { label: "Day 10", y: 7.09 }
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