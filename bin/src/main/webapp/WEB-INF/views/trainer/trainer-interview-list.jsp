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
    <jsp:include page="../common/link-css.jsp"/>
    <jsp:include page="../common/varilable.jsp"/>
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
                <button type="button" class="btn btn-primary" data-toggle="modal"
                        data-target="#addInterview ">Import interview result
                </button>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="title py-4">
                            <h3>List interview result: ${subject.name} </h3>
                        </div>
                        <table id="tableID" class="display">
                            <thead>
                            <tr>
                                <th>No.</th>
                                <th>Name</th>
                                <th>Account</th>
                                <th>Level</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${listInterview}" var="interview" varStatus="loop">
                                <tr>
                                    <td>${loop.index +1}</td>
                                    <td>${interview.trainee.fullName}</td>
                                    <td>${interview.trainee.account}</td>
                                    <td>${interview.level}</td>
                                    <td><a class="btn btn-primary"
                                           href="/trainer/interview-result-edit/${interview.id}">Edit</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <%--  modal--%>
                    <div class="modal fade" id="addInterview" role="dialog">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="header">Interview result subject: ${subject.name}</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <c:if test="${trainee.size() > 0}">
                                    <form:form action="/trainer/interview-result/${subject.id}"
                                               modelAttribute="interviewResult" method="post" id="frm-interview-result">
                                        <form:hidden path="id"/>
                                        <form:hidden path="trainer.id" value="${trainer.id}"/>
                                        <form:hidden path="trainingObjective.id" value="${subject.id}"/>
                                        <div class="form-group">
                                            <label for="trainee" class="col-form-label"><b>Trainee</b>:</label>
                                            <form:select path="trainee.id" name="trainee" id="trainee"
                                                         class="form-control">
                                                <c:forEach var="trainee" items="${trainee}">
                                                    <form:option value="${trainee.id}"
                                                                 label="${trainee.fullName}-${trainee.account}"/>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                        <div class="form-group">
                                            <label for="level" class="col-form-label"><b>Level</b>:</label>
                                            <form:input path="level" type="number" max="5" min="1" value="1"
                                                        class="form-control"/>
                                            <form:errors path="level" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="comment" class="col-form-label"><b>Comment</b>:</label>
                                            <form:input path="comment" type="text" placeholder="Enter comment"
                                                        required="required" class="form-control"/>
                                            <form:errors path="comment" cssClass="error"/>
                                        </div>
                                        <div class="form-group">
                                            <input type="reset" class="btn btn-default" value="Reset"/>
                                            <input type="submit" class="btn btn-primary" value="Save"/>
                                        </div>
                                    </form:form>
                                    </c:if>
                                    <c:if test="${trainee.size() == 0}"><h3>No trainee to interview</h3></c:if>
                                </div>
                            </div>
                        </div>
                        <%--                    --%>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../common/link-js.jsp"/>
    <script>
        $(document).ready(function () {
            $('#tableID').DataTable({
                searching: false,
                info: false
            });
        });
    </script>
    <script>
        var mess = "${interviewMessage}";
        if (mess !== "") {
            toast({
                title: "Success!",
                message: mess,
                type: "success",
                duration: 3000
            });
        }
    </script>
</body>
</html>