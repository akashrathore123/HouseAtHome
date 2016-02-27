package com.landportal.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class Image
 */
@WebServlet("/image")
public class Image extends HttpServlet implements FileRenamePolicy {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 public static String newmode;  
	    @Override
		  public File rename(File f) {
	      String name = f.getName();
	      String body = null;
	      String ext = null;

	      int dot = name.lastIndexOf(".");
	      if (dot != -1) {
	          ext = name.substring(dot); // includes "."
	      } else {
	          ext = "";
	      }
	      if((ext.toLowerCase().matches(".jpg")) || (ext.toLowerCase().matches(".jpeg")) || (ext.toLowerCase().matches(".png"))){
	    	
	    	 }else{
	    	  return null;
	      }
	      body = Long.toString( System.currentTimeMillis() );

	      File renameFile = new File( f.getParent(), body + ext );
	      newmode=body+ext;
	      if( renameFile.exists() ){
	          int count = 0;
	          do {
	              count++;
	         final     String newName = body + count + ext;
	             newmode=newName;
	              
	             
	              renameFile = new File(f.getParent(), newName);
	          }while( renameFile.exists() && count < 9999 );
	           
	      }
	      f.renameTo( renameFile );
	      return renameFile;
	}
		
	
	
	public Image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Logger logger =Logger.getLogger(Image.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + "images/property";
     try{   
        MultipartRequest m = new MultipartRequest(request,savePath,5*1024*1024);
        Enumeration files = m.getFileNames();
        while (files.hasMoreElements()) {
        String name = (String)files.nextElement();
      
		 String filename = m.getFilesystemName(name);
		
        String type = m.getContentType(name);
        File f = m.getFile(name);
        File check = rename(f);
      if(null==check){
    	  response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    	  out.write("* Wrong Format Of Image." );
    	  return;
      }
       
        HttpSession session=request.getSession(false);
        session.setAttribute("imageName", newmode);
        out.write("* Image Successfully Uploaded");
        return;
	}
             
       }
     catch(Exception e){
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		
		out.write("* Error in uploading image.");
		return;
	}
 
     
	}
	
}
