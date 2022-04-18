function deleteCourse(params) {
    $("#delete-modal").modal("show");
    let link = $("#delete").attr("href");
    link += params;

    $("#delete").attr("href", link);
};

$("#btn-create").click(function () {
    $("#modal-training-object").modal("show");
    $("#form-training-object").attr("action", "/admin/subject/training-objective-add");
    $("#header").text("Create Training Objective")

    $("#btn-submit").click(function () {
        changeData(null);
    });
})

function updateCourse(params) {
    let id = "#id-" + params;
    let code = "#code-" + params;
    let name = "#name-" + params;
    let trainerID = "#trainer-id-" + params;
    let classID = "#class-id-" + params;

    $.ajax({
        type: "POST",
        url: "/admin/json/trainer",
        data: {
            account: $(trainerID).text()
        },
        success: function (data) {
            $("#trainer-account").val(data.id);
        }
    });

    $.ajax({
        type: "POST",
        url: "/admin/json/class/id",
        data: {
            name: $(classID).text(),
        },
        success: function (data) {
            $("#class-id").val(data.code)
        }
    });
    $("#code").val($(code).text());
    $("#header").text("Update Training Objective");
    $("#name").val($(name).text());
    $("#class-id").attr("value", $(classID).text());
    $("#modal-training-object").modal("show");
    $("#form-training-object").attr("action", "/admin/subject/training-objective-update/" + params);

    $("#btn-submit").click(function () {
        changeData(params);
    });
}

function changeData(id) {
    if ($("#code").val().length == 0) {
        $("#code-error").text("Code cannot be left blank");
        $("#code-error").css("display", "block");
    } else {
        $("#code-error").text("");
    }

    if ($("#name").val().length === 0) {
        $("#name-error").text("Name cannot be left blank");
        $("#name-error").css("display", "block");
    } else {
        $("#name-error").text("");
    }

    if ($("#trainer-account").val() == null) {
        $("#trainer-account-error").text("Trainer cannot be left blank");
        $("#trainer-account-error").css("display", "block");
    } else {
        $("#trainer-account-error").text("");
    }

    if ($("#class-id").text().length === 0) {
        $("#class-id-error").text("Class cannot be left blank");
        $("#class-id-error").css("display", "block");
    } else {
        $("#class-id-error").text("");
    }

    if ($("#code-error").text().length == 0 && $("#name-error").text().length == 0
        && $("#trainer-account-error").text().length == 0 && $("#class-id-error").text().length == 0) {
        checkCode($("#code").val(), $("#class-id option:selected").val(), id);
    }
}


function checkCode(code, classId, id) {
    let codeId = "#code-error";
    let classError = "#class-id-error";
    let formId = "#form-training-object";
    $.ajax({
        type: "GET",
        url: "/admin/json/training-object/code",
        data: {
            id: id,
            code: code,
            classId: classId
        },
        success: function (output) {
            let message = output.message;
            let code = output.code;

            if (message == null && code == null) {
                $(formId).submit();
                $(classError).css("display", "none");
                $(codeId).css("display", "none");
            } else {
                if (code === "class") {
                    $(classError).text(message);
                    $(classError).css("display", "block");
                } else if (code === "code") {
                    $(codeId).text(message);
                    $(codeId).css("display", "block");
                }
            }
        }
    })
}

