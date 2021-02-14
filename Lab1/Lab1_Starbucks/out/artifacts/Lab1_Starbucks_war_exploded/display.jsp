<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 2/14/21
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advice</title>
</head>
<body>

<h2>Login Successful</h2>
<p />

<form action = "../action/advice" method="get">
    <select name="roast" >
        <option value="-">--Choose Roast--</option>
        <option value="dark">Dark</option>
        <option value="medium">Medium</option>
        <option value="light">Light</option>
    </select>
    <br/><br/>
    <input type="submit" value = "Submit" />
</form>
</body>
</html>
