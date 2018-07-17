package basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String id = request.getParameter("id");
		//���ǰ�ü�� ����
		HttpSession ses = request.getSession();
		//���ǿ� ������ ����
		ses.setAttribute("mydata", id);
		
		RequestDispatcher rd = 
		request.getRequestDispatcher("/servlettest/ses_first.jsp");
		rd.forward(request, response);
		
	}

}