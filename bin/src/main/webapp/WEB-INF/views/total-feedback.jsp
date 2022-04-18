<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
    <title>Feedback results</title>

    <link href="${pageContext.request.contextPath}/resources/css/light-bootstrap-dashboard.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/total-feedback.css" rel="stylesheet" type="text/css"/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
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

</head>
<body>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <jsp:include page="common/navbar.jsp"/>
        <div class="main-panel">
        <h2>Feedback results</h2>
        <div class="content-feedback">
            <p>Class &emsp;&emsp;&emsp;&emsp;&nbsp;&nbsp;:&nbsp;${className}</p>
            <p>Subject&emsp;&emsp;&emsp;&emsp;:&nbsp;${subjectName} </p>
            <p>Trainer&emsp;&emsp;&emsp;&emsp;:&nbsp;${accountTrainer}</p>
            <p>Total feedback&nbsp;&nbsp;:&nbsp;${feedbackDTO.totalFeedback}</p>
            <table class="minimalistBlack">
                <thead>
                    <tr>
                        <th>No</th>
                        <th class="question">Question</th>
                        <th>Answer/Evaluate</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td class="question">What did you like most about this topic/course?</td>
                        <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#courseLikes">View detail</button></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td class="question">What aspects of the topic/course could be improved?</td>
                        <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#improveCourse">View detail</button></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td class="question">The course is useful for my work?</td>
                        <td>${feedbackDTO.totalUsefulCourseForMe}</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td class="question">I am satisfied with the topic/course's content?</td>
                        <td>${feedbackDTO.totalSatisfied}</td>
                    </tr>
                    <tr>
                        <td class="question">5</td>
                        <td>The trainer is knowledgeable in the topic/course training subject area?</td>
                        <td>${feedbackDTO.totalKnowledgeableTeacher}</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td class="question">The trainer's instructions were clear and understandable?</td>
                        <td>${feedbackDTO.totalGoodInstructorsTeacher}</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td class="question">The training content is fully transferred following the courseware?</td>
                        <td>${feedbackDTO.totalFullConveyedContent}</td>
                    </tr>
                </tbody>
            </table>

            <div class="modal fade" id="courseLikes" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title" id="exampleModalLabel">What did you like most about this topic/course?</h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table id="tableCourseLikes" class="display">
                                <thead>
                                <tr>
                                    <th class="stt">No</th>
                                    <th class="answer">Answer</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%int indexCourseLike = 1;%>
                                <c:forEach var="courseLike" items="${feedbackDTO.courseLikes}">
                                    <tr>
                                        <td class="stt"><%=indexCourseLike++%></td>
                                        <td class="answer">${courseLike}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="improveCourse" tabindex="-1" role="dialog" aria-labelledby="improveCourseModal"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title" id="improveCourseModal">What aspects of the topic/course could be improved?</h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <table id="tableImproveCourse" class="display">
                                <thead>
                                <tr>
                                    <th class="stt">No</th>
                                    <th class="answer">Answer</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%int indexImproveCourses = 1;%>
                                <c:forEach var="improveCourse" items="${feedbackDTO.improveCourses}">
                                    <tr>
                                        <td class="stt"><%=indexImproveCourses++%></td>
                                        <td class="answer">${improveCourse}</td>
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
        <script>
            $(document).ready(function () {
                $('#tableCourseLikes').DataTable({
                    searching: false,
                    info: false,
                    "lengthMenu": [3, 5, 10]
                });
                $('#tableImproveCourse').DataTable({
                    searching: false,
                    info: false,
                    "lengthMenu": [3, 5, 10]
                });
            });

        </script>
</body>
</html>