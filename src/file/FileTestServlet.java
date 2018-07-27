package file;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "filetest", urlPatterns = { "/filetest" })
public class FileTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		//
		System.out.println("getRemoteHost"+request.getRemoteHost());
		System.out.println("getRemoteAddr"+request.getRemoteAddr());
		System.out.println("getRemotePort"+request.getRemotePort());
		System.out.println("getServerName"+request.getServerName());
		System.out.println("getLocalAddr"+request.getLocalAddr());
		
		//������ ����io�� �ϴ� ��� ���� ������ ���
	    //               ---------
	 	//                  |_ ������ �ν��ϴ� �ּ�
				
		//���� ������ ��δ� ������ �ν��ϴ� ��ġ���� �����;� �Ѵ�. �ڹ��� �� ȯ�濡���� ������ ������
		//������Ʈ ��, context�� ���� ���������� �����ϴ� ServletContext��� ��ü�� ����
		//ServletContext�� ������ü�� ���ؼ� Ȥ�� request��ü�� ���ؼ� ������ ����
		ServletContext context = getServletContext();
		//���� ������ �ν��ϴ� ��ġ������ �����´�.
		System.out.println(context.getRealPath("/log"));
		String realpath = context.getRealPath("/log");
		FileWriter fw = 
				new FileWriter(realpath+"/20180727_log.txt");
		fw.write(request.getRemoteAddr()+"������");
		fw.flush();
		fw.close();
		
		
		
	}
}










