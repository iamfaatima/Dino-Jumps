<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dino Jumps</title>
    <link rel="stylesheet" href="style.css">
    <%@page import = "java.io.*, java.lang.*, java.io.*"%> 
</head>
<body>
   <%
    if (session.getAttribute("uname") == null)
  {
     response.sendRedirect("index.jsp?session='000'");
  }
  else{
%>
<div class="gameContainer">
    <div class="gameOver">Welcome to Dino-Jumps </div>
    <div class="dino"></div>
    <div id="scoreCont" name="scr">0</div>
    <div class="obstacle obstacleAni"></div>
</div>
 <form name="user" action="ScoreServlet" method="GET">
    <input type="hidden" id="scoreinput1" name="scoreinput1" value="0"/>
</form>
 <% } %>
</body>
<script src="script.js"></script>

</html>