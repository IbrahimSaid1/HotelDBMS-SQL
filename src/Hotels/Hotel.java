package Hotels;

import java.sql.*;
import java.util.Scanner;
public class Hotel {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=HotelDBMS;" +
                "encrypt=true;" +
                "trustServerCertificate=true";
        
        
        String user = "sa";
        String pass = "root";
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter id: ");
        Integer id = scanner.nextInt();
        System.out.println("Enter hotel name: ");
        String name = scanner.next();
        System.out.println("Enter hotel location: ");
        String location = scanner.next();
        System.out.println("Enter created date: ");  
        String  date = scanner.next();
        System.out.println("Enter updated date: ");  
        String  date1 = scanner.next();
        System.out.println("is_Active: ");  
        boolean active = scanner.nextBoolean();
	
	
	
	
	
	
	System.out.println("-----------");
	System.out.println("Enter id: ");
	Integer id1 = scanner.nextInt();
	System.out.println("room type name: ");
	String type = scanner.next();
	System.out.println("Enter created date: ");
	String date2 = scanner.next();
	System.out.println("Enter updated date: ");
	String date3 = scanner.next();
	System.out.println("is_Active: ");
	boolean active1 = scanner.nextBoolean();
	


	
	

	System.out.println("-----------");
	System.out.println("Enter id: ");
	Integer id2 = scanner.nextInt();
	System.out.println("room type Id: ");
	Integer IdType = scanner.nextInt();
	System.out.println("Enter hotel Id: ");
	Integer IdHotel = scanner.nextInt();
	System.out.println("Enter updated date: ");
	String date4 = scanner.next();
	System.out.println("Enter updated date: ");
	String date5 = scanner.next();
	System.out.println("is_Active: ");
	boolean active2 = scanner.nextBoolean();
	
	
	
	
 Connection con = null;
 
        try {
Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
 Statement st = con.createStatement();
 
 String sql = "CREATE TABLE Hotels ("
		+ "id INT PRIMARY KEY, " +		
		 "hotel_name VARCHAR(255) NOT NULL, " +
	"hotel_location VARCHAR(255), " +
	"created_date VARCHAR(250) NOT NULL, " +
		"updated_date VARCHAR(250), " +
	"is_Active BIT NOT NULL);"
 

+  "CREATE TABLE Room_Type ("
		 +"id Integer Primary Key,"
 		+ "room_type_name String not null,"
 		+ "created_date VARCHAR(250), "                  
 		+ "updated_date VARCHAR(250), "                
 		+ "is_Active BIT NOT NULL);"
 

	 
	 
	 + "CREATE TABLE Rooms("
	 + "id Integer Primary Key,"                                    
	 + "room_type_id Foriegn key REFERENCES Room_Type(id),"
	 + "hotel_id Foriegn key REFERENCES Hotels(id),"         
	 + "created_date VARCHAR(250) not null, "                                
	 + "updated_date VARCHAR(250),"                                             
	 + "is_Active BIT not null)";  
 
 
	 
 st.executeUpdate(sql);

 
 
 
 
 
 
 for(Integer i =4;i<=10000;i++) {
            String sql1 = "insert into Hotels(id, hotel_name, hotel_location, created_date, updated_date, is_Active) values('" + id
            		+ "','" + name + "','" + location + "','" + date +"','" + date1+"','" + active+"' );"
 
            		
            		+	"insert into Room values('"+ id1
       			 + "','" + type + "','" + date2 + "','" + date3 +"','" + active1+"' );"
       			 
       			 +"insert into Rooms values('"+ id2
       		 + "','" + IdType + "','" + IdHotel + "','" + date4 +"','" + date5 + "', '"+ active2+"' )";
        		

                   
        			
 		
            Integer m = st.executeUpdate(sql1);
            
 			if (m >= 1) {
 				System.out.println("inserted successfully \n" + sql1);
 			} else {
 				System.out.println("insertion failed");
 			}

        }	
		
 			
 			
 			
        String sql2 = "Select * from Hotels";
        ResultSet resultSet = st.executeQuery(sql2);
        while (resultSet.next()) {
				System.out.println(resultSet.getString("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("location"));
				System.out.println(resultSet.getString("date"));
				System.out.println(resultSet.getString("date1"));
				System.out.println(resultSet.getString("active"));
        		}
             
             
             
             
             
             
		 String sql3 = "Select * from Room_Type";
		 ResultSet resultSet1 = st.executeQuery(sql3);
		 while (resultSet1.next()) {
			 System.out.println(resultSet.getString("id1"));
			 System.out.println(resultSet.getString("type"));
			 System.out.println(resultSet.getString("date2"));
			 System.out.println(resultSet.getString("date3"));
			 System.out.println(resultSet.getString("active1"));
              } 
             
             
		 
		 
	      
			 String sql4 = "Select * from Rooms";
			 ResultSet resultSet2 = st.executeQuery(sql4);
			 while (resultSet2.next()) {
				 System.out.println(resultSet.getString("id2"));
				 System.out.println(resultSet.getString("IdType"));
				 System.out.println(resultSet.getString("IdHotel"));
				 System.out.println(resultSet.getString("date4"));
				 System.out.println(resultSet.getString("date5"));
				 System.out.println(resultSet.getString("active2"));
	              } 
			 
			 
			 
             
            con.close();
} catch (Exception ex) {
System.err.println(ex);
}
}
}
