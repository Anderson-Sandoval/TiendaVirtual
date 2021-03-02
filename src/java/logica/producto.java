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
public class producto {
    private int k_idProducto;
    private float q_valorProducto;
    private String n_nombreProducto;
    private int q_stock;
    private int k_idCategoria;
    private int k_rutProveedor;

    public int getK_idProducto() {
        return k_idProducto;
    }

    public void setK_idProducto(int k_idProducto) {
        this.k_idProducto = k_idProducto;
    }

    public float getQ_valorProducto() {
        return q_valorProducto;
    }

    public void setQ_valorProducto(float q_valorProducto) {
        this.q_valorProducto = q_valorProducto;
    }

    public String getN_nombreProducto() {
        return n_nombreProducto;
    }

    public void setN_nombreProducto(String n_nombreProducto) {
        this.n_nombreProducto = n_nombreProducto;
    }

    public int getQ_stock() {
        return q_stock;
    }

    public void setQ_stock(int q_stock) {
        this.q_stock = q_stock;
    }

    public int getK_idCategoria() {
        return k_idCategoria;
    }

    public void setK_idCategoria(int k_idCategoria) {
        this.k_idCategoria = k_idCategoria;
    }

    public int getK_rutProveedor() {
        return k_rutProveedor;
    }

    public void setK_rutProveedor(int k_rutProveedor) {
        this.k_rutProveedor = k_rutProveedor;
    }
    
    
    
    
    public producto(){
    
    }
}
