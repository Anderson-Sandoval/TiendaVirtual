/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 *
 * @author carlos lopez
 */
public class producto {

    public int id;
    public int idCategoria;
    public String nombre;
    public String nombreCat;
    public int precio;
    public String img2;

    public List<producto> consultaProductos(String categoria) {
        List<producto> prods = new ArrayList<>();
        try {
            Connection conn = new Connector().conn;
            String query = "SELECT * FROM producto left join categoria on producto.idCategoria = categoria.id where idCategoria like '" + categoria + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                producto p = new producto();
                p.id = rs.getInt("producto.id");
                p.idCategoria = rs.getInt("producto.idCategoria");
                p.nombre = rs.getString("producto.nombre");
                p.nombreCat = rs.getString("categoria.categoria");
                p.precio = rs.getInt("producto.precio");
               
                Blob blob = rs.getBlob("img");
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                inputStream.close();
                outputStream.close();
                
                p.img2 = base64Image;
                
                prods.add(p);
            }
            st.close();
        } catch (Exception ex) {

        }
        return prods;
    }

    public producto consultaProducto(String id) {
        producto p = new producto();
        try {
            Connection conn = new Connector().conn;
            String query = "SELECT * FROM producto where id like '" + id + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p.id = rs.getInt("id");
                p.idCategoria = rs.getInt("idCategoria");
                p.nombre = rs.getString("nombre");
                p.precio = rs.getInt("precio");
            }
            st.close();
        } catch (Exception ex) {

        }
        return p;
    }

    public boolean insertaProducto(String categoria, String nombre, String precio, InputStream file) {
        try {
            Connection conn = new Connector().conn;
            //String query = "insert into producto(idCategoria,nombre,precio) values ('"+categoria+"','"+nombre+"','"+precio+"');";
            String query = "insert into producto(idCategoria,nombre,precio,img) values (?,?,?,?)";
            //Statement st = conn.createStatement();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, categoria);
            st.setString(2, nombre);
            st.setString(3, precio);
            st.setBlob(4, file);
            int up = st.executeUpdate();
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
