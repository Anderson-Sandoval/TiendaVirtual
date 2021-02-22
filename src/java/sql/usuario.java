/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author carlos lopez
 */
public class usuario {
    public String id;
    public boolean consultaUsuario(String user, String contra) {
        try {
            Connection conn = new Connector().conn;
            String query = "SELECT * FROM usuario where usuario='" + user + "' and clave='" + contra + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                if(rs.getString("usuario").equals(user)){
                    id = rs.getString("id");
                    st.close();
                    return true;
                }
            }
            st.close();
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
    
    public boolean insertaUsuario(String user, String contra) {
        try {
            Connection conn = new Connector().conn;
            String query = "insert into usuario(usuario,clave) values ('"+user+"','"+contra+"');";
            Statement st = conn.createStatement();
            int up = st.executeUpdate(query);
            if(up>0){
                return true;
            }
            st.close();
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
    
    

}
