package com.landportal.jdbc;

import java.util.ResourceBundle;

public interface SQLConstants {
	ResourceBundle rb =ResourceBundle.getBundle("topProject");

	String checkLogin = "select * from userinfo where email=? and password=?;";
	String signUp = "insert into userinfo values(?,?,?,?,?,?,'0');";
	String ckeckEntry = "select verify from userinfo where email=?;";
	String emailConfirmed = "update userinfo set verify='1' where id=?;";
	String extractUser = "select * from userinfo where id=?;";
	String checkEmail = "select * from userinfo where email=?;";
	String findID = "select id from userinfo where email=?;";
	String changePassword = "update userinfo set password=? where id=?; ";
	String getProjects = "select * from topprojects where stype=? and projectcity in('"+rb.getString("city1")+"','"+rb.getString("city2")+"','"+rb.getString("city3")+"','"+rb.getString("city4")+"');";
    String enterProperty = "insert into propertyinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'0',?);";
    String EXTRACT_PROPERTY = "SELECT `propertyinfo`.*,  `userinfo`.`name`,`userinfo`.`email`,`userinfo`.`mobile`,`userinfo`.`city` "
    		+ "FROM `land_portal`.`propertyinfo` left join `land_portal`.`userinfo` on `propertyinfo`.id = `userinfo`.`id` where `propertyinfo`.`pcategory`=? and `propertyinfo`.`pfor`=?;";
    String EXTRACT_PROPERTY_ALL = "SELECT `propertyinfo`.*,  `userinfo`.`name`,`userinfo`.`email`,`userinfo`.`mobile`,`userinfo`.`city` "
    		+ "FROM `land_portal`.`propertyinfo` left join `land_portal`.`userinfo` on `propertyinfo`.id = `userinfo`.`id` where `propertyinfo`.`pfor`=?;";
    String EXTRACT_PG_HOSTEL = "SELECT `pg_hostel_info`.*,  `userinfo`.`name`,`userinfo`.`email`,`userinfo`.`mobile`,`userinfo`.`city` "
    		+ "FROM `land_portal`.`pg_hostel_info` left join `land_portal`.`userinfo` on `pg_hostel_info`.id = `userinfo`.`id` where `pg_hostel_info`.`type`=?;";
    String EXTRACT_ALL_PG_HOSTEL = "SELECT `pg_hostel_info`.*,  `userinfo`.`name`,`userinfo`.`email`,`userinfo`.`mobile`,`userinfo`.`city` "
    		+ "FROM `land_portal`.`pg_hostel_info` left join `land_portal`.`userinfo` on `pg_hostel_info`.id = `userinfo`.`id`;";
   String INSERT_PG_HOSTEL = "insert into `land_portal`.`pg_hostel_info` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'0',?);";
}
   