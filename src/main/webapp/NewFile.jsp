<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%@page import="sql.Sql"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="jquery-ui.js"></script>
<link rel='stylesheet' href="jquery-ui.css">

<script src="home.js"></script>
<style>
body{background:url('') no-repeat;
	background-size:cover;
	background-attachment:fixed;
	font-family:Times New Roman;}
span{font-size:160%;}
.topic{
    font-size:30px;
    text-align:center;
    display:inline-block;
    width:100%;
    border:1px inset white;
	background-color:black;
	color:white;
	padding:10px;
	border-radius:5px;
	border-style: inset;}
.w{
    font-size:20px;
    display:inline-block;
    width:100%;
    border:1px inset white;
	background-color:black;
	color:white;
	padding:10px;
	border-radius:5px;
	border-style: inset;}
.nav-pills > li > a{color:white;
				   background-color:black;
				   border-radius:5px;
				   width:150px;
				   border:none;}
 .nav-pills > li >a:hover,.nav-pills > li >a:focus{color:black;
				   									  background-color:white;
				   									  font-weight:bold;}		
ul.dropdown-menu > li > a{color:black;
				   		 background-color:white;}
ul.dropdown-menu > li > a:hover,ul.dropdown-menu > li > a:focus{color:white;
				   									            background-color:black;
				   									            font-weight:bold;}

#container{
			background:url('home.jpg') no-repeat;
			background-size:cover;
			background-attachment:fixed;
			padding:50px;}
</style>
</head>
<body>
<%/*try{
	String n=request.getParameter("username");
	Connection con=Sql.getcon();
	Statement st=con.createStatement();
	String sql=null;
	if(request.getAttribute("n")=="admin")
		{
		sql="select * from admin where username=\""+n+"\"";
		}
	else{
		sql="select * from user where username=\""+n+"\"";
		}
	ResultSet rs=st.executeQuery(sql);
	rs.next();*/
%>
<div id="container">
<div class="topic">
<b><span>C</span>RIMINAL <span>R</span>ECORD <span>M</span>ANAGEMENT</b></div><br>
<div class="w"><b><span>W</span>ELCOME&ensp;<%//=rs.getString("name").toUpperCase() %></b></div>
	<div class="row">
		<div class="col-xs-1">
			<nav id="mainnavbar">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="javascript:;" onclick="h()">HOME</a></li>
					<%//if(request.getAttribute("n")=="admin") {%>
					<li class="dropdown">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle">USER<span class="caret right"></span></a>
					    <ul class="dropdown-menu">
					    	<li><a href="javascript:;" onclick="su()">Search User</a></li>
							<li><a href="javascript:;" onclick="au()">Add User</a></li>
							<li><a href="javascript:;" onclick="du()">All Users</a></li>
					    </ul>
					</li>
					  <%//} %>
					<li class="dropdown">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle">CRIMINAL<span class="caret right"></span></a>
					    <ul class="dropdown-menu">
			  				<li><a href="javascript:;" onclick="sc()">Search Criminal</a></li>
							<li><a href="javascript:;" onclick="ac()">Add Criminal</a></li>
							<li><a href="javascript:;" onclick="dc()">All criminals</a></li>
					    </ul>
					</li>
					<li><a href="javascript:;" onclick="changepwd('<%//=rs.getString("username")%>')">CHANGE PASSWORD</a></li>
					<li><a href="javascript:;" onclick="logout()">LOG OUT</a></li>
				</ul>
			</nav>
		</div>
		<%//}catch(Exception e){e.printStackTrace();} %>
		<div class="col-xs-11">
			<div id="sc"></div>
		</div>
	</div>
</div>
</body>
</html>