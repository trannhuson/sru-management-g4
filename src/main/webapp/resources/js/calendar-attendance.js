var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
var startYear = 2010;
var endYear = 2022;
var month = 0;
var year = 0;

function loadCalendarMonths() {
    for (var i = 0; i < months.length; i++) {
        var doc = document.createElement("div");
        doc.innerHTML = months[i];
        doc.classList.add("dropdown-item");

        doc.onclick = (function () {
            var selectedMonth = i;
            return function () {
                month = selectedMonth;
                document.getElementById("curMonth").innerHTML = months[month];
                loadCalendarDays();
                return month;
            }
        })();

        document.getElementById("months").appendChild(doc);
    }
}

function loadCalendarYears() {
    document.getElementById("years").innerHTML = "";
    for (var i = startYear; i <= endYear; i++) {
        var doc = document.createElement("div");
        doc.innerHTML = i;
        doc.classList.add("dropdown-item");

        doc.onclick = (function () {
            var selectedYear = i;
            return function () {
                year = selectedYear;
                document.getElementById("curYear").innerHTML = year;
                loadCalendarDays();
                return year;
            }
        })();

        document.getElementById("years").appendChild(doc);
    }
}
function loadCalendarDays() {
    removeAllChildNodes(document.querySelector('#week_1'));
    removeAllChildNodes(document.querySelector('#week_2'));
    removeAllChildNodes(document.querySelector('#week_3'));
    removeAllChildNodes(document.querySelector('#week_4'));
    removeAllChildNodes(document.querySelector('#week_5'));
    removeAllChildNodes(document.querySelector('#week_6'));

    $.ajax({
        url: "/trainee/get-attendance-trainee",
        type: "POST",
        data: {
            month: month + 1,
            year: year
        }, success: function (data) {
            handleData(data);
        }
    });

}

function handleData(data) {
    var tmpDate = new Date(year, month, 0);
    var num = daysInMonth(month, year);
    var dayofweek = tmpDate.getDay();       // find where to start calendar day of week

    for (var i = 1; i <= dayofweek; i++) {
        var d = document.createElement("div");
        d.classList.add("calendar__day");
        d.classList.add("day");
        d.classList.add("day-blank");
        d.innerHTML = "";
        document.getElementById("week_1").appendChild(d);
    }
    var j = 0;
    for (var i = dayofweek+1; i <= 7; i++) {
        var d = document.createElement("div");
        d.classList.add("calendar__day");
        d.classList.add("day");
        d.classList.add("day-late");
        d.innerHTML = ++j;
        d.setAttribute("id", "week_1_day_" + j);
        document.getElementById("week_1").appendChild(d);
        checkLate(d, j, data, 1);
        startTime(d, j, data, 1);
        endTime(d, j, data, 1);
    }
    for (var k = 2; k <= 4; k++) {
        for (var i = 1; i <= 7; i++) {
            var d = document.createElement("div");
            d.classList.add("calendar__day");
            d.classList.add("day");
            d.innerHTML = ++j;
            d.setAttribute("id", "week_" + k + "_day_" + j);
            document.getElementById("week_" + k).appendChild(d);
            checkLate(d, j, data, k);
            startTime(d, j, data, k);
            endTime(d, j, data, k);
        }
    }
    if (dayofweek <= 4) {
        for (var i = 1; i <= 7; i++) {
            var d = document.createElement("div");
            d.classList.add("calendar__day");
            d.classList.add("day");
            if (j < num) {
                d.innerHTML = ++j;
                d.setAttribute("id", "week_5_day_" + j);
                document.getElementById("week_5").appendChild(d);
                checkLate(d, j, data, 5);
                startTime(d, j, data, 5);
                endTime(d, j, data, 5);
            } else {
                d.classList.add("day-blank");
                d.innerHTML = "";
                document.getElementById("week_5").appendChild(d);
            }
        }
    } else {
        for (var i = 1; i <= 7; i++) {
            var d = document.createElement("div");
            d.classList.add("calendar__day");
            d.classList.add("day");
            d.innerHTML = ++j;
            d.setAttribute("id", "week_5_day_" + j);
            document.getElementById("week_5").appendChild(d);
            checkLate(d, j, data, 5);
            startTime(d, j, data, 5);
            endTime(d, j, data, 5);
        }

        for (var i = 1; i <= 7; i++) {
            var d = document.createElement("div");
            d.classList.add("calendar__day");
            d.classList.add("day");
            if (j < num) {
                d.innerHTML = ++j;
                d.setAttribute("id", "week_6_day_" + j);
                document.getElementById("week_6").appendChild(d);
                checkLate(d, j, data, 6);
                startTime(d, j, data, 6);
                endTime(d, j, data, 6);
            } else {
                d.classList.add("day-blank");
                d.innerHTML = "";
                document.getElementById("week_6").appendChild(d);
            }
        }
    }

}
function checkLate (d, x, result, week) {
    result.forEach(function (element) {
        if (x == element.dayInMonth && element.type == 'L') {
            comeLate(d, x, week);
        }
    });
}

function comeLate(d, x, week) {
    var br = document.createElement("br");
    var span = document.createElement("label");
    span.classList.add("late");
    var late = document.createElement("span");
    late.classList.add("txt-late");
    late.innerHTML = "Late";
    document.getElementById("week_"+week+"_day_" + x).appendChild(br);
    document.getElementById("week_"+week+"_day_" + x).appendChild(span);
    document.getElementById("week_"+week+"_day_" + x).appendChild(late);
    document.getElementById("week_"+week+"_day_" + x).appendChild(br);
}
function startTime (d, x, result, week) {

    var br = document.createElement("br");
    var late = document.createElement("span");
    late.classList.add("txt-startTime")
    result.forEach(function (element) {
        if (x == element.dayInMonth) {
            var e_lable = document.createElement("label");
            e_lable.classList.add("startTime");
            late.innerHTML = element.createTime == null ? "No data" : element.createTime;
            document.getElementById("week_"+week+"_day_" + x).appendChild(br);
            document.getElementById("week_"+week+"_day_" + x).appendChild(e_lable);
        }
    })

    document.getElementById("week_"+week+"_day_" + x).appendChild(late);
    document.getElementById("week_"+week+"_day_" + x).appendChild(br);
}
function endTime (d, x, result, week) {
    var br = document.createElement("br");
    var late = document.createElement("span");
    late.classList.add("txt-checkOut")
    result.forEach(function (element) {
        if (x == element.dayInMonth) {
            var e_lable = document.createElement("label");
            e_lable.classList.add("endTime");
            late.innerHTML = element.endTime == null ? "No data" : element.endTime;
            document.getElementById("week_"+week+"_day_" + x).appendChild(br);
            document.getElementById("week_"+week+"_day_" + x).appendChild(e_lable);
        }
    })

    document.getElementById("week_"+week+"_day_" + x).appendChild(late);
    document.getElementById("week_"+week+"_day_" + x).appendChild(br);
}

function daysInMonth(month, year)
{
    var d = new Date(year, month+1, 0);
    return d.getDate();
}

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}
window.addEventListener('load', function () {
    var date = new Date();
    month = date.getMonth();
    year = date.getFullYear();
    document.getElementById("curMonth").innerHTML = months[month];
    document.getElementById("curYear").innerHTML = year;
    loadCalendarMonths();
    loadCalendarYears();
    loadCalendarDays();
});