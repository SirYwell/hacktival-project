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

        <h1>Login Page</h1>

        <div class="col-sm-6">
            <form action="/login" method="post">
                <label for="username">
                    <input name="username" type="text" placeholder="Your username..."/>
                </label>
                <label for="password">
                    <input name="password" type="password" placeholder="Your password..."/>
                </label>
                <button type="submit">Log in</button>
            </form>
        </div>

        <div class="col-sm-6">
        </div>
    </div>
</body>
</html>