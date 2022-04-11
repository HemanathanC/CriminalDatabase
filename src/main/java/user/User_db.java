package user;
import sql.Sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_db
 */
@WebServlet("/User_db")
public class User_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_db() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		    Connection con=Sql.getcon();
			PreparedStatement ps=con.prepareStatement("insert into user(image,name,gender,age,DOB,country,state,district,city,address,pincode,email_id,phone_no,username,password)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			String img=request.getParameter("img");
			InputStream in = new FileInputStream(img);
			ps.setBlob(1,in);
			ps.setString(2,request.getParameter("name"));
			ps.setString(3,request.getParameter("sex"));
			ps.setString(4,request.getParameter("age"));
			ps.setString(5,request.getParameter("DOB"));
			ps.setString(6,request.getParameter("country"));
			ps.setString(7,request.getParameter("state"));
			ps.setString(8,request.getParameter("district"));
			ps.setString(9,request.getParameter("city"));
			ps.setString(10,request.getParameter("add"));
			ps.setString(11,request.getParameter("pin"));
			ps.setString(12,request.getParameter("email"));
			ps.setString(13,request.getParameter("phone"));
			ps.setString(14,request.getParameter("uname"));
			ps.setString(15,request.getParameter("pwd"));
			
			int i=ps.executeUpdate();
			if(i>0) {
				out.println("User Added Successfully");
			}
		}
		catch(Exception e) {e.printStackTrace();}
	}
}
