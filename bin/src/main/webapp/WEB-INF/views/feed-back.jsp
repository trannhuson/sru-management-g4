<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png"
          href="${pageContext.request.contextPath}/resources/templete/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Feed Back</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/light-bootstrap-dashboard.css?v=2.0.0"
          rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/demo.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/feed-back.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
    <script src="${pageContext.request.contextPath}/resources/js/toast-message.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/toast-message.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />

</head>

<body>
<div id="toast"></div>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
        <jsp:include page="common/navbar.jsp"/>
        <div class="content">
            <div class="container">
                <div class="jumbotron text-left">
                    <h1>TRAINING COURSE FEEDBACK FORM</h1>
                    <div class="informmation_1">
                        <p>Please indicate your level of agreement with the statements listed in Mark column of the tables
                            below</p>
                        <p>(Vui lòng cho biết mức độ tán thành của bạn với những ý kiến bên dưới)</p>
                        <p>In which: (Trong đó)</p>
                    </div>
                    <div class="informmation_2">
                        <p>5. Strongly agree: Rất đồng ý </p>
                        <p>4. Agree: Đồng ý </p>
                        <p>3. Neutral: Không hẳn tán thành nhưng cũng không phản đối</p>
                        <p>2. Disagree: Không đồng ý</p>
                        <p>1. Strongly disagree: Rất không đồng ý</p>
                    </div>
                </div>
                <div class="content">
                    <div class="container">
                        <form:form action="create-feedback" method="post" id="add-feedback" modelAttribute="feedback">

                            <p>Hi <span style="color: red">${feedback.accountTrainee}</span>, when you submit this form, the owner will be able to see your name and email
                                address.</p>
                            <p><span class="required">*</span> Required</p>

                            <div class="form-group">
                                <label for="class-name">1. Class name<span class="required">*</span></label>
                                <form:input type="text" path="className" class="form-control" id="class-name" value="${feedback.className}" readonly="true"/>
                            </div>
                            <div class="form-group">
                                <label for="trainer-account">2. Trainer name<span class="required">*</span></label>
                                <form:input type="text" path="trainerAccount" class="form-control" id="trainer-account" readonly="true" value="${feedback.trainerAccount}"/>
                            </div>

                            <div class="form-group">
                                <label for="topic">3. Topic<span class="required">*</span></label>
                                <form:input type="text" path="nameSubject" class="form-control" id="topic" readonly="true" value="${nameSubject}"/>
                            </div>

                            <div class="form-group">
                                <label for="courseLikes">4. What did you like most about this topic/course? (Những điểm bạn thích nhất ở môn học/khóa học này?)<span class="required">*</span></label>
                                <form:input type="text" path="courseLikes" class="form-control" id="courseLikes" placeholder="Nhập câu trả lời của bạn"/>
                            </div>

                            <div class="form-group">
                                <label for="improve-course">5. What aspects of the topic/course could be improved? (Những điểm có thể cải tiến ở môn học/khóa học này?)
                                    <span class="required">*</span></label>
                                <form:input type="text" path="improveCourse" class="form-control" id="improve-course" placeholder="Nhập câu trả lời của bạn" />
                            </div>

                            <div class="form-group">
                                <label for="topic">6. The course is useful for my work? (Khóa học có ích cho công việc của tôi)</label>
                                <ul>
                                    <li value="1" onclick="rating(this)" class="usefulCourseForMe">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="usefulCourseForMe" name="usefulCourseForMe" value="1" />
                                        </i></label>
                                    </li>
                                    <li value="2" onclick="rating(this)" class="usefulCourseForMe">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="usefulCourseForMe" name="usefulCourseForMe" value="2" />
                                        </i></label>
                                    </li>
                                    <li value="3" onclick="rating(this)" class="usefulCourseForMe">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="usefulCourseForMe" name="usefulCourseForMe" value="3" />
                                        </i></label>
                                    </li>
                                    <li value="4" onclick="rating(this)" class="usefulCourseForMe">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="usefulCourseForMe" name="usefulCourseForMe" value="4" />
                                        </i></label>
                                    </li>
                                    <li value="5" onclick="rating(this)" class="usefulCourseForMe">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="usefulCourseForMe" name="usefulCourseForMe" value="5" />
                                        </i></label>
                                    </li>
                                </ul>
                            </div>

                            <div class="form-group">
                                <label for="topic">7. I am satisfied with the topic/course's content? (Tôi hài lòng với nội dung môn học/khóa học)</label>
                                <ul>
                                    <li value="1" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="satisfied" name="satisfied" value="1"/>
                                        </i></label>
                                    </li>
                                    <li value="2" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="satisfied" name="satisfied" value="2"/>
                                        </i></label>
                                    </li>
                                    <li value="3" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="satisfied" name="satisfied" value="3"/>
                                        </i></label>
                                    </li>
                                    <li value="4" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="satisfied" name="satisfied" value="4"/>
                                        </i></label>
                                    </li>
                                    <li value="5" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="satisfied" name="satisfied" value="5"/>
                                        </i></label>
                                    </li>
                                </ul>
                            </div>

                            <div class="form-group">
                                <label for="topic">8. The trainer is knowledgeable in the topic/course training subject area? (Giảng viên giàu kiến thức trong lĩnh vực đang đào tạo)</label>
                                <ul>
                                    <li value="1" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="knowledgeableTeacher" name="knowledgeableTeacher" value="1"/>
                                        </i></label>
                                    </li>
                                    <li value="2" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="knowledgeableTeacher" name="knowledgeableTeacher" value="2"/>
                                        </i></label>
                                    </li>
                                    <li value="3" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="knowledgeableTeacher" name="knowledgeableTeacher" value="3"/>
                                        </i></label>
                                    </li>
                                    <li value="4" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="knowledgeableTeacher" name="knowledgeableTeacher" value="4"/>
                                        </i></label>
                                    </li>
                                    <li value="5" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="knowledgeableTeacher" name="knowledgeableTeacher" value="5"/>
                                        </i></label>
                                    </li>
                                </ul>
                            </div>

                            <div class="form-group">
                                <label for="topic">9. The trainer's instructions were clear and understandable? (Giảng viên hướng dẫn rõ ràng và dễ hiểu)</label>
                                <ul>
                                    <li value="1" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="goodInstructorsTeacher" name="goodInstructorsTeacher" value="1"/>
                                        </i></label>
                                    </li>
                                    <li value="2" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="goodInstructorsTeacher" name="goodInstructorsTeacher" value="2"/>
                                        </i></label>
                                    </li>
                                    <li value="3" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="goodInstructorsTeacher" name="goodInstructorsTeacher" value="3"/>
                                        </i></label>
                                    </li>
                                    <li value="4" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="goodInstructorsTeacher" name="goodInstructorsTeacher" value="4"/>
                                        </i></label>
                                    </li>
                                    <li value="5" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="goodInstructorsTeacher" name="goodInstructorsTeacher" value="5"/>
                                        </i></label>
                                    </li>
                                </ul>
                            </div>

                            <div class="form-group">
                                <label for="topic">10. The training content is fully transferred following the courseware? (Nội dung đào tạo được truyền đạt đầy đủ theo giáo trình)</label>
                                <ul>
                                    <li value="1" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="fullConveyedContent" name="fullConveyedContent" value="1"/>
                                        </i></label>
                                    </li>
                                    <li value="2" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="fullConveyedContent" name="fullConveyedContent" value="2"/>
                                        </i></label>
                                    </li>
                                    <li value="3" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="fullConveyedContent" name="fullConveyedContent" value="3"/>
                                        </i></label>
                                    </li>
                                    <li value="4" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="fullConveyedContent" name="fullConveyedContent" value="4"/>
                                        </i></label>
                                    </li>
                                    <li value="5" onclick="rating(this)">
                                        <label><i class="fa fa-star">
                                            <form:radiobutton path="fullConveyedContent" name="fullConveyedContent" value="5"/>
                                        </i></label>
                                    </li>
                                </ul>
                            </div>
                            <form:input type="hidden" path="accountTrainee" class="form-control" id="accountTrainee" value="${feedback.accountTrainee}" />
                            <form:input type="hidden" path="trainingObjectiveId" class="form-control" id="trainingObjectiveId" value="${feedback.trainingObjectiveId}"/>
                            <div class="act-feedback">
                                <button type="submit" class="btn-outline-primary">Submit</button>
                                <button type="button" class="btn-outline-secondary">Back</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    var mess = "${messageFeedback}";
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

<script src="${pageContext.request.contextPath}/resources/js/feed-back.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/validate-feedback.js"></script>
<%--<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/jquery.3.2.1.min.js"--%>
<%--        type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/popper.min.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/bootstrap.min.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/bootstrap-switch.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/chartist.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/bootstrap-notify.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/light-bootstrap-dashboard.js?v=2.0.0"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/demo.js"></script>

</html>