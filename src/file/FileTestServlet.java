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
		
		//웹에서 파일io를 하는 경우 실제 웹상의 경로
	    //               ---------
	 	//                  |_ 서버가 인식하는 주소
				
		//실제 웹상의 경로는 서버가 인식하는 위치에서 가져와야 한다. 자바의 웹 환경에서는 서버에 배포된
		//프로젝트 즉, context에 대한 설정정보를 관리하는 ServletContext라는 객체를 제공
		//ServletContext는 서블릿객체를 통해서 혹은 request객체를 통해서 접근이 가능
		ServletContext context = getServletContext();
		//실제 서버가 인식하는 위치정보를 가져온다.
		System.out.println(context.getRealPath("/log"));
		String realpath = context.getRealPath("/log");
		FileWriter fw = 
				new FileWriter(realpath+"/20180727_log.txt");
		fw.write(request.getRemoteAddr()+"접속함");
		fw.flush();
		fw.close();
		
		
		
	}
}










