package criminal;

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
 * Servlet implementation class Criminaldisplay
 */
@WebServlet("/Criminaldisplay")
public class Criminaldisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Criminaldisplay() {
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
			ResultSet rs=st.executeQuery("select * from criminal");
			out.println("<html><head><link rel=\"stylesheet\" href=\"dis.css\">");
			out.println("</head><body>");
			out.println("<h2 style=\"text-align:center;\">All Criminals List</h2>");
			out.println("<table align=center><tr><th>SERIAL NO</th><th>PHOTO</th><th>ID</th><th>NAME</th><th>ACTIONS</th></tr>");
			int i=0;
			while(rs.next())
			{
				i++;
			    out.println("<tr><td>"+i+"</td><td><img src=\"Image_criminal?name="+rs.getString("name")+"\"></td><td>"+rs.getInt("Id")+"</td><td>"+rs.getString("name")+"</td><td><a id=\"a\" href=\"cdisplay.jsp?name="+rs.getString("name")+"\' target=\'blank\'  rel=\"noopener noreferrer\">view</a></td></tr>");			    
			}
			out.println("</table></body></html>");
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
