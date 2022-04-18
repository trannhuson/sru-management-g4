$(document).ready(function() {
    $("#btn-change-password").click(function() {
        let username = $("#user-name").val();
        let oldPassword = $("#old-password").val();
        let newPassword = $("#new-password").val();
        let confirmPassword = $("#confirm-password").val();

        if (username.length == 0) {
            $("#error-user-name").text("User Name cannot be left blank");
            $("#error-user-name").css("display", "block");
        } else {
            $("#error-user-name").text("");
        }

        if (oldPassword.length == 0) {
            $("#error-old-password").text("Old password cannot be left blank");
            $("#error-old-password").css("display", "block");
        } else {
            $("#error-old-password").text("");
        }

        if (newPassword.length == 0) {
            $("#error-new-password").text("New password cannot be left blank");
            $("#error-new-password").css("display", "block");
        } else {
            $("#error-new-password").text("");
        }

        if (confirmPassword.length == 0) {
            $("#error-confirm-password").text("Old password cannot be left blank");
            $("#error-confirm-password").css("display", "block");
        } else {
            $("#error-confirm-password").text("");
        }

        if (newPassword.length != 0 && confirmPassword.length != 0) {
            if (newPassword !== confirmPassword) {
                $("#error-confirm-password").text("Confirm password is not the same as the new password");
                $("#error-confirm-password").css("display", "block");
            }
        }

        if ($("#error-user-name").text().length == 0 && $("#error-old-password").text().length == 0 && $("#error-new-password").text().length == 0 &&
            $("#error-confirm-password").text().length == 0) {
            $("#change-password-form").submit();
        }
    });
});