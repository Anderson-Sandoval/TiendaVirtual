
package Consultas;

import controlador.util.CaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logica.categoria;
import util.ServiceLocator;

/**
 *
 * @author kestn
 */
public class CategoriaDAO {
    private int k_idCategoria;
    private String n_nombreCategoria;
    private String n_descripcionCategoria;
    private ServiceLocator conexion;

    public CategoriaDAO() throws Exception {
        this.conexion = new ServiceLocator();
    }
    
    public categoria[] cargarCategoria() throws CaException{
        categoria[] categoriaUno =null;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from categoria ;";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            categoriaUno=new categoria[numeroCategorias()];
            int auxUno=0;
            while (rs.next()){
                categoria aux = new categoria();
                aux.setK_idCategoria(rs.getInt(1));
                aux.setN_nombreCategoria(rs.getString(2));
                aux.setN_descripcionCategoria(rs.getString(3));
                categoriaUno[auxUno]=aux;
                auxUno++;
            }
            
        }catch(Exception e){
            
        }
        return categoriaUno;
    }
    
    
    public void insertarCategoria(String nombre,String descripcion) throws CaException{
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "insert into categoria values ((select count(*)from categoria)+1,'"+nombre+"','"+descripcion+"');";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            
        }
    }
    
    
    public boolean buscarCategoria(String nombre) throws CaException{
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from categoria where n_nombrecategoria='"+nombre+"';";
        ResultSet rs;
        boolean resultado=false;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                resultado=true;
            }
            
        }catch(Exception e){
            
        }
        return resultado;
    }
    
    public categoria obtenerCategoria(String nombre) throws CaException{
        Connection con;
        categoria cat=null;
        PreparedStatement prepStmt;
        String strSQL = "select * from categoria where n_nombrecategoria='"+nombre+"';";
        ResultSet rs;
        boolean resultado=false;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                cat= new categoria();
                cat.setK_idCategoria(rs.getInt(1));
                cat.setN_nombreCategoria(rs.getString(2));
                cat.setN_descripcionCategoria(rs.getString(3));
            }
            
        }catch(Exception e){
            
        }
        return cat;
    }
    
    
    public int numeroCategorias(){
        int respuesta=0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from categoria";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                respuesta++;
            }
            
        }catch(Exception e){
            
        }
        return respuesta;
    
        
        
        
        
    }
    
}
