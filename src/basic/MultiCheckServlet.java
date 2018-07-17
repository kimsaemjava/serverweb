package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//클라이언트가 양식태그에 입력한 데이터를 추출
public class MultiCheckServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("서블릿 요청 성공");
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		//요청정보추출
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String[] sw = req.getParameterValues("sw");
		
		//클라이언트에 응답할 화면을 생성
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>출력결과</h1>");
		out.println("<hr/>");
		out.println("<h1>이름:"+name+"</h1>");
		out.println("<h1>주소:"+addr+"</h1>");
		out.println("<h1>사용중인 소프트웨어:</h1>");
		for (int i = 0; i < sw.length; i++) {
			out.print(sw[i]+"<br/>");
		}
	
		out.println("</body>");		
		out.println("</html>");
	}
}













