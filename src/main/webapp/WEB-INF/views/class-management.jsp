<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
    <title>Class management</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
    <link href="${pageContext.request.contextPath}/resources/css/light-bootstrap-dashboard.css" rel="stylesheet" type="text/css"/>
<%--    <link type="text/css" href="<c:url value="/resources/css/light-bootstrap-dashboard.css&"/>" rel="stylesheet"/>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Datatable plugin CSS file -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <!-- jQuery library file -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js">
    </script>
    <!-- Datatable plugin JS library file -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
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
            <div class="btn-group-lg p-2" style="float: right;">
                <button type="button" class="btn btn-outline-primary" onclick="window.location.href='form-create-class'">
                    Add New Class
                </button>
                <button type="button" class="btn btn-outline-primary" onclick="window.location.href='/admin/export-to-excel'">Export Classes</button>
            </div>
            <table id="tableID" class="display">
                <thead>
                <tr>
                    <th>NAME</th>
                    <th>PLAN COUNT</th>
                    <th>CURRENT COUNT</th>
                    <th>START DATE</th>
                    <th>END DATE</th>
                    <th>HEAD TEACHER</th>
                    <th>TYPE</th>
                    <th>STATUS</th>
                    <th>ISSUE</th>
                    <th>ACTION</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="classDTO" items="${classDTOS}">
                        <c:url var="updateLink" value="form-update-class">
                            <c:param name="classId" value="${classDTO.id}" />
                        </c:url>
                        <c:url var="deleteLink" value="delete-class">
                            <c:param name="classId" value="${classDTO.id}" />
                        </c:url>
                        <c:url var="issueLink" value="get-all-issue">
                            <c:param name="classId" value="${classDTO.id}" />
                        </c:url>
                        <tr>
                            <td>${classDTO.name}</td>
                            <td>${classDTO.planCount}</td>
                            <td>${classDTO.currentCount}</td>
                            <td>${classDTO.openDate}</td>
                            <td>${classDTO.endDate}</td>
                            <td>${classDTO.trainer}</td>
                            <td>${classDTO.type}</td>
                            <td>${classDTO.status}</td>
                            <td>
                                <a href="${issueLink}" class="btn btn-outline-primary">Issues</a>
                            </td>
                            <td>
                                <!-- display the update link --><a href="${updateLink}">Edit</a> |
                                <!-- display the update link --><a href="/admin/detail-class/${classDTO.id}">Detail </a>|
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Are you sure you want to delete this class?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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
        } else {
            toast({
                title: "Success!",
                message: mess,
                type: "success",
                duration: 5000
            });
        }
    }
</script>
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