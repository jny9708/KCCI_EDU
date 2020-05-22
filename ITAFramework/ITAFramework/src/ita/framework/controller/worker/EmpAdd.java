package ita.framework.controller.worker;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import ita.framework.controller.ITAController;
import ita.framework.controller.NextPage;
import ita.framework.entity.*;
import ita.framework.model.*;

public class EmpAdd implements ITAController {
	public NextPage execute(HttpServletRequest request, Map model) throws Exception {
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String deptId = request.getParameter("deptId");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String phoneNo = request.getParameter("phoneNo");
		
		EmpDAO dao = new EmpDAO();
		EmpEntity emp = new EmpEntity();
		DeptEntity dept = new DeptEntity();
		
		emp.setId(Integer.parseInt(id));
		emp.setName(name);
		dept.setId(Integer.parseInt(deptId));
		emp.setDept(dept);
		emp.setEmail(email);
		emp.setHireDate(hireDate);
		emp.setPhoneNo(phoneNo);
		
		dao.insertEmp(emp);
		
		return new NextPage("FrontController?action=EmpList", NextPage.REDIRECT);
	}

}