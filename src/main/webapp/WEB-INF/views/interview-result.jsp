<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Class management</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="<c:url value="/resources/css/light-bootstrap-dashboard.css?v=2.0.0 " />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Datatable plugin CSS file -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <!-- jQuery library file -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js">
    </script>
    <!-- Datatable plugin JS library file -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
    </script>
</head>
<style type="text/css">
    body input[type="number"]{
        border: 1px solid #ccc;
        text-align: center;
    }
    .table > thead > tr > th {
        text-align: center!important;
        font-weight: bold;
        color: black;
    }
</style>
<body>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg " color-on-scroll="500">
            <div class="container-fluid">
                <a class="navbar-brand" href="#"> Interview result subject: ${subjectName} </a>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link">
                                <span class="no-icon">Admin</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span class="no-icon">Log out</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">

            <table class="table table-bordered table-hover " id="myTable">
                <thead>
                <tr >
                    <th>NAME</th>
                    <th>ACCOUNT</th>
                    <th>LEVEL</th>
                    <th>APPLY</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${trainee}" var="trainee">
                    <form action="/trainer/interview" method="post">
                        <tr>
                            <input type="hidden" name="trainerId" value="${trainerId}"/>
                            <input type="hidden" name="traineeId" value="${trainee.id}"/>
                            <input type="hidden" name="subjectId" value="${subjectId}"/>
                            <input type="hidden" name="classId" value="${classId}"/>
                            <td>${trainee.fullName}</td>
                            <td>${trainee.account}</td>
                            <td>
                                <input  type="number"  max="5" min="1" value="1" required = "required" name="level"/>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-outline-primary btn-save"><i id="btn-save"  class="fa fa-check"></i></button>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>