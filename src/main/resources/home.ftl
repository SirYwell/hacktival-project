<html lang="en">
<#assign title="Home">
<#include "head.ftl">

<script>
    $("#nav-home").attr('class', 'nav-item active');
</script>

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

                <div class="alert alert-info alert-dismissible fade show" role="alert">
                    This is a info alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">10 p</span>
                    </button>
                </div>

                <div class="alert alert-info alert-dismissible fade show" role="alert">
                    This is a info alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">10 p</span>
                    </button>
                </div>

                <div class="alert alert-info alert-dismissible fade show" role="alert">
                    This is a info alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">10 p</span>
                    </button>
                </div>

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
                    <div style="float: right;">Level 3 (450 / 1000 p) <i class="far fa-star"></i></div>
                </div>

                <div class="progress" style="border: 1px solid black; display: block;">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width:45%">
                        450 p
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script>
    $('.alert').alert()

    $(document).ready(function(){
        $(".close").click(function(){
            $(".alert-success").show();
        });
    });
</script>
</html>