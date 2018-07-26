$('body').on('click', '.products', function() {
    $(this).toggleClass("opened");
    $(".shadow1").toggleClass("show");
});
$(".shadow1").click(function() {
    $(this).removeClass("show");
    $(this).removeClass("opened");
    $(".products").removeClass("opened");
});