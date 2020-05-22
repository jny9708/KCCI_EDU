package ita.framework.controller.worker;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import ita.framework.controller.*;
import ita.framework.entity.*;
import ita.framework.model.*;


public class EmpList implements ITAController {
	public NextPage execute(HttpServletRequest request, Map model) throws Exception {
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpEntity> emps = dao.getAllEmp();
		
		model.put("emps", emps);
		model.put("title", "사원 목록");
		model.put("contents", "EmpList.jsp");
		
		return new NextPage("EmpMgt.jsp");
	}

}
