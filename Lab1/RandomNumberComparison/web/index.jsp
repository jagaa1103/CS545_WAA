<%--
  Created by IntelliJ IDEA.
  User: enkhjargalgansukh
  Date: 2/14/21
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Random Number Comparison</title>
  </head>
  <body>


  <h1>And the results are: </h1>

  <c:choose>
    <c:when test="${controlNumber <= num1 && controlNumber >= num2 && controlNumber != num3}">
      <p>Control Number ${controlNumber}</p>
      <p style="color: green; font-weight: bold;">is NOT greater than ${num1}</p>
      <p style="color: red; font-weight: bold;">is NOT less than ${num2}</p>
      <p style="color: blue; font-weight: bold;">is NOT equal to ${num3}</p>
    </c:when>
    <c:when test="${controlNumber > num1}">
      <p style="color: green; font-weight: bold;">The number ${controlNumber} is greater than ${num1}</p>
    </c:when>
    <c:when test="${controlNumber < num2}">
      <p style="color: red; font-weight: bold;">The number ${controlNumber} is less than ${num2}</p>
    </c:when>
    <c:when test="${controlNumber == num3}">
      <p style="color: blue; font-weight: bold;">The number ${controlNumber} is equal to ${num3}</p>
    </c:when>

  </c:choose>

  <form action="generate" method="get">
    <input type="submit" value="Generate" />
  </form>
  </body>
</html>
