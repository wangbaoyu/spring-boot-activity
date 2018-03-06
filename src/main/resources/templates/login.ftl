<!DOCTYPE>
<html>
<head>
    <title>
        请登录
    </title>
</head>
<link rel="stylesheet" href="../css/index/login.css"/>
<script src="../js/jquery/jquery.min.js"></script>
<script src="../js/common.js"></script>
<script src="../js/index/login.js"></script>
<body>
<div id = "login" class="login_login">
    <h4>Demo登录页</h4>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input id="userName" name="userName" type="text" placeholder="请输入用户名"></td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;码：</td>
                <td><input id="passWord" name="passWord" type="password" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td><button type="reset" value="重置">重置</button></td>
                 <td><button onclick="userLogin()">登录</button></td>
            </tr>
            <tr>
               <td colspan="2">
                <a href="goRegister">还没有账号,点此注册一个！</a>
               </td>
            </tr>
        </table>
</div>
<script>
    function userLogin(){
        var userName = $("#userName").val();
        var passWord = $("#passWord").val();
        if(userName == '' || userName == undefined){
            alert("请输入用户名");
            $("#userName").focus();
            return;
        }
        if(passWord == '' || passWord == undefined){
            alert("请输入密码");
            $("#passWord").focus();
            return;
        }
        $.ajax({
            url:"user/login?userName="+userName+"&passWord="+passWord,
            type:"get",
            dataType:"json",
            success:function(data,statusCode){
                if(data.errorCode == 0){
                     window.location.href =data.errorMessage;
                }else{
                     alert(data.errorMessage);
                }
            },
            error:function(data,statusCode){
            }
        })
    }
</script>
</body>