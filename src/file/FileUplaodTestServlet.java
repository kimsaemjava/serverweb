package file;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUplaodTestServlet
 */
@WebServlet(name = "upload", urlPatterns = { "/upload.do" })
public class FileUplaodTestServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String saveFolder="/log";
		String encType = "euc-kr";
		int size  = 5*1024*1024;
		String realpath = "";
		
		//1. ���� ���ε�� ������ ��θ� ���Ѵ�. ������ �ν��ϴ� ��ġ
		//  => Context�� ������ ���� �ִ� ServletContext�� �̿��ؼ� �۾�
		ServletContext context = getServletContext();
		realpath = context.getRealPath(saveFolder);
		System.out.println("realpath=>"+realpath);
		
		//2. cos.jar���� �����ϴ� MultipartRequest��ü�� �����Ͽ� ���Ͼ��ε�
		/*   FileRenamePolicy�� ������ DefaultFileRenamePolicy�� �̿�
		 *   FileRenamePolicy��ü�� ������ ���ϸ����� ���ε� �Ǵ� ��� ���ϸ��� ���
		 *   ������ �������� ���� ��å�� ���ǵǾ� �ִ� ��ü  
		 */
		
		MultipartRequest multipart = 
				new MultipartRequest(request, realpath,
						size, encType,
						    new DefaultFileRenamePolicy());
		
		//3. ������ ����
		String fileName = "";
		Enumeration<String> files =  multipart.getFileNames();
		int count = 0;
		while(files.hasMoreElements()){//������ �����ϸ�
			count++;
			String file = files.nextElement();//���ϸ��� ������
			fileName =	multipart.getFilesystemName(file);
			System.out.println("file"+file);
			System.out.println("fileName=>"+fileName);
			System.out.println("getOriginalFileName"+
							multipart.getOriginalFileName(file));
			request.setAttribute("image"+count,fileName);
		}
		
		//�ۼ��� ���� ���
		String user = multipart.getParameter("user");
		String title = multipart.getParameter("title");
		System.out.println("user:"+user);
		System.out.println("title:"+title);
		
		//���ε��� ������ ����� �� �ִ� �������� forward
		RequestDispatcher rd =
		request.getRequestDispatcher("/upload/uploadResult.jsp");
		rd.forward(request, response);
	}
}















