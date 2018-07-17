package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		
		req.setCharacterEncoding("euc-kr");
		//1. ��û���� ����
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String check = req.getParameter("member_id_save");
		
		//2. �����Ͻ� �޼ҵ� ȣ��
		EmpService service = new EmpServiceImpl();
		EmpDTO loginUser = service.login(id,pass);
	
		//�α��� �����ϸ� ��Ű�� ����
		//-> ���̵� ������ üũ�� ���·� �α��� ��ư�� �������� �α����� �����ϸ�
		//���̵� ��Ű�� �����ϱ�
		if(check!=null){
			if(check.equals("T") & loginUser!=null){
				Cookie cookie = 
						new Cookie("id",loginUser.getId());
				cookie.setMaxAge(60*60*24);
				res.addCookie(cookie);
			}
		}
		
		
		//3. �����Ͱ���
		req.setAttribute("loginUser", loginUser);
		
		//4. ��û������
		String url="";
		if(loginUser!=null){//�α��� ����
			url="/emp/list.do";
		}else{
			url = "/emp/login.jsp";//�α��� ����
		}
		RequestDispatcher rd = 
				req.getRequestDispatcher(url);
		rd.forward(req, res);
	}
}













