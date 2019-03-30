
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>

    <title>表单检验</title>

</head>
<body >
<table align="center">
    <tr>
        <td colspan="2" align="center"><font color="#ff0000" size="5sp"><h3>注册页面</h3></font></td>
    </tr>
    <form action = "register1" method = "post" onsubmit = "return checkForm();">
        <tr>
            <td>用户名：</td>
            <td><input type = "text" name = "username" id = "usernameId" onkeyup = "checkName();"/>
                <span id = "usernameMsg"></span></td><br/><br/>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type = "password" name = "password" id = "passwordId" onkeyup = "checkPassword();"/>
                <span id = "passwordMsg"></span></td><br/><br/>
        </tr>
        <tr>
            <td align="center" colspan="2"><input type = "submit" value = "注册"/></td>
        </tr>
    </form>

</body>
<script type = "text/javascript">
    var usernameObj;
    var passwordObj;
    var phoneObj;
    var usernameMsg;
    var passwordMsg;
    window.onload = function(){
        usernameObj = document.getElementById("usernameId");
        passwordObj = document.getElementById("passwordId");
        phoneObj = document.getElementById("phoneId");
        usernameMsg = document.getElementById("usernameMsg");
        passwordMsg = document.getElementById("passwordMsg");
    }
    function checkName(){
        var value = usernameObj.value;
        var regex = /[a-zA-Z]{3,8}/;
        if(value==""){
            usernameMsg.innerHTML = "用户名必须填写";
            return false;
        }
        else if (!regex.test(value)){
            usernameMsg.innerHTML = "用户名要是3-8个字母组成";
            return false;
        }
        else{
            usernameMsg.innerHTML = "";
            return true;
        }
    }

    function checkPassword(){
        var value = passwordObj.value;
        var regex = /\d{3,8}/;
        if(value==""){
            passwordMsg.innerHTML = "密码必须填写";
            return false;
        }
        else if (!regex.test(value)){
            passwordMsg.innerHTML = "密码要3-8个数字组成";
            return false;
        }
        else{
            passwordMsg.innerHTML = "";
            return true;
        }

    }
    function checkForm(){
        var usernameFlag = checkName();
        var passwordFlag = checkPassword();
        return usernameFlag && passwordFlag;
    }
</script>
</html>