<html lang="en">
<#assign title="Login">
<#assign highlighted="login">
<#include "head.ftl">
<body>
    <#include "navbar.ftl">
    <#if error??>
        <#assign level="danger">
        <#assign alert=error>
        <#include "message.ftl">
    </#if>
    <h1>Login Page</h1>
    <form action="/login" method="post">
        <label for="username">
            <input name="username" type="text" placeholder="Your username..."/>
        </label>
        <label for="password">
            <input name="password" type="password" placeholder="Your password..."/>
        </label>
        <button type="submit">Log in</button>
    </form>
</body>
</html>