package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Ŭ���̾�Ʈ�� ����±׿� �Է��� �����͸� ����
public class PostServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		System.out.println("���� ��û ����");
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();
		
		//��û��������
		String userId = req.getParameter("userId");
		String userName = req.getParameter("userName");
		String passwd = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String[] item = req.getParameterValues("item");
		
		//Ŭ���̾�Ʈ�� ������ ȭ���� ����
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Customer</h1>");
		out.println("<hr/>");
		out.println("<h1>���̵�:"+userId+"</h1>");
		out.println("<h1>����:"+userName+"</h1>");
		out.println("<h1>�н�����:"+passwd+"</h1>");
		out.println("<h1>����:"+gender+"</h1>");
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













