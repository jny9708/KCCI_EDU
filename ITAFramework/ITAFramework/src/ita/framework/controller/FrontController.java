package ita.framework.controller;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class FrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	private static final String propertyPath = "/WEB-INF/controller.properties";
	private Map<String, Object> ctrlMap;
	
	//FrontController가 클라이언트에 의해서 처음 요청될 때 한번만 실행되는 메서드
	public void init() throws ServletException {
		try {
			//Properties 개체를 이용하여 controller.properties 파일의 내용을 읽는다. 
			Properties ctrlProperties = new Properties();
			String propertyRealPath = getServletContext().getRealPath(propertyPath);
			ctrlProperties.load(new FileReader(propertyRealPath));

			//Properties 개체로 읽어낸 정보를 이용하여 클래스 개체를 생성하고 별도 준비한 Map에 저장한다.  
			ctrlMap = new HashMap<String, Object>();
			
			for (Object it : ctrlProperties.keySet()) {
				String key = (String)it;
				String className = (String)ctrlProperties.get(key);
				ctrlMap.put(key, Class.forName(className));
			}
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		doPost(reqeust, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String action = request.getParameter("action");
		
		//이동할 서블릿이 지정되지 않은 경우, controller.properties 파일 안에 index항목에 지정된 서블릿으로 이동시키도록 한다.
		if (action == null)
			action = "index";
		
		//이동하고자 하는 서블릿에 해당하는 클래스 개체 정보를 Map으로 부터 가져온다.
		Class controllerClass = (Class)ctrlMap.get(action);
		
		//Map에 클래스 개체가 등록되지 않은 경우
		if (controllerClass == null) 
			throw new IllegalArgumentException("프로퍼티 파일에서 [" + action + "] 컨트롤러 클래스를 찾을 수 없습니다.");
		
		try {
			//클래스 개체 정보를 이용해서 객체를 생성한다.
			ITAController ctrl = (ITAController)(controllerClass.newInstance());
			Map<String, Object> model = new HashMap<String, Object>();
			NextPage nextPage = ctrl.execute(request, model);
			String url = nextPage.getUrl();
			
			if (url == null) {
				System.out.println("[" + controllerClass.getName() + "] 클래스에 이동할 페이지가 설정되지 않았습니다.");
				return;
			}
			
			if (nextPage.getMethod() == NextPage.REDIRECT) {
				//컨트롤러 클래스에서 sendDirect 방식으로 이동하고자 한 경우 
				if (model.size() > 0) {
					String nextToken = "?";
					
					if (url.indexOf("?") > 0) 
						nextToken = "&";
					
					for(String key : model.keySet()) {
						url += nextToken + (String)key + "=" + URLEncoder.encode((String)model.get(key), "euc-kr");
						nextToken = "&";
					}
				}
				
				response.sendRedirect(url); //Redirect 방식으로 다른 서블릿 또는 JSP로 이동
			} else {	
				//컨트롤러 클래스에서 dispatch 방식으로 이동하고자 한 경우
				for(Object key : model.keySet().toArray()) {
					request.setAttribute((String)key, model.get(key));
				}
				
				//Dispatch 방식으로 다른 서블릿 또는 JSP로 이동
				request.getRequestDispatcher("/WEB-INF/jsp/" + url).forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}   	  	    
}