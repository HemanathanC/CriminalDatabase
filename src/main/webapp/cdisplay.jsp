<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{background:url('criminal.jpg') no-repeat;
	background-size:cover;
	}
h2{background-color:black;
	text-align:center;
	color:white;
	}
fieldset{
	border:2px groove;
	width:700px;
	}
h4{background-color:rgb(197, 197, 197);
	width:50%;}
img{height:150px;
	 width:120px;
	 float:right;}
</style>
</head>
<body>
<%@page import="java.sql.*"%>
<%@page import="sql.Sql"%>
<%try{
	Connection con=Sql.getcon();
	Statement st=con.createStatement();
	String id=request.getParameter("id");
	String n=request.getParameter("name");
	String sql=null;
	if(id!=null){
		sql="select * from criminal where id=\""+id+"\"";
	}
	else if(n!=null){
		sql="select * from criminal where name=\""+n+"\"";
	}
	ResultSet rs=st.executeQuery(sql);
	if(rs.next()){
%>
<fieldset>
<h2><b>Criminal Details</b></h2>
<h4><b>Personal details</b></h4>
<br><b>ID&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;:&emsp;</b><%=rs.getInt("Id") %><img src="Image_criminal?name=<%=rs.getString("name")%>">
<br><br><b>NAME&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;:&emsp;</b><%=rs.getString("name") %>
<br><br><b>GENDER&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getString("gender") %>
<br><br><b>AGE&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;:&emsp;</b><%=rs.getInt("age") %>
<br><br><b>DOB&emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getDate("DOB") %>
<br><br><b>COUNTRY&emsp;&emsp;&emsp;&emsp;&ensp;&emsp;:&emsp;</b><%=rs.getString("country") %>
<br><br><b>STATE&emsp;&emsp;&emsp;&emsp;&nbsp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getString("state") %>
<br><br><b>CITY&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getString("city") %>
<br><br><b>ADDRESS&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getString("address") %>
<br><br><b>PINCODE&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getInt("pincode") %>
<br><br><b>HEIGHT(IN ft)&emsp;&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getInt("height(ft)") %>
<br><br><b>WEIGHT(IN kgs)&emsp;&emsp;&emsp;:&emsp;</b><%=rs.getInt("wight(kg)") %>
<br><br><h4><b>Case details</b></h4>
<br><b>CRIME CATEGORY&emsp;&ensp;:&emsp;</b><%=rs.getString("crime_category") %>
<br><br><b>CRIME DATE&emsp;&emsp;&emsp;&emsp;&ensp;:&emsp;</b><%=rs.getDate("crime_date") %>
<br><br><b>ARREST DATE&emsp;&emsp;&ensp;&nbsp;&emsp;:&emsp;</b><%=rs.getDate("arrest_date") %>
<br><br><b>CASE DESCRIPTION&emsp;:&emsp;</b><br><%=rs.getString("description") %>
</fieldset>
<%
	}
	else{
		out.println("Can't find the details");
	}
}
catch(Exception e){e.printStackTrace();}
%>
</body>
</html>