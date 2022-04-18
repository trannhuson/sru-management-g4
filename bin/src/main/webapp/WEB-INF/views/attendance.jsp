<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/templete/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Attendance</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/light-bootstrap-dashboard.css?v=2.0.0"
          rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/demo.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/change-password.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/attendance.css" rel="stylesheet"/>

</head>

<body>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
        <jsp:include page="common/navbar.jsp"/>
        <div class="content">
            <div class="row" style="margin: 20px;">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="card card-user">
                        <div class="card-image">
                            <img src="${pageContext.request.contextPath}/resources/img/sidebar-5.jpg" alt="...">
                        </div>
                        <div class="card-body">
                            <div class="author">
                                <a href="#">
                                    <img class="avatar border-gray"
                                         src="${pageContext.request.contextPath}/resources/img/default-avatar.png" alt="...">
                                    <h5 class="title"><span id="account">${user.account}</span><i class="fa fa-check-circle"
                                                                                     id="check-circle"></i>
                                    </h5>
                                </a>
                            </div>
                            <a class="btn btn-danger" id="btn-attendance" href="#"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    $(document).ready(function () {
        $("#btn-attendance").attr("href", "/trainee/attendance/create/" + $("#account").text());
        $.ajax({
            type: "GET",
            url: "/trainee/check",
            data: {
                account: $("#account").text()
            },
            success: function (output) {
                if (output.message != null) {
                    demo.showNotification();
                    $("#check-circle").css("display", "inline-block");
                    $("#btn-attendance").text("Check Out");
                    $("#btn-attendance").click(function () {
                        demo.showNotification();
                    });
                } else {
                    demo.showAlert();
                    $("#btn-attendance").text("Check In");
                }
            }
        });
    });
</script>

<script src="${pageContext.request.contextPath}/resources/js/subject-management.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/bootstrap-switch.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/chartist.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/bootstrap-notify.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/light-bootstrap-dashboard.js?v=2.0.0" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/demo.js"></script>

</html>