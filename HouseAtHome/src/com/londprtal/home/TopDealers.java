package com.londprtal.home;

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
 * Servlet implementation class TopDealers
 */
@WebServlet("/topdealers")
public class TopDealers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopDealers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Logger logger = Logger.getLogger(TopDealers.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		ArrayList<ProjectDTO> dealers = new ArrayList<ProjectDTO>();
	    DAO dao =Factory.getDAOObject();
	    String type = "Dealer";
	    try {
			dealers =dao.getProjects(SQLConstants.getProjects,type);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			return;
		}
	    out.write(gson.toJson(dealers).toString());
		response.setStatus(HttpServletResponse.SC_OK);
        return;
	}

}
