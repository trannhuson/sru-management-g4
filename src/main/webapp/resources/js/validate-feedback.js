$(document).ready(function() {
    $("#add-feedback").validate({
        ignore:'',
        onfocusout: false,
        onkeyup: false,
        onclick: true,
        rules: {
            "courseLikes": {
                required: true,
                maxlength: 100,
                minlength: 3
            },
            "improveCourse": {
                required: true,
                maxlength: 100,
                minlength: 3
            },
            "usefulCourseForMe": {
                required: true
            },
            "satisfied": {
                required: true
            },
            "knowledgeableTeacher": {
                required: true
            },
            "goodInstructorsTeacher": {
                required: true
            },
            "fullConveyedContent": {
                required: true
            }
        },
        messages: {
            "courseLikes": {
                required: "You must answer this question!",
                maxlength: "Must be less than 100 characters!",
                minlength: "Must be greater than 3 characters!"
            },
            "improveCourse": {
                required: "You must answer this question!",
                maxlength: "Must be less than 100 characters!",
                minlength: "Must be greater than 3 characters!"
            },
            "usefulCourseForMe": {
                required: "You need to rate!"
            },
            "satisfied": {
                required: "You need to rate!"
            },
            "knowledgeableTeacher": {
                required: "You need to rate!"
            },
            "goodInstructorsTeacher": {
                required: "You need to rate!"
            },
            "fullConveyedContent": {
                required: "You need to rate!"
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});