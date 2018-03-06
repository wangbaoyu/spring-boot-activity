<!DOCTYPE>
<html>
<head>
    <title>
        欢迎
    </title>
</head>
<script src="../js/jquery/jquery.min.js"></script>
<body>
<h3>Hello ${user.userName} </h3>
<a href="#" onclick = "logout()">退出</a>
<script>
    function logout(){
        $.ajax({
            url:"user/logout",
            type:"post",
            dataType:"json",
            success:function(data,statusCode){
                if(data.errorCode == 0){
                    window.location.href ="/";
                }
            },
            error:function(){
                window.location.href ="/";
            }
        });
    }
</script>
</body>