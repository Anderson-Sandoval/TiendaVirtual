/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ServiceLocator;


public class carrito {
    
    public int id;
    public producto p = new producto();
    private ServiceLocator conexion= new ServiceLocator();
    
    
    public List<carrito> consultaCarrito(String usuario) {

        List<carrito> carritos = new ArrayList<>();
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT * FROM carrito left join producto on producto.k_idproducto = carrito..k_idproducto where carrito.k_email='" + usuario + "'";
        ResultSet rs;
        try {
            
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                carrito car = new carrito();
                car.id = rs.getInt("carrito.id");
                car.p.setK_idProducto(rs.getInt(1));
                car.p.setK_idCategoria(rs.getInt(5));;
                car.p.setN_nombreProducto(rs.getString(3));
                car.p.setQ_valorProducto(rs.getInt(2));
                carritos.add(car);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return carritos;
    }
    
    
    
    public List<producto> consultaProductosCarrito(String usuario) {

        List<producto> productos = new ArrayList<>();
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "SELECT * FROM carrito left join producto on producto.k_idproducto = carrito..k_idproducto where carrito.k_email='" + usuario + "'";
        ResultSet rs;
        try {
            
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                producto p= new producto();
                p.setK_idProducto(rs.getInt(1));
                p.setK_idCategoria(rs.getInt(5));;
                p.setN_nombreProducto(rs.getString(3));
                p.setQ_valorProducto(rs.getInt(2));
                productos.add(p);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return productos;
    }

    public boolean insertaCarrito(String usuario, String prod) {

        try {
            Connection con;
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            String query = "insert into carrito values((count(*) from carrito)+1,'"+usuario+"','"+prod+"')";
            Statement st = con.createStatement();
            int up = st.executeUpdate(query);
            if (up > 0) {
                return true;
            }
            st.close();
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    public boolean eliminaCarrito(String usuario) {

        try {
            Connection con;
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            String query = "delete from carrito where k_email = '" + usuario + "';";
            Statement st = con.createStatement();
            int up = st.executeUpdate(query);
            if (up > 0) {
                return true;
            }
            st.close();
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
    
    public boolean eliminaCarrito(String usuario,String idCarrito) {

        try {
            Connection con;
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            String query = "delete from carrito where id = '" + idCarrito + "';";
            Statement st = con.createStatement();
            int up = st.executeUpdate(query);
            if (up > 0) {
                return true;
            }
            st.close();
        } catch (Exception ex) {
            return false;
        }
        return false;
    }
    
    
    
    
    
}
