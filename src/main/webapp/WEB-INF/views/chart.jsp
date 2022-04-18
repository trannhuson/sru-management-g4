<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/templete/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>Chart</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/light-bootstrap-dashboard.css?v=2.0.0" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/templete/assets/css/demo.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/css/chart.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
</head>

<body>
<div class="wrapper">
    <jsp:include page="common/sidebar.jsp"/>
    <div class="main-panel">
        <jsp:include page="common/navbar.jsp"/>
        <div class="content">
            <div class="container">
                <div class="row" id="search-by-date">
                    <div class="col-md-5">
                        <input type="date" class="form-control" id="start">
                    </div>
                    <div class="col-md-5">
                        <input type="date" class="form-control" id="end">
                    </div>
                    <div class="col-md-2">
                        <button type="button" class="btn btn-outline-info" id="show-report">Show Report</button>
                    </div>
                </div>

                <p id="error"></p>

                <h2>Fresher statistic</h2>
                <div class="row">
                    <div class="col-md-6 d-flex">
                        <div class="card flex-fill">
                            <div class="card-header">Class</div>
                            <div class="card-body">
                                <canvas id="chart-class-fresher"></canvas>
                            </div>
                            <div class="row">
                                <div class="col-md-3 col-1">
                                    <p id="total-class-fresher">18</p>
                                    <p>Total</p>
                                </div>
                                <div class="col-md-3 col-2">
                                    <p id="waiting-class-fresher">18</p>
                                    <p>Waiting</p>
                                </div>
                                <div class="col-md-3 col-3">
                                    <p id="release-class-fresher">18</p>
                                    <p>Release</p>
                                </div>
                                <div class="col-md-3 col-4">
                                    <p id="running-class-fresher">18</p>
                                    <p>Running</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 d-flex">
                        <div class="card flex-fill">
                            <div class="card-header">
                                <div class="row">
                                    <div class="col-md-8">Trainee</div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <select class="form-control form-control-sm" id="class-fresher">
                                                <option value="" selected>Select class...</option>
                                                <c:forEach var="c" items="${classByFresher}">
                                                    <option value="${c.id}">${c.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <canvas id="chart-trainee-fresher"></canvas>
                            </div>
                            <div class="row">
                                <div class="col-md-3 col-1">
                                    <p id="total-trainee-fresher"></p>
                                    <p>Total</p>
                                </div>
                                <div class="col-md-3 col-2">
                                    <p id="waiting-trainee-fresher">18</p>
                                    <p>Waiting</p>
                                </div>
                                <div class="col-md-3 col-3">
                                    <p id="release-trainee-fresher">18</p>
                                    <p>Release</p>
                                </div>
                                <div class="col-md-3 col-4">
                                    <p id="running-trainee-fresher">18</p>
                                    <p>Running</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <h2>Internship statistic</h2>
                <div class="row">
                    <div class="col-md-6 d-flex">
                        <div class="card flex-fill">
                            <div class="card-header">Class</div>
                            <div class="card-body">
                                <canvas id="chart-class-internship"></canvas>
                            </div>
                            <div class="row">
                                <div class="col-md-3 col-1">
                                    <p id="total-class-internship"></p>
                                    <p>Total</p>
                                </div>
                                <div class="col-md-3 col-2">
                                    <p id="waiting-class-internship"></p>
                                    <p>Watiting</p>
                                </div>
                                <div class="col-md-3 col-3">
                                    <p id="release-class-internship"></p>
                                    <p>Release</p>
                                </div>
                                <div class="col-md-3 col-4">
                                    <p id="running-class-internship"></p>
                                    <p>Running</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 d-flex">
                        <div class="card flex-fill">
                            <div class="card-header">
                                <div class="row">
                                    <div class="col-md-8">Trainee</div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <select class="form-control form-control-sm" id="class-internship">
                                                <option value="" selected>Select class...</option>
                                                <c:forEach var="c" items="${classByInternship}">
                                                    <option value="${c.id}">${c.title}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body ">
                                <canvas id="chart-trainee-internship"></canvas>
                            </div>
                            <div class="row">
                                <div class="col-md-3 col-1">
                                    <p id="total-trainee-internship"></p>
                                    <p>Total</p>
                                </div>
                                <div class="col-md-3 col-2">
                                    <p id="waiting-trainee-internship"></p>
                                    <p>Waiting</p>
                                </div>
                                <div class="col-md-3 col-3">
                                    <p id="release-trainee-internship"></p>
                                    <p>Release</p>
                                </div>
                                <div class="col-md-3 col-4">
                                    <p id="running-trainee-internship"></p>
                                    <p>Running</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/chart.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/bootstrap-switch.js"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/chartist.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/plugins/bootstrap-notify.js"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/light-bootstrap-dashboard.js?v=2.0.0" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/templete/assets/js/demo.js"></script>

</html>