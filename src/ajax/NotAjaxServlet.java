package ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ajax��û�� �ƴ� ���
@WebServlet(name = "notajax", urlPatterns = { "/notajax" })
public class NotAjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String id = request.getParameter("id");
		String msg = "";
		if(id.equals("jang")){
			msg = "���Ұ��� ���̵�";
		}else{
			msg = "��밡�ɾ��̵�";
		}
		request.setAttribute("msg",msg);
		RequestDispatcher rd = 
				request.getRequestDispatcher("/ajax/notajax.jsp");
		rd.forward(request, response);
	}

}
