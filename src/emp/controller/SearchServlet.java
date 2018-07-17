package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;
import emp.service.EmpServiceImpl;
@WebServlet(name = "emp/search", urlPatterns = { "/emp/search.do" })
public class SearchServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,
					HttpServletResponse res)
						throws ServletException,IOException{
		req.setCharacterEncoding("euc-kr");
		System.out.println("������û����");
		String column = req.getParameter("column");
		String search = req.getParameter("search");
		String pass = req.getParameter("pass");
		System.out.println("�˻���:"+search);
		//�����Ͻ� �޼ҵ� ȣ��
		EmpService service = new EmpServiceImpl();
		ArrayList<EmpDTO> userlist =
					service.search(column, search,pass);
	
		//�����Ͱ���
		req.setAttribute("userlist", userlist);
		
		//��û������
		RequestDispatcher rd = 
				req.getRequestDispatcher("/emp/list.jsp");
		rd.forward(req, res);
	}
}













