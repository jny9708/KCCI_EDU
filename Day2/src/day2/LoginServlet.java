package day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		String loginId = "";
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("loginId")) {
					loginId = c.getValue(); 
					break;
				}
			}
		}
		String checked = "";
		System.out.println(loginId.isEmpty());
		if(!loginId.isEmpty()) {
			checked = "checked";
		}
		
		request.setAttribute("loginId",loginId);
		request.setAttribute("checked",checked);
		request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
		/*
		 * response.setContentType("text/html; charset=utf-8");
		 * response.setCharacterEncoding("utf-8"); PrintWriter out =
		 * response.getWriter(); out.println("<!DOCTYPE html>"); out.println("<html>");
		 * out.println("<head>"); out.println("<meta charset=\"EUC-KR\">");
		 * out.println("<title>Insert title here</title>"); out.println("</head>");
		 * out.println("<body>"); out.println("<form action='/Login' method='post'>");
		 * out.println("아이디: <input type=\"text\" name=\"id\" value='"+ loginId +
		 * "'/><br>");
		 * out.println("비밀번호: <input type=\"password\" name=\"password\"/><br>");
		 * out.println("<input name=\"saveLoginId\" type=\"checkbox\" +"+ checked +
		 * " > 아이디 저장 <br>"); out.println("<input type=\"submit\" value=\"로그인\">");
		 * out.println("</form>"); out.println("</body>"); out.println("</html>");
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("id");
		String password = request.getParameter("password");
		String saveLoginId = request.getParameter("saveLoginId");
		Cookie cookie;
		
		if(loginId.equals("test") && password.equals("1234") ) {
			if(saveLoginId != null) {
				cookie = new Cookie("loginId", loginId);
			}else {
//				Cookie[] cookies = request.getCookies();
//				if(cookies != null) {
//					for(Cookie c : cookies) {
//						if(c.getName().equals("loginId")) {
//							c.setMaxAge(-1000);
//							response.addCookie(c);
//							break;
//						}
//					}
//				}
				cookie = new Cookie("loginId", "");
				cookie.setMaxAge(-1000);
			}
			response.addCookie(cookie);
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
			response.sendRedirect("Main");
		}
		
	}

}
