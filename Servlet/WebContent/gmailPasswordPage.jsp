<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script>

	function required(){

		if(document.formName.identifier.value=="")
		{
			document.getElementById("demo").innerHTML="*Required field";
			return false;
		}
		return true;
	}

	</script>
</head>
<title>
Gmail
</title>

<body background="bg.jpg">
<form method ="post" name="formName" action="PasswordValidate" onsubmit="return required()">

<!--<img src = "/home/bridgeit/Desktop/week-4/bgimage.jpg" height="650" width ="1500" alt="image">
<center><img src = "/home/bridgeit/Desktop/week-4/whitebg.png" style="position:absolute; height:500px; width:450px; top:90px; left:430px"  alt="image"></center>-->

<img src = "google.png" style="position:absolute; height:33px; width:80px; left:455px; top:130px" alt="google">


<div class="div1">
<%
HttpSession ss = request.getSession();
String var = (String)request.getAttribute("email");
String firstname = (String)request.getAttribute("firstname");
%>
<h1 class="headerclass">Hi <%out.print(firstname);%> </h1>
<h1 class="subheading"><%out.print(var);%></h1>
<input id="identifier" class="username" type="password" name="password" placeholder="Enter your password">
<hr class="line">
<p id="demo" style="position:absolute; left:460px;top:305px; color:red; font-size:15px; font-family:FreeSans"></p>
<button type="button" class ="forgotPassword"> Forgot password?</button>
<p></p>
<button type="submit" class ="next"> NEXT </button>
<font style="position:absolute; top:610px; left:423px ;width:200px; font-size:12px; font-family:FreeSans">English (United States)</font>
<font style="position:absolute; top:610px; left:710px ;width:250px; font-size:13px; font-family:FreeSans; color:grey" >Help &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Privacy &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Terms</font>
</div>

</form>
</body>
<style>
.div1 {
	width: 450px;
	height: 500px;
	background-color:white;
	margin-left: 32.2%;
	margin-top: 6.8%;
	box-shadow: 1px 1px 5px #888888

}

.headerclass{
	position:relative;
	font-size:23px;
	margin-left: 8%;
	top: 90px;
 	color:black;
	font-weight:200;
 	font-family:FreeSans;
}

.subheading{
	position:relative;
	font-size:15px;
	margin-left: 8%;
	top: 80px;
 	color:black;
	font-weight:200;
 	font-family:FreeSans;
}
.username{
	position:relative;
	top:137px;
	left:35px;
	width:370px;
	border:none;
	font-size:15px;
}
.line{
	position:relative;
	left:-3px;
	top:133px;
	width:370px;
	color:#EAECEE;
}
.forgotPassword{
	position:relative;
	margin-left:6.3%;
	margin-top:184px;
	width:139px;
	font-weight:400;
	color:#4285f4;
	border:none;
	background:none;
	font-size:14px;
}

.next{
	position:relative;
	margin-left:72%;
	margin-top:-12%;
	font-size:15px;
	background-color:#4285f4;
	border:15px;
	padding:10px 23px;
	color:white;
	font-weight:500;
	border-radius:3px;
	box-shadow: 1px 1px 5px #888888
}
body{
background-position:center;
background-size:cover;
background-repeat:no-repeat;

}




</style>

</html>
