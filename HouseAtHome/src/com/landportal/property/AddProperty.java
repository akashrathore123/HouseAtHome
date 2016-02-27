package com.landportal.property;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.landportal.jdbc.DAO;
import com.landportal.jdbc.DBConstants;
import com.landportal.jdbc.Factory;
import com.landportal.jdbc.PreparedStatementDTO;
import com.landportal.jdbc.SQLConstants;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

import com.google.gson.Gson;

/**
 * Servlet implementation class CommercialSubmit
 */
@WebServlet("/commercialSubmit")
public class AddProperty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProperty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    Logger logger = Logger.getLogger(AddProperty.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int random = rand.nextInt(((99999999-11111111)+1)+11111111);
		
		StringBuffer sb = new StringBuffer();
		PrintWriter out = response.getWriter();
		try{
			String line = null;
			BufferedReader reader = request.getReader();
			while((line=reader.readLine())!=null){
				sb.append(line);
			}
		}catch(Exception e){
			logger.error("Error in storing property information in string buffer in Commercial Submit class.");
	    	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    	e.printStackTrace(); 
	    	return;
			
		}		
		
		HttpSession session = request.getSession(false);
		Gson gson = new Gson();
		Map<String, String> map1 = gson.fromJson(sb.toString(),Map.class);
		Map<String, Map> map2 = gson.fromJson(sb.toString(),Map.class);
        String id = (String) session.getAttribute("id");
		String pid =(Integer.toString(random));		
		String category = request.getParameter("category");

		if("null".equals(sb.toString()) || sb.toString().trim().equals("")){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter Seller role.");
			return;
		}
		String srole = map1.get("role");
		if(null==srole){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select Seller role.");
			return;
		}
		String pfor = map1.get("for");
		if(null==pfor){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select purpose of property.");
			return;
		}
		
		Map<String,String> type = map2.get("type");
		String ptype;
		if(null==type){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select property type.");
			return;
		}else{
		 ptype = type.get("type");
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
		String psociety = map1.get("society");
		if(null!=psociety || psociety.trim()!=""){
			if(psociety.trim().length()<3 || psociety.trim().length()>70){
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				out.write("* Enter correct location of property.");
				return;
			}else{
				
					 char[] str1 =psociety.toCharArray();
					   
					    
					    str1[0] = Character.toUpperCase(str1[0]);
					    for(int i=0;i<psociety.length();i++)
					    {
					        if(str1[i] == ' ')
					        {                   
					            str1[i+1] =  Character.toUpperCase(str1[i+1]);
					        }
					    }
					    String name1="";
					    for(int i=0;i<psociety.length();i++)
					    {
					       name1+=str1[i];
					    }
					    psociety=name1;
				}
			
		}else{
			psociety="";
		}
		
		
		
		String paddress = map1.get("address");
		
		if(null!=paddress || paddress.trim()!=""){
		if(paddress.trim().length()<3 || paddress.trim().length()>100){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Address too long.)");
		}
		}else{
			paddress="";
		}
        String parea = map1.get("area");
        if(null==parea || parea.trim()==""){
          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
          out.write("* Enter area of property.");
          return;
        }
        if(!(parea.trim().matches("^[0-9]+$"))){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            out.write("* Enter correct area of property.");
            return;
          }
        
		Map unit = map2.get("unit");
		if(null==unit){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select unit of area.");
			return;
		}else{
		String punit = (String) unit.get("type");
		 parea =parea+" "+punit;
		}
		
		String pprice = map1.get("price");
		if(null==pprice || pprice.trim()==""){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Enter price of property.");
			return;
		}
		String pwashroom;
		Map washroom = map2.get("washroom");
		if(null==washroom){
			pwashroom="";
			
		}else{
		   pwashroom = (String) washroom.get("number");
		}
		String pbalcony;
		Map balcony = map2.get("balcony");
		if(null==balcony){
			pbalcony="";
		}else{
		pbalcony = (String) balcony.get("number");
		}
        String pbedroom;
		Map bedroom = map2.get("bedroom");
		if(null==bedroom){
			pbedroom="";
		}else
		pbedroom = (String) bedroom.get("number");
		String pbathroom;
		Map bathroom = map2.get("bathroom");
		if(null==bathroom){
			pbathroom="";
		}else{
		pbathroom = (String) bathroom.get("number");
		}
		

		String pmcharge = map1.get("maintainance");
		if(null!=pmcharge){
		if(pmcharge.trim().length()>15){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Maintainance charge value too long.");
			return;
		}
		
		}else{
			pmcharge="";
		}
		String pavailability =map1.get("availability");
		if(null==pavailability){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			out.write("* Select availability of property.");
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
		

		
		List<PreparedStatementDTO> pslist = new ArrayList<PreparedStatementDTO>();
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
        ps.setValue(srole);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(4);
        ps.setValue(pfor);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(5);
        ps.setValue(ptype);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(6);
        ps.setValue(pcity);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(7);
        ps.setValue(plocation);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(8);
        ps.setValue(psociety);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(9);
        ps.setValue(paddress);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(10);
        ps.setValue(parea);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(11);
        ps.setValue(pprice);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(12);
        ps.setValue(pwashroom);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(13);
        ps.setValue(pbalcony);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(14);
        ps.setValue(pbedroom);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(15);
        ps.setValue(pbathroom);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(16);
        ps.setValue(pmcharge);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(17);
        ps.setValue(pavailability);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(18);
        ps.setValue(ppossession);
        pslist.add(ps);
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(19);
        ps.setValue(pdescription);
        pslist.add(ps);
        
        String image=(String) session.getAttribute("imageName");
        if(null==image){
        	image="image.jpg";
        }
        ps = new PreparedStatementDTO();
        ps.setDatatype(DBConstants.STRING);
        ps.setPosition(20);
        ps.setValue(image);
        pslist.add(ps);
       session.removeAttribute("imageName");
        
        if(category.matches("residential")){
        	 ps = new PreparedStatementDTO();
             ps.setDatatype(DBConstants.STRING);
             ps.setPosition(21);
             ps.setValue(category);
             pslist.add(ps);
        }else{
        	 ps = new PreparedStatementDTO();
             ps.setDatatype(DBConstants.STRING);
             ps.setPosition(21);
             ps.setValue(category);
             pslist.add(ps);
        }
        DAO dao = Factory.getDAOObject();
        boolean status = false;
        try {
			status = dao.enterProperty(SQLConstants.enterProperty,pslist);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
        if(status){
        	response.setStatus(HttpServletResponse.SC_OK);
        	return;
        }else{
        	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	return;
        }
	}

}
