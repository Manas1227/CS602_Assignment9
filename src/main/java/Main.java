import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class Main extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String gender = request.getParameter("gender");
		
		String message = "";
		
		if (fName.trim().isEmpty() || lName.trim().isEmpty()) {
			if (fName.trim().length() > 0) {
				message = "Please Enter Your Last Name.";
			} else if (lName.trim().length() > 0) {
				message = "Please Enter Your First Name.";
			} else {
				message = "Please Enter Your First & Last Name.";
			}
		} else if (gender == null) {
			message = "Please Select Appropiate Gender.";
		} else {
			switch (gender) {
				case "male": {
					message = "Thank you Mr. " + fName + " " + lName + ".";
					break;
				}
				case "female": {
					message = "Thank you Ms. " + fName + " " + lName + ".";
					break;
				}
				case "other": {
					message = "Thank you " + fName + " " + lName + ".";
					break;
				}
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
	    out.println("<head><style>");
	    out.println(".container {max-width: 600px;margin: 0 auto;background-color: #fff;padding: 20px;border-radius: 8px;box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);}");
	    out.println("body {font-family: Arial, sans-serif;text-align: center; background-color: #f2f2f2;margin: 0;padding: 20px;}");
	    out.println("</style></head>");
	    out.println("<body>");
	    out.println("<div class=\"container\">");
	    out.println("<h1>Welcome to My Shop</h1>");
	    out.println("<p>" + message + "</p>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");
	}
}
