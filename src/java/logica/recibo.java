/*
 * Clase que alegoriza a la tabla de rompimiento 
 * venta-producto
 */
package logica;

/**
 *
 * @author DAVID
 */
public class recibo {
    private int k_idVenta;
    private int k_idProducto;
    private int q_cantidad;
    private float v_valor ;

    public int getK_idVenta() {
        return k_idVenta;
    }

    public void setK_idVenta(int k_idVenta) {
        this.k_idVenta = k_idVenta;
    }

    public int getK_idProducto() {
        return k_idProducto;
    }

    public void setK_idProducto(int k_idProducto) {
        this.k_idProducto = k_idProducto;
    }

    public int getQ_cantidad() {
        return q_cantidad;
    }

    public void setQ_cantidad(int q_cantidad) {
        this.q_cantidad = q_cantidad;
    }

    public float getV_valor() {
        return v_valor;
    }

    public void setV_valor(float v_valor) {
        this.v_valor = v_valor;
    }
    
    
    
    public recibo(){
    }
}
