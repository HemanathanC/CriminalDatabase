package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Sql;

/**
 * Servlet implementation class Udelete
 */
@WebServlet("/Udelete")
public class Udelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Udelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			String n=request.getParameter("name");
			Connection con=Sql.getcon();
			PreparedStatement ps=con.prepareStatement("delete from user where name=\""+n+"\"");
						
			int i=ps.executeUpdate();
			if(i>0) {
				out.println("User "+n+" is Deleted Successfully...");
			}
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
