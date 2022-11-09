import java.sql.*;  
import oracle.jdbc.driver.*;

class TestCases {
    public static void main(String args[]){
		int testCaseResult = 0; // 0 = Passed -1 = Failed
        try{  
            // load Oracle JDBC-driver
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            // open connect to DB
            Connection con = DriverManager.getConnection(  
                                  "jdbc:oracle:thin:@91.219.60.189:1521/XEPDB1",
				   			      "student",
							      "p1234");           
            // create template string with PL/SQL-function "add_user"
			CallableStatement cstmt1 = con.prepareCall("{? = call add_user(?,?)}");
			cstmt1.registerOutParameter(1,Types.NUMERIC);
			
			// TC1
			System.out.print("TC1: ");
            Statement cstmt2 = con.createStatement();
			cstmt2.executeUpdate("DELETE FROM Users WHERE uname = upper('user1')");
            // init template variables
			cstmt1.setString(2, "user1");
			cstmt1.setString(3, "a12A345678#");
			// execute query
			cstmt1.executeUpdate();
			// analize TastCase-result
            if (cstmt1.getInt(1) == 1)
			    System.out.println("Passed");
			else { 
			    System.out.println("Failed");
				testCaseResult = -1;
			}
			// TC2
			System.out.print("TC2: ");
            // init template variables
			cstmt1.setString(2, "user1");
			cstmt1.setString(3, "a12A345678#");
			// execute query
			cstmt1.executeUpdate();
			// analize TastCase-result
            if (cstmt1.getInt(1) == -1)
			    System.out.println("Passed");
			else { 
			    System.out.println("Failed");
				testCaseResult = -1;
			}
			// TC3
			System.out.print("TC3: ");
            // init template variables
			cstmt1.setString(2, "1user1");
			cstmt1.setString(3, "a12A345678#");
			// execute query
			cstmt1.executeUpdate();
			// analize TastCase-result
            if (cstmt1.getInt(1) == -2)
			    System.out.println("Passed");
			else { 
			    System.out.println("Failed");
				testCaseResult = -1;
			}

			// close connect 
            con.close();  
        }
		catch(Exception e){ 
		    System.out.println(e);
		}  
	    System.exit(testCaseResult);
    }    
}  

