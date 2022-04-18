function update(params) {
    let createTimeId = "#create-time-" + params;
    let endTimeId = "#end-time-" + params;
    let typeId = "#type-" + params;
    let noteId = "#note-" + params;
    $("#create-time").val(null);
    $("#end-time").val(null);
    $("#error").css("display", "none");
    $("#error").text();

    $("#create-time").val($(createTimeId).text().trim());
    $("#end-time").val($(endTimeId).text().trim());


    $("#update-modal").modal("show");

    $("#btn-update-attendance").click(function () {
        let createTime = $("#create-time").val();
        let endTime = $("#end-time").val();
        console.log(createTime);
        $.ajax({
            type: "POST",
            url: "/admin/json/attendance/update",
            data: {
                id: params,
                createTime: createTime,
                endTime: endTime,
            },
            success: function (data) {
                let id = data.id;
                if (id == 0) {
                    $("#error").text("Create Time must be before the End Time");
                    $("#error").css("display", "block");
                } else if (id == null) {
                    $("#error").text("Incomplete data");
                    $("#error").css("display", "block");
                } else {
                    $("#error").text("");
                    $("#error").css("display", "none");
                    if (id === null) {
                        $("#update-modal").modal("hide");
                        demo.showMessage('top', 'right', "Update Attendance Failed");
                    } else {
                        $(typeId).text(data.type);
                        $(createTimeId).text(data.createTime);
                        $(endTimeId).text(data.endTime);
                        $(noteId).text(data.note);
                        $("#update-modal").modal("hide");
                        demo.showMessage('top', 'right', "Update Attendance Success");
                    }
                }
            }
        })
    });
};