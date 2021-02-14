<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 2/13/21
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
    <h1>Calculator</h1>

    <form action="calculator" method="get">
        <input type="number" name="add1" value="${add1}" /> +
        <input type="number" name="add2" value="${add2}" />
        <input type="text" name="sum" value="${sum}"  readonly />
        <br />
        <input type="number" name="multi1" value="${multi1}" /> +
        <input type="number" name="multi2" value="${multi2}" />
        <input type="text" name="profit" value="${profit}"  readonly />
        <br />
        <input type="submit" name="Calculate" />
    </form>

</body>
</html>
