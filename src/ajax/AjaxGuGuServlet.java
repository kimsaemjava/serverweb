package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ajaxgugu", urlPatterns = { "/ajaxgugu" })
public class AjaxGuGuServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("num"));
		String result="";
		for (int i = 1; i <=9; i++) {
			result = result+ (dan+"*"+i+"="+(dan*i)+"<br/>");
		}
		pw.println(result);
	}

}












