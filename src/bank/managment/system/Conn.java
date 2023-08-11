
package bank.managment.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn() {
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem","root","sahu");
            s = c.createStatement();
        
        } catch(Exception e){
            System.out.print(e);
        
        }
        
    
    }
   
}
