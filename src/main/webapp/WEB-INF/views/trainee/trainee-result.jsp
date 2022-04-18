<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Subject result</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="../common/link-css.jsp"/>
    <jsp:include page="../common/varilable.jsp"/>
    <style>
        .header {
            background: #eeeeee;
            border: 1px solid #d9d9d9;
            padding: 10px 10px 10px 10px;
        }
        .modal-content {
            margin-top: 65px;
        }
        h2.modal-title {
            margin-left: 35px;
        }
        .table>thead>tr>th{
            font-weight: bold !important;
            text-align: center !important;
            color: black;
        }
    </style>
</head>

<body>
<div class="wrapper">
    <jsp:include page="../common/sidebar.jsp"/>
    <div class="main-panel">
        <jsp:include page="../common/navbar.jsp"/>
        <div class="content">
            <div class="container">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="header">
                        <h2 class="modal-title">Your Result</h2><br>
                        <div class="row-create-issue">

                        </div>
                    </div>
                    <!-- Modal body -->
                    <div class="modal-body">
                        <table class="table table-border">
                            <thead>
                            <tr>
                                <th>Score</th>
                                <th>Level</th>
                                <th>Comment</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>${score.value}</th>
                                <th>${interviewResult.level}</th>
                                <th>${interviewResult.comment}</th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a href="${base}/trainee/get-all-subject" class="btn btn-secondary" data-dismiss="modal">Close</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>