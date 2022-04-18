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
  <meta name="google-signin-scope" content="profile email">
  <meta name="google-signin-client_id" content="814576837036-si9q1nr9jb348ng9fjajsf6o87m4rmlu.apps.googleusercontent.com">
  <script src="https://apis.google.com/js/platform.js" async defer></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<div class="limiter">
  <div class="container-login100">
    <div class="wrap-login100">
      <div class="login100-form-title" style="background-image: url('${pageContext.request.contextPath}/resources/css/login/images/bg-01.jpg');">
                    <span class="login100-form-title-1">
						Login
					</span>
      </div>

      <form:form class="login100-form validate-form" action="login-user" method="post" modelAttribute="loginRequest">
        <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
          <span class="label-input100">Username</span>
          <form:input path="email" class="input100" type="text" name="username" placeholder="Enter email" />
          <span class="focus-input100"></span>
        </div>

        <div class="wrap-input100 validate-input m-b-18" data-validate="Password is required">
          <span class="label-input100">Password</span>
          <form:input path="password" class="input100" type="password" name="pass" placeholder="Enter password"/>
          <span class="focus-input100"></span>
        </div>

        <div class="flex-sb-m w-full p-b-30">
          <div class="contact100-form-checkbox">
            <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
            <label class="label-checkbox100" for="ckb1">
              Remember me
            </label>
          </div>
          <button name="button" id="disconnect" style="display:none;">Disconnect</button>
          <div>
            <a href="get-email" class="txt1">
              Forgot Password?
            </a>
          </div>
        </div>

        <div class="container-login100-form-btn">
          <button class="login100-form-btn" type="submit">
            Login
          </button>
        </div>
      </form:form >

      <form action='login-google' method='post' id='login-google-web'>
        <div class='g-signin2' data-onsuccess='onSignIn' data-theme='dark' id="google-login"></div>
      </form>

      <p class="login-error" id="hideMe">${messageLogin}</p>
    </div>
  </div>
</div>
<script type="text/javascript">
  function onSignIn(googleUser) {
    // var profile = googleUser.getBasicProfile();
    var data = "<input type='hidden' name='access_token' value='" + googleUser.getAuthResponse().access_token + "'/>";
    $("#login-google-web").append(data);
    $("#login-google-web").submit();
  };
</script>

<script src="${pageContext.request.contextPath}/resources/css/login/vendor/jquery/jquery-3.2.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/css/login/js/main.js"></script>


</body>

</html>