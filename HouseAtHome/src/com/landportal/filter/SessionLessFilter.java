package com.landportal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class SessionLessFilter implements Filter{
    
	 Logger logger = Logger.getLogger(SessionLessFilter.class);
	
	 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException {
            HttpSession session = ((HttpServletRequest) request).getSession(false);	

	  try{
		  if((null==session) || null==session.getAttribute("email")){
	  
	    		 ((HttpServletResponse) response).sendRedirect("login.jsp");
	    	 }else{
	    		 chain.doFilter(request, response); 
	     }
	    
	}catch(Exception e){
          logger.error("error in log in filter");	}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
