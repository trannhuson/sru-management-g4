<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link
            rel="apple-touch-icon"
            sizes="76x76"
            href="../assets/img/apple-icon.png"
    />
    <link rel="icon" type="image/png" href="../assets/img/favicon.ico"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>
        Class detail
    </title>
    <meta
            content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no"
            name="viewport"
    />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
    <link href="<c:url value="/resources/css/light-bootstrap-dashboard.css?v=2.0.0 " />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!--   Core JS Files   -->
    <script
            src="<c:url value="/resources/js/core/jquery.3.2.1.min.js"/>"
            type="text/javascript"
    ></script>
    <script src="<c:url value="/resources/js/core/popper.min.js"/>" type="text/javascript"></script>
    <script
            src="<c:url value="/resources/js/core/bootstrap.min.js"/>"
            type="text/javascript"
    ></script>
    <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
    <script src="<c:url value="/resources/js/plugins/bootstrap-switch.js"/>"></script>

    <!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
    <script src="<c:url value="/resources/js/demo.js"/>"></script>

    <!-- Datatable plugin CSS file -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <!-- Datatable plugin JS library file -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
    </script>
    <script src="${pageContext.request.contextPath}/resources/js/toast-message.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/toast-message.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
</head>
<body>
<div id="toast"></div>
<div class="wrapper">
    <jsp:include page="../common/sidebar.jsp"/>
    <div class="main-panel">
        <!-- Navbar -->
        <jsp:include page="../common/navbar.jsp"/>
        <!-- End Navbar -->
        <div class="content">
            <div class="btn-group-lg p-2">
                <button type="button" class="btn btn-outline-primary">
                    <a href="/trainer/create-score/${sessionScope.subjectId}">Create score</a>
                </button>
                <button type="button" class="btn btn-outline-primary">Import Score</button>
                <button type="button" class="btn btn-outline-primary">Export Score</button>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="title py-4">
                            <h2>Score</h2>
                        </div>
                        <table id="tableID" class="display">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Name</th>
                                <th>Score</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="scoreDTO" items="${scoreDTOS}">
                                <c:url var="updateLink" value="/trainer/edit-score">
                                    <c:param name="subjectId" value="${scoreDTO.trainingObjective.id}" />
                                    <c:param name="traineeId" value="${scoreDTO.trainee.id}" />
                                </c:url>
                                <tr>
                                    <td>${scoreDTO.id}</td>
                                    <td>${scoreDTO.trainee.fullName}</td>
                                    <td>${scoreDTO.value}</td>
                                    <td>Active</td>
                                    <td><a class="btn btn-outline-primary" href="${updateLink}">Edit</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#tableID').DataTable({
            searching: false,
            info: false
        });
    });

    var mess = "${messageScore}";
    if (mess !== "") {
        toast({
            title: "Success!",
            message: mess,
            type: "success",
            duration: 5000
        });
    }
</script>
</body>
</html>