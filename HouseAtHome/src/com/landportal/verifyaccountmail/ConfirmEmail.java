package com.landportal.verifyaccountmail;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.landportal.dto.UserDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.DBConstants;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.PreparedStatementDTO;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet implementation class ConfirmEmail
 */
@WebServlet("/confirmemail")
public class ConfirmEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmEmail() {
        super();
        // TODO Auto-generated constructor stub
    }
    Logger logger = Logger.getLogger(ConfirmEmail.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("profile");
		System.out.println(request.getParameter("profile"));
		try{
			DAO dao = Factory.getDAOObject();
			PreparedStatementDTO pstmt = new PreparedStatementDTO();
			pstmt.setDatatype(DBConstants.STRING);
			pstmt.setPosition(1);
			pstmt.setValue(token);
			
		    dao.emailConfirmed(SQLConstants.emailConfirmed,pstmt);
		    
		   UserDTO user = new UserDTO(); 
			user = dao.extractUser(SQLConstants.extractUser,token);
			System.out.println(user);
			if(null!=user){
				System.out.println("up");
				HttpSession session=request.getSession(true);
				session.setAttribute("email",user.getEmail());
				session.setAttribute("name",user.getName());
				session.setAttribute("mobile",user.getMobile());
				session.setAttribute("id",user.getId());
				session.setAttribute("verify",user.getVerify());
				session.setAttribute("city",user.getCity());
				System.out.println("down");
	            Cookie cookie = new Cookie("Token", user.getId());
	            cookie.setMaxAge(2000*700);
				response.addCookie(cookie);
				response.sendRedirect("home.jsp");
			}else{
				response.sendRedirect("error500.jsp");
			}
		}catch (ClassNotFoundException | SQLException e){
			response.sendRedirect("error500.jsp");
			e.printStackTrace();
	        logger.error("email confirmation problem");
            
		}
	}
       
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
