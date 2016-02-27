package com.landportal.login;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignOut
 */
@WebServlet("/signout")
public class SignOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		
		if(null==session || (null==session.getAttribute("email"))){
		}else{
		
		Cookie[] cookies = request.getCookies();
		if(null!=cookies){
		for(Cookie cookie : cookies){
			System.out.println(cookie.getName());
		    if("Token".equals(cookie.getName())){
		    	
		    	Cookie cookie1 = new Cookie("Token",(String) session.getAttribute("id"));
		    	cookie1.setMaxAge(0);
                response.addCookie(cookie1);
		    	cookie1.setPath("/");
		    	System.out.println(cookie1.getPath());

		   
	}
}
		}
		session.invalidate();
	    response.sendRedirect("home.jsp");
		}

	}
}