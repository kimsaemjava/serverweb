package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//클라이언트가 양식태그에 입력한 데이터를 추출
public class CalcServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("서블릿 요청 성공");
		//처리를 위한 기본 작업 - 한글설정, 응답객체로 부터 스트림을 얻기, 응답에 대한 타입을 설정
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		//요청정보추출
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		String opr = req.getParameter("method");
		
		//비지니스로직 호출
		Calc obj = new Calc();
		int result = obj.calc(num1, num2, opr);
		
		//클라이언트에 응답할 화면을 생성
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>계산결과("+opr+"연산적용)</h1>");
		out.println("<hr/>");

		out.println("<h3>num1의 "+num1+"과 num2의"+num2+
				"를 연산한 결과는"+result+"입니다.</h3>");
	
		out.println("</body>");		
		out.println("</html>");
	}
}













