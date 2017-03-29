<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:forward page="/users"></jsp:forward>
<a href="<c:url value="/users"/>" target="_blank">Books list</a>
</body>
</html>
