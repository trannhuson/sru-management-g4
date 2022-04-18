<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="modal fade" id="modal-training-object" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="header"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form:form id="form-training-object" modelAttribute="trainingObjective" method="post">
                <div class="form-group">
                    <label for="code">Code:</label>
                    <form:input path="code" type="text" class="form-control" id="code"
                                placeholder="Enter code" name="code"/>
                    <span id="code-error" class="error"></span>
                </div>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <form:input path="name" type="text" class="form-control" id="name"
                                placeholder="Enter name" name="name"/>
                    <span id="name-error" class="error"></span>
                </div>
                <div class="form-group">
                    <label for="trainer-account">Select trainer:</label>
                    <form:select path="trainer.id" class="form-control" id="trainer-account">
                        <form:options items="${trainers}" itemValue="id" itemLabel="account"></form:options>
                    </form:select>
                    <span id="trainer-account-error" class="error"></span>
                </div>
                <div class="form-group">
                    <label for="class-id">Select class:</label>
                    <form:select path="classClass.id" class="form-control" id="class-id">
                       <form:options items="${nameAndYears}" itemLabel="title" itemValue="id"></form:options>
                    </form:select>
                    <span id="class-id-error" class="error"></span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="btn-submit">Submit</button>
            </div>
            </form:form>
        </div>
    </div>
</div>

<div class="modal fade" id="delete-modal" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Warning</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <p>Do you want to delete the course?</p>
            </div>
            <div class="modal-footer">
                <a class="btn btn-danger" id="delete" href="/admin/subject/training-objective-delete/"></span>Yes</a>
            </div>

        </div>
    </div>
</div>
