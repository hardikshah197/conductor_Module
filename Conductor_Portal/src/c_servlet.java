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

@WebServlet("/c_servlet")
public class c_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       // request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        System.out.print(name);
        System.out.print("Hello1");
        try {
		Class.forName("com.mysql.jdbc.Driver");			  
//		Connection con=DriverManager.getConnection(  
//					"jdbc:mysql://localhost:3306/railway_bus","root","hardik");
		Connection con = DatabaseConnection.initializeDatabase();
		java.sql.Statement ps = con.createStatement();
        System.out.print("hello2");
		
		PreparedStatement st = con.prepareStatement("select name,passw from rail;");
		 ResultSet rs = st.executeQuery();
		 char c='a';
		 while(rs.next()){
			 if(name.equals(rs.getString(1)))
				 if(password.equals(rs.getString(2))){
			       
			        HttpSession session=request.getSession();
			        session.setAttribute("name",name);
			        request.setAttribute("id", "print");
//			        RequestDispatcher rd = request.getRequestDispatcher("Sadd");
//			        rd.forward(request, response);
			        out.print("<div id='all'> <div class='colmn'> <h2 id='head-title'>Conductor-Details</h2> <h3>User Name :</h3><br> </div>");
			        out.print("<div><font size=10 id='head'>WELCOME</font><br > <label for='c_name' class='labels' style='text-align: justify;'>City name :</label> <select id='cities'> <option value='city_1'>City_1</option> <option value='city_2'>City_2</option> <option value='city_3'>City_3</option> <option value='city_4'>City_4</option> </select></div>");
			        out.print("<div class='colmn' id='show'><!--<oltype='I'>--><span class='city'>City_1</span><span class='city'>City_2</span><span class='city'>City_3</span><span class='city'>City_4</span><!--</ol>--></div> </div><br/><br/><center><button type='button' id='butt' onclick='fun1()'>Submit</button></center>");
			        System.out.println("Hello3");
			        c='b';
			        break;
			        }
			        
		 }
		 if(c!='b'){  
//			 response.sendRedirect("conductor.html");
			 out.print("<center><div class='colmn' id='main_colmn'> <!-- <button onclick='document.getElementById('logn').style.display='block'' style='width: auto;' id='butt-log'>Login</button> --> <div id='logn' class='model'> <div class='login_page' id='page'> <img src='image.jpg' alt='Avatar' class='avatar' /><br /> <label class='labels'>User Name :</label> <input type='text' placeholder='Enter User_Name' class='inp' id='u_name' required/> <label class='labels'>Password :</label> <input type='password' placeholder='Enter Password' class='inp' id='pass' required/> <button id='submit' >Login</button> <button onclick='document.getElementById('id01').style.display='none'' class='cancelbtn'>Cancel</button> </div> </div> </div></center>");
			 System.out.println("Hello4");
			 out.print("<center>                     Credentials invalid!</center>");
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
