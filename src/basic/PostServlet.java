package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//클라이언트가 양식태그에 입력한 데이터를 추출
public class PostServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		//요청정보추출
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String passwd = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String[] item = req.getParameterValues("item");
		
		//클라이언트에 응답할 화면을 생성
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Customer</h1>");
		out.println("<hr/>");
		out.println("<h1>아이디:"+userId+"</h1>");
		out.println("<h1>성명:"+userName+"</h1>");
		out.println("<h1>패스워드:"+passwd+"</h1>");
		out.println("<h1>성별:"+gender+"</h1>");
		out.println("<h1>job:"+job+"</h1>");
		out.println("<h1>Favorites:");
		for (int i = 0; i < item.length; i++) {
			out.print(item[i]);
		}
		out.println("</h1>");		
		out.println("</body>");		
		out.println("</html>");
	}
}













