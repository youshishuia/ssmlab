<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
</head>
<body>

<form action="login1" method="post">
    <table align="center">

        <tr>
            <td colspan="2" align="center"><font color="#ff0000" size="5sp">用户登录</font></td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
