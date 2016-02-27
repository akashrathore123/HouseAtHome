package com.landportal.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.landportal.dto.BuyDTO;
import com.landportal.dto.PGHostelDTO;
import com.landportal.dto.ProjectDTO;
import com.landportal.dto.UserDTO;



public interface DAO {
	public int cud(String sql,List<PreparedStatementDTO> psList) throws ClassNotFoundException, SQLException ;
    public UserDTO checkLogin(String sql,List<PreparedStatementDTO> psList) throws ClassNotFoundException, SQLException ;
    public void signUpEntry(String sql,List<PreparedStatementDTO> psList) throws ClassNotFoundException, SQLException ;
    public boolean checkEntry(String sql,PreparedStatementDTO pstmt) throws ClassNotFoundException, SQLException;
    public void emailConfirmed(String sql,PreparedStatementDTO pstmt) throws ClassNotFoundException, SQLException;
    public UserDTO extractUser(String sql,String id) throws ClassNotFoundException, SQLException;
    public boolean checkEmail(String sql,String email) throws ClassNotFoundException, SQLException;
    public String getID(String sql,String email) throws ClassNotFoundException, SQLException;
	public void changePassword(String sql, String id, String password) throws ClassNotFoundException, SQLException;
    public ArrayList<ProjectDTO> getProjects(String sql,String type) throws ClassNotFoundException, SQLException;
	public boolean enterProperty(String enterproperty,List<PreparedStatementDTO> pslist) throws ClassNotFoundException, SQLException; 
    public ArrayList<BuyDTO> extractProperty(String sql,ArrayList<PreparedStatementDTO> pstmt) throws ClassNotFoundException, SQLException; 
    public ArrayList<BuyDTO> extractPropertyAll(String sql,PreparedStatementDTO pstmt) throws ClassNotFoundException, SQLException; 
    public ArrayList<PGHostelDTO> extractPGHostel(String sql,String extract) throws ClassNotFoundException, SQLException;
    public ArrayList<PGHostelDTO> extractAllPGHostel(String sql) throws ClassNotFoundException, SQLException;
	public boolean insertPGHostel(String insertPgHostel,ArrayList<PreparedStatementDTO> pslist) throws ClassNotFoundException, SQLException;
}
