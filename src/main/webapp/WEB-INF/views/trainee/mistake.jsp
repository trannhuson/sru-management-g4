<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
    <!-- Datatable plugin JS library file -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
    </script>
</head>
<body>
<div class="wrapper">
    <jsp:include page="../common/sidebar.jsp"/>
    <div class="main-panel">
        <!-- Navbar -->
        <jsp:include page="../common/navbar.jsp"/>
        <!-- End Navbar -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card trainee-add">
                            <div class="card-header">
                                <h3 class="card-title">Mistake</h3>
                            </div>
                            <div class="card-body">
                                <form:form id="form-mistake" action="${base}/admin/create-mistake/${traineeId}" modelAttribute="mistake" method="post">
                                <div class="form-group">
                                    <label for="name">Name:</label>
                                    <form:input path="name" type="text" class="form-control" id="name" required = "required"
                                                placeholder="Enter name mistake" name="name"/>
                                    <form:errors path="name" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                    <label for="description">Description:</label>
                                    <form:input path="description" type="text" class="form-control" id="description"
                                                placeholder="Enter description" name="description"/>
                                </div>
                                <div class="form-group">
                                    <label for="note">Note:</label>
                                    <form:textarea path="noteMistake" class="form-control" id="note"/>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="sumit" class="btn btn-info" id="btn-submit">Submit</button>
                            </div>
                            </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/js/validate-score.js" />"></script>
</body>
</html>