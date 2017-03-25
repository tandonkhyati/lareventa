import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class TopStories
 */
@WebServlet("/TopStories")
public class TopDeals extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/lareventa";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopDeals() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   JSONObject object=new JSONObject();
			 JSONArray array =new JSONArray();
		        //array.add("news");
			   
		        
		      try {
		    	  Class.forName("com.mysql.jdbc.Driver");
		    	//  getClass().forName("com.jdbc.mysql");
		         Connection con =  (Connection)DriverManager.getConnection(DB_URL,"root","yoyo");
		         Statement stmt =  con.createStatement();
		        ResultSet rs1 = stmt.executeQuery
	       		         ("SELECT * FROM ads");
	       		         
		         stmt = con.createStatement();
		        
		         while(rs1.next())
		         {	JSONObject obj=new JSONObject();
		     	
		        	 String title=rs1.getString(1);
		        	 /*obj.put("name",rs1.getString(1));
			        	obj.put("email",rs1.getString(2));
			        	obj.put("FcmToken",rs1.getString(3));*/
		        	obj.put("itemname",rs1.getString(1));
		        	obj.put("itemcategory",rs1.getString(2));
		        	obj.put("itemprice",rs1.getString(3));
		        	obj.put("itemold",rs1.getString(4));
		        	obj.put("ownername",rs1.getString(5));
		        	obj.put("ownerphone",rs1.getString(6));
		        	obj.put("owneremail",rs1.getString(7));
		        	obj.put("posteddate",rs1.getString(8));
		        	obj.put("postedtime",rs1.getString(9));
		        	obj.put("itemdescription",rs1.getString(10));
		        	obj.put("sno",rs1.getString(11));
		        	obj.put("imageurl",rs1.getString(12));
			        
		        	
		        	array.add(obj);
		 		    	 	
		         }
		         object.put("item", array);
		         response.getWriter().append(object.toJSONString());
			       
		       }
		      catch(SQLException e){
		         System.out.println("SQL exception occured" + e);
		      } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
