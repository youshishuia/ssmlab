<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/18
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验室</title>
</head>
<body>
<table border="1">
    <tr>
        <td>序号</td>
        <td>实验室名</td>
        <td>地址</td>
    </tr>

                <tr>
                    <td>${lab.id}</td>
                    <td>${lab.name}</td>
                    <td>${lab.address}</td>
                </tr>

</table>
</body>
</html>
