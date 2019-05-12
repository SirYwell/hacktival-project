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
                    <#list questions as question>
                        <div class="form-group">
                            <p>${question.text}</p>
                            <#list question.answers as answer>
                                <input type="hidden" name="answeredQuestionId" value="${question.id}">
                                <label for="${answer.id}">${answer.text}</label>
                                <input type="radio" class="form-control" id="${answer.id}" name="${answer.id}" value="${answer.id}">
                            </#list>
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