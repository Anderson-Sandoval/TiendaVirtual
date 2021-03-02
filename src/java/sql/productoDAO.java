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
public class productoDAO {

    public int id;
    public int idCategoria;
    public String nombre;
    public String nombreCat;
    public int precio;
    public String img2;

    public List<productoDAO> consultaProductos(String categoria) {
        return null;     
    }

    public productoDAO consultaProducto(String id) {
        productoDAO p = new productoDAO();
        
        return p;
    }

    public boolean insertaProducto(String categoria, String nombre, String precio, InputStream file) {
        
        return false;
    }
}
