$(document).ready(function() {
    $.validator.addMethod("checkDate", function (value, element) {
        var startDate = new Date(value);
        var endDate = new Date($("#enddate").val());
        if (endDate < startDate)
            return false;
        return true;
    }, "The end date must be greater than the start date!");

    $.validator.addMethod("checkNumber", function (value, element) {
        return /^[0-9]*$/.test(value);
    }, "Please enter the number!");

    $("#add-class-form").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: true,
        rules: {
            "name": {
                required: true,
                maxlength: 50,
                minlength: 3
            },
            "planCount": {
                required: true,
                checkNumber: true
            },
            "openDate": {
                required: true,
                checkDate: true
            },
            "endDate": {
                required: true
            },
        },
        messages: {
            "name": {
                required: "Name class is required!",
                minlength: "Class name cannot exceed 50 characters!",
                minlength: "Class name at least 3 characters!"
            },
            "planCount": {
                required: "Number of member is required!"
            },
            "openDate": {
                required: "Start date is required!"
            },
            "endDate": {
                required: "End date is required!"
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
})