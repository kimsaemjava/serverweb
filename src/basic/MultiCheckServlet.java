package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Ŭ���̾�Ʈ�� ����±׿� �Է��� �����͸� ����
public class MultiCheckServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("���� ��û ����");
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		//��û��������
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String[] sw = req.getParameterValues("sw");
		
		//Ŭ���̾�Ʈ�� ������ ȭ���� ����
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>��°��</h1>");
		out.println("<hr/>");
		out.println("<h1>�̸�:"+name+"</h1>");
		out.println("<h1>�ּ�:"+addr+"</h1>");
		out.println("<h1>������� ����Ʈ����:</h1>");
		for (int i = 0; i < sw.length; i++) {
			out.print(sw[i]+"<br/>");
		}
	
		out.println("</body>");		
		out.println("</html>");
	}
}













