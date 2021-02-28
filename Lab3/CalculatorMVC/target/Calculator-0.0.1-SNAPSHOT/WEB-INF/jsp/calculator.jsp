<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 2/13/21
  Time: 9:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Calculate</title>
</head>
<body>
    <h1>Calculator</h1>
    <c:if test="${errors != null}">
        <ul>
        <c:forEach items="${errors}" var="error">
            <li style="color: red;">${error}</li>
        </c:forEach>
        </ul>
    </c:if>
    <form action="calculator_result" method="post">
        <input type="text" name="add1" value="${add1}" /> +
        <input type="text" name="add2" value="${add2}" />
        <input type="text" name="sum" value="${sum}"  readonly />
        <br />
        <input type="text" name="multi1" value="${multi1}" /> +
        <input type="text" name="multi2" value="${multi2}" />
        <input type="text" name="profit" value="${profit}"  readonly />
        <br />
        <input type="submit" name="Calculate" />
    </form>

</body>
</html>
