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
	
	//FrontController�� Ŭ���̾�Ʈ�� ���ؼ� ó�� ��û�� �� �ѹ��� ����Ǵ� �޼���
	public void init() throws ServletException {
		try {
			//Properties ��ü�� �̿��Ͽ� controller.properties ������ ������ �д´�. 
			Properties ctrlProperties = new Properties();
			String propertyRealPath = getServletContext().getRealPath(propertyPath);
			ctrlProperties.load(new FileReader(propertyRealPath));

			//Properties ��ü�� �о ������ �̿��Ͽ� Ŭ���� ��ü�� �����ϰ� ���� �غ��� Map�� �����Ѵ�.  
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
		
		//�̵��� ������ �������� ���� ���, controller.properties ���� �ȿ� index�׸� ������ �������� �̵���Ű���� �Ѵ�.
		if (action == null)
			action = "index";
		
		//�̵��ϰ��� �ϴ� ������ �ش��ϴ� Ŭ���� ��ü ������ Map���� ���� �����´�.
		Class controllerClass = (Class)ctrlMap.get(action);
		
		//Map�� Ŭ���� ��ü�� ��ϵ��� ���� ���
		if (controllerClass == null) 
			throw new IllegalArgumentException("������Ƽ ���Ͽ��� [" + action + "] ��Ʈ�ѷ� Ŭ������ ã�� �� �����ϴ�.");
		
		try {
			//Ŭ���� ��ü ������ �̿��ؼ� ��ü�� �����Ѵ�.
			ITAController ctrl = (ITAController)(controllerClass.newInstance());
			Map<String, Object> model = new HashMap<String, Object>();
			NextPage nextPage = ctrl.execute(request, model);
			String url = nextPage.getUrl();
			
			if (url == null) {
				System.out.println("[" + controllerClass.getName() + "] Ŭ������ �̵��� �������� �������� �ʾҽ��ϴ�.");
				return;
			}
			
			if (nextPage.getMethod() == NextPage.REDIRECT) {
				//��Ʈ�ѷ� Ŭ�������� sendDirect ������� �̵��ϰ��� �� ��� 
				if (model.size() > 0) {
					String nextToken = "?";
					
					if (url.indexOf("?") > 0) 
						nextToken = "&";
					
					for(String key : model.keySet()) {
						url += nextToken + (String)key + "=" + URLEncoder.encode((String)model.get(key), "euc-kr");
						nextToken = "&";
					}
				}
				
				response.sendRedirect(url); //Redirect ������� �ٸ� ���� �Ǵ� JSP�� �̵�
			} else {	
				//��Ʈ�ѷ� Ŭ�������� dispatch ������� �̵��ϰ��� �� ���
				for(Object key : model.keySet().toArray()) {
					request.setAttribute((String)key, model.get(key));
				}
				
				//Dispatch ������� �ٸ� ���� �Ǵ� JSP�� �̵�
				request.getRequestDispatcher("/WEB-INF/jsp/" + url).forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}   	  	    
}