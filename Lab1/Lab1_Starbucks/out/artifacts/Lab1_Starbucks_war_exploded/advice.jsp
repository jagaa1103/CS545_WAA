<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 2/14/21
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Advice</title>
</head>
<body>
<form action="../" method="get">

    <p>Starbuck's ${roast.toUpperCase()} Roast Coffees:</p>

    <table>
        <c:forEach var="item" items="${advice}" varStatus="loop">
            <tr style="background-color:${loop.index % 2 == 0 ? 'yellow' : 'cyan'}">
                <td>${item}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Back" />
</form>
</body>
</html>
