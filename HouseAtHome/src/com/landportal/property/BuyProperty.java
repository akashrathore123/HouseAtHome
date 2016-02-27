package com.landportal.property;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.landportal.dto.BuyDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.DBConstants;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.PreparedStatementDTO;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet implementation class ResidentialBuy
 */
@WebServlet("/residentialBuy")
public class BuyProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyProperty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	Logger logger = Logger.getLogger(BuyProperty.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		PrintWriter out = response.getWriter();
		try{
			String line = null;
			BufferedReader reader = request.getReader();
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		}catch(Exception e){
			logger.error("Error in storing property information in string buffer in Buy class.");
	    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    	e.printStackTrace(); 
	    	return;
			
		}
		Gson gson = new Gson();
		Map<String,String> received=gson.fromJson(sb.toString(),Map.class);
	   String category = received.get("category");
	   String pfor = received.get("pfor");
	   ArrayList<BuyDTO> data = new ArrayList<BuyDTO>();
		DAO dao = Factory.getDAOObject();
		ArrayList<PreparedStatementDTO> ps = new ArrayList<PreparedStatementDTO>();
		
		if(category.length()>12){
			PreparedStatementDTO pstmt =new PreparedStatementDTO();
			pstmt.setDatatype(DBConstants.STRING);
			pstmt.setPosition(1);
			pstmt.setValue(pfor);
			ps.add(pstmt);
			
			try {
				data = dao.extractPropertyAll(SQLConstants.EXTRACT_PROPERTY_ALL,pstmt);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				logger.error("*Error in Buy class:lassNotFoundException | SQLException");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return;
			}
		}else{
		PreparedStatementDTO pstmt =new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(1);
		pstmt.setValue(category);
		ps.add(pstmt);
		
		pstmt = new PreparedStatementDTO();
		pstmt.setDatatype(DBConstants.STRING);
		pstmt.setPosition(2);
		pstmt.setValue(pfor);
		ps.add(pstmt);
		
		try {
			data = dao.extractProperty(SQLConstants.EXTRACT_PROPERTY,ps);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error("*Error in Buy class:lassNotFoundException | SQLException");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		}
		if(null==data){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}else{
			gson = new Gson();
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			out.write(gson.toJson(data));
			return;
		}
		
	}

}
