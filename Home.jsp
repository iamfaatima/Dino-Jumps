<html>
<head>
<title>SignUp</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="mystyle.css">
<script language="JavaScript" type="text/javaScript">
function validateinfo()
{	
	if ( document.user.uname.value == "" )
	    {
			document.getElementById('errUser').innerHTML="*please enter username";;			
			return false;
	    }
     if ( document.user.email.value == "" )		
        {
		document.getElementById('errEmail').innerHTML="*please enter email";
		return false;
	}	
	
	if(document.user.password.value == "")	
	   {
			document.getElementById('errPwd').innerHTML="*please enter password";
			document.user.password.focus();
			return false;
	   }	
	
   if(document.user.confirm_password.value == "")	
	   {
			document.getElementById('errCpwd').innerHTML="*please enter confirm password";
			document.user.password.focus();
			return false;
	   }	
	if(document.user.password.value!=document.user.confirm_password.value)
	{
			alert(" Password and Confirm Password doesn't match");
			document.user.confirm_password.focus();
			return false;
	}
	
	return true;
}
</script>
</head>

<body>

	<!-- <form name=user action="SignupServlet" method="post" onsubmit="return validateinfo()"></form> -->

	<section class="vh-100">
		<div class="container-fluid h-custom">
		  <div class="row d-flex justify-content-center align-items-center h-100">
			<div class="col-md-9 col-lg-6 col-xl-5">
			  <img src="hellofromdino.png" class="img-fluid"
				alt="Dino Jumps image">
			</div>
			<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
			  <form name=user action="SignupServlet" method="post" onsubmit="return validateinfo()">
				  <h4 style="padding-left: 2rem; padding-right: 2rem; padding-bottom: 2rem;">Signup To Become A Member Now!</h4>
				<!-- Username input -->
				<div class="form-outline mb-4">
				  <input type="text" id="form3Example3" name="uname" class="form-control form-control-lg"
					placeholder="Enter a unique username" />
				  <label class="form-label" for="form3Example3">Username</label>
				</div>
	  
				<!-- Password input -->
				<div class="form-outline mb-3">
				  <input type="password" id="form3Example4" name="pswd" class="form-control form-control-lg"
					placeholder="Enter password" />
				  <label class="form-label" for="form3Example4">Password</label>
				</div>

				<!--Confirm Password input-->
				<div class="form-outline mb-3">
					<input type="password" id="form3Example4" name="cpswd" class="form-control form-control-lg"
					  placeholder="Enter password again" />
					<label class="form-label" for="form3Example4">Confirm Password</label>
				  </div>
	  
				<div class="text-center text-lg-start mt-4 pt-2">
				  <!-- <input type="button" class="btn btn-primary btn-lg"
					style="padding-left: 2.5rem; padding-right: 2.5rem;"><a href="score.html"
					class="link-danger">Sign Up</a></button> -->
					<input type=submit value='Signup'>
					<p class="small fw-bold mt-2 pt-1 mb-0">Already a member? <a href="index.jsp"
						class="link-danger">Login</a></p>
				</div>
			  </form>
			</div>
		  </div>
		</div>
	  </section>
</body>
</html>
	 
