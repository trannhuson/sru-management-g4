<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
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
    <link href="<c:url value="/resources/css/style.css"  />" rel="stylesheet"/>
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
    <jsp:include page="common/varilable.jsp"/>
</head>
<div id="toast"></div>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
        <!-- Navbar -->
        <jsp:include page="common/navbar.jsp"/>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">${classDTO.name}</h4>
                            </div>
                            <div class="card-body">
                                <div>
                                    <em>Plan: </em>&nbsp;<em style="color: blue;"> ${planCount} student</em>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <em>Actual: </em>&nbsp;<em style="color: blue;"> ${actual} student</em><br><br>
                                    <em>Start date: </em>&nbsp;<em style="color: blue;"> ${startDate}</em>&nbsp;&nbsp;&nbsp;
                                    <em>End date: </em>&nbsp;<em style="color: blue;"> ${endDate}</em>
                                </div>
                            </div>
                            <hr>
                            <div class="card-group">
                                <div class="card-body text-center">
                                    <h1 class="card-title" style="color: blue; font-weight: bold;">${actual}</h1>
                                    <p class="card-text" style="color: blue;">Total</p>
                                </div>
                                <div class="card-body text-center">
                                    <h1 class="card-title" style="color: rgb(216, 62, 62); font-weight: bold;">0</h1>
                                    <p class="card-text" style="color: rgb(216, 62, 62);">Failed</p>
                                </div>
                                <div class="card-body text-center">
                                    <h1 class="card-title" style="color: rgb(84, 166, 180); font-weight: bold;">0</h1>
                                    <p class="card-text" style="color: rgb(84, 166, 180);">Passed</p>
                                </div>
                                <div class="card-body text-center">
                                    <h1 class="card-title" style="color: rgb(109, 103, 103); font-weight: bold;">0</h1>
                                    <p class="card-text" style="color: rgb(109, 103, 103);">Drop out</p>
                                </div>
                            </div>
                            <br><br><br>
                        </div>
                    </div>
                    <c:forEach items="${trainersDTO}" var="trainer">
                        <div class="py-5 col-md-4">
                            <div class="card card-user">
                                <div class="card-body">
                                    <div class="author">
                                        <img class="avatar border-gray" src="<c:url value="/resources/img/default-avatar.png"/>" alt="...">
                                        <h3 class="card-title">${trainer.fullName}</h3><br>
                                        <table class="table table-striped" style="color: #5ea3d7">
                                            <tr>
                                                <th scope="col">Account</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Email</th>
                                            </tr>
                                            <tbody>
                                            <tr>
                                                <td>${trainer.account}</td>
                                                <td>${trainer.phoneNumber}</td>
                                                <td>${trainer.email}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <div class="content">
                    <div class="btn-group-lg p-2" style="float: right;">
                        <button type="button" class="btn btn-outline-primary" data-toggle="modal"
                                data-target="#addTraineeModal">Add Trainee
                        </button>
                        <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/admin/export-to-excel/${classDTO.id}'">
                            Export class infor</button>
                    </div>
                    <br><br><br><br><br>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="title">
                                    <h2 style="color: #1D62F0">Trainee</h2>
                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row list">
                                            <c:forEach items="${traineesDTO}" var="trainee">
                                                <c:url var="updateLink" value="/admin/trainee/trainee-update">
                                                    <c:param name="traineeId" value="${trainee.id}" />
                                                </c:url>
                                                <div class="col-md-5 list-infor">
                                                    <div class="row">
                                                        <div class="col-md-4">
                                                            <img src="<c:url value="/resources/img/default-avatar.png"/>" alt="">
                                                            <div class="text-center">
                                                                <span class="fa fa-star checked"></span>
                                                                <span class="fa fa-star checked"></span>
                                                                <span class="fa fa-star checked"></span>
                                                                <span class="fa fa-star checked"></span>
                                                                <span class="fa fa-star checked"></span>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-8 p-4">
                                                            <p><i class="fa fa-user"></i><a href="/admin/trainee/trainee-detail/${trainee.id}">${trainee.fullName}</a></p>
                                                            <p><i class="fa fa-info-circle"></i> ${trainee.account}</p>
                                                            <p><i class="fa fa-mortar-board"></i> Rank: ${trainee.rank}</p>
                                                            <p><i class="fa fa-envelope-square"></i> Email: <a href="#">${trainee.email}</a>
                                                            </p>
                                                            <p><i class="	fa fa-university"></i> University: ${trainee.university}</p>
                                                            <a href="${updateLink}" class="btn btn-primary">Edit</a>
                                                            <a href="/admin/detail-class/${classDTO.id}/delete-trainee/${trainee.id}" class="btn btn-danger"
                                                               onclick="if (!(confirm('Are you sure you want to delete this class?'))) return false">Delete</a>
                                                            <a href="${base}/admin/create-mistake/${trainee.id}" class="btn btn-warning">Mistake</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="title">
                                    <h2 style="color: #1D62F0">Training Objectives</h2>
                                </div>
                                <table id="tableSubjectID" class="display">
                                    <thead>
                                    <tr>
                                        <th>Code</th>
                                        <th>Name</th>
                                        <th>Trainer</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="trainingObjectives" items="${trainingObjectives}">
                                        <c:url var="subjectLink" value="/admin/view-feedback">
                                            <c:param name="subjectId" value="${trainingObjectives.id}" />
                                            <c:param name="className" value="${classDTO.name}" />
                                            <c:param name="accountTrainer" value="${trainingObjectives.trainer.account}" />
                                            <c:param name="subjectName" value="${trainingObjectives.name}" />
                                        </c:url>
                                        <tr>
                                            <td>${trainingObjectives.code}</td>
                                            <td>${trainingObjectives.name}</td>
                                            <td>${trainingObjectives.trainer.fullName}</td>
                                            <td><a href="${subjectLink}" class="btn btn-primary">View Feedback</a></td>
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
        <!-- Modal -->
        <div class="modal fade" id="addTraineeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLabel">List of trainee</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table id="tableTraineeID" class="display">
                            <thead>
                            <tr>
                                <th>NAME</th>
                                <th>ACCOUNT</th>
                                <th>EMAIL</th>
                                <th>UNIVERSITY</th>
                                <th>ACTION</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${allTraineesDTO}" var="allTrainees">
                                <tr>
                                    <td>${allTrainees.fullName}</td>
                                    <td>${allTrainees.account}</td>
                                    <td>${allTrainees.email}</td>
                                    <td>${allTrainees.university}</td>
                                    <td>
                                        <a class="btn" href="/admin/detail-class/${classDTO.id}/add-trainee/${allTrainees.id}"><i class="fa fa-plus"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- end modal -->
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#tableTraineeID').DataTable({
            searching: false,
            info: false,
            "lengthMenu": [3, 5, 10]
        });
        $('#tableSubjectID').DataTable({
            searching: false,
            info: false,
            "lengthMenu": [3, 5, 10]
        });
    });
</script>
<script>
    var messa = "${mistakeMessage}";
    if (messa !== "") {
        toast({
            title: "Success!",
            message: messa,
            type: "success",
            duration: 3000
        });
    }
    var mess = "${message}";
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