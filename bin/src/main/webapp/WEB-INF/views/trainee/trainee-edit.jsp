<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link
            rel="apple-touch-icon"
            sizes="76x76"
            href="../assets/img/apple-icon.png"
    />
    <link rel="icon" type="image/png" href="../assets/img/favicon.ico" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Trainee management
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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card trainee-add">
                            <div class="card-header">
                               <h4 class="card-title">Edit trainee</h4>
                                <span style="color: red">${message}</span>
                            </div>
                            <div class="card-body">
                                <form:form action="${base}/admin/trainee/trainee-edit" modelAttribute="trainee"  method="post" id="frm-add-trainee" enctype="multipart/form-data">
                                    <form:hidden path="id"/>
                                    <form:hidden path="password"/>
                                    <div class="form-group">
                                        <label for="account" class="col-form-label">Account:</label>
                                            <form:input path="account" type="text" readonly="true" class="form-control" id="account" name="account" placeholder="Enter account"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="col-form-label">Email:</label>
                                        <form:input path="email" type="email" id="email" name = "email" readonly="true" placeholder="Enter email" class="form-control"></form:input>
                                    </div>
                                    <div class="form-group">
                                        <label for="facebook" class="col-form-label">Facebook:</label>
                                        <form:input path="facebook" type="text" id="facebook" name = "facebook" placeholder="Enter facebook" class="form-control"></form:input>

                                    </div>
                                    <div class="form-group">
                                        <label for="fullname" class="col-form-label">Full name:</label>
                                        <form:input path="fullName" type="text" id="fullname" name = "fullname" placeholder="Enter full name" class="form-control"></form:input>
                                        <form:errors path="fullName" cssClass="error"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label">Gender:</label>
                                        <br>
                                        <div class="form-check form-check-inline">
                                            <form:radiobutton path="gender"  id="male" value="Male" name="gender" checked="checked"/>
                                            <label class="form-check-label" for="male">Male</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <form:radiobutton path="gender" id="female" value="Female" name="gender"/>
                                            <label class="form-check-label" for="female">Female</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="phonenumber" class="col-form-label">Phone number:</label>
                                        <form:input path="phoneNumber" type="text" id="phonenumber" name = "phonenumber" placeholder="Enter phone number" class="form-control"></form:input>
                                        <form:errors path="phoneNumber" cssClass="error"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="branch" class="col-form-label">Branch:</label>
                                        <form:input path="branch" type="text" id="branch" name = "branch" placeholder="Enter branch" class="form-control"></form:input>
                                        <form:errors path="branch" cssClass="error"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="factory" class="col-form-label">Factory:</label>
                                        <form:input path="faculty" type="text" id="factory" name = "factory" placeholder="Enter factory" class="form-control"></form:input>
                                        <form:errors path="faculty" cssClass="error"/>
                                    </div>
                                    <div class="form-group">
                                        <img id="photo" />
                                        <c:if test="${trainee.id != null}">
                                            <input type="file" id="imageFile" name="imageFile" accept=".jpg,.png,.jpeg" multiple value="${trainee.image}"
                                                   onchange="document.getElementById('photo').src = window.URL.createObjectURL(this.files[0])">
                                        </c:if>
                                    </div>
                                    <div class="form-group">
                                        <label for="parentdepartment" class="col-form-label">Parent Department:</label>
                                        <form:input path="parentDepartment" type="text" id="parentdepartment" name = "parentdepartment" placeholder="Enter parent department" class="form-control"></form:input>
                                        <form:errors path="parentDepartment" cssClass="error"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="recinterviewdate" class="col-form-label">Rec interview date:</label>
                                        <form:input path="recInterviewDate"   type="date" id="recinterviewdate" value="${trainee.recInterviewDate}" name = "recinterviewdate" placeholder="Select rec interview date:" class="form-control"></form:input>
                                        <form:errors path="recInterviewDate" cssClass="error"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-form-label">Interview status:</label>
                                        <br>
                                        <div class="form-check form-check-inline">
                                            <form:radiobutton path="recInterviewStatus" id="waiting" checked="checked" value="Waiting" name="waiting"/>
                                            <label class="form-check-label" for="waiting">Waiting</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <form:radiobutton path="recInterviewStatus"  id="success" value="Success" name="success" />
                                            <label class="form-check-label" for="success">Success</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <form:radiobutton path="recInterviewStatus" id="fail" value="Fail" name="fail"/>
                                            <label class="form-check-label" for="fail">Fail</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="university" class="col-form-label">University:</label>
                                        <form:input path="university" type="text" id="university" name = "university" placeholder="Enter university" class="form-control"></form:input>
                                        <form:errors path="university" cssClass="error"/>
                                    </div>
                                    <c:if test="${trainee.classRoom != null}">
                                        <div class="form-group">
                                            <label for="classRoom" class="col-form-label">Class:</label>
                                            <form:select path="classRoom.id" name="class" id="classRoom" class="form-control">
                                                <form:options items="${classRoom}" itemLabel="name" itemValue="id" ></form:options>
                                            </form:select>
                                        </div>
                                    </c:if>
                                    <div class="form-group">
                                        <label for="traineestatus" class="col-form-label">Trainee status:</label>
                                        <form:select path="status.id" name="status" id="traineestatus" class="form-control">
                                            <form:options items="${status}" itemLabel="type" itemValue="id" ></form:options>
                                        </form:select>
                                    </div>
                                    <div class="form-group">
                                        <label for="note" class="col-form-label">Note:</label>
                                        <form:textarea path="note" class="form-control" rows="10"  id="note"></form:textarea>
                                    </div>
                                    <div class="form-group">
                                        <input type="reset" class="btn btn-default" value="Reset"/>
                                        <input type="submit" class="btn btn-primary" value="Edit trainee"/>
                                    </div>
                                    <form:hidden path="image"/>
                                </form:form>
                            </div>
                        </div>
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
</body>
<jsp:include page="../common/link-js.jsp"/>
<script>
    var mess = "${traineeMessage}";
    if (mess !== "") {
        toast({
            title: "Fail!",
            message: mess,
            type: "success",
            duration: 3000
        });
    }
</script>
</html>
