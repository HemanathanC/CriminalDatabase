<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Changepassword</title>
<style>
fieldset{
	background-color:rgb(256,256,256,0.5);
	border:none;
	width:350px;
	}
legend{text-align:center;}
#btn{background-color:limegreen;
        color:white;
        border:2px white;
        padding:8px 8px;
        border-style:outset;
        border-radius:5px;}
</style>
<script>
function check()
{
	let p=document.form.uform.pwd.value;
	let cp=document.form.uform.cpwd.value;
	if(p!=cp){
		document.getElementById("pass").innerHTML.style.color="red";
		document.getElementById("pass").innerHTML="password and confirm password is not matching";
	}
}
function msg(){
	<%if(request.getAttribute("msg")!=null){%>
	var msg=<%=request.getAttribute("msg")%>;
	alert(msg);<%}%>
}	
</script>
</head>
<body onload="msg()">
<center>
<fieldset>
<legend>Change Password</legend><br>
<form action="Changepass" method="post">
Username:<input type="text" name="username" value="<%=request.getParameter("name")%>" readonly><br/><br/>
Old Password:<input type="text" name="opwd"><br/><br/>
New Password:<input type="text" name="npwd"><br/><br/>
Confim new Password:<input type="text" name="cpwd" id="pass" onkeypress="check()"><br/><br/>
<input id="btn" type="submit" value="Submit"><br/><br/>
</form></fieldset></center>
</body>
</html>