/*
 * clase cliente y administrador
 */
package logica;

/**
 *
 * @author DAVID
 */
public class usuario {
    private String k_email;
    private String n_nombre;
    private String n_direccion;        
    private String o_contraseña;
    private String q_telefono;        

    public String getK_email() {
        return k_email;
    }

    public void setK_email(String k_email) {
        this.k_email = k_email;
    }

    public String getN_nombre() {
        return n_nombre;
    }

    public void setN_nombre(String n_nombre) {
        this.n_nombre = n_nombre;
    }

    public String getN_direccion() {
        return n_direccion;
    }

    public void setN_direccion(String n_direccion) {
        this.n_direccion = n_direccion;
    }

    public String getO_contraseña() {
        return o_contraseña;
    }

    public void setO_contraseña(String o_contraseña) {
        this.o_contraseña = o_contraseña;
    }

    public String getQ_telefono() {
        return q_telefono;
    }

    public void setQ_telefono(String q_telefono) {
        this.q_telefono = q_telefono;
    }
    
    
    public usuario(){
    }
}
