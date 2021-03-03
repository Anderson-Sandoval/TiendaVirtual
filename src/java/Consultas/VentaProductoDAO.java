
package Consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logica.producto;
import util.ServiceLocator;

/**
 *
 * @author kestn
 */
public class VentaProductoDAO {
    private ServiceLocator conexion= new ServiceLocator();
    public VentaProductoDAO() {
    }
    
    public void agregarVentas(int idVenta,producto[] productos, int[] cantidades){
        for(int i=0;i<cantidades.length;i++){
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "insert into venta_producto values ("+idVenta+","+productos[i].getK_idProducto()+","+cantidades[i]+","+((cantidades[i])*(productos[i].getQ_valorProducto()))+");";
        
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
        
    }
    
    
    public int numeroProductosComprados(String correo){
        int respuesta=0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select distinct vp.k_idproducto from venta_producto vp, venta v where v.k_idventa=vp.k_idventa and k_emailcliente='"+correo+"'";
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
    
    
    
    public int[] obtenerProductosComprados(String correo){
        int[] resultado =null;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select distinct vp.k_idproducto from venta_producto vp, venta v where v.k_idventa=vp.k_idventa and k_emailcliente='"+correo+"'";
        ResultSet rs;
        resultado=new int[this.numeroProductosComprados(correo)];
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            int aux=0;
            while (rs.next()){
                resultado[aux]=rs.getInt(1);
                aux++;
            }
            
        }catch(Exception e){
            
        }
        
        
        return resultado;
    }
    
    
    
    
}
