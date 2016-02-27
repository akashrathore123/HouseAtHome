package com.landportal.jdbc;

import java.io.PrintWriter;
import java.util.ResourceBundle;

public class Factory {
	public static DAO getDAOObject(){
	DAO dao=null;	
	ResourceBundle rb=ResourceBundle.getBundle("db");
	String database=rb.getString("dbtype");
	if(database.equals("mysql")){
		dao=new MySQLDAO();
	}
	return dao;
	}
}
