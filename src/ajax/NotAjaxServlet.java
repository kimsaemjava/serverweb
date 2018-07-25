package ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//ajax요청이 아닌 경우
@WebServlet(name = "notajax", urlPatterns = { "/notajax" })
public class NotAjaxServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String id = request.getParameter("id");
		String msg = "";
		if(id.equals("jang")){
			msg = "사용불가능 아이디";
		}else{
			msg = "사용가능아이디";
		}
		request.setAttribute("msg",msg);
		RequestDispatcher rd = 
				request.getRequestDispatcher("/ajax/notajax.jsp");
		rd.forward(request, response);
	}

}
