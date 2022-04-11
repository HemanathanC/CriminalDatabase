package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Sql;

/**
 * Servlet implementation class Userdisplay
 */
@WebServlet("/Userdisplay")
public class Userdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userdisplay() {
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
			Connection con=Sql.getcon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			out.println("<html><head><link rel=\"stylesheet\" href=\"dis.css\">");
			out.println("</head><body>");
			out.println("<h2 style=\"text-align:center;\">All Users List</h2>");
			out.println("<table align=center><tr><th>SERIAL NO</th><th>PHOTO</th><th>NAME</th><th>EMAIL</th><th>ACTIONS</th></tr>");
			int i=0;
			while(rs.next())
			{
				i++;
			    out.println("<tr><td>"+i+"</td><td><img src=\"Image_user?name="+rs.getString("name")+"\"></td><td>"+rs.getString("name")+"</td><td>"+rs.getString("email_id")+"</td><td><a href=\'udisplay.jsp?name="+rs.getString("name")+"\' target=\'blank\'  rel=\"noopener noreferrer\">View</a></td></tr>");			    
			}
			out.println("</table></body></html>");
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
