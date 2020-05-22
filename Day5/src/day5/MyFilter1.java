package day5;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
			arg1.setContentType("text/html;charset=utf-8");
			arg1.setCharacterEncoding("utf-8");
			System.out.println("MyFilter1이 수행되었습니다.");
			chain.doFilter(arg0, arg1);
			System.out.println("MyFilter1이 다시 수행되었습니다.");
	}
	
}
