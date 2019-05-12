<html lang="en">
<#assign title="Weekly Check In">
<#include "head.ftl">

<body>
    <#include "navbar.ftl">

    <div class="container">
        <h3>Weekly Check In</h3>

        <div class="row">
            <div class="col-sm-6">
                <form method="post">
                    <#list weeklyQuestions as question>
                        <div class="form-group">
                            <label for="question1">${question.text}</label>
                            <input type="text" class="form-control" id="question1" placeholder="Your answer">
                        </div>
                        <button type="submit" class="btn btn-outline-success">Done</button>
                    </#list>
                </form>
            </div>
        </div>
    </div>
</body>

<script>
    $("#nav-weekly-check-in").attr('class', 'nav-item active');
</script>
</html>