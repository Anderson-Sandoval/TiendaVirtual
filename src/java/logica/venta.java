/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author DAVID
 */
public class venta {
    private int k_idVenta;
    private String f_fechaVenta ;//cambiar por date
    private float q_montoFinal ;
    private float q_descuento ;
    private String k_emailCliente ;

    public int getK_idVenta() {
        return k_idVenta;
    }

    public void setK_idVenta(int k_idVenta) {
        this.k_idVenta = k_idVenta;
    }

    public String getF_fechaVenta() {
        return f_fechaVenta;
    }

    public void setF_fechaVenta(String f_fechaVenta) {
        this.f_fechaVenta = f_fechaVenta;
    }

    public float getQ_montoFinal() {
        return q_montoFinal;
    }

    public void setQ_montoFinal(float q_montoFinal) {
        this.q_montoFinal = q_montoFinal;
    }

    public float getQ_descuento() {
        return q_descuento;
    }

    public void setQ_descuento(float q_descuento) {
        this.q_descuento = q_descuento;
    }

    public String getK_emailCliente() {
        return k_emailCliente;
    }

    public void setK_emailCliente(String k_emailCliente) {
        this.k_emailCliente = k_emailCliente;
    }
    
    
    
    public venta(){
    }
}
