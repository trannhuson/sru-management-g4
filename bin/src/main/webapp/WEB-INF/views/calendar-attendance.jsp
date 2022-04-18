<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calendar Attendance</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"/>
    <!-- CSS Files -->
    <link href="<c:url value="/resources/css/light-bootstrap-dashboard.css?v=2.0.0 " />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Datatable plugin CSS file -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
    <!-- jQuery library file -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <!-- Datatable plugin JS library file -->
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js">
    </script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/calendar-attendance.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
</head>
<body>
    <div class="wrapper">
        <jsp:include page="common/sidebar.jsp"/>
        <div class="main-panel">
            <!-- Navbar -->
            <jsp:include page="common/navbar.jsp"/>
            <div class="wrapper-calendar">
                <main>
                    <div class="calendar" id="calendar">
                    <div class="toolbar">
                        <div class="toggle">
                            <ul class="infor-table">
                                <li><i class="fas fa-circle late"></i></i></lable><span class="check-in-late">Late</span></li>
                                <li><i class="fas fa-circle startTime"></i></lable><span class="check-in-start">Check-in time</span></li>
                                <li><i class="fas fa-circle endTime"></i></lable><span class="check-in-end">Check-out time</span></li>
                            </ul>
                        </div>
                        <div class="calendar-btn month-btn" onclick="$('#months').toggle('fast')">
                            <span id="curMonth"></span>
                            <div id="months" class="months dropdown"></div>
                        </div>

                        <div class="calendar-btn year-btn" onclick="$('#years').toggle('fast')">
                            <span id="curYear"></span>
                            <div id="years" class="years dropdown"></div>
                        </div>

                        <div class="clear"></div>

                    </div>
                    <div class="cal0endar">
                        <div class="calendar__header">
                            <div>mon</div>
                            <div>tue</div>
                            <div>wed</div>
                            <div>thu</div>
                            <div>fri</div>
                            <div>sat</div>
                            <div>sun</div>
                            <div class="clear"></div>
                        </div>
<%--                        <div class="calendarDays">--%>
                        <div class="calendar__week" id="week_1">
                        </div>
                        <div class="calendar__week" id="week_2">
                        </div>
                        <div class="calendar__week" id="week_3">
                        </div>
                        <div class="calendar__week" id="week_4">
                        </div>
                        <div class="calendar__week" id="week_5">
                        </div>
                        <div class="calendar__week" id="week_6">
                        </div>
<%--                        </div>--%>
                    </div>
                    </div>
                </main>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/resources/js/calendar-attendance.js"></script>
</body>
</html>
