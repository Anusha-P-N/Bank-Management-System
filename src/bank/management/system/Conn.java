package bank.management.system;

import java.sql.*;

public class Conn {

	  Connection c;        
	    Statement s;
	    public Conn(){  
	    	//as mySQL is external connectivty there is a change that we get error..so we will use exception handling as below(to catch runtime errors)
	        try{                   
	            Class.forName("com.mysql.cj.jdbc.Driver");          //driver creation
	            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem",
	            		"root",
	            		"Anusha"
	            		);    //creating connection
	            s =c.createStatement(); 
	           
	          
	            
	        }catch(Exception e){ 
	            e.printStackTrace();
	        }  
	    }  
	}  


//this is jdbc connection file  -- consists of 4 steps 
//1. create connection
//2. create statement
//3. execute query
//4. close connection
