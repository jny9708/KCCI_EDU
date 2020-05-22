package ita.framework.controller.worker;

import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import ita.framework.controller.*;
import ita.framework.entity.*;
import ita.framework.model.*;

public class EmpEditForm implements ITAController {
	public NextPage execute(HttpServletRequest request, Map model) {
		String id = request.getParameter("id");
		
		DeptDAO deptDAO = new DeptDAO();
		EmpDAO empDAO = new EmpDAO();
		
		ArrayList<DeptEntity> list = deptDAO.getAllDept();
		EmpEntity emp = empDAO.getEmp(Integer.parseInt(id));
		
		model.put("depts", list);
		model.put("emp", emp);
		model.put("title", "사원 수정");
		model.put("contents", "EmpEditForm.jsp");
		
		return new NextPage("EmpMgt.jsp");
	}

}
