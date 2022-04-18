<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.userdetails.UserDetails" %>
<%@ page import="fa.training.srumanagementg4.entities.Users" %>
<%@ page import="fa.training.srumanagementg4.security.service.UserPrinciple" %>
<%
    String account="";
    UserPrinciple principal= (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

%>
<nav class="navbar navbar-expand-lg " color-on-scroll="500">
    <a class="navbar-brand" href="#"> ${namePage} </a>
    <div class="container-fluid">
        <div class="collapse navbar-collapse justify-content-end" id="navigation">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#pablo">
                        <span class="no-icon"><%= principal.getUsername()%></span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout-user" id="handle-logout">
                        <span class="no-icon">Log out</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/change-password">
                        <span class="no-icon">Change password</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>