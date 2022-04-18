<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/toast-message.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/toast-message.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />

</head>
<body>
<div id="toast"></div>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
        <!-- Navbar -->
        <jsp:include page="common/navbar.jsp"/>
        <!-- End Navbar -->
        <div class="content">
            <div class="py-3">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h2 class="text-right" style="color: #888888;">Add Class</h2>
                </div>
                <p id="hideMe">${message}</p>
                <form:form action="create-class" method="post" id="add-class-form" modelAttribute="classDTO">
                    <div class="row mt-2">
                        <div class="col-md-12"><label class="labels pt-1"><b>Name</b></label>
                            <form:input type="text" path="name" class="form-control" placeholder="Enter the class name" value="${classDTO.name}" name="name" id="name"/>
                        </div>
                        <div class="col-md-12"><label class="labels pt-1"><b>Plan count</b></label>
                            <form:input type="text" path="planCount" class="form-control" placeholder="Enter the number" value="${classDTO.planCount}" name="planCount" id="planCount"/>
                        </div>

                        <div class="col-md-12"><label class="labels pt-1"><b>Status</b></label><br>
                            <form:radiobutton path="status" id="Waiting" name="status" value="Waiting"  checked="checked"/> Waiting &nbsp;&nbsp;&nbsp;&nbsp;
                            <form:radiobutton path="status" id="Running" name="status" value="Running"/> Running &nbsp;&nbsp;&nbsp;&nbsp;
                            <form:radiobutton path="status" id="Release" name="status" value="Release"/> Release<br>
                        </div>

                        <div class="col-md-12"><label class="labels pt-1"><b>Type class</b></label><br>
                            <form:radiobutton path="type" id="Fresher" name="status" value="Fresher" checked="checked"/> Fresher &nbsp;&nbsp;
                            <form:radiobutton path="type" id="Internship" name="status" value="Internship"/> Internship<br>
                        </div>
                        <div class="col-md-6"><label class="labels pt-1"><b>Start date</b></label>
                            <form:input path="openDate" type="date" class="form-control" name="startdate" id="startdate" value="${classDTO.openDate}"/>
                        </div>
                        <div class="col-md-6"><label class="labels pt-1"><b>End date</b></label>
                            <form:input path="endDate" type="date" class="form-control" name="enddate" id="enddate" value="${classDTO.endDate}"/>
                        </div>
                        <div class="col-md-12"><label class="labels pt-1"><b>Note</b></label>
                            <form:textarea path="note" class="form-control" rows="5" name="note" value="${classDTO.note}"></form:textarea>
                        </div>
                    </div>
                    <form:input type="hidden" path="id" class="classId" size="50" value="${classDTO.id}"/><br>
                    <div class="py-md-3 text-left">
                        <button class="btn btn-outline-info" type="submit" id="submit">Save</button>
                        <button class="btn btn-outline-info" type="reset">Reset</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<script>
    var mess = "${messageClass}";
    if (mess !== "") {
        if (mess.includes("fail") || mess.includes("exists")) {
            toast({
                title: "Error!",
                message: mess,
                type: "error",
                duration: 5000
            });
        }
    }
</script>
<script src="<c:url value="/resources/js/add-class.js" />"></script>
</body>
</html>