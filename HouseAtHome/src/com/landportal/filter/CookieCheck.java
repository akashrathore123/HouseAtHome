package com.landportal.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.landportal.dto.UserDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet Filter implementation class CookieCheck
 */
@WebFilter("/CookieCheck")
public class CookieCheck implements Filter {

    /**
     * Default constructor. 
     */
    public CookieCheck() {
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
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		Logger logger = Logger.getLogger(CookieCheck.class);
		if(null==session ||  (null==session.getAttribute("email"))){
			Cookie[] cookies = ((HttpServletRequest) request).getCookies();
			String id = null;
			if(null!=cookies){
			for(Cookie cookie : cookies){
			    if("Token".equals(cookie.getName())){
			        id = cookie.getValue();
			        
			        DAO dao = Factory.getDAOObject();
                    
			        UserDTO user = new UserDTO(); 
					try {
						user = dao.extractUser(SQLConstants.extractUser,id);
					} catch (ClassNotFoundException | SQLException e) {
                       logger.error("ClassNotFoundException | SQLException in filter cookiecheck");	
                        e.printStackTrace();
					}
					if(null!=user){
					    session=((HttpServletRequest) request).getSession(true);
						session.setAttribute("email",user.getEmail());
						session.setAttribute("name",user.getName());
						session.setAttribute("mobile",user.getMobile());
						session.setAttribute("id",user.getId());
						session.setAttribute("verify",user.getVerify());
						session.setAttribute("city",user.getCity());
			    
			    }
		}
			    }
			}
	}
		chain.doFilter(request, response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
