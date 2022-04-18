$(document).ready(function () {

    $.ajax({
        type: "GET",
        url: "/json/class",
        data: {
            type: "Fresher",
            start: null,
            end: null
        }, success: function (data) {
            chartClass("fresher", data);
        }
    });

    $.ajax({
        type: "GET",
        url: "/json/class",
        data: {
            type: "Internship",
            start: null,
            end: null
        }, success: function (data) {
            chartClass("internship", data);
        }
    });

    $.ajax({
        type: "GET",
        url: "/json/trainee",
        data: {
            type: "Fresher",
            start: null,
            end: null,
        }, success: function (data) {
            chartTrainee("fresher", data);
        }
    });

    $.ajax({
        type: "GET",
        url: "/json/trainee",
        data: {
            type: "Internship",
            start: null,
            end: null,
        }, success: function (data) {
            chartTrainee("internship", data);
        }
    });

    function chartTrainee(key, data) {
        let label = [];
        let values = [];
        let barColors = [];
        let chartId = "chart-trainee-" + key;
        let totalId = "#total-trainee-" + key;
        let waitingId = "#waiting-trainee-" + key;
        let releaseId = "#release-trainee-" + key;
        let runningId = "#running-trainee-" + key;
        let sumTrainne = 0;

        let waiting = {
            name: "Waiting",
            amount: 0,
            color: "#D9B44A"
        };

        let release = {
            name: "Release",
            amount: 0,
            color: "#4F6457"
        };

        let running = {
            name: "Running",
            amount: 0,
            color: "#ACD0C0"
        }

        for (let i = 0; i < data.length; i++) {
            if (waiting.name == data[i].name) {
                waiting.amount = data[i].amount;
            } else if (release.name == data[i].name) {
                release.amount = data[i].amount;
            } else if (running.name = data[i].name) {
                running.amount = data[i].amount;
            }
            sumTrainne += data[i].amount;
        }

        $(totalId).text(sumTrainne);
        $(waitingId).text(waiting.amount);
        $(releaseId).text(release.amount);
        $(runningId).text(running.amount);

        label = [waiting.name, release.name, running.name];
        values = [waiting.amount, release.amount, running.amount];
        barColors = [waiting.color, release.color, running.color];

        new Chart(chartId, {
            type: "pie",
            data: {
                labels: label,
                datasets: [{
                    backgroundColor: barColors,
                    data: values
                }]
            }
        });
    }

    function chartClass(key, data) {
        let label = [];
        let values = [];
        let barColors = [];
        let chartId = "chart-class-" + key;
        let totalId = "#total-class-" + key;
        let waitingId = "#waiting-class-" + key;
        let releaseId = "#release-class-" + key;
        let runningId = "#running-class-" + key;
        let sum = 0;

        let waiting = {
            name: "Waiting",
            amount: 0,
            color: "#D9B44A"
        };

        let release = {
            name: "Release",
            amount: 0,
            color: "#4F6457"
        };

        let running = {
            name: "Running",
            amount: 0,
            color: "#ACD0C0"
        }

        for (let i = 0; i < data.length; i++) {
            if (waiting.name == data[i].name) {
                waiting.amount = data[i].amount;
            } else if (release.name == data[i].name) {
                release.amount = data[i].amount;
            } else if (running.name = data[i].name) {
                running.amount = data[i].amount;
            }
            sum += data[i].amount;
        }

        $(totalId).text(sum);
        $(waitingId).text(waiting.amount);
        $(releaseId).text(release.amount);
        $(runningId).text(running.amount);

        label = [waiting.name, release.name, running.name];
        values = [waiting.amount, release.amount, running.amount];
        barColors = [waiting.color, release.color, running.color];

        new Chart(chartId, {
            type: "pie",
            data: {
                labels: label,
                datasets: [{
                    backgroundColor: barColors,
                    data: values
                }]
            }
        });
    };


    $("#show-report").click(function () {
        let start = $("#start").val();
        let end = $("#end").val();

        if (start.length == 0 || end.length == 0) {
            $("#error").text("Input Start Date Or End Date");
            $("#error").css("display", "block");
        } else {
            let startDate = new Date(start);
            let endDate = new Date(end);
            if (startDate > endDate) {
                $("#error").text("End Date is invalid");
                $("#error").css("display", "block");
            } else {
                $("#error").text("");
                $("#error").css("display", "none");

                $.ajax({
                    type: "GET",
                    url: "/json/class",
                    data: {
                        type: "Fresher",
                        start: start,
                        end: end
                    }, success: function (data) {
                        chartClass("fresher", data);
                    }
                });

                $.ajax({
                    type: "GET",
                    url: "/json/class",
                    data: {
                        type: "Internship",
                        start: start,
                        end: end
                    }, success: function (data) {
                        chartClass("internship", data);
                    }
                });

                $.ajax({
                    type: "GET",
                    url: "/json/trainee",
                    data: {
                        type: "Fresher",
                        start: start,
                        end: end,
                        class: $("#class-fresher option:selected").val()
                    }, success: function (data) {
                        console.log(data.length);
                        chartTrainee("fresher", data);
                    }
                });

                $.ajax({
                    type: "GET",
                    url: "/json/trainee",
                    data: {
                        type: "Internship",
                        start: start,
                        end: end
                    }, success: function (data) {
                        chartTrainee("internship", data);
                    }
                });
            }
        }
    })

    $("#class-fresher").on("change", function () {
            let start = $("#start").val();
            let end = $("#end").val();

            if (start.length < 0 || end.length < 0) {
                let startDate = new Date(start);
                let endDate = new Date(end);
                if (startDate > endDate) {
                    $("#error").text("End Date is invalid");
                    $("#error").css("display", "block");
                } else {
                    $("#error").text("");
                    $("#error").css("display", "none");
                }
            } else {
                console.log("ajax");
                $.ajax({
                    type: "GET",
                    url: "/json/trainee",
                    data: {
                        type: "Fresher",
                        start: start,
                        end: end,
                        class: $("#class-fresher option:selected").val()
                    }, success: function (data) {
                        console.log("Length: " + data.length);
                        chartTrainee("fresher", data);
                    }
                });
            }
        }
    );

    $("#class-internship").change(function () {
            let start = $("#start").val();
            let end = $("#end").val();

            if (start.length < 0 || end.length < 0) {
                let startDate = new Date(start);
                let endDate = new Date(end);
                if (startDate > endDate) {
                    $("#error").text("End Date is invalid");
                    $("#error").css("display", "block");
                } else {
                    $("#error").text("");
                    $("#error").css("display", "none");
                }
            } else {
                $.ajax({
                    type: "GET",
                    url: "/json/trainee",
                    data: {
                        type: "Internship",
                        start: start,
                        end: end,
                        class: $("#class-internship option:selected").val()
                    }, success: function (data) {
                        chartTrainee("internship", data);
                    }
                });
            }

        }
    );
})