<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{background:url('police.jpg') no-repeat;
	background-size:cover;
	}
h2{background-color:black;
	text-align:center;
	color:white;
	}
fieldset{
	text-align:left;
	border:2px groove;
	width:500px;
	}
h4{background-color:rgb(197, 197, 197);
	width:50%;}
button{float:right;
	   background-color:red;
	   border:2px solid white;
	   border-radius:5px;
       border-style:rigid;
       color:white;
       padding:10px 12px;}
img{height:150px;
	 width:120px;
	 float:right;}
</style>
<script>
function myfun(n)
{
	if(confirm("Are you sure you want to delete this user?")){
		location.href="Udelete?name="+n;
	}
}
</script>
</head>
<body>
<%@page import="java.sql.*"%>
<%@page import="sql.Sql"%>
<%@page import="java.io.*"%>
<%try{
	String n=request.getParameter("name");
	Connection con=Sql.getcon();
	Statement st=con.createStatement();
	String sql="select * from user where name=\""+n+"\"";
	ResultSet rs=st.executeQuery(sql);
	if(rs.next()){
%>
<center>
<fieldset>
<h2><b>User Details</b></h2>
<h4><b>Personal details</b></h4>
<br><b>NAME&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getString("name") %><img src="Image_user?name=<%=rs.getString("name")%>">
<br><br><b>GENDER&emsp;&emsp;:&emsp;</b><%=rs.getString("gender") %>
<br><br><b>AGE&emsp;&emsp;&ensp;&ensp;&emsp;:&emsp;</b><%=rs.getInt("age") %>
<br><br><b>DOB&emsp;&ensp;&ensp;&emsp;&emsp;:&emsp;</b><%=rs.getDate("DOB") %>
<br><br><b>COUNTRY&emsp;:&emsp;</b><%=rs.getString("country") %>
<br><br><b>STATE&emsp;&ensp;&nbsp;&emsp;:&emsp;</b><%=rs.getString("state") %>
<br><br><b>DISTRICT&emsp;&nbsp;:&emsp;</b><%=rs.getString("district") %>
<br><br><b>CITY&ensp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getString("city") %>
<br><br><b>ADDRESS&ensp;&emsp;:&emsp;</b><%=rs.getString("address") %>
<br><br><b>PINCODE&ensp;&emsp;:&emsp;</b><%=rs.getInt("pincode") %>
<br><br><b>EMAIL_ID&nbsp;&emsp;:&emsp;</b><%=rs.getString("email_id") %>
<br><br><b>PHONE NO&emsp;:&emsp;</b><%=rs.getLong("phone_no") %>
<center><button onclick="myfun('<%=n%>')">Delete</button></center>
<%
	}
	else{
		out.println("Can't find the details");
	}%>
	</fieldset></center>
<%}
catch(Exception e){e.printStackTrace();}
%>
</body>
</html>