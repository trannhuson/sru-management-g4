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
        form#change-password-form {
            padding: 20px 20px 20px 90px;
        }
        button.login100-form-btn {
            margin-top: -8px;
        }
        a.txt1 {
            margin-right: 20px;
        }

        span.label-input100 {
            margin-top: 8px;
        }
    </style>

</head>

<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title" style="background-image: url('${pageContext.request.contextPath}/resources/css/login/images/bg-01.jpg');">
                    <span class="login100-form-title-1">
						Validate Number?
					</span>
            </div>

            <form action="number-validate" method="post" id="change-password-form">

                <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                    <span class="label-input100">Number</span>
                    <input path="number" class="input100" type="text" name="number" placeholder="Enter number validate"/>
                    <span class="focus-input100"></span>
                </div>

                <div class="flex-sb-m w-full p-b-30">
                    <span style="color: red">${message}</span>
                    <div>
                        <a href="login" class="txt1">Login?</a>
                    </div>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit">
                        Submit
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/css/login/vendor/jquery/jquery-3.2.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/css/login/js/main.js"></script>

</body>

</html>