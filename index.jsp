<html>
    <head>
        <title>
            LogIn Page
        </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="mystyle.css"> 
         <%@page import = "java.io.*, java.lang.*, java.io.*"%>
    </head>
    <body>
    <%   
    if (request.getParameter("session") != null)
  {%>
  <script>
  alert("Session has expired");
  </script>
  <%
  }
  %>
        <section class="vh-100">
            <div class="container-fluid h-custom">
              <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                  <img src="hellofromdino.png" class="img-fluid"
                    alt="Dino Jumps image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                  <form action="LoginServlet" method="post">
                    <h4 style="padding-left: 9rem; padding-right: 9rem; padding-bottom: 2rem;">Member Login</h4>
                    <!-- Username input -->
                    <div class="form-outline mb-4">
                      <input type="text" id="form3Example3" name="username" class="form-control form-control-lg"
                        placeholder="Enter your username" />
                      <label class="form-label" for="form3Example3">Username</label>
                    </div>
          
                    <!-- Password input -->
                    <div class="form-outline mb-3">
                      <input type="password" id="form3Example4" name="password" class="form-control form-control-lg"
                        placeholder="Enter password" />
                      <label class="form-label" for="form3Example4">Password</label>
                    </div>
          
                    <div class="text-center text-lg-start mt-4 pt-2">
                       <input type=submit value='Login'> 
                      <p class="small fw-bold mt-2 pt-1 mb-0">Not a member? <a href="Home.jsp"
                          class="link-danger">Signup</a></p>
                    </div>
          
                  </form>
                </div>
              </div>
            </div>
          </section>
    </body>
</html>