$(document).ready(function() {
    $("#add-issue-form").validate({
        rules: {
            "name": {
                required: true,
                maxlength: 50,
                minlength: 3
            }
        },
        messages: {
            "name": {
                required: "Name issue is required!",
                minlength: "Name issue cannot exceed 50 characters!",
                minlength: "Name issue at least 3 characters!"
            },
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});