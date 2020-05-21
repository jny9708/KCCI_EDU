package day4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.ooad.MyBean;

/**
 * Servlet implementation class ELExServlet
 */
@WebServlet("/ELExServlet")
public class ELExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyBean bean = new MyBean();
		bean.setId(30);
		bean.setDeptName("행정팀");
		bean.setLocId(500);
		request.setAttribute("dept", bean);
		request.getRequestDispatcher("ELEx3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
