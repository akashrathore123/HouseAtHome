package com.londprtal.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.landportal.dto.ProjectDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet implementation class TopProjectsData
 */
@WebServlet("/topProjects")
public class TopProjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopProjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Logger logger = Logger.getLogger(TopProjects.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		DAO dao = Factory.getDAOObject();
		ArrayList<ProjectDTO> projects = new  ArrayList<ProjectDTO>();
		try {
			String type = "Builder";
			projects = dao.getProjects(SQLConstants.getProjects,type);
		    Gson gson = new Gson();
			String data = gson.toJson(projects);
			response.setContentType("application/json");
		    out.write(data);
		    return;
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("error in topproject class ClassNotFoundException | SQLException");
			// TODO Auto-generated catch block
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
		
		
	}

}
