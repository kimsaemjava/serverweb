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
		
		//1. 실제 업로드될 폴더의 경로를 구한다. 서버가 인식하는 위치
		//  => Context의 정보를 갖고 있는 ServletContext를 이용해서 작업
		ServletContext context = getServletContext();
		realpath = context.getRealPath(saveFolder);
		System.out.println("realpath=>"+realpath);
		
		//2. cos.jar에서 지원하는 MultipartRequest객체를 생성하여 파일업로드
		/*   FileRenamePolicy의 하위인 DefaultFileRenamePolicy를 이용
		 *   FileRenamePolicy객체는 동일한 파일명으로 업로드 되는 경우 파일명을 어떻게
		 *   변경할 것인지에 대한 정책이 정의되어 있는 객체  
		 */
		
		MultipartRequest multipart = 
				new MultipartRequest(request, realpath,
						size, encType,
						    new DefaultFileRenamePolicy());
		
		//3. 정보를 추출
		String fileName = "";
		Enumeration<String> files =  multipart.getFileNames();
		int count = 0;
		while(files.hasMoreElements()){//파일이 존재하면
			count++;
			String file = files.nextElement();//파일명을 꺼내라
			fileName =	multipart.getFilesystemName(file);
			System.out.println("file"+file);
			System.out.println("fileName=>"+fileName);
			System.out.println("getOriginalFileName"+
							multipart.getOriginalFileName(file));
			request.setAttribute("image"+count,fileName);
		}
		
		//작성자 제목 출력
		String user = multipart.getParameter("user");
		String title = multipart.getParameter("title");
		System.out.println("user:"+user);
		System.out.println("title:"+title);
		
		//업로드한 파일을 출력할 수 있는 페이지로 forward
		RequestDispatcher rd =
		request.getRequestDispatcher("/upload/uploadResult.jsp");
		rd.forward(request, response);
	}
}















