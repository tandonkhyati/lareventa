

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

/**
 * Servlet implementation class LoginInsert
 */
@WebServlet("/LoginAPI")
public class LoginAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public String dburl="jdbc:mysql://localhost/lareventa";
    String user="root";
	String pass="yoyo";
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	String Name=request.getParameter("Name");
	String Email=request.getParameter("Email");	
	System.out.println("Input"+" "+Name +"  "+Email );
	
		
	try{
		
		  Class.forName("com.mysql.jdbc.Driver");
	    	//  getClass().forName("com.jdbc.mysql");
	         Connection con =  (Connection)DriverManager.getConnection(dburl,"root","yoyo");
	         Statement stmt =  con.createStatement();
	        	
	        int success=stmt.executeUpdate("insert into users(name,email) values ('"+Name+"','"+Email+"')");
	            
	        if(success>0)
	        {
	    	response.getWriter().append("Row inserted");
	        }
	        else
	        {
	        	response.getWriter().append("Row insert Failure");
		        	
	        }
	         
	         
	}catch(SQLException e)
	{
		e.printStackTrace();
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
