<html lang="en">
<#assign title="Home">
<#include "head.ftl">

<body>
    <#include "navbar.ftl">

    <div class="container">
        <h3>Home</h3>

        <div class="row">
            <div class="col-sm-6">
                <div class="alert alert-info alert-warning fade show" role="alert">
                    Answer some questions for your <a href="weekly-check-in" class="alert-link">weekly check in</a>!
                </div>

                <p style="margin: 1em"><b>Complete your challenges:</b></p>

                <#list challenges as challenge>
                    <div data-toggle="tooltip" data-placement="left" title="${challenge.fact}" class="alert alert-info alert-dismissible fade show" role="alert">
                        <p>${challenge.text}</p>

                        <form method="post">
                            <input type="hidden" name="finishedChallengeId" value="${challenge.id}"/>
                            <button type="submit" class="close" aria-label="Close">
                                <span aria-hidden="true">${challenge.points} p</span>
                            </button>
                        </form>
                    </div>
                </#list>

                <div class="alert alert-success alert-dismissible" role="alert">
                    <h4 class="alert-heading">Well done!</h4>
                    <p>You have just successfully completed your first weekly challenge!</p>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="clearfix">
                    <div style="float: left;">Check your progress:</div>
                    <div style="float: right;">Level 3 (${user.getTotalPoints()} / 1000 p) <i class="far fa-star"></i></div>
                </div>

                <div class="progress" style="border: 1px solid black; display: block;">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width:45%">
                        ${user.getTotalPoints()} p
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script>
    $("#nav-home").attr('class', 'nav-item active');

    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();

        /*$(".close").click(function(){
            $(".alert-success").show();
        });*/
    });

    //$('.alert').alert();
</script>
</html>