package com.landportal.pgHostel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.landportal.dto.PGHostelDTO;
import com.landportal.jdbc.DAO;
import com.landportal.jdbc.DBConstants;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.PreparedStatementDTO;
import com.landportal.jdbc.SQLConstants;

/**
 * Servlet implementation class AddPGHostel
 */
@WebServlet("/addPGHostel")
public class AddPGHostel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPGHostel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Logger logger = Logger.getLogger(AddPGHostel.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int random = rand.nextInt(((999999999-111111111)+1)+111111111);
		
		StringBuffer sb = new StringBuffer();
		PrintWriter out = response.getWriter();
		try{
			String line = null;
			BufferedReader reader = request.getReader();
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		}catch(Exception e){
			logger.error("Error in storing property information in string buffer in AddPGHostelclass.");
	    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    	e.printStackTrace(); 
	    	return;
			
		}		
		
		if("null".equals(sb.toString()) || sb.toString().trim().equals("")){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter your role.");
			return;
		}
		HttpSession session = request.getSession(false);
		Gson gson = new Gson();
		Map<String, String> map1 = gson.fromJson(sb.toString(),Map.class);
		Map<String, Map> map2 = gson.fromJson(sb.toString(),Map.class);
        String id = (String) session.getAttribute("id");
		String pid =(Integer.toString(random));	
		
		String srole = map1.get("role");
		if(null==srole){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select Seller role.");
			return;
		}
		String type = map1.get("type");
		if(null==type){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select type of property.");
			return;
		}
		Map city = map2.get("city");
		String pothercity = (map1.get("otherCity"));
		String pcity ;
		if(null==city){
			
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select city.");
			return;
		}else{
		pcity = (String) city.get("name");
		if(pcity.matches("Other")){
			if(null==pothercity || pothercity.trim()==""){
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			    out.write("* Enter  city.");
                return;
			}else{
				if(pothercity.length()<3 || !(pothercity.trim().matches("^[A-Z a-z]+$")) || pothercity.length()>32){
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				    out.write("* Enter correct city.");
		            return;
				}else{
					 char[] str1 =pothercity.toCharArray();
					   
					    
					    str1[0] = Character.toUpperCase(str1[0]);
					    for(int i=0;i<pothercity.length();i++)
					    {
					        if(str1[i] == ' ')
					        {                   
					            str1[i+1] =  Character.toUpperCase(str1[i+1]);
					        }
					    }
					    String pothercity1="";
					    for(int i=0;i<pothercity.length();i++)
					    {
					       pothercity1+=str1[i];
					    }
				pcity=pothercity1;
			}
			}
		}
		}
		String plocation = map1.get("locality");
		if(null==plocation || plocation.trim()==""){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter location of property.");
			return;
		}
		if(plocation.trim().length()<3 || plocation.trim().length()>70){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter correct location of property.");
			return;
		}
		String paddress = map1.get("address");
		if(null==paddress || paddress.trim()==""){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter address of property.");
			return;
		}
		if(paddress.trim().length()<3 || paddress.trim().length()>100){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter correct paddress of property.");
			return;
		}
		String noOfRooms;
		Map rooms = map2.get("noOfRooms");
		if(null== rooms){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select no. of rooms");
			return;
		}else{
		noOfRooms = (String) rooms.get("number");
		if(null==noOfRooms || noOfRooms ==""){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter number of rooms.");
			return;
		}
		}
		String rent = map1.get("rentroom");
		if(null==rent || rent==""){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter rent of room.");
			return;
		}
		if(rent.trim().length()<2 || rent.trim().length()>12){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter correct rent of room.");
			return;
		}
		String furnish = map1.get("furnish");
		if(null==furnish || furnish==""){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter furnishing condition.");
			return;
		}
		String bathroom;
		Map bath = map2.get("bathroom");
		if(null==bath){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter type of bathroom.");
			return;
			
		}else
		{
			bathroom = (String) bath.get("number");
			if(null==bathroom || bathroom==""){
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				out.write("* Enter bathroom type.");
				return;
			}
		}
		String conditions = map1.get("conditions");
		if(null!=conditions){
			if(conditions.trim().length()<1 || conditions.trim().length()>70){
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				out.write("* Conditions too long.");
				return;
			}
		}else{
			conditions="";
		}
		String availability=map1.get("availability");
		if(null==availability || availability==""){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter availability of room.");
			return;
		}
		String ppossession;
		Map possession = map2.get("possession");
		if(null==possession){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select property possession.");
			return;
		}else{
		ppossession = (String) possession.get("name");
		}
		String pdescription = map1.get("description");
		if(null==pdescription){
			pdescription="";
		}
		if(pdescription.trim().length()>100){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Description is too long");
			return;
		}
		
		DAO dao = Factory.getDAOObject();
		ArrayList<PreparedStatementDTO> pslist =new ArrayList<PreparedStatementDTO>();
		PreparedStatementDTO ps = new PreparedStatementDTO();
		ps.setDatatype(DBConstants.STRING);
		ps.setPosition(1);
		ps.setValue(pid);
		pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(2);
	    ps.setValue(id);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(3);
	    ps.setValue(paddress);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(4);
	    ps.setValue(pcity);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(5);
	    ps.setValue(plocation);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(6);
	    ps.setValue(noOfRooms);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(7);
	    ps.setValue(pdescription);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(8);
	    ps.setValue(conditions);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(9);
	    ps.setValue(availability);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(10);
	    ps.setValue(ppossession);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(11);
	    ps.setValue(bathroom);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(12);
	    ps.setValue(furnish);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(13);
	    ps.setValue(srole);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(14);
	    ps.setValue(rent);
	    pslist.add(ps);
		
	    String image=(String) session.getAttribute("imageName");
        if(null==image){
        	image="image.jpg";
        }
	    ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(15);
	    ps.setValue(image);
	    pslist.add(ps);
		ps = new PreparedStatementDTO();
	    ps.setDatatype(DBConstants.STRING);
	    ps.setPosition(16);
	    ps.setValue(type);
	    pslist.add(ps);
	    
	    boolean status=false;
	    try{
	    status = dao.insertPGHostel(SQLConstants.INSERT_PG_HOSTEL,pslist);
	    }catch(ClassNotFoundException | SQLException e){
	    	logger.error("ERROR in addpghostel class (CLASS NOT FOUND or SQL EXCEPTION)");
	    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    	return;
	    }
	    if(status==false){
	    	logger.error("No data entered in AddPGHostel class");
	    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    	return;
	    }
	}

}
