<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Guests</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="<c:url value="styles/style.css"/> " >
  <style>
    body {
      margin: 0;
      padding: 0;
      height: 100%;
      width: 100%;
      background: -webkit-radial-gradient(center, circle farthest-corner, rgba(255,255,255,0) 50%, rgba(200,200,200,1)), -webkit-radial-gradient(center, circle, rgba(255,255,255,.35), rgba(255,255,255,0) 20%, rgba(255,255,255,0) 21%), -webkit-radial-gradient(center, circle, rgba(0,0,0,.2), rgba(0,0,0,0) 20%, rgba(0,0,0,0) 21%), -webkit-radial-gradient(center, circle farthest-corner, #f0f0f0, #c0c0c0);
      background: -moz-radial-gradient(center, circle farthest-corner, rgba(255,255,255,0) 50%, rgba(200,200,200,1)), -moz-radial-gradient(center, circle, rgba(255,255,255,.35), rgba(255,255,255,0) 20%, rgba(255,255,255,0) 21%), -moz-radial-gradient(center, circle, rgba(0,0,0,.2), rgba(0,0,0,0) 20%, rgba(0,0,0,0) 21%), -moz-radial-gradient(center, circle farthest-corner, #f0f0f0, #c0c0c0);
      background: radial-gradient(center, circle farthest-corner, rgba(255,255,255,0) 50%, rgba(200,200,200,1)), radial-gradient(center, circle, rgba(255,255,255,.35), rgba(255,255,255,0) 20%, rgba(255,255,255,0) 21%), radial-gradient(center, circle, rgba(0,0,0,.2), rgba(0,0,0,0) 20%, rgba(0,0,0,0) 21%), radial-gradient(center, circle farthest-corner, #f0f0f0, #c0c0c0);
      -webkit-background-size: 100% 100%, 10px 10px, 10px 10px, 100% 100%;
      -moz-background-size: 100% 100%, 10px 10px, 10px 10px, 100% 100%;
      background-size: 100% 100%, 10px 10px, 10px 10px, 100% 100%;
      background-repeat: repeat;
      background-position: top center, 1px 1px, 0px 0px, top center;
    }
    table{
      color: mediumblue;

    }
    th {
      color: crimson;
      font-size: xx-large;
      text-align: center;
      font-family: cursive;
    }
    td{
      font-size: x-large;
      text-align: center;
      font-family: initial;

      position:relative;
    }
    h2{
      color: ghostwhite;
      text-align: center;
    }
    .wrapper{
      margin: 0 auto;
      padding-bottom: 100px;
    }
    .footer{
      background :#da9077;
      position: absolute;
      bottom: 0;
      width:100%;
      height: 80px;
      color: #ccc;
      text-align: center;
    }
    .header{
      color: navy;
      width: 98%;
      float: left;
      padding: 1%;
      background :#dadada;
      border-bottom: 2px;
    }

    @media screen and (max-width:490px){
      th {
        color: crimson;
        font-size: larger;
        text-align: center;
        font-family: cursive;
      }
      td{
        font-size: large;
        text-align: center;
        font-family: initial;

        position:relative;
      }
    }
  </style>
</head>
<body>

<c:if test="${!empty listGuests}">
  <div class="table-responsive">
    <table class="table table-hover">
      <tr>
        <th>IP</th>
        <th>Time</th>
      </tr>
      <c:forEach items="${listGuests}" var="userIp">
        <tr>
          <td data-label="IP">${userIp.number}</td>
          <td data-label="TIME">${userIp.time}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</c:if>
<br/>
<a href="/users">Back to Users</a>
</body>
</html>
