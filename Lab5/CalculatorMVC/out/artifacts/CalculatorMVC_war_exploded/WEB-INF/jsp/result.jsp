<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 2/14/21
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%--    <c:forEach items="${stringList}" var="message">--%>
        <h2>${stringList[0]}</h2>
        <h2>${stringList[1]}</h2>
<%--    </c:forEach>--%>

    <h3>Result</h3>
    <p>${calculator.add1} + ${calculator.add2} = ${calculator.sum}</p>
    <p>${calculator.multi1} * ${calculator.multi2} = ${calculator.profit}</p>
</body>
</html>
