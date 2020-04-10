

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/conductor")
public class conductor extends HttpServlet {
       
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();  
        
		String n=request.getParameter("userName");    
		String e=request.getParameter("userEmail");
		String p=request.getParameter("userPass");
		//String c=request.getParameter("userCountry");  
		          
		try{  System.out.print("Hello1");
//			Class.forName("com.mysql.jdbc.Driver");  
//			Connection con=DriverManager.getConnection(  
//			"jdbc:mysql://localhost:3306/railway_bus","root","hardik");  
		Connection con = DatabaseConnection.initializeDatabase();
				
		java.sql.Statement ps = con.createStatement();  
		  String s ="insert into rail values('"+n+"','"+e+"','"+p+"');";
//		ps.setString(1,n);  
//		ps.setString(2,p);  
//		ps.setString(3,e);  
		//ps.setString(4,c);  
		  System.out.print("Hello2");
		ps.executeUpdate(s);  
		  System.out.print("Hello3");
		  
//		out.print("You are successfully registered...");  
		      
		          
		}catch (Exception e2) {
			e2.printStackTrace();
			}  
		          
		out.close(); 
	}

}
