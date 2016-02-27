package com.landportal.pgHostel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;

import sun.util.logging.resources.logging;

import com.google.gson.Gson;
import com.landportal.dto.PGHostelDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet implementation class pgHostel
 */
@WebServlet("/pgHostel")
public class PGHostel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PGHostel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doPost(request, response);	
          }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	Logger logger = Logger.getLogger(PGHostel.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		  String extract = request.getParameter("extract");
	      DAO dao = Factory.getDAOObject();
		  Gson gson = new Gson();
		  ArrayList<PGHostelDTO> data = new ArrayList<PGHostelDTO>();
	      if(extract.equals("pg") || extract.equals("hostel")){
			 try{
	    	  data = dao.extractPGHostel(SQLConstants.EXTRACT_PG_HOSTEL,extract);
			 }catch(ClassNotFoundException | SQLException e){
				 logger.error("ERROR:In class PG & Hostel Class not found or sql exception");
				 response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				 e.printStackTrace();
				 return;
			 }
			 if(null==data){
				 response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				 return;
			 }else{
				 response.setStatus(HttpServletResponse.SC_OK);
		         out.write(gson.toJson(data));
		         return;
	}
	      }else{
	    	  if(extract.equals("all")){
	    		  try{
	    	    	  data = dao.extractAllPGHostel(SQLConstants.EXTRACT_ALL_PG_HOSTEL);
	    			 }catch(ClassNotFoundException | SQLException e){
	    				 logger.error("ERROR:In class PG & Hostel Class not found or sql exception");
	    				 response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    				 e.printStackTrace();
	    				 return;
	    			 }
	    			 if(null==data){
	    				 response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    				 return;
	    			 }else{
	    				 response.setStatus(HttpServletResponse.SC_OK);
	    		         out.write(gson.toJson(data));
	    		         return;
	    	}
	    	  }else{
	    		  response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	    		  return;
	    	  }
	      }
	}

}
