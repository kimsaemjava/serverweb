package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ajaxtest01", urlPatterns = { "/ajaxtest01" })
public class AjaxFirstTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		//Ajax를 이용해서 사용가능 아이디 파악
		//5. 서버에서 request를 수신
		//6. request를 처리해서 클라이언트에게 다시 보내기
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String msg = "";
		if(id.equals("jang")){
			msg = "사용불가능 아이디";
		}else{
			msg = "사용가능아이디";
		}
		System.out.println("get방식으로 ajax요청(jquery)=>"+msg);
		pw.println(msg);
	}

}
