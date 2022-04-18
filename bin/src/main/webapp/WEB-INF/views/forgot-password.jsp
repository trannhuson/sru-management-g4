<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">

<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%--  <link href="${pageContext.request.contextPath}/resources/css/login/images/icons/favicon.ico" rel="stylesheet" type="text/css"/>--%>
    <link href="${pageContext.request.contextPath}/resources/css/light-bootstrap-dashboard.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/login/css/util.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/login/css/main.css" rel="stylesheet" type="text/css"/>
    <style>
        span.label-input100 {
            width: 95px !important;
        }
    </style>
</head>

<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title" style="background-image: url('${pageContext.request.contextPath}/resources/css/login/images/bg-01.jpg');">
                    <span class="login100-form-title-1">
						Forgot Password
					</span>
            </div>

            <form:form class="login100-form validate-form" action="forgot-password" method="post" modelAttribute="changePassword">
                <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                    <span class="label-input100">Password</span>
                    <form:input path="passwordNew" type="password" class="input100" placeholder="New Password" id="new-password" />
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-18" data-validate="Password is required">
                    <span class="label-input100">Re Password</span>
                    <form:input path="rePasswordNew" type="password" class="input100" placeholder="Confirm Password" id="confirm-password" />
                    <span class="focus-input100"></span>
                </div>

                <div class="flex-sb-m w-full p-b-30">
                    <span style="color: red">${message}</span>
                    <div>
                        <a href="login" class="txt1">
                            Login
                        </a>
                    </div>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit">
                        Login
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/css/login/vendor/jquery/jquery-3.2.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/css/login/js/main.js"></script>

</body>

</html>