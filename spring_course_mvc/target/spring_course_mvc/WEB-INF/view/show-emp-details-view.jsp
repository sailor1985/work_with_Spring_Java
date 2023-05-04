<%--
  Created by IntelliJ IDEA.
  User: Клен-М
  Date: 26.03.2023
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Dear, Employee, you are WELCOME!!!!</h2>

<br>
<br>
<br>


<%--Your name: ${param.employeeName}--%>

<%--Your name = ${nameAttribute} ${description}--%>

Your name = ${employee.name}
<br>
Your surname = ${employee.surname}
<br>
Your salary = ${employee.salary}
<br>
Your department = ${employee.department}
<br>
Your car = ${employee.carBrand}


</body>
</html>
