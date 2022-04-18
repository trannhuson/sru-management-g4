function showSolution (id, classId) {
    $.ajax({
        type: 'GET',
        url: 'get-all-issue?classId=' + classId + '&issueId=' + id,
        success: function (data) {
            $('.container').html(data);
            var solutionDisplayValue = $("#solution"+id).css("display");
            $("#solution"+id).css("display", solutionDisplayValue == "none" ? "block" : "block");
        },
    });

};