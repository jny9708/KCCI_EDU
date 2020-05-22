package day5;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter2
 */
@WebFilter("/Servlet2")
public class MyFilter2 implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilter2가 수행되었습니다.");
		chain.doFilter(request, response);
		System.out.println("MyFilter2가 다시 수행되었습니다.");
	}


}
