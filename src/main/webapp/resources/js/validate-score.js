$(document).ready(function() {
    $("#frm-create-score").validate({
        rules: {
            "value": {
                required: true,
                number: true,
                range: [0,10]
            }
        },
        messages: {
            "value": {
                required: "Value is required!",
                number: "Must be digit number",
                range: "Value must greater than 0 and less than 10"
            },
        },
    });
});