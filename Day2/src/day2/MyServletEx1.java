package day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServeltEx1
 */
@WebServlet("/MyServeltEx1")
public class MyServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int value = 0;
	@Override
		public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			super.init(config);
			System.out.println("인스턴스가 생성되었습니다...");
			String LoginId = config.getServletContext().getInitParameter("LoginId");
			String Password = config.getServletContext().getInitParameter("Password");
			System.out.println("login id : " + LoginId);
			System.out.println("password : " + Password);
		}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("악");
		value++;
		out.println("vlaue : "+ value);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
