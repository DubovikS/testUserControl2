<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
</head>
<body>
Hello! Enter the number > 0 and <4000
  <form name="formArabic" method="post" action="/arabicToRoman">
    <br/>
    <input type="text" size="5" name="arabicNumber" placeholder="enter number">
    <br/>
    <input type="submit"/>
  </form>
  <c:if test="${!empty romanNumber}">
    ${romanNumber}
  </c:if>
</body>
</html>
