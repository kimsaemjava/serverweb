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
		//Ajax�� �̿��ؼ� ��밡�� ���̵� �ľ�
		//5. �������� request�� ����
		//6. request�� ó���ؼ� Ŭ���̾�Ʈ���� �ٽ� ������
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String msg = "";
		if(id.equals("jang")){
			msg = "���Ұ��� ���̵�";
		}else{
			msg = "��밡�ɾ��̵�";
		}
		System.out.println("get������� ajax��û(jquery)=>"+msg);
		pw.println(msg);
	}

}
