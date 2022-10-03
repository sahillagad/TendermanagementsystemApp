package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {

	

		
		public static Connection provideConnection() {
			
			Connection conn=null;
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
		
			} catch (ClassNotFoundException e) {
				
				System.out.println(e.getMessage());	
				
			}
			 String url="jdbc:mysql://localhost:3306/TenderManagementApp";
			
			
			 
			 try {
				conn=DriverManager.getConnection(url,"root","root");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return conn;
		}
		
		
		
	}


