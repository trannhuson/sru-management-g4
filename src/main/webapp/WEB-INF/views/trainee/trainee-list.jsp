<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Trainees in SRU</h4>
                            </div>
                            <div class="card-body">
                                <div class="body-header">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <button class="btn btn-primary"><a href="${base}/admin/trainee/trainee-add">
                                                <i class="fa fa-bars"></i>Add trainee
                                            </a></button>
                                        </div>
                                        <div class="col-md-6">
                                            <form action="${base}/admin/trainee/trainee-search" method="get" class="row">
                                                <input type="text" class="form-control col-md-10" value="${keySearch}"  id="keySearch" name="keySearch" placeholder="Enter account or name....">
                                                <input type="submit" class="btn btn-primary col-md-2" value="Search">
                                            </form>
                                        </div>
                                    </div>
                                    <div class="row mt-3  justify-content-end">
                                        <div class="col-md-3">
                                            <form action="" class="row">
                                                <label for="page" class="col-md-4" style="padding-top: 11px;">Page size</label>
                                                <input type="number" id="page" name="pageSize" required class="form-control col-md-8" value="${pageSize}" min="10" step="10" >
                                            </form>
                                        </div>
                                    </div>
                                </div>

<%--                                <span class="page-size"><b>Page size:</b><input type="number" value="10" min="10" /></span></span>--%>
                                <div class="row list">
                                    <c:forEach items="${listTrainee}" var="trainee">
                                        <c:if test="${trainee.active == true}">
                                        <c:url var="updateLink" value="/admin/trainee/trainee-update">
                                            <c:param name="traineeId" value="${trainee.id}" />
                                        </c:url>
                                        <c:url var="deleteLink" value="/admin/trainee/trainee-delete">
                                            <c:param name="traineeId" value="${trainee.id}" />
                                        </c:url>
                                        <c:url var="detailLink" value="/admin/trainee/trainee-detail">
                                            <c:param name="traineeId" value="${trainee.id}" />
                                        </c:url>
                                    <div class="col-md-6 list-infor">
                                        <div class="row">
                                            <div class="col-md-5">
                                                <img src="<c:url value="/resources/upload/image/${trainee.image}"/>" alt="">
                                            </div>
                                            <div class="col-md-7 p-4">
                                                <p><i class="fa fa-user"></i><a href="${base}/admin/trainee/trainee-detail/${trainee.id}">${trainee.fullName}</a></p>
                                                <p><i class="fa fa-info-circle"></i>${trainee.account}</p>
                                                <p><i class="fa fa-envelope-square"></i>Email: <a href="#">${trainee.email}</a></p>
                                                <p><i class="	fa fa-university"></i>University: ${trainee.university}</p>
                                                <a href="${updateLink}" class="btn btn-primary">Edit</a>
                                                <a href="${deleteLink}" class="btn btn-danger" onclick="if (!(confirm('Are you sure you want to delete this trainee?'))) return false">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                        </c:if>
                                    </c:forEach>
                                </div>

                                <nav aria-label="Page navigation example">

                                    <ul class="pagination">
                                        <li class="page-item"><a class="page-link" href="${base}/admin/trainee/page/1">First</a></li>
                                        <c:forEach var="i" begin="1" end="${totalPages}">
                                            <c:if test="${currentPage == i}">
                                                <li class="page-item active"><a class="page-link " href="${base}/admin/trainee/page/${i}">${i}</a></li>
                                            </c:if>
                                            <c:if test="${currentPage != i}">
                                                <li class="page-item"><a class="page-link " href="${base}/admin/trainee/page/${i}">${i}</a></li>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${totalPages ==0}">
                                            <li class="page-item"><a class="page-link" href="${base}/admin/trainee/page/1">Last</a></li>
                                        </c:if>
                                        <c:if test="${totalPages !=0}">
                                            <li class="page-item"><a class="page-link" href="${base}/admin/trainee/page/${totalPages}">Last</a></li>
                                        </c:if>
                                    </ul>
                                </nav>

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
            title: "Success!",
            message: mess,
            type: "success",
            duration: 3000
        });
    }
</script>
</html>