<%--
  Created by IntelliJ IDEA.
  User: www72
  Date: 2020/2/2
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<form action="<c:url value="/user.html"/>" method="post">
    <table>
    <tr>
    <td>用户名：</td>
    <td><input type="text" name="userName"></td>
    </tr>
    <tr>
    <td>密码：</td>
    <td><input type="password" name="password"></td>
    </tr>
    <tr>
    <td>姓名：</td>
    <td><input type="text" name="realName"></td>
    </tr>
    <tr>
    <td colspan="2"><input type="submit" name="提交"></td>
    </tr>
    </table>
</form>
    </body>
</html>