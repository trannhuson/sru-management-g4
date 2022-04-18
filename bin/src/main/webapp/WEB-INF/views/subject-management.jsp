<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="<c:url value="/resources/templete/assets/img/favicon.ico"></c:url>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Subject Management</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <link href="<c:url value="/resources/templete/assets/css/bootstrap.min.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/light-bootstrap-dashboard.css?v=2.0.0"/>"
          rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link href="<c:url value="/resources/templete/assets/css/demo.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/change-password.css"/>" rel="stylesheet"/>

    <!-- Datatable plugin CSS file -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <!-- jQuery library file -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js">
    </script>
    <!-- Datatable plugin JS library file -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js" defer></script>
    <script src="${pageContext.request.contextPath}/resources/js/toast-message.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/toast-message.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
</head>

<body>
<div id="toast"></div>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
        <jsp:include page="common/navbar.jsp"/>
        <div class="content">
            <div class="container-fluid">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-8"><h4 class="card-title">Subject Management</h4></div>
                                    <div class="col-md-4">
                                        <button type="button" class="btn btn-outline-primary float-right"
                                                title="Create" style="margin-bottom: 5px" id="btn-create"><i
                                                class="fa fa-plus"></i></button>
                                    </div>
                                </div>
                                <table id="tbl-trainingObjectives" class="display">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Code</th>
                                        <th>Name</th>
                                        <th>Trainer ID</th>
                                        <th>Class</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="s" items="${trainingObjectives}">
                                        <tr>
                                            <td id="id-${s.id}">${s.id}</td>
                                            <td id="code-${s.id}">${s.code}</td>
                                            <td id="name-${s.id}">${s.name}</td>
                                            <td id="trainer-id-${s.id}">${s.trainer.account}</td>
                                            <td id="class-id-${s.id}">
                                                    ${s.classClass.name}(${df.format(dateFormat.parse(s.classClass.openDate))})
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-link"
                                                        onclick="deleteCourse(${s.id})"><i
                                                        class="fa fa-trash"></i></button>
                                                <button type="button" class="btn btn-link"
                                                        onclick="updateCourse(${s.id})"><i class="fa fa-edit"></i>
                                                </button>
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
    </div>
</div>

<jsp:include page="common/modal-training-objective.jsp"/>
</body>
<script>
    $(document).ready(function () {
        $("#tbl-trainingObjectives").DataTable({
            info: false,
            "lengthMenu": [5, 10, 15]
        })
    });
    var mess = "${messageSubject}";
    if (mess !== "") {
        toast({
            title: "Success!",
            message: mess,
            type: "success",
            duration: 5000
        });
    }
</script>

<script src="<c:url value="/resources/js/subject-management.js"/>"></script>
<script src="<c:url value="/resources/templete/assets/js/core/jquery.3.2.1.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/templete/assets/js/core/popper.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/templete/assets/js/core/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/templete/assets/js/plugins/bootstrap-switch.js"/>"></script>
<script src="<c:url value="/resources/templete/assets/js/plugins/chartist.min.js"/>"></script>
<script src="<c:url value="/resources/templete/assets/js/plugins/bootstrap-notify.js"/>"></script>
<script src="<c:url value="/resources/templete/assets/js/light-bootstrap-dashboard.js?v=2.0.0"/>"
        type="text/javascript"></script>
<script src="<c:url value="/resources/templete/assets/js/demo.js"/>"></script>
</html>