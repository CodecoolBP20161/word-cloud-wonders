var sendData = function () {
    var username = $("#r_username").val();
    var pwd = $("#r_password").val();

    $.ajax({
        type: "POST",
        url: "/registration",
        data: JSON.stringify({"username": username, "password": pwd}),
        contentType: "application/json; charset=utf-8"
    });
};


$(document).ready(function () {
    $("#register-submit").click(function () {
        sendData();
    });
});
