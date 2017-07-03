$(document).ready(function () {
    $('#login').click(function () {
        $.post(
            "/account/login",
            $("#loginForm").serialize(),
            function (data, status) {
                if (200 == data.code) {
                    navi2page("/cart.html");
                } else {
                    navi2page("/login.html");
                }
            }
        );
    });
});
