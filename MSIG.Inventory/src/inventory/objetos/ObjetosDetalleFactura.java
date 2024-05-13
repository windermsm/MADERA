/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosDetalleFactura {
    
    private int id_d_factura;
    private int id_factura;
    private String id_producto;
    private float cant_d_factura;
    private float precio_venta_d_factura;
    private float sub_total_d_factura;
    private String comentario_factura;
    private float arancel_factura;
    private float precio_estandar;

    public float getArancel_factura() {
        return arancel_factura;
    }

    public void setArancel_factura(float arancel_d_factura) {
        this.arancel_factura = arancel_d_factura;
    }

    public float getCant_d_factura() {
        return cant_d_factura;
    }

    public void setCant_d_factura(float cant_d_factura) {
        this.cant_d_factura = cant_d_factura;
    }

    public String getComentario_d_factura() {
        return comentario_factura;
    }

    public void setComentario_d_factura(String comentario_d_factura) {
        this.comentario_factura = comentario_d_factura;
    }

    public int getId_d_factura() {
        return id_d_factura;
    }

    public void setId_d_factura(int id_d_factura) {
        this.id_d_factura = id_d_factura;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public float getPrecio_venta_d_factura() {
        return precio_venta_d_factura;
    }

    public void setPrecio_venta_d_factura(float precio_venta_d_factura) {
        this.precio_venta_d_factura = precio_venta_d_factura;
    }

    public float getSub_total_d_factura() {
        return sub_total_d_factura;
    }

    public void setSub_total_d_factura(float sub_total_d_factura) {
        this.sub_total_d_factura = sub_total_d_factura;
    }

    public String getComentario_factura() {
        return comentario_factura;
    }

    public void setComentario_factura(String comentario_factura) {
        this.comentario_factura = comentario_factura;
    }

    public float getPrecio_estandar() {
        return precio_estandar;
    }

    public void setPrecio_estandar(float precio_estandar) {
        this.precio_estandar = precio_estandar;
    }
    
}
