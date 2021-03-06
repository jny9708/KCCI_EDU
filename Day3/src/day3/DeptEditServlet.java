package day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day3.model.dao.DeptDAO;
import day3.model.entity.Dept;

@WebServlet("/DeptEdit")
public class DeptEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Dept dept = DeptDAO.getInstance().getDept(id);
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("DeptEdit.jsp").forward(request, response);
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
		deptDAO.Update(dept);
		response.sendRedirect("DeptList");		
	}

}
