

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	       // request.getRequestDispatcher("link.html").include(request, response);  
	          
	        String name=request.getParameter("name");  
	        String password=request.getParameter("password");  
	          
	        
	        try {
			Class.forName("com.mysql.jdbc.Driver");			  
			Connection con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/railwaybus","root","manan");
	        
			PreparedStatement st = con.prepareStatement("select name,pass from login;");
			 ResultSet rs = st.executeQuery();
			 char c='a';
			 while(rs.next()){
				 if(name.equals(rs.getString(1)))
					 if(password.equals(rs.getString(2))){
				       
				        HttpSession session=request.getSession();
				        session.setAttribute("name",name);
				        request.setAttribute("id", "print");
				        RequestDispatcher rd = request.getRequestDispatcher("Sadd");
				        rd.forward(request, response);
				        break;
				        }
				        
			 }
			 if(c!='b'){
				 out.print("Credentials invalid!");  
				 response.sendRedirect("login.html");
			 }
			 st.close();
	        
	          
	        out.close();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
