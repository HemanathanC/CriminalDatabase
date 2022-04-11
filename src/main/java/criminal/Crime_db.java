package criminal;
import sql.Sql;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Crime_db
 */
@WebServlet("/Crime_db")
@MultipartConfig
public class Crime_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crime_db() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			Connection con=Sql.getcon();
			PreparedStatement ps=con.prepareStatement("insert into criminal(Id,image,name,gender,age,DOB,crime_category,crime_date,arrest_date,address,country,state,city,pincode,height(ft),weight(kg),description)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		    String img=request.getParameter("img");
			InputStream in = new FileInputStream(img);
			ps.setString(1,request.getParameter("id"));
			ps.setBlob(2,in);
			ps.setString(3,request.getParameter("name"));
			ps.setString(4,request.getParameter("sex"));
			ps.setString(5,request.getParameter("age"));
			ps.setString(6,request.getParameter("DOB"));
			ps.setString(7,request.getParameter("ctype"));
			ps.setString(8,request.getParameter("cdate"));
			ps.setString(9,request.getParameter("adate"));
			ps.setString(10,request.getParameter("add"));
			ps.setString(11,request.getParameter("country"));
			ps.setString(12,request.getParameter("state"));
			ps.setString(13,request.getParameter("city"));
			ps.setString(14,request.getParameter("pin"));
			ps.setString(15,request.getParameter("height"));
			ps.setString(16,request.getParameter("weight"));
			ps.setString(17,request.getParameter("desc"));
			
			int i=ps.executeUpdate();
			if(i>0) {
				out.println("Criminal Added Successfully");
			}
		}
		catch(Exception e) {System.out.println(e);}
	}

}
