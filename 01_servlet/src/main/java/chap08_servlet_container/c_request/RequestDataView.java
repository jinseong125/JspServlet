package chap08_servlet_container.c_request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestDataView")
public class RequestDataView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  List<Map<String, Object>> products = (List<Map<String, Object>>) request.getAttribute("products");
	  
	  response.setHeader("Content-Type", "text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  out.println("<div class=\"products\">");
	  for (Map<String, Object> product : products) {
	    out.println("<div class=\"product\">");
	    out.println(product.get("model") + ", " + product.get("price"));
	    out.println("</div>");
	  }
	  out.println("</div>");
	  out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
