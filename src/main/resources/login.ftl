<html lang="en">
<#assign title="Login">
<#include "head.ftl">

<head>
    <style type="text/css">
        .modal-login {
            width: 350px;
        }
        .modal-login .modal-content {
            padding: 20px;
            border-radius: 5px;
            border: none;
        }
        .modal-login .modal-header {
            border-bottom: none;
            position: relative;
            justify-content: center;
        }
        .modal-login .close {
            position: absolute;
            top: -10px;
            right: -10px;
        }
        .modal-login h4 {
            color: #636363;
            text-align: center;
            font-size: 26px;
            margin-top: 0;
        }
        .modal-login .modal-content {
            color: #999;
            border-radius: 1px;
            margin-bottom: 15px;
            background: #fff;
            border: 1px solid #f3f3f3;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 25px;
        }
        .modal-login .form-group {
            margin-bottom: 20px;
        }
        .modal-login label {
            font-weight: normal;
            font-size: 13px;
        }
        .modal-login .form-control {
            min-height: 38px;
            padding-left: 5px;
            box-shadow: none !important;
            border-width: 0 0 1px 0;
            border-radius: 0;
        }
        .modal-login .form-control:focus {
            border-color: #ccc;
        }
        .modal-login .input-group-addon {
            max-width: 42px;
            text-align: center;
            background: none;
            border-width: 0 0 1px 0;
            padding-left: 5px;
            border-radius: 0;
        }
        .modal-login .btn {
            font-size: 16px;
            font-weight: bold;
            background: #19aa8d;
            border-radius: 3px;
            border: none;
            min-width: 140px;
            outline: none !important;
        }
        .modal-login .btn:hover, .modal-login .btn:focus {
            background: #179b81;
        }
        .modal-login .hint-text {
            text-align: center;
            padding-top: 5px;
            font-size: 13px;
        }
        .modal-login .modal-footer {
            color: #999;
            border-color: #dee4e7;
            text-align: center;
            margin: 0 -25px -25px;
            font-size: 13px;
            justify-content: center;
        }
        .modal-login a {
            color: #fff;
            text-decoration: underline;
        }
        .modal-login a:hover {
            text-decoration: none;
        }
        .modal-login a {
            color: #19aa8d;
            text-decoration: none;
        }
        .modal-login a:hover {
            text-decoration: underline;
        }
        .modal-login .fa {
            font-size: 21px;
        }

        i {
            padding: 0.5em;
            padding-right: 1em;
        }
    </style>
</head>

<body>
<#include "navbar.ftl">

<div class="container">
    <#if error??>
        <#assign level="danger">
        <#assign alert=error>
        <#include "message.ftl">
    </#if>

    <h3>Welcome to Healthy Earth!</h3>

    <div class="row" style="margin-top: 1em;">
        <div class="col-sm-6" style="padding=1em;">
            <div class="row align-items-center justify-content-center">
                <div>
                    <img src="images/forest.png" class="tree-img rounded-circle" alt="" width="256px" height="256px">
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <p style="padding: 1em; text-align: justify">Compete with your friends to save the planet! We all can play our part in fighting against climate change and now is the time to start.
                Challenge your friends and yourself to do the right thing: Unique challenges and a weekly check-in are waiting for you.
                Live a greener life and watch your very own forest grow.</p>
        </div>
    </div>

    <!-- Modal HTML -->
    <div id="myModal" class="modal fade">
        <div class="modal-dialog modal-login">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Sign In</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <#if error??>
                        <#assign level="danger">
                        <#assign alert=error>
                        <#include "message.ftl">
                    </#if>

                    <form action="/login" method="post">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input type="text" class="form-control" name="username" placeholder="Username" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="password" placeholder="Password" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary btn-block btn-lg">Sign In</button>
                        </div>
                        <p class="hint-text"><a href="#">Forgot Password?</a></p>
                    </form>
                </div>
                <div class="modal-footer">Don't have an account?&nbsp;<a href="#">Create one</a></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>