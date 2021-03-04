/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import logica.usuario;
import util.ServiceLocator;

/**
 *
 * @author kestn
 */
public class ClienteDAO {
private String nombre;
private String correo;
private String direccion;
private String contraseña;
private double telefono;
private ServiceLocator conexion= new ServiceLocator();

    public ClienteDAO() {
    }

    public usuario validarUsuario(String correo,String contraseña){
    usuario respuesta=null;
     Connection con;
        PreparedStatement prepStmt;
        System.out.println(correo);
        System.out.println(contraseña);
        String strSQL = "select * from cliente where k_email='"+correo+"' and o_contraseña='"+contraseña+"';";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                respuesta=new usuario();
                respuesta.setK_email(correo);
                respuesta.setN_direccion(rs.getString(3));
                respuesta.setN_nombre(rs.getString(2));
                respuesta.setO_contraseña(rs.getString(4));
                respuesta.setQ_telefono(rs.getString(5));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    
    
    return respuesta;
}


    
    public boolean buscarUsuario(String correo){
    boolean respuesta=false;
     Connection con;
        PreparedStatement prepStmt;
        String strSQL = "select * from cliente where k_email='"+correo+"';";
        ResultSet rs;
        try{
            Class.forName(conexion.getDriver());
            con= DriverManager.getConnection(conexion.getUrl(), conexion.getUsuario(), conexion.getPass());
            prepStmt = con.prepareStatement(strSQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
               respuesta =true;
            }
            
        }catch(Exception e){
            
        }
    
    
    return respuesta;
}    
    
    
    public void ingresarUsuario(String correo,String contraseña,String direccion,String nombre,String telefono){
    usuario respuesta=null;
     Connection con;
        PreparedStatement prepStmt;
        String strSQL ="insert into cliente values ('"+correo+"','"+nombre+"','"+direccion+"','"+contraseña+"',"+telefono+");";
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
