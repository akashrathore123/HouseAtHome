package com.landportal.forgotpassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet implementation class CheckEmail
 */
@WebServlet("/checkemail")
public class CheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	Logger logger =Logger.getLogger(CheckEmail.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		Gson gson = new Gson();
		boolean check = false;
		 try 
		    {
		      BufferedReader reader = request.getReader();
		      String line = null;
		      while ((line = reader.readLine()) != null)
		      {
		        sb.append(line);
		      }
		    } catch (Exception e) {
		    	logger.error("Error in fetching json data in check email class");
		    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    	e.printStackTrace(); 
		    	return;
		    }
		     String email = gson.fromJson(sb.toString(),String.class);
             DAO dao = Factory.getDAOObject();
             String sql = SQLConstants.checkEmail;
             try {
				check = dao.checkEmail(sql,email);
			} catch (ClassNotFoundException | SQLException e) {
				logger.error("class not found or sql exception in checkEmail class");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				e.printStackTrace();
				return;
				// TODO Auto-generated catch block
				
			}
             if(check){
            	 sql = SQLConstants.findID;
        		 String id = null;
        		try {
        			id = dao.getID(sql,email);
        		} catch (ClassNotFoundException | SQLException e) {
                   logger.error("class not found or sql exception in passwordEmail class");
                   response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                   e.printStackTrace();
                   return;
        		}
        		 try {
        			NewPasswordEmail.sendEmail(email, id);
        			
        		} catch (MessagingException e) {
                     logger.error("error in sending mail in class passwordEmail.");
                     response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                     return;
        		}
            	 response.setStatus(HttpServletResponse.SC_OK);
            	 out.write("Link has been sent to your email account,click on the link to change password");
            	 return;
             }else{
            	 response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            	 out.write("* Email ID not exist.");
            	 System.out.println("not found");
                 return;
             }
            
	}

}
