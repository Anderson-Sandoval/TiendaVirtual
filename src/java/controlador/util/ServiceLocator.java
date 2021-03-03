package util;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;



public class ServiceLocator {
 
        String url;
        String usuario;
        String pass;
        String driver;

    public ServiceLocator() {
        this.url = "jdbc:postgresql://localhost:5432/parqueadero";
        this.usuario = "postgres";
        this.pass = "kevinydilmerK1001";
        this.driver = "org.postgresql.Driver";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}