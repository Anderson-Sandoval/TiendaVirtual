
package Consultas;

import controlador.util.CaException;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import logica.producto;
import sun.misc.IOUtils;
import util.ServiceLocator;


/**
 *
 * @author kestn
 */
public class ProductoDAO {
    
    private ServiceLocator conexion= new ServiceLocator();

    public ProductoDAO() {
    }
   
    public boolean buscarProducto(String nombre){
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from producto where n_nombreproducto='"+nombre+"';";
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
    
    
    public producto[] cargarProducto() throws CaException{
        producto[] productoUno =null;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from producto";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            productoUno=new producto[this.numeroProductos()];
            int auxUno=0;
            while (rs.next()){
                producto aux=new producto();
                aux.setK_idCategoria(rs.getInt(5));
                aux.setK_idProducto(rs.getInt(1));
                aux.setQ_stock(rs.getInt(4));
                aux.setN_nombreProducto(rs.getString(3));
                aux.setQ_valorProducto(rs.getFloat(2));
                aux.setArchivo(ConvertirImagen(rs.getBytes(6)));
                productoUno[auxUno]=aux;
                auxUno++;
            }
            
        }catch(Exception e){
            
        }
        return productoUno;
    }
    
    
    private Image ConvertirImagen(byte[] bytes) throws IOException {
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");    
    ImageReader reader = (ImageReader) readers.next();
    Object source = bis;
    ImageInputStream iis = ImageIO.createImageInputStream(source);
    reader.setInput(iis, true);
    ImageReadParam param = reader.getDefaultReadParam();
    return reader.read(0, param);
 }
    
    
    public int numeroProductos(){
        int respuesta=0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from producto";
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
    
    public void insertarProductos(String nombre,int stock, int valor, int idCategoria,InputStream imagen){
        
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "insert into producto values ((select count(*)from categoria)+1,"+valor+",'"+nombre+"',"+stock+","+idCategoria+",?);";
        
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setBlob(4,imagen);
            if(prepStmt.executeUpdate()>0){
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            
        }
        
    }
    
    
    
    
}
