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

    <jsp:include page="../common/link-css.jsp"/>
    <jsp:include page="../common/varilable.jsp"/>

</head>
<body>
<div id="toast"></div>
<div class="wrapper">
    <jsp:include page="../common/sidebar.jsp"/>
    <div class="main-panel">
        <jsp:include page="../common/navbar.jsp"/>

        <div class="content">

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="title">
                            <button type="button" data-toggle="modal" data-target="#showMistake" class="btn btn-primary">Show mistake</button>
                            <h2>Your subject</h2>
                            <%--  modal--%>
                            <div class="modal fade" id="showMistake" role="dialog">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h3 class="modal-title" id="header">List of your mistake</h3>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                           <table>
                                               <table class="table table-hover table-hover table-bordered"  >
                                                   <thead>
                                                   <tr>
                                                       <th>NO.</th>
                                                       <th>MISTAKE</th>
                                                       <th>DESCRIPTION</th>
                                                       <th>NOTE</th>
                                                       <th>DATE</th>
                                                   </tr>
                                                   </thead>
                                                   <c:forEach items="${mistakes}" var="mistake" varStatus="loop">
                                                       <tr>
                                                           <td>${loop.index +1}</td>
                                                           <td>${mistake.name}</td>
                                                           <td>${mistake.description}</td>
                                                           <td>${mistake.noteMistake}</td>
                                                           <td>${mistake.createdDate}</td>
                                                       </tr>
                                                   </c:forEach>
                                               </table>
                                           </table>
                                        </div>
                                    </div>
                                </div>
                                <%--                    --%>

                        </div>
                        <table id="tableID" class="display">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>Code</th>
                                <th>Subject Name</th>
                                <th>Class</th>
                                <th>Trainer</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <c:forEach var="trainingObjectiveDTO" items="${trainingObjectiveDTOS}" varStatus="loop">
                                <c:url var="feedBackLink" value="feed-back">
                                    <c:param name="classId" value="${trainingObjectiveDTO.classClass.id}" />
                                    <c:param name="trainerId" value="${trainingObjectiveDTO.trainer.id}" />
                                    <c:param name="subjectId" value="${trainingObjectiveDTO.id}" />
                                </c:url>
                                <tr>
                                    <td>${loop.index +1}</td>
                                    <td>${trainingObjectiveDTO.code}</td>
                                    <td>${trainingObjectiveDTO.name}</td>
                                    <td>${trainingObjectiveDTO.classClass.name}</td>
                                    <td>${trainingObjectiveDTO.trainer.fullName}</td>
                                    <td><a class="btn btn-primary" href="${feedBackLink}">Feed back</a>
                                        <a class="btn btn-primary" href="${base}/trainee/subject-result?traineeId=${trainee.id}&subjectId=${trainingObjectiveDTO.id}">Result</a>
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
<jsp:include page="../common/link-feedback-js.jsp"/>
<script>
    var mess = "${messageFeedback}";
    if (mess !== "") {
        toast({
            title: "Success!",
            message: mess,
            type: "success",
            duration: 5000
        });
    }
</script>
<script>
    $(document).ready(function () {
        $('#tableID').DataTable({
            searching: false,
            info: false,
            "lengthMenu":[5,10,15]
        });
        $('#showMistakeTable').DataTable({
            searching: false,
            info: false,
            "lengthMenu":[5,10,15]
        });
    });
</script>
</body>
</html>