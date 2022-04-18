<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/issue.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/js/toast-message.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/toast-message.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
</head>

<body>
<div id="toast"></div>
<div class="container">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="header">
                    <h2 class="modal-title">Issues Class ${issue.classIssue.name}</h2><br>
                    <div class="row-create-issue">
                        <form:form action="create-issue" method="post" id="add-issue-form" modelAttribute="issue">
                            <form:input path="name" class="form-control" style="width: 100%;" id="issues"/>
                            <form:input type="hidden" path="classIssue.id" class="classIssue" size="50" value="${issue.classIssue.id}"/>
                            <button type="submit" class="btn btn-outline-primary">Create Issues</button>
                        </form:form>
                    </div>
                </div>
                <!-- Modal body -->
                <div class="modal-body">
                    <div id="content-issues" class="container">
                        <c:forEach var="issueDTO" items="${issueDTOS}">

                            <c:url var="deleteLink" value="delete-issue">
                                <c:param name="classId" value="${issueDTO.classIssue.id}" />
                                <c:param name="issueId" value="${issueDTO.id}" />
                            </c:url>
                            <div class="issue">
                                <lable class="issue-detail" onclick="showSolution(${issueDTO.id}, ${issueDTO.classIssue.id})">
                                    <input class="issue-item" style="width: 100%;" value="${issueDTO.name}" disabled="true"/>
                                </lable>
                                <a href="${deleteLink}" class="btn btn-outline-danger btn-delete-issue" onclick="if (!(confirm('Are you sure you want to delete this issue?'))) return false"><i class="fas fa-trash-alt"></i></a>
                                <div class="solutions" id="solution${issueDTO.id}">
                                    <div class="solution-manage">
                                    <div class="solution-total">
                                        <% int index = 0;%>
                                        <c:forEach var="solution" items="${issueDTO.solutions}">
                                            <c:url var="deleteSolutionLink" value="delete-solution">
                                                <c:param name="solutionId" value="${solution.id}" />
                                            </c:url>
                                            <div id="wrap-solution">
                                                <div class="solution-item">
                                                    <form:form action="create-solution" method="post" id="add-issue-form" modelAttribute="solutionDTO">
                                                        <lable class="solution-name" href="#" onclick="return showSolutionItem(<%=index= index + 1%>, ${solution.id})"><b>Solution <%=index%></b>&nbsp;<lable class="date-solution">(${solution.createdDate})</lable></lable><br>
                                                        <div id="area-txt-<%=index%>-${solution.id}" class="area-txt">
                                                            <form:input type="text" path="nameSolution" value='${solution.nameSolution}'/>
                                                            <form:input type="hidden" path="id" class="classIssue" size="50" value="${solution.id}"/>
                                                        </div>
                                                        <div class="btn-manage-update" id="btn-manage-update-<%=index%>-${solution.id}">
                                                            <button class="btn btn-outline-primary btn-save" type="submit"><i class="fas fa-check"></i></button>
                                                            <a href="${deleteSolutionLink}" class="btn btn-outline-danger btn-save" onclick="if (!(confirm('Are you sure you want to delete this solution?'))) return false"><i class="fas fa-trash-alt"></i></a>
                                                        </div>
                                                    </form:form>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <div class="btn-plus-solution">
                                        <script type="text/javascript">
                                            var counter = ${issueDTO.size};
                                        </script>
                                        <button type="button" id="btn-plus-solution" class="btn btn-outline-success" onclick="addSolution(counter++ , ${issueDTO.id})"><i class="fas fa-plus"></i></button>
                                    </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="modal-footer">
                    <a href="get-all-class" class="btn btn-secondary" data-dismiss="modal">Close</a>
                </div>

            </div>
        </div>
<script>
    var mess = "${messageIssue}";
    if (mess !== "") {
        if (mess.includes("fail") || mess.includes("exists")) {
            toast({
                title: "Error!",
                message: mess,
                type: "error",
                duration: 5000
            });
        } else {
            toast({
                title: "Success!",
                message: mess,
                type: "success",
                duration: 5000
            });
        }
    }
</script>
<script>
    function showSolutionItem(item, idSolution) {
        var positionSolution = item;
        var solutionId = idSolution;
        console.log("idSolution: " + typeof idSolution);
        console.log("item: " + item.className);
        if (typeof item !== "number") {
            positionSolution = item.className.split("-")[2];
        }
        if (typeof idSolution !== "number") {
            solutionId = item.className.split("-")[3];
        }
        console.log("position: " + positionSolution);
        var areaDisplayValue = $("#area-txt-"+positionSolution+"-"+solutionId).css("display");
        var manageUpdateDisplayValue = $("#btn-manage-update-"+positionSolution+"-"+solutionId).css("display");

        $("#area-txt-"+positionSolution+"-"+solutionId).css("display", areaDisplayValue == "none" ? "block" : "none");
        $("#btn-manage-update-"+positionSolution+"-"+solutionId).css("display", manageUpdateDisplayValue == "none" ? "block" : "none");

    };

    function addSolution(counter, issueId) {
        var addSolution = "add";
        let element = "<div class='solution-item-item' id=" + "solution-item-item-" + counter +">"
            +'<form:form action='create-solution' method='post' id='add-solution-form' modelAttribute='solutionDTO'>'
            +"<lable class=" + "solution-name-"+ counter+ "-add"+ " id='solution-name' onclick='showSolutionItem(this)'><b>Solution</b> <lable style='color: red'>(*)</lable></lable><br>"
            +"<div id=" + "area-txt-" + counter + "-add" + " class='area-txt'>"
            +'<form:input type='text' id='nameSolution' path='nameSolution' name='nameSolution' value='${solutionDTO.nameSolution}'/>'
            +"</div>"
            +"<div class='btn-manage-update' id=" + "btn-manage-update-" + counter + "-add"+ ">"
            +"<button class='btn btn-outline-primary btn-save' type='submit'><i class='fas fa-check'></i></button>"
            +"</div>"
            +'</form:form>'
            +"</div>";
        $("#solution" + issueId).append(element);
    };
</script>
<script src="<c:url value="/resources/js/validate-issue.js" />"></script>
<script src="<c:url value="/resources/js/issue.js" />"></script>
</body>
</html>