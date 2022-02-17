<html>
<head>
<title>Score</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="mystyle.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
		  <div class="navbar-header">
			<a class="navbar-brand" href="game.jsp">Play Game</a>
          </div>
          <p class="nav navbar-nav">
          <li class="active"><a href="index.jsp">Signup/login</a></li>
          <li><a href="ScoreServlet">View Score</a></li>
          <li><a href="search.jsp">Search Gamers</a></li>
          <li><a href="delete.jsp">Delete your account</a></li>
          <li><a href="LogoutServlet">Logout</a></li>
          </p>
		</div>
	  </nav>

	<section class="vh-100">
		<div class="container-fluid h-custom">
		  <div class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-md-9 col-lg-6 col-xl-5">
			  <img src="hellofromdino.png" class="img-fluid" alt="Dino Jumps image">
			</div>
			<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
			  <!-- <form name=user action="ScoreServlet" method="get"> -->
				  <h2 style="padding-left: 2rem; padding-right: 2rem; padding-bottom: 0.3rem;">Instructions</h2>
                <table>
                    <tr>
                        <td id="form3Example3" class="form-control form-control-lg"> press upward key to jump </td></br>
						<td id="form3Example3" class="form-control form-control-lg"> press forward key to move forward </td></br>
						<td id="form3Example3" class="form-control form-control-lg"> press backward key to move backward </td></br>
						<td id="form3Example3" class="form-control form-control-lg"> press upward and forward key to jump over the obstacle </td>

                    </tr>
                </table>

				</div>


			</div>
		  </div>
		</div>
	  </section>
	   <% } %>
</body>

</html>