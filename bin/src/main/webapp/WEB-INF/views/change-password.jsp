<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/img/favicon.ico" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <jsp:include page="common/link-css.jsp"/>
    <link href="${pageContext.request.contextPath}/resources/css/change-password.css" rel="stylesheet" />
</head>
<body>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
       <jsp:include page="common/navbar.jsp"/>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4">
                        <form:form action="change-password" method="post" id="change-password-form" modelAttribute="changePassword">
                            <div class="card">
                                <div class="card-header" style="text-align: center; font-size: 30px; font-weight: bolder;">
                                    SRU Management
                                </div>
                                <div class="card-body ">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                                        </div>
                                        <form:input path="passwordOld" type="password" class="form-control" placeholder="Password" id="user-name" />
                                    </div>
                                    <span id="error-old-password" class="error"></span>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                                        </div>
                                        <form:input path="passwordNew" type="password" class="form-control" placeholder="New Password" id="new-password" />
                                    </div>
                                    <span id="error-new-password" class="error"></span>
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                                        </div>
                                        <form:input path="rePasswordNew" type="password" class="form-control" placeholder="Confirm Password" id="confirm-password" />
                                    </div>
                                    <span id="error-confirm-password" class="error"></span>
                                    <button type="submit" class="btn btn-primary" style="width: 100%;" id="btn-change-password">Submit</button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="common/link-js.jsp"/>
<script src="<c:url value="/resources/js/change-password.js"/>"></script>
</body>
</html>