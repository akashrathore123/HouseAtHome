package com.landportal.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

import com.google.gson.Gson;
import com.landportal.dto.UserDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.DBConstants;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.PreparedStatementDTO;
import com.landportal.jdbc.SQLConstants;
import com.landportal.verifyaccountmail.SendEmail;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    Logger logger =Logger.getLogger(SignUp.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		Gson gson = new Gson();
		UserDTO newUser = new UserDTO();
	    try 
	    {System.out.println("sat");
	      BufferedReader reader = request.getReader();
	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        sb.append(line);
	      }
	    } catch (Exception e) { e.printStackTrace(); }
	  
          newUser =gson.fromJson(sb.toString(),UserDTO.class);
		
        String name = newUser.getName().trim();
	    String email = newUser.getEmail().trim();
	    String mobile = newUser.getMobile().trim();
	    String city = newUser.getCity().trim();
	    String password = newUser.getPassword().trim();
	   
	    if((null==name) || (name.length()<3) || (name.length()>52) || !(name.matches("^[A-Z a-z]+$"))){
	    	response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	    	out.write("* Enter valid name");
	    	return;
	    }else{
	    	if((null==email)|| (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))){
	    		response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	    		out.write("* Enter valid email id");
	    		return;
	    	}else{
	    		Double minvalue = 7000000000.0;
	    		if(!(mobile.matches("^[0-9]+$")&&(mobile.length()==10)) || (Double.parseDouble(mobile)<minvalue)){
	    			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		    		out.write("* Enter valid mobile number");
	    			return;
	    		}else{	    		System.out.println(mobile.length());

	    			if((city.length()<3) || city.length()>30 || city.contains(" ") || !(city.matches("^[A-Za-z]+$"))){
	    				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	    	    		out.write("* Enter correct city name");
	    				return;
	    			}else{
	    				if((password.length()<6 || (password.length()>30))){
	    					response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	    		    		out.write("* Password must be 6-30 characters long");
		    				return;
	    				}else{
	    					if(password.contains(" ")){
	    						response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
	    			    		out.write("* Enter correct password");
			    				return;
	    					}
	    				}
	    			}
	    		}
	    }
	    }
		
		int sent = 0;
		DAO dao=Factory.getDAOObject();
		PreparedStatementDTO pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(1);
		pstmt.setValue(email);
		
		   boolean entry = false;
			try {
				entry = dao.checkEntry(SQLConstants.ckeckEntry,pstmt);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		if(entry==true){
		Random rand = new Random();
		int random = rand.nextInt(((99999999-11111111)+1)+11111111);
		String id =Integer.toString(random);
		 char[] str1 =name.toCharArray();
		   
		    
		    str1[0] = Character.toUpperCase(str1[0]);
		    for(int i=0;i<name.length();i++)
		    {
		        if(str1[i] == ' ')
		        {                   
		            str1[i+1] =  Character.toUpperCase(str1[i+1]);
		        }
		    }
		    String name1="";
		    for(int i=0;i<name.length();i++)
		    {
		       name1+=str1[i];
		    }
		
		
		List<PreparedStatementDTO> pslist = new ArrayList<PreparedStatementDTO>();
		
	    pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(1);
		pstmt.setValue(email);
	    pslist.add(pstmt);
	    pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(2);
		pstmt.setValue(password);
	    pslist.add(pstmt);
	    pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(3);
		pstmt.setValue(name1);
		pslist.add(pstmt);
		pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(4);
		pstmt.setValue(mobile);
	    pslist.add(pstmt);
	    pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(5);
		pstmt.setValue(id);
	    pslist.add(pstmt);
	    pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(6);
		pstmt.setValue(city);
	    pslist.add(pstmt);
	    try {
			dao.signUpEntry(SQLConstants.signUp,pslist);
			sent = SendEmail.sendEmail(email,id);
			if(sent==1){
				response.setStatus(HttpServletResponse.SC_OK);
				return;
			}else
			{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
		} catch (ClassNotFoundException | SQLException | MessagingException e) {
			logger.error("Error in either sending mail or class not found in signup");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			 e.printStackTrace();
		    return;
		}
	
	}else{
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
          out.write("* Already have account with this email id.");
		  return;
	}
	
	}
}

