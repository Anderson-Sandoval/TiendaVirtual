/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.*;

/**
 *
 * @author carlos lopez
 */
public class Connector {
    Connection conn = null;
    public Connector() throws Exception {
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/merca?user=root&password=carlos&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

}
