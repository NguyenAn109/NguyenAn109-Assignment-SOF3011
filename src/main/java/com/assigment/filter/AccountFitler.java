package com.assigment.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import com.assignment.utils.SessionUtils;


/**
 * Servlet Filter implementation class AccountFitler
 */
@WebFilter("/*")
public class AccountFitler extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AccountFitler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Kiểm tra nếu tài khoản đã đăng nhập thì thay đổi nút đăng nhập
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String nameSession = "loggedInUser";
        Object session = SessionUtils.getAttribute(httpRequest, nameSession);
        
        System.out.println(SessionUtils.getAttribute(httpRequest, "loggedInUser"));
        if (session != null && session != null) {
            request.setAttribute("loggedIn", true);
        } else {
            request.setAttribute("loggedIn", false);
        }

        // Tiếp tục chuyển request và response đến servlet hoặc filter tiếp theo trong chuỗi Filter
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
