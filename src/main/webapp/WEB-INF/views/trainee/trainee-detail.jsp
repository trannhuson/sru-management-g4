<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link
            rel="apple-touch-icon"
            sizes="76x76"
            href="../assets/img/apple-icon.png"
    />
    <link rel="icon" type="image/png" href="<c:url value="/resources/img/favicon.ico"/>"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>
        Trainee management
    </title>
    <meta
            content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no"
            name="viewport"
    />
    <jsp:include page="../common/link-css.jsp"/>
    <link href="<c:url value="/resources/css/trainee-details-attendance.css"/>" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/light-bootstrap-dashboard.css?v=2.0.0"
          rel="stylesheet"/>
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
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-md-5 pt-4 text-center user-text">
                        <img src="<c:url value="${base}/resources/upload/image/${trainee.image}"/>" alt="">
                        <p>${trainee.account} - ${trainee.fullName}</p>
                        <p>${trainee.phoneNumber}</p>
                        <p>${trainee.email}</p>
                    </div>
                    <div class="col-md-5 pt-4 ml-3 text-center user-result">
                        <h1>${trainee.rank}</h1>
                        <p class="final-grade">Final Grade: ${grade}</p>
                        <p class="attendance">Attendance: ${dayInMonth}</p>
                    </div>
                </div>
                <nav class="nav nav-tabs nav-justified mt-5">
                    <a class="nav-item nav-link" data-toggle="tab" href="#comments">Comments(${count})</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#score">Score</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#attendance">Attendance</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#interview-result">Interview Result</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#mistake">Mistake(${mistakes.size()})</a>
                </nav>

                <div class="tab-content">
                    <div id="comments" class="tab-pane active fade show">
                        <c:forEach items="${interviewResult}" var="comment">
                            <div class="content-comment">
                                <div class="row">
                                    <div class="col-md-2">
                                        <img src="<c:url value="/resources/img/default-avatar.png"/>" alt="">
                                    </div>
                                    <div class="col-md-10">
                                        <span class="author">${comment.trainer.fullName}(${comment.trainingObjective.name}- ${comment.trainee.classRoom.name}) </span>
                                        <span class="comment-date">Date: ${comment.dateInterview}
                                    </span>
                                        <p>${comment.comment}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div id="score" class="tab-pane fade">
                        <table class="table table-bordered text-center">
                            <tr>
                                <th>No.</th>
                                <th>Training objective</th>
                                <th>POINT</th>
                            </tr>
                            <c:forEach var="scoreDTO" items="${scoreDTOS}">
                                <c:set var="stt">
                                    ${stt + 1}
                                </c:set>
                                <tr>
                                    <td>${stt}</td>
                                    <td>${scoreDTO.trainingObjective.name}</td>
                                    <td>${scoreDTO.value}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div id="attendance" class="tab-pane fade">
                        <div class="d-flex flex-row-reverse">
                            <div class="p-2"><input type="month" id="month" value="${month}"></div>
                        </div>
                        <table class="table table-bordered text-center">
                            <tr>
                                <th>NO.</th>
                                <th>DATE</th>
                                <th>STATUS</th>
                                <th>Time In</th>
                                <th>Time Out</th>
                                <th>NOTE</th>
                                <th>Action</th>
                            </tr>
                            <tbody id="tbody-attendance">
                            <c:forEach var="a" items="${allByUsers}" varStatus="l">
                                <tr>
                                    <td>
                                            ${l.index+1}
                                    </td>
                                    <td>
                                            ${a.createdDate}
                                    </td>
                                    <td id="type-${a.id}">
                                            ${a.type}
                                    </td>
                                    <td id="create-time-${a.id}">
                                            ${a.createTime}
                                    </td>
                                    <td id="end-time-${a.id}">
                                            ${a.endTime}
                                    </td>
                                    <td id="note-${a.id}">
                                            ${a.note}
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-primary btn-sm"
                                                onclick="update(${a.id})"><i class="fa fa-edit"></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div id="interview-result" class="tab-pane fade">
                        <table class="table table-bordered text-center">
                            <tr>
                                <th>No.</th>
                                <th>NAME SUBJECT</th>
                                <th>LEVEL</th>
                            </tr>
                            <c:forEach items="${interviewResult}" var="result" varStatus="loop">
                                <tr>
                                    <td>
                                            ${loop.index +1}
                                    </td>
                                    <td>
                                        <span>${result.trainingObjective.name}</span>
                                    </td>
                                    <td>
                                            ${result.level}/5
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div id="mistake" class="tab-pane fade">
                        <table class="table table-bordered text-center">
                            <tr>
                                <th>NO.</th>
                                <th>MISTAKE</th>
                                <th>DESCRIPTION</th>
                                <th>NOTE</th>
                                <th>DATE</th>
                                <th>ACTION</th>
                            </tr>
                            <c:forEach items="${mistakes}" var="mistake" varStatus="loop">
                                <tr>
                                    <td>${loop.index +1}</td>
                                    <td>${mistake.name}</td>
                                    <td>${mistake.description}</td>
                                    <td>${mistake.noteMistake}</td>
                                    <td>${mistake.createdDate}</td>
                                    <td>
                                        <a class="btn btn-primary" data-toggle="modal"
                                           data-target="#editMistake"><i class="fa fa-edit"></i>
                                        </a>
                                        <!-- Modal -->
                                        <div class="modal fade" id="editMistake" role="dialog">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h4 class="modal-title" id="header">Mistake</h4>
                                                        <button type="button" class="close" data-dismiss="modal">
                                                            &times;
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form:form id="form-mistake"
                                                                   action="${base}/admin/update-mistake"
                                                                   modelAttribute="mistakeEdit" method="post">
                                                        <form:hidden path="id" value="${mistake.id}"/>
                                                        <form:hidden path="trainee" value="${mistake.trainee.id}"/>
                                                        <div class="form-group">
                                                            <label for="name">Name:</label>
                                                            <form:input path="name" type="text" class="form-control"
                                                                        id="name" required="required"
                                                                        value="${mistake.name}"
                                                                        placeholder="Enter name mistake" name="name"/>
                                                            <form:errors path="name" cssClass="error"/>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="description">Description:</label>
                                                            <form:input path="description" type="text"
                                                                        class="form-control" id="description"
                                                                        value="${mistake.description}"
                                                                        placeholder="Enter description"
                                                                        name="description"/>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="note">Note:</label>
                                                            <form:input path="noteMistake"
                                                                        value="${mistake.noteMistake}"
                                                                        class="form-control" id="note"/>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="sumit" class="btn btn-info" id="btn-submit">Edit
                                                        </button>
                                                    </div>
                                                    </form:form>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- end modal -->
                                        <a class="btn btn-primary" data-toggle="modal"
                                           data-target="#deleteMistake"><i class="fa fa-trash"></i>
                                        </a>
                                        <div class="modal fade" id="deleteMistake" role="dialog">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h4 class="modal-title">Notification</h4>
                                                        <button type="button" class="close" data-dismiss="modal">&times;
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Do you want to delete the mistake?</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <a class="btn btn-danger" id="delete"
                                                           href="${base}/admin/delete-mistake?mistakeId=${mistake.id}&traineeId=${trainee.id}"></span>
                                                            Yes</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <footer class="footer">
            <div class="container-fluid">
                <nav>
                    <ul class="footer-menu">
                        <li>
                            <a href="#"> Home </a>
                        </li>
                        <li>
                            <a href="#"> Company </a>
                        </li>
                        <li>
                            <a href="#"> Portfolio </a>
                        </li>
                        <li>
                            <a href="#"> Blog </a>
                        </li>
                    </ul>
                    <p class="copyright text-center">
                        ©
                        <script>
                            document.write(new Date().getFullYear());
                        </script>
                        <a href="#">Group 4</a>, made with love for a better web
                    </p>
                </nav>
            </div>
        </footer>
    </div>
</div>

<jsp:include page="../common/modal-update-attendance.jsp"/>

</body>
<jsp:include page="../common/link-js.jsp"/>
<script src="<c:url value="/resources/templete/assets/js/demo.js"/>"></script>
<script src="<c:url value="/resources/js/update-attendance.js"/>"></script>

<script>
    $(document).ready(function () {
        $("#month").on("change", function () {

            $.ajax({
                type: "POST",
                url: "/admin/json/attendance/list",
                data: {
                    id: ${trainee.id},
                    monthAndYear: $("#month").val(),
                },
                success: function (data) {
                    let row = '';
                    for (let i = 0; i < data.length; i++) {
                        row = row + '<tr>' +
                            '<td>' + (i + 1) +
                            '</td>'
                            + '<td>' + data[i].createdDate +
                            '</td>' +
                            '<td id="type-' + data[i].id + '">' + data[i].type +
                            '</td>' +
                            '<td id="create-time-' + data[i].id + '">' + data[i].createTime +
                            '</td>' +
                            '<td id="end-time-' + data[i].id + '">' + data[i].endTime +
                            '</td>' +
                            '<td id="note-' + data[i].id + '">' + data[i].note +
                            '</td>' +
                            '<td>' + ' <button type="button" class="btn btn-primary btn-sm" onclick="update(' + data[i].id + ')">' + '<i class="fa fa-edit"></i>' + '</button>' +
                            '</td>'
                            +
                            '</tr>';

                    }

                    $("#tbody-attendance").html(row);
                }
            })
        });
    })
</script>


<script>
    var mess = "${mistakeMessage}";
    if (mess !== "") {
        toast({
            title: "Success!",
            message: mess,
            type: "success",
            duration: 3000
        });
    }
</script>
</html>
