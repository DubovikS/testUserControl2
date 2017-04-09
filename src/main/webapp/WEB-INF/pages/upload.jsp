<%--
  Created by IntelliJ IDEA.
  User: Music
  Date: 09.04.2017
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form method="POST" action="/uploadFile" enctype="multipart/form-data">
  File to upload: <input type="file" name="file">
  <br />
  <input type="submit" value="Upload"> Press here to upload the file
</form>

</body>
</html>
