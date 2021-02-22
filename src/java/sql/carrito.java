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

/**
 *
 * @author carlos lopez
 */
public class carrito {
    public int id;
    public producto p = new producto();
    public List<carrito> consultaCarrito(String usuario) {

        List<carrito> carritos = new ArrayList<>();
        try {
            Connection conn = new Connector().conn;
            String query = "SELECT * FROM carrito left join producto on producto.id = carrito.idProducto where carrito.idUsuario='" + usuario + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                carrito car = new carrito();
                car.id = rs.getInt("carrito.id");
                car.p.id = rs.getInt("producto.id");
                car.p.idCategoria = rs.getInt("producto.idCategoria");
                car.p.nombre = rs.getString("producto.nombre");
                car.p.precio = rs.getInt("producto.precio");
                carritos.add(car);
            }
            st.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return carritos;
    }

    public boolean insertaCarrito(String usuario, List<producto> prod) {
        String ids = "";
        for (producto p : prod) {
            ids += "('" + usuario + "','" + p.id + "'),";
        }
        ids = ids.substring(0, ids.length() - 1) + ";";

        try {
            Connection conn = new Connector().conn;
            String query = "insert into carrito(idUsuario,idProducto) " + ids;
            Statement st = conn.createStatement();
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
    
    public boolean insertaCarrito(String usuario, String prod) {

        try {
            Connection conn = new Connector().conn;
            String query = "insert into carrito(idUsuario,idProducto) values('"+usuario+"','"+prod+"')";
            Statement st = conn.createStatement();
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
            Connection conn = new Connector().conn;
            String query = "delete from carrito where idUsuario = '" + usuario + "';";
            Statement st = conn.createStatement();
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
            Connection conn = new Connector().conn;
            String query = "delete from carrito where id = '" + idCarrito + "';";
            Statement st = conn.createStatement();
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
