<html lang="en">
<#assign title="Weekly Check In">
<#include "head.ftl">

<body>
    <#include "navbar.ftl">

    <div class="container">
        <h3>Weekly Check In</h3>

        <div class="row">
            <div class="col-sm-6">
                <form class="form-inline" method="post">
                    <#list questions as question>
                        <div class="form-group">
                            <div class="container"><div class="row" style="padding: 1em; padding-left: 0em; padding-top: 0em;">${question.text}</div></div>
                            <#list question.answers as answer>
                                <div class="input-group">
                                    <input type="hidden" name="answeredQuestionId" value="${question.id}">
                                    <input style="margin: 0.6em; !important;" type="radio" id="${answer.id}" name="answerId-${question.id}" value="${answer.id}">
                                    <label for="${answer.id}">${answer.text}</label>
                                </div>
                            </#list>
                        </div>
                    </#list>

                    <button style="margin: 0.5em;" type="submit" class="btn btn-outline-success">Done</button>
                </form>
            </div>
        </div>
    </div>
</body>

<script>
    $("#nav-weekly-check-in").attr('class', 'nav-item active');
</script>
</html>