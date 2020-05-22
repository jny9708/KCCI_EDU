package ita.framework.controller.worker;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import ita.framework.controller.*;
import ita.framework.entity.*;
import ita.framework.model.*;

public class EmpAddForm implements ITAController {
	public NextPage execute(HttpServletRequest request, Map model) {
		DeptDAO deptDAO = new DeptDAO();
		
		ArrayList<DeptEntity> list = deptDAO.getAllDept();
		
		model.put("depts", list);
		model.put("title", "사원 추가");
		model.put("contents", "EmpAddForm.jsp");
		
		return new NextPage("EmpMgt.jsp");
	}
}
