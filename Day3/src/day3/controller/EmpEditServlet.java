package day3.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day3.model.dao.DeptDAO;
import day3.model.dao.EmpDAO;
import day3.model.entity.Dept;
import day3.model.entity.Emp;

@WebServlet("/EmpEdit")
public class EmpEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empNo = Integer.parseInt(request.getParameter("empNo"));
		Emp emp = EmpDAO.getInstance().getEmp(empNo);
		ArrayList<Dept> deptList = DeptDAO.getInstance().getAll();
		request.setAttribute("emp",emp);
		request.setAttribute("deptList",deptList);
		request.getRequestDispatcher("/WEB-INF/view/EmpEdit.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
