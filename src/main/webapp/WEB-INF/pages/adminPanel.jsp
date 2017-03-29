<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title></title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
  <link rel="stylesheet" href="<c:url value="styles/style.css"/> " >
  <script>
    jQuery(window).load(function() {
      $(".loaderbig, .loadersmall").fadeOut();
      $(".preloader").delay(1000).fadeOut("slow");
    });
  </script>
  <style>
    body {
      margin: 0;
      padding: 0;
      height: 100%;
      background: -webkit-radial-gradient(center, circle farthest-corner, rgba(255,255,255,0) 50%, rgba(200,200,200,1)), -webkit-radial-gradient(center, circle, rgba(255,255,255,.35), rgba(255,255,255,0) 20%, rgba(255,255,255,0) 21%), -webkit-radial-gradient(center, circle, rgba(0,0,0,.2), rgba(0,0,0,0) 20%, rgba(0,0,0,0) 21%), -webkit-radial-gradient(center, circle farthest-corner, #f0f0f0, #c0c0c0);
      background: -moz-radial-gradient(center, circle farthest-corner, rgba(255,255,255,0) 50%, rgba(200,200,200,1)), -moz-radial-gradient(center, circle, rgba(255,255,255,.35), rgba(255,255,255,0) 20%, rgba(255,255,255,0) 21%), -moz-radial-gradient(center, circle, rgba(0,0,0,.2), rgba(0,0,0,0) 20%, rgba(0,0,0,0) 21%), -moz-radial-gradient(center, circle farthest-corner, #f0f0f0, #c0c0c0);
      background: radial-gradient(center, circle farthest-corner, rgba(255,255,255,0) 50%, rgba(200,200,200,1)), radial-gradient(center, circle, rgba(255,255,255,.35), rgba(255,255,255,0) 20%, rgba(255,255,255,0) 21%), radial-gradient(center, circle, rgba(0,0,0,.2), rgba(0,0,0,0) 20%, rgba(0,0,0,0) 21%), radial-gradient(center, circle farthest-corner, #f0f0f0, #c0c0c0);
      -webkit-background-size: 100% 100%, 10px 10px, 10px 10px, 100% 100%;
      -moz-background-size: 100% 100%, 10px 10px, 10px 10px, 100% 100%;
      background-size: 100% 100%, 10px 10px, 10px 10px, 100% 100%;
      background-repeat: repeat;
      background-position: top center, 1px 1px, 0px 0px, top center;
    }
    .preloader {
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      width: 100%;
      height: 100%;
      background: #fff;
      overflow: hidden !important;
      z-index: 99999;
    }
    .loaderbig {
      background-color: rgba(0,0,0,0);
      border:5px solid rgba(0,183,229,0.9);
      opacity:.9;
      border-top:5px solid rgba(0,0,0,0);
      border-left:5px solid rgba(0,0,0,0);
      border-radius:50px;
      box-shadow: 0 0 35px #2187e7;
      width:50px;
      height:50px;
      position: absolute;
      left: 50%;
      top: 50%;
      margin: -25px 0 0 -25px;
      -webkit-animation:loaderbig .5s infinite linear;
      animation:loaderbig .5s infinite linear;
    }
    .loadersmall {
      background-color: rgba(0,0,0,0);
      border:5px solid rgba(0,183,229,0.9);
      opacity:.9;
      border-top:5px solid rgba(0,0,0,0);
      border-left:5px solid rgba(0,0,0,0);
      border-radius:50px;
      box-shadow: 0 0 15px #2187e7;
      width:30px;
      height:30px;
      position: absolute;
      left: 50%;
      top: 50%;
      margin: -15px 0 0 -15px;
      -webkit-animation:loadersmall .5s infinite linear;
      animation:loadersmall .5s infinite linear;
    }

    @-webkit-keyframes loaderbig {
      0% { -webkit-transform:rotate(0deg); }
      100% { -webkit-transform:rotate(360deg); }
    }
    @-webkit-keyframes loadersmall {
      0% { -webkit-transform:rotate(0deg); }
      100% { -webkit-transform:rotate(-360deg); }
    }
    @keyframes loaderbig {
      0% { transform:rotate(0deg); }
      100% { transform:rotate(360deg); }
    }
    @keyframes loadersmall {
      0% { transform:rotate(0deg); }
      100% { transform:rotate(-360deg); }
    }
    th {
      color: crimson;
      font-size: xx-large;
      text-align: center;
    }
    h2{
      color: ghostwhite;
      text-align: center;
    }
    td{
      font-size: x-large;
      text-align: center;
    }
    table{
      color: mediumblue;
      font-family: cursive;
    }
  </style>
</head>
<body>

<h1>Admin Panel</h1>
<c:if test="${!empty listUsers}">
  <table class="table table-hover">
    <tr>
      <th>id</th>
      <th>First Name</th>
      <th>Second Name</th>
      <th>Status</th>
      <th>Card Number</th>
    </tr>
    <c:forEach items="${listUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>${user.secondName}</td>
        <td>${user.status}</td>
        <td>${user.cardNumber}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<a href="/users">Back</a>
</body>
</html>
