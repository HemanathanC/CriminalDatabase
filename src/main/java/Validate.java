import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sql.Sql;
public class Validate {
    public static boolean admin(String n,String p){
    	boolean status=false;
    	try {
    	Connection con=Sql.getcon();
    	Statement st=con.createStatement();		
		ResultSet rs=st.executeQuery("select * from admin where username='"+n+"' and password='"+p+"'");	
		status=rs.next();
    	}
    	 catch (SQLException e) {e.printStackTrace();}	
    	return status;
    }

	public static boolean user(String n, String p) {
		boolean status=false;
    	try {
    	Connection con=Sql.getcon();
    	Statement st=con.createStatement();		
		ResultSet rs=st.executeQuery("select * from user where username='"+n+"' and password='"+p+"'");	
		status=rs.next();
    	}
    	 catch (SQLException e) {e.printStackTrace();}	
    	return status;	}
}
