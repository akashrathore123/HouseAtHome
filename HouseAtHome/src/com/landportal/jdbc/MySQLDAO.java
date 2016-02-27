package com.landportal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.landportal.dto.BuyDTO;
import com.landportal.dto.PGHostelDTO;
import com.landportal.dto.ProjectDTO;
import com.landportal.dto.UserDTO;



public  class MySQLDAO implements DAO, DBConstants{
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driverName = rb.getString("drivername");
		Class.forName(driverName);
		
		String url = rb.getString("url");
		String userid = rb.getString("userid");
		String password = rb.getString("pwd");
		
		return DriverManager.getConnection(url,userid,password);
		
	}
	@Override
	public int cud(String sql, List<PreparedStatementDTO> psList) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			if(psList!=null && psList.size()>0){
				for(PreparedStatementDTO psDTO : psList){
					if(psDTO.getDatatype()==STRING){
				
						pstmt.setString(psDTO.getPosition(), psDTO.getValue().toString());
					}
					else
					if(psDTO.getDatatype()==INTEGER){
						pstmt.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
						
					}
					else
						if(psDTO.getDatatype()==DOUBLE){
							
							pstmt.setDouble(psDTO.getPosition(), (Double)psDTO.getValue());
							
						}
				}
			}
			rowCount = pstmt.executeUpdate();
		}
		finally
		{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return rowCount;
	}
	
	@Override
	public UserDTO checkLogin(String sql,List<PreparedStatementDTO> psList) throws SQLException, ClassNotFoundException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		UserDTO user = null;
		ResultSet rs=null;
		try
		{
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			if(psList!=null && psList.size()>0){
				for(PreparedStatementDTO psDTO : psList){
					if(psDTO.getDatatype()==STRING){
				
						pstmt.setString(psDTO.getPosition(), psDTO.getValue().toString());
					}
					else
					if(psDTO.getDatatype()==INTEGER){
						pstmt.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
						
					}
					else
						if(psDTO.getDatatype()==DOUBLE){
							
							pstmt.setDouble(psDTO.getPosition(), (Double)psDTO.getValue());
							
						}
				}
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				user=new UserDTO();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setMobile(rs.getString("mobile"));
				user.setId(rs.getString("id"));
				user.setVerify((short) rs.getInt("verify"));
				user.setCity(rs.getString("city"));

				
			}
		}
		finally
		{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return user;
	}
	
	@Override
	public void signUpEntry(String sql,List<PreparedStatementDTO> psList) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
		con = getConnection();
		
		pstmt = con.prepareStatement(sql);
		
		if(psList!=null && psList.size()>0){
			for(PreparedStatementDTO psDTO : psList){
				if(psDTO.getDatatype()==STRING){
			
					pstmt.setString(psDTO.getPosition(), psDTO.getValue().toString());
				}
				else
				if(psDTO.getDatatype()==INTEGER){
					pstmt.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
					
				}
				else
					if(psDTO.getDatatype()==DOUBLE){
						
						pstmt.setDouble(psDTO.getPosition(), (Double)psDTO.getValue());
						
					}
			}
		}
		pstmt.execute();
		}
		finally
		{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	@Override
	public boolean checkEntry(String sql,PreparedStatementDTO pstmt) throws ClassNotFoundException, SQLException{
		Connection con = null;
        PreparedStatement ps = null;
        boolean count = true;

        try{
		con = getConnection();

        ps = con.prepareStatement(sql);

		

			ps.setString(pstmt.getPosition(), pstmt.getValue().toString());
		   
			if(ps.executeQuery().next()){
			count = false;

		}
        }finally
		{
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return count;
	}
	@Override
	public void emailConfirmed(String sql, PreparedStatementDTO pstmt)
			throws ClassNotFoundException, SQLException {
		   PreparedStatement ps = null;
		   Connection con = null;
		   try{
		   con = getConnection();
		   ps = con.prepareStatement(sql);
		   
			ps.setString(pstmt.getPosition(), pstmt.getValue().toString());
            ps.executeUpdate();
		   }
		   finally
			{
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			}
	}
	@Override
	public UserDTO extractUser(String sql, String id)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		 Connection con = null;
		 ResultSet rs = null;
		 UserDTO user = null;
		 try{
		   con = getConnection();
		   ps = con.prepareStatement(sql);
		  
			 ps.setString(1,id);
			 rs = ps.executeQuery();
			 if(rs.next()){
                 user = new UserDTO();
				 user.setEmail(rs.getString("email"));
                 user.setCity(rs.getString("city"));
				 user.setId(rs.getString("id"));
				 user.setMobile(rs.getString("mobile"));
				 user.setName(rs.getString("name"));
				 user.setPassword(rs.getString("password"));

				 user.setVerify(rs.getShort("verify"));
}
		 }   finally
			{
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			}
		return user;
	}
	@Override
	public boolean checkEmail(String sql, String email)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean check = false;
		PreparedStatement ps = null;
		 Connection con = null;
		 try{
		 con = getConnection();
		   ps = con.prepareStatement(sql);
		   
			ps.setString(1,email);
			
            if(ps.executeQuery().next()){
            	check = true;

            }
		 }   finally
			{
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			}
		return check;
	}
	@Override
	public String getID(String sql, String email)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		 Connection con = null;
		 ResultSet rs = null;
		 String id = null;
		 try{  
		 con = getConnection();
		   ps = con.prepareStatement(sql);
		   
			ps.setString(1,email);
			rs = ps.executeQuery();
        
         while(rs.next()){
         id = rs.getString(1);
         }
		 }
		   finally
					{
						if(ps!=null){
							ps.close();
						}
						if(con!=null){
							con.close();
						}
					}
		return id;
	}
	@Override
	public void changePassword(String sql, String id, String password)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		 Connection con = null;
		 try{
		   con = getConnection();
		   ps = con.prepareStatement(sql);
		   
			ps.setString(1,password);
			ps.setString(2,id);
			ps.executeUpdate();
	}finally
	{
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
	} 
	}
	@Override
	public ArrayList<ProjectDTO> getProjects(String sql,String type)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<ProjectDTO> projects = new ArrayList<ProjectDTO>(); 
		PreparedStatement ps = null;
		ResultSet rs = null;
		 Connection con = null;
		 try{
		 con = getConnection();
		   ps = con.prepareStatement(sql);
		   ps.setString(1,type);
           rs = ps.executeQuery();
           while(rs.next())
           {
        	   ProjectDTO project = new ProjectDTO();
        	   project.setProjectCity(rs.getString("projectcity"));
        	   project.setProjectId(rs.getString("projectid"));
        	   project.setProjectName(rs.getString("projectname"));
        	   project.setProjectPrice(rs.getString("projectprice"));
        	   project.setProjectType(rs.getString("projecttype"));
        	   project.setProjectLocation(rs.getString("projectlocation"));
        	   
        	   projects.add(project);
           }
		 }finally
			{
				if(ps!=null){
					ps.close();
				}
				if(con!=null){
					con.close();
				}
			}
		   return projects;
	}
	@Override
	public boolean enterProperty(String sql,List<PreparedStatementDTO> pslist) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		boolean status = false;
		PreparedStatement pstmt =null;
		Connection con =null;
		try{
		con = getConnection();
		pstmt=con.prepareStatement(sql);
		if(pslist!=null && pslist.size()>0){
				for(PreparedStatementDTO psDTO : pslist){
					if(psDTO.getDatatype()==STRING){
						pstmt.setString(psDTO.getPosition(), psDTO.getValue().toString());
					}
					else
					if(psDTO.getDatatype()==INTEGER){
						pstmt.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
						
					}
			
		}
				pstmt.execute();
				System.out.println("out");

				status = true;
				return status;
			
	}
		}finally
		{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return status;
		}
	@Override
	public ArrayList<BuyDTO> extractProperty(String sql,ArrayList<PreparedStatementDTO> pslist) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BuyDTO> data = new ArrayList<BuyDTO>();
		try{
			con = getConnection();
			ps = con.prepareStatement(sql);
			
			if(pslist!=null && pslist.size()>0){
				
				for(PreparedStatementDTO psDTO : pslist){
					if(psDTO.getDatatype()==STRING){
						ps.setString(psDTO.getPosition(), psDTO.getValue().toString());
						
					}
					else{
					if(psDTO.getDatatype()==INTEGER){
						ps.setInt(psDTO.getPosition(), (Integer)psDTO.getValue());
						
					}
					}
				
		}
			rs=ps.executeQuery();
		

			while(rs.next()){
				BuyDTO property = new BuyDTO();
				property.setId(rs.getString("id"));
				property.setPaddress(rs.getString("paddress"));
				property.setParea(rs.getString("parea"));
				property.setPavailability(rs.getString("pavailability"));
				property.setPbalcony(rs.getString("pbalcony"));
				property.setPbathroom(rs.getString("pbathroom"));
				property.setPbedroom(rs.getString("pbedroom"));
				property.setPcity(rs.getString("pcity"));
				property.setPdescription(rs.getString("pdescription"));
				property.setPfor(rs.getString("pfor"));
				property.setPid(rs.getString("pid"));
				property.setPimage(rs.getString("pimagepath"));
				property.setPlocation(rs.getString("plocation"));
				property.setPmcharge(rs.getString("pmcharge"));
				property.setPossession(rs.getString("ppossession"));
				property.setPprice(rs.getString("pprice"));
				property.setPsociety(rs.getString("psociety"));
				property.setPtype(rs.getString("ptype"));
				property.setPwashroom(rs.getString("pwashroom"));
				property.setScity(rs.getString("city"));
				property.setSemail(rs.getString("email"));
			    property.setSmobile(rs.getString("mobile"));
			    property.setSname(rs.getString("name"));
				property.setSrole(rs.getString("srole"));
				property.setVerify(rs.getShort("verify"));
				data.add(property);
				

				
				
			}
		}
		}finally
		{
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		}
	
		return data;
	}
	
	public ArrayList<BuyDTO> extractPropertyAll(String sql,PreparedStatementDTO pslist) throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BuyDTO> data = new ArrayList<BuyDTO>();
		try{
			con = getConnection();
			ps = con.prepareStatement(sql);
			
		
				
				
					if(pslist.getDatatype()==STRING){
						ps.setString(pslist.getPosition(), pslist.getValue().toString());
						
					}
					
				
		
			rs=ps.executeQuery();
		

			while(rs.next()){
				BuyDTO property = new BuyDTO();
				property.setId(rs.getString("id"));
				property.setPaddress(rs.getString("paddress"));
				property.setParea(rs.getString("parea"));
				property.setPavailability(rs.getString("pavailability"));
				property.setPbalcony(rs.getString("pbalcony"));
				property.setPbathroom(rs.getString("pbathroom"));
				property.setPbedroom(rs.getString("pbedroom"));
				property.setPcity(rs.getString("pcity"));
				property.setPdescription(rs.getString("pdescription"));
				property.setPfor(rs.getString("pfor"));
				property.setPid(rs.getString("pid"));
				property.setPimage(rs.getString("pimagepath"));
				property.setPlocation(rs.getString("plocation"));
				property.setPmcharge(rs.getString("pmcharge"));
				property.setPossession(rs.getString("ppossession"));
				property.setPprice(rs.getString("pprice"));
				property.setPsociety(rs.getString("psociety"));
				property.setPtype(rs.getString("ptype"));
				property.setPwashroom(rs.getString("pwashroom"));
				property.setScity(rs.getString("city"));
				property.setSemail(rs.getString("email"));
			    property.setSmobile(rs.getString("mobile"));
			    property.setSname(rs.getString("name"));
				property.setSrole(rs.getString("srole"));
				property.setVerify(rs.getShort("verify"));
				data.add(property);
				

				
				
			}
		
		}finally
		{
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		}
	
		return data;
	}
	@Override
	public ArrayList<PGHostelDTO> extractPGHostel(String sql, String extract)throws ClassNotFoundException, SQLException {
      ArrayList<PGHostelDTO> data = new ArrayList<PGHostelDTO>();
      Connection con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      try{
    	  con = getConnection();
    	  ps = con.prepareStatement(sql);
    	  ps.setString(1, extract);
    	  
    	  rs = ps.executeQuery();
    	  while(rs.next()){
    		  PGHostelDTO data1= new PGHostelDTO();
    		  data1.setAddress(rs.getString("address"));
    		  data1.setPid(rs.getString("pid"));
    		  data1.setId(rs.getString("id"));
    		  data1.setAvailability(rs.getString("availability"));
    		  data1.setBathroom(rs.getString("bathroom"));
    		  data1.setCity(rs.getString("pcity"));
    		  data1.setConditions(rs.getString("conditions"));
    		  data1.setDescription(rs.getString("description"));
    		  data1.setFurnish(rs.getString("furnish"));
    		  data1.setImage(rs.getString("image"));
    		  data1.setLocality(rs.getString("locality"));
    		  data1.setNoOfRooms(rs.getString("no_of_rooms"));
    		  data1.setPossession(rs.getString("possession"));
    		  data1.setRentroom(rs.getString("rentroom"));
    		  data1.setScity(rs.getString("city"));
    		  data1.setSemail(rs.getString("email"));
    		  data1.setSmobile(rs.getString("mobile"));
    		  data1.setType(rs.getString("type"));
    		  data1.setSname(rs.getString("name"));
    		  data1.setSrole(rs.getString("srole"));
    		  data1.setVerify(rs.getString("verify"));
    		  data.add(data1);
    	  }
      }finally{
    	  if(ps!=null){
    		  ps.close();
    	  }
    	  if(con!=null){
    		  con.close();
    	  }
      }
		
		return data;
	}
	@Override
	public ArrayList<PGHostelDTO> extractAllPGHostel(String sql)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		  ArrayList<PGHostelDTO> data = new ArrayList<PGHostelDTO>();
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      try{
	    	  con = getConnection();
	    	  ps = con.prepareStatement(sql);
	    	  rs = ps.executeQuery();
	    	  while(rs.next()){
	    		  PGHostelDTO data1= new PGHostelDTO();
	    		  data1.setAddress(rs.getString("address"));
	    		  data1.setPid(rs.getString("pid"));
	    		  data1.setId(rs.getString("id"));
	    		  data1.setAvailability(rs.getString("availability"));
	    		  data1.setBathroom(rs.getString("bathroom"));
	    		  data1.setCity(rs.getString("pcity"));
	    		  data1.setConditions(rs.getString("conditions"));
	    		  data1.setDescription(rs.getString("description"));
	    		  data1.setFurnish(rs.getString("furnish"));
	    		  data1.setImage(rs.getString("image"));
	    		  data1.setLocality(rs.getString("locality"));
	    		  data1.setNoOfRooms(rs.getString("no_of_rooms"));
	    		  data1.setPossession(rs.getString("possession"));
	    		  data1.setRentroom(rs.getString("rentroom"));
	    		  data1.setScity(rs.getString("city"));
	    		  data1.setSemail(rs.getString("email"));
	    		  data1.setSmobile(rs.getString("mobile"));
	    		  data1.setType(rs.getString("type"));
	    		  data1.setSname(rs.getString("name"));
	    		  data1.setSrole(rs.getString("srole"));
	    		  data1.setVerify(rs.getString("verify"));
	    		  data.add(data1);
	    	  }
	      }finally{
	    	  if(ps!=null){
	    		  ps.close();
	    	  }
	    	  if(con!=null){
	    		  con.close();
	    	  }
	      }
			
		return data;
	}
	@Override
	public boolean insertPGHostel(String insertPgHostel,ArrayList<PreparedStatementDTO> pslist)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean status = false;
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = getConnection();
			ps = con.prepareStatement(insertPgHostel);
			if(pslist!=null && pslist.size()>0){
				
				for(PreparedStatementDTO psDTO : pslist){
					
					if(psDTO.getDatatype()==STRING){
					
						ps.setString(psDTO.getPosition(), psDTO.getValue().toString());
						
					
				
					
				}
					}			

				 ps.execute();
			     status=true;
			   

			}

			
		}finally{
			if(ps!=null){
				ps.close();
			}
		if(con!=null){
			con.close();
		}
		}
		return status;
	}
	
	
	}
