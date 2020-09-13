package production.Staging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import com.microsoft.sqlserver.jdbc.*;
import com.thoughtworks.selenium.webdriven.commands.Close; 

public class DbConnection {
	 static Connection connection = null; 
 
    public static void main(String[] args) throws SQLException {
//    	DbConnectionF("RM-DEV01", "sa", "newspaper","update Personnel set email = 'lan.lan2' where userid = 596063");
//    	DbConnectionF("rminta14.redmatch.net\\SQLSTAGING", "sa", "Newspaper!","update Personnel set email = 'lan.lan2' where userid = 596063");
//    	DbAccess("RM-DEV01", "sa", "newspaper");
//    	DbUpdate("update Personnel set email = 'lan.lan2' where userid = 596063");
    	
    	//Staging.DbConnection.DbAccess("rminta14.redmatch.net\\SQLSTAGING","sa", "Newspaper!");
		//Staging.DbConnection.DbUpdate("util_deletecandidate'680457504@10noemail',512937");
		//Staging.DbConnection.DbUpdate("update personnel set email  = 'ban.ban2' where userid = 596063");
    }  
    
    public static Connection DbAccess (String ServerName,String User,String Password){
     	 String connectionString =  
     	        "jdbc:sqlserver://"+ ServerName + ";"
     	                + "database=RedmatchDB_RecruiterPro;"  
     	                + "user="+User+";"  
     	                + "password="+Password+";"  
     	                + "encrypt=false;"  
     	                + "trustServerCertificate=false;"  
     	                + "loginTimeout=30;";  
     	    	  
     	    	 
     	           try {
     				connection = DriverManager.getConnection(connectionString);
     			} catch (SQLException e) {
     				 e.printStackTrace();  
     			} 
     	          System.out.println("Connection Succeeded");
     	           return connection;
     	           
     	       
    }
    
    
    public static Connection DbUpdate (String EcecutionText) throws SQLException{
    	Statement stmt = null;
        stmt = connection.createStatement();
        String sql = EcecutionText;
        stmt.execute(sql);
        connection.close();
        System.out.println("Db updated");
        return connection;
        
    	
    } 
    
    public static String DbConnectionF(String ServerName,String User,String Password,String EcecutionText) throws SQLException{
    	 String connectionString =  
        "jdbc:sqlserver://"+ ServerName + ";"
                + "database=RedmatchDB_RecruiterPro;"  
                + "user="+User+";"  
                + "password="+Password+";"  
                + "encrypt=false;"  
                + "trustServerCertificate=false;"  
                + "loginTimeout=30;";  
    	   Connection connection = null;  
           Statement stmt = null;
           try {
			connection = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			 e.printStackTrace();  
		} 
           stmt = connection.createStatement();
           String sql = EcecutionText;
           stmt.executeUpdate(sql);
           connection.close();
           System.out.println("success");
    	 
		return null;}
    
    
    
    public static Connection viewTable(Connection connection , String dbName)
    	    throws SQLException {
    	 
    	    Statement stmt = null;
    	    String query =
    	    		"select top 1 * from" + dbName + "..persresumes";
    	    //    "select content from " + dbName + ".persresumes" + " where userid in (select userid from personnel where idno = '680457504')";
    	
    	   
    	   // try {
    	   	
    	        stmt = connection.createStatement();
    	   
    	        ResultSet rs = stmt.executeQuery(query);
    	   	
    	        while (rs.next()) {
    	            String content = rs.getString("content");
    	            System.out.println(content + "\t" );
    	       // }
    	  //  } catch (SQLException e ) {
    	    	System.out.println ("4");
    	    	//printSQLException(e.getMessage());
    	    	System.out.println ("5");
    	   // } finally {
    	        if (stmt != null) { stmt.close(); }
    	    }
    	    System.out.println("end of view table function" );
			return connection;
    	}

	private static char[] printSQLException(String string) {
		// TODO Auto-generated method stub
		return null;
	}


}  

