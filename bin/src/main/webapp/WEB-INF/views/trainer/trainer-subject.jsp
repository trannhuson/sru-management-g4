<%@ page import="fa.training.srumanagementg4.dto.TrainingObjectiveDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Class management</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
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
<body>
<div class="wrapper">
    <jsp:include page="../common/sidebar.jsp"/>
    <div class="main-panel">
        <jsp:include page="../common/navbar.jsp"/>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="title py-4">
                            <h2>Subject</h2>
                        </div>
                        <table id="tableID" class="display">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Code</th>
                                <th>Subject Name</th>
                                <th>Class</th>
                                <th></th>
                            </tr>
                            </thead>
                            <c:forEach var="trainingObjectiveDTO" items="${trainingObjectiveDTOS}">
                                <tr>
                                    <td>${trainingObjectiveDTO.id}</td>
                                    <td>${trainingObjectiveDTO.code}</td>
                                    <td>${trainingObjectiveDTO.name}</td>
                                    <td>${trainingObjectiveDTO.aClass.name}</td>
                                    <td><a class="btn btn-primary" href="/trainer/get-score/${trainingObjectiveDTO.id}">Detail</a>
                                    <a class="btn btn-primary" href="/trainer/interview-result/${trainingObjectiveDTO.id}">Interview Result</a>
                                    </td>
                                </tr>
                            </c:forEach>
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
</script>
</body>
</html>