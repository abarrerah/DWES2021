package Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundo extends javax.servlet.http.HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out;
    response.setContentType("text/html");
    out = response.getWriter();
    
    out.println("<html>");
    out.println("<head><title>Hola Mundo</title></head>");
    out.println("<body>");
    out.println("<h1>Hola Mundo!</h1>");
    out.println("</body></html>");
    

}}
