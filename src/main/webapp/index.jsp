<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.js"></script>
</head>
<body>
<div id="text-view"></div>
username: <input id="username" type="text"/>
<br/>
password: <input id="password" type="password">
<br/>
<button id="login_btn">login</button>
<button id="btn1">button1</button>
<script>
    $(document).ready(function () {
        $("#login_btn").click(function () {
            $.ajax({
                type: "POST",
                url: "login",
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                data: JSON.stringify({username: $("#username").val(), password: $("#password").val()}),
                success: function (data) {
                    console.log(data);
                    if (data && data.meta && data.meta.success) {
                        $.cookie("x-nov-token", data.data.token);
                        $("#text-view").text(data);
                    }
                }
            })
        });
        $("#btn1").click(function () {
            $.ajax({
                type: "POST",
                url: "hello.do",
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                data: JSON.stringify({id: 1}),
                success: function (data) {
                    console.log(data);
                }
            });
        });
    })
</script>
</body>
</html>