<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="sidebar" data-image="${pageContext.request.contextPath}/resources/img/sidebar-5.jpg"/>
<div class="sidebar-wrapper">
    <div class="logo">
        <a href="#" class="simple-text"> FRESHER REPORT </a>
    </div>
    <ul class="nav">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li>
            <a class="nav-link" href="/chart">
                <i class="fa fa-bar-chart"></i>
                <p>Dashboard</p>
            </a>
        </li>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_TRAINEE')">
        <li>
            <a class="nav-link" href="/trainee/attendance/get-trainee">
                <i class="fa fa-calendar" aria-hidden="true"></i>
                <p>Attendance</p>
            </a>
        </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_TRAINEE')">
            <li>
                <a class="nav-link" href="/trainee/get-all-subject">
                    <i class="fa fa-book" aria-hidden="true"></i>
                    <p>Subject</p>
                </a>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li class="nav-item">
            <a class="nav-link" href="/admin/get-all-class">
                <i class="fa fa-pie-chart"></i>
                <p>Class managenet</p>
            </a>
        </li>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li>
            <a class="nav-link" href="/admin/trainee/trainee-list">
                <i class="fa fa-pie-chart"></i>
                <p>Trainee managenet</p>
            </a>
        </li>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li>
            <a class="nav-link" href="/admin/subject/get-all-subject">
                <i class="fa fa-book"></i>
                <p>Subject management</p>
            </a>
        </li>
        </sec:authorize>

        <sec:authorize access="hasRole('ROLE_TRAINER')">
        <li>
            <a class="nav-link" href="/trainer/get-subject">
                <i class="fa fa-book"></i>
                <p>Trainer subject </p>
            </a>
        </li>
        </sec:authorize>

    <sec:authorize access="hasRole('ROLE_TRAINEE')">
        <li>
            <a class="nav-link" href="/trainee/calendar-attendance">
                <i class="fa fa-calendar-check"></i>
                <p>Calendar attendance</p>
            </a>
        </li>
    </ul>
    </sec:authorize>
</div>
</div>