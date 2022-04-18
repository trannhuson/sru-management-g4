function rating(element) {
    if (element.classList.contains("active")) {
        $(element).nextAll().removeClass("active");
        $(element).nextAll().removeClass("active");
    } else {
        $(element).addClass("active");
        $(element).prevAll().addClass("active")
    }
}