<html>
    <head>
        <title>
            Search
        </title>
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
                  <img src="hellofromdino.png" class="img-fluid"
                    alt="Dino Jumps image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                  <form action="DeleteServlet" method="post">
                    <h4 style="padding-left: 9rem; padding-right: 9rem; padding-bottom: 2rem;">Delete Your Account</h4>
                    <!-- Username input -->
                    <div class="form-outline mb-4">
                      <input type="text" id="form3Example3" name="username" class="form-control form-control-lg"
                        placeholder="Enter username to search" />
                      <label class="form-label" for="form3Example3">Enter your username</label>
                    </div>
                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <input type="password" id="form3Example4" name="password" class="form-control form-control-lg"
                          placeholder="Enter password" />
                        <label class="form-label" for="form3Example4">Enter your password</label>
                      </div>
          
                    <div class="text-center text-lg-start mt-4 pt-2">

                       <input type=submit value='Delete'> 
                    </div>
          
                  </form>
                </div>
              </div>
            </div>
          </section>
           <% } %>
    </body>
     
</html>