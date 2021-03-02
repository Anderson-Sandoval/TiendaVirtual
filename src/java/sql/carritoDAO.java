package sql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class carritoDAO {
    public int id;
    public productoDAO p = new productoDAO();
    
    
    public List<carritoDAO> consultaCarrito(String usuario) {

        List<carritoDAO> carritos = new ArrayList<>();
        
        return carritos;
    }

    public boolean insertaCarrito(String usuario, List<productoDAO> prod) {
        
        return false;
    }
    
    public boolean insertaCarrito(String usuario, String prod) {

      
        return false;
    }

    public boolean eliminaCarrito(String usuario) {

        return false;
    }

}
