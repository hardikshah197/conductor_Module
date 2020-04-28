
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.parser.JSONParser;


@WebServlet("/Rapid_api")
public class Rapid_api<JSONObject> extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringToParse = request.getParameter("st");
		System.out.println(stringToParse);
		JSONParser parser = new JSONParser(stringToParse, null, false);
		
		JSONObject json = (JSONObject) parser.parse();
		System.out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
