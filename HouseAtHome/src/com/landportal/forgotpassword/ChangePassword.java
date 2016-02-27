package com.landportal.forgotpassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Logger logger = Logger.getLogger(ChangePassword.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		HttpSession session = request.getSession(false);
		Gson gson = new Gson();
		 try 
		    {
		      BufferedReader reader = request.getReader();
		      String line = null;
		      while ((line = reader.readLine()) != null)
		      {
		        sb.append(line);
		      }
		    } catch (Exception e) {
		    	logger.error("Error in fetching json data in PasswordEmail class");
		    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    	e.printStackTrace(); 
		    	return;
		    }
		 Map<String,String> map =gson.fromJson(sb.toString(),Map.class);
		 String password = map.get("password");
		 String confirm = map.get("confirmPassword");
		 System.out.println(password);
		 String id = (String) session.getAttribute("token");
		 session.invalidate();
		 if(!password.matches(confirm)){
			 response.setStatus(HttpServletResponse.SC_CONFLICT);
			 out.write("* Password not matched");
			 return;
		 }else{
			 DAO dao = Factory.getDAOObject();
			 String sql = SQLConstants.changePassword;
			 try {
				dao.changePassword(sql,id,password);
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				logger.error("ClassNotFoundException | SQLException in class changePassword");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				e.printStackTrace();
				return;
			}
			 
		 }
	}

}
