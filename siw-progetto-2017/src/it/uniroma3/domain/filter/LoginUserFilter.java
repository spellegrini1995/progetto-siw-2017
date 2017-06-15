package it.uniroma3.domain.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


import it.uniroma3.domain.controller.UserController;

public class LoginUserFilter implements Filter{
	private ServletContext application;
	@Override
	public void destroy() {
		//non bisogna fare niente
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		
		UserController controller=(UserController)(req.getSession().getAttribute("userController"));
		
		if(controller==null||controller.getCurrentUser()==null){
			RequestDispatcher rd=this.application.getRequestDispatcher("/userLogin.xhtml");
			rd.forward(request,response);
		}
		chain.doFilter(request,response);
		
	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		this.application=fconfig.getServletContext();
	}

}