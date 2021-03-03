
package Consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import util.ServiceLocator;
import logica.*;

/**
 *
 * @author kestn
 */
public class VentaDAO {
    private ServiceLocator conexion= new ServiceLocator();

    public int idVenta(){
        int respuesta=0;
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from venta";
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
    
    
    
    
    
public venta generarVenta(String correoCliente, int monto){
    venta resultado=null;
        int  auxiliar= this.idVenta();
        Connection con;
        PreparedStatement prepStmt;
        String strSQL = "insert into venta values ((select count(*)from venta)+1,?,"+monto+",'"+correoCliente+"');";
        
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            prepStmt.setDate(1,java.sql.Date.valueOf(LocalDate.now()));
            if(prepStmt.executeUpdate()>0){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                resultado.setF_fechaVenta(sdf.format(java.sql.Date.valueOf(LocalDate.now())));
                resultado.setK_emailCliente(correoCliente);
                resultado.setQ_montoFinal(monto);
                resultado.setK_idVenta(auxiliar+1);
                con.close();
            }else{
                con.close();
            }
        }catch(Exception e){
            
        }    
    return resultado;
}

}

