package com.landportal.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.landportal.dto.UserDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.DBConstants;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.PreparedStatementDTO;
import com.landportal.jdbc.SQLConstants;


@WebServlet("/LogInCheck")
public class LogInCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Logger logger=Logger.getLogger(LogInCheck.class);
  
    public LogInCheck() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		    try 
		    {
		      BufferedReader reader = request.getReader();
		      String line = null;
		      while ((line = reader.readLine()) != null)
		      {
		        sb.append(line);
		      }
		    } catch (Exception e) {
		    	logger.error("Error in storing login information in string buffer in logincheck class.");
		    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    	e.printStackTrace(); 
		    	return;
		    }
		    System.out.println(sb);
                Gson gson = new Gson();
                Map<String,String> user1 = gson.fromJson(sb.toString(),Map.class);

		
		    
		    String email = (String) user1.get("email");
		    String password = (String) user1.get("password");
		    
    DAO dao=Factory.getDAOObject();
	PreparedStatementDTO ps=new PreparedStatementDTO();
	List<PreparedStatementDTO> pslist= new ArrayList<PreparedStatementDTO>();
	ps.setDatatype(DBConstants.STRING);
	ps.setPosition(1);
	ps.setValue(email);
	pslist.add(ps);
	ps=new PreparedStatementDTO();
	ps.setDatatype(DBConstants.STRING);
	ps.setPosition(2);
	ps.setValue(password);
	pslist.add(ps);
	try {
		UserDTO user=dao.checkLogin(SQLConstants.checkLogin, pslist);
		
		if(null!=user){
			HttpSession session=request.getSession(true);
			session.setAttribute("email",user.getEmail());
			session.setAttribute("name",user.getName());
			session.setAttribute("mobile",user.getMobile());
			session.setAttribute("id",user.getId());
			session.setAttribute("verify",user.getVerify());
			session.setAttribute("city",user.getCity());
			
            Cookie cookie = new Cookie("Token", user.getId());
            cookie.setMaxAge(2000*800);
			response.addCookie(cookie);
			if(user.getVerify()==0){
			out.write("* Verify your account first.");
			return;
			}else{
				
				response.setStatus(HttpServletResponse.SC_OK);

			return;
			}

		
	}else
		out.write("* Invalid email id or password.");
		return;

	}catch (ClassNotFoundException e) {			

            logger.error("class not found in login check servlet");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
	} catch (SQLException e) {			

		 logger.error("class not found in login check servlet");
         response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
   		e.printStackTrace();
   		return;
	} 
	
	
	}

}
