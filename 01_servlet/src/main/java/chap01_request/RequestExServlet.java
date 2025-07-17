package chap01_request;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestExServlet
 */
@WebServlet("/RequestExServlet")
public class RequestExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestExServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  //----- 요청 파라미터 UTF-8 인코딩
	  request.setCharacterEncoding("UTF-8");
	  
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	String[] hobbies  = request.getParameterValues("hobbies");
	String[] mobile = request.getParameterValues("mobile");
	
	System.out.println("이름: " + name);
	System.out.println("메일: " + email);
	System.out.println("성별: " + gender);
	System.out.println("취미: " + Arrays.toString(hobbies));
	System.out.println("폰: " + Arrays.toString(mobile));
	
	response.getWriter().append("Serverd at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
