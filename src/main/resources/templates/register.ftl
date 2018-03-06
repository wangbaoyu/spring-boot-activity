<!DOCTYPE>
<html>
<head>
    <title>
        注册
    </title>
</head>
<link rel="stylesheet" href="../css/index/regist.css"/>
<script src="../js/jquery/jquery.min.js"></script>
<script src="../js/common.js"></script>
<body>
<div id = "login" class="regist_regist">
    <h4>注册</h4>
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
            <td><button onclick="userLogin()">注册</button></td>
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
            url:"user/regist?userName="+userName+"&passWord="+passWord,
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