package day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day3.model.dao.DeptDAO;
import day3.model.entity.Dept;

/**
 * Servlet implementation class DeptAddServlet
 */
@WebServlet("/DeptAdd")
public class DeptAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("DeptAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DeptDAO deptDAO = DeptDAO.getInstance();
		Dept dept = new Dept();
		int id = Integer.parseInt(request.getParameter("id"));
		String deptName = request.getParameter("deptName");
		int locId = Integer.parseInt(request.getParameter("locId"));
		dept.setId(id);
		dept.setDeptName(deptName);
		dept.setLocId(locId);
		deptDAO.Add(dept);
		response.setCharacterEncoding("utf-8");
		response.sendRedirect("DeptList");
	}

}
