<%--
  Created by IntelliJ IDEA.
  User: zcb
  Date: 2018/4/20
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<h2>Student Information</h2>
<form:form method="POST" action="/addStudent">
    <table>
        <tr>
            <td><form:label path="name">名字：</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="age">年龄：</form:label></td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td><form:label path="id">编号：</form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交表单"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
