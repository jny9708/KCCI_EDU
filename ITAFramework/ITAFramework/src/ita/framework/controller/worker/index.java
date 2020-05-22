package ita.framework.controller.worker;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import ita.framework.controller.*;

public class index implements ITAController {

	public NextPage execute(HttpServletRequest request, Map model) {
		return new NextPage("FrontController?actioin=EmpList", NextPage.REDIRECT);
	}

}
