function checkSession() {
    $.get(
        "/session/token",
        function (data, status) {
            if (200 != data.code) {
                //跳转
                navi2page("/login.html");
                return;
            }
        }
    );
}

checkSession();
