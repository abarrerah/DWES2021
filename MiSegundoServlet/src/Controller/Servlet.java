package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ArrayList myArray=new ArrayList();
		PrintWriter out;
	    response.setContentType("text/html");
	    out = response.getWriter();
	    out.println("<html>");
	    out.println("<head><title>Mi Primer Servlet </title></head>");
	    out.println("<body>");
	    out.println("<h1>Hello! Welcome to my second servlet</h1>");
	    try {
			myArray.add(Operations.showAllFirstNameEmployees());
			for(int i=0;i<myArray.size();i++) {
				out.println("<p>"+myArray.get(i)+"<br>"+"</p>");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    out.println("</body></html>");
	    
	    
	}  	  	    
	
}
