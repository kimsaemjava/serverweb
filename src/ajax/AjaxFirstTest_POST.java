package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ajax_post", urlPatterns = { "/ajax_post.do" })
public class AjaxFirstTest_POST extends HttpServlet {
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		//Ajax�� �̿��ؼ� ��밡�� ���̵� �ľ�
		//5. �������� request�� ����
		//6. request�� ó���ؼ� Ŭ���̾�Ʈ���� �ٽ� ������
		response.setContentType("text/html;charset=euc-kr");
		//response�� ������� ����
		//html�� ��û�ϴ� ���� �������ҽ��� ��û�ϴ� �۾��̰� ��û�� �ɶ����� �������� 
		//�۾��� �����ϰ� �����ؼ� ����� �����´�. �̸� ��ȿ�����̶� �Ǵ��Ͽ�
		//�⺻������ ������ ��û�� �������� ĳ������ �����ϰ� �ִ� ������ �����ش�.
		//����� ĳ���� �����ϸ� ���� ��û�� ���� ����� �ȳ��� �� �ֱ� ������
		//�������� ĳ���� �������� �ʰ� �������� ���û�ϵ��� ������� ����
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String msg = "";
		if(id.equals("jang")){
			msg = "���Ұ��� ���̵�";
		}else{
			msg = "��밡�ɾ��̵�";
		}
		System.out.println("post������� ajax��û=>"+msg);
		pw.println(msg);
	}

}
