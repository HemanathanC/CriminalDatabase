

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Sql;

/**
 * Servlet implementation class Changepass
 */
@WebServlet("/Changepass")
public class Changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=Sql.getcon();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changepass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("username");
		String p=request.getParameter("opwd");
		String p1=request.getParameter("npwd");
		try {
			if(Validate.admin(n,p)) {
				PreparedStatement ps=con.prepareStatement("update admin set password=\""+p1+"\" where username=\""+n+"\" and password=\""+p+"\"");
				int i=ps.executeUpdate();
				if(i>0)
					out.println("Password Changed Successfully");
			 }
		    else if(Validate.user(n,p)) {
				PreparedStatement ps=con.prepareStatement("update user set password=\""+p1+"\" where username=\""+n+"\" and password=\""+p+"\"");
				int i=ps.executeUpdate();
				if(i>0)
					out.println("Password Changed Successfully");
			 }
			else{
				request.setAttribute("msg","\"Sorry old password is incorrect\"");
				RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp");
				rd.forward(request,response);
			}
		}
		catch(Exception e) {e.printStackTrace();}
	}
}
