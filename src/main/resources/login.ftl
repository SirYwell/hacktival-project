<html lang="en">
<#assign title="Login">
<#assign highlighted="login">
<#include "head.ftl">
<body>
    <#include "navbar.ftl">

    <div class="container">
        <#if error??>
            <#assign level="danger">
            <#assign alert=error>
            <#include "message.ftl">
        </#if>

        <h3>Sign In to Healthy Earth</h3>

        <div class="col-sm-6">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="username"></label>
                    <input name="username" type="text" placeholder="Your username...">
                </div>

                <div class="form-group">
                    <label for="password"></label>
                    <input name="password" type="password" placeholder="Your password...">
                </div>

                <button type="submit">Log in</button>
            </form>
        </div>

        <div class="col-sm-6">
        </div>
    </div>
</body>
</html>