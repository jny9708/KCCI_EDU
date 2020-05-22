package ita.framework.controller.worker;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import ita.framework.model.*;
import ita.framework.controller.*;

public class EmpDelete implements ITAController {
	public NextPage execute(HttpServletRequest request, Map model) {
		String id = request.getParameter("id");
		EmpDAO dao = new EmpDAO();
	
		dao.deleteEmp(Integer.parseInt(id));
	
		return new NextPage("FrontController?action=EmpList", NextPage.REDIRECT);
	}

}
