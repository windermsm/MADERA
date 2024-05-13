/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosAnulacionFacturas {
    
    private int id_factura;
    private int id_d_factura;
    private String id_producto;
    private int num_factura;
    private String serie_factura;
    private String folio_factura;
    private String fecha_emision_factura;
    private float total_factura;
    private String marca_producto;
    private float cant_d_factura;
    private float precio_venta_d_factura;
    private float subtotal;
    private float exi_producto;
    
    
    public int getId_factura(){
        int vId_factura = 0;
        try{
            vId_factura = id_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:getId_factura : "+error);
        }
        return vId_factura;
    }
    
    public void setId_factura(int pId_factura){
        try{
            id_factura = pId_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:setId_factura "+error);
        }
    }
    
    public int getId_d_factura(){
        int vId_d_factura = 0;
        try{
            vId_d_factura = id_d_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:getId_d_factura : "+error);
        }
        return vId_d_factura;
    }
    
    public void setId_d_factura(int pId_d_factura){
        try{
            id_d_factura = pId_d_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:setId_d_factura "+error);
        }
    }
    
    public String getId_producto(){
        String vId_producto = null;
        try{
            vId_producto = id_producto;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:GETID_PRODUCTO : "+error);
        }
        return vId_producto;
    }
    
    public void setId_producto(String pId_producto){
        try{
            id_producto = pId_producto;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:SETID_PRODUCTO "+error);
        }
    }
    
    public int getNum_factura(){
        int vNum_factura = 0;
        try{
            vNum_factura = num_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:getNum_factura "+error);
        }
        return vNum_factura;
    }
    
    public void setNum_factura(int pNum_factura){
        try{
            num_factura = pNum_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:setNum_factura "+error);
        }
    }
    
    public String getSerie_factura(){
        String vSerie_factura = null;
        try{
            vSerie_factura = serie_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:getSerie_factura "+error);
        }
        return vSerie_factura;
    }
    
    public void setSerie_factura(String pSerie_factura){
        try{
            serie_factura = pSerie_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:setSerie_factura "+error);
        }
    }
    
    public String getFolio_factura(){
        String vFolio_factura = null;
        try{
            vFolio_factura = folio_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:getFolio_factura "+error);
        }
        return vFolio_factura;
    }
    
    public void setFolio_factura(String pFolio_factura){
        try{
            folio_factura = pFolio_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:setFolio_factura "+error);
        }
    }
    
    public String getFecha_emision_factura(){
        String vFecha_emision_factura = null;
        try{
            vFecha_emision_factura = fecha_emision_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:GETFECHA_EMISION_FACTURA "+error);
        }
        return vFecha_emision_factura;
    }
    
    public void setFecha_emision_factura(String pFecha_emision_factura){
        try{
            fecha_emision_factura = pFecha_emision_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:SETFECHA_EMISION_FACTURA "+error);
        }
    }
    
    public float getTotal_factura(){
        float vTotal_factura = 0;
        try{
            vTotal_factura = total_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:GETTOTAL_FACTURA "+error);
        }
        return vTotal_factura;
    }
    
    public void setTotal_factura(float pTotal_factura){
        try{
            total_factura = pTotal_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:SETTOTAL_FACTURA "+error);
        }
    }
    
    public String getMarca_producto(){
        String vMarca_producto = null;
        try{
            vMarca_producto = marca_producto;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:GETMARCA_PRODUCTO "+error);
        }
        return vMarca_producto;
    }
    
    public void setMarca_producto(String pMarca_producto){
        try{
            marca_producto = pMarca_producto;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:SETMARCA_PRODUCTO"+error);
        }
    }
    
    public float getSubTotal_factura(){
        float vSubTotal_factura = 0;
        try{
            vSubTotal_factura = subtotal;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:getSubTotal_factura "+error);
        }
        return vSubTotal_factura;
    }
    
    public void setSubTotal_factura(float pSubTotal_factura){
        try{
            subtotal = pSubTotal_factura;
        }catch(Error error){
            System.out.println("EC ObjetosAnulacionFacturas:setSubTotal_factura "+error);
        }
    }
   
     public float getCant_d_factura() {
        return cant_d_factura;
    }

    public void setCant_d_factura(float cant_d_factura) {
        this.cant_d_factura = cant_d_factura;
    }
    
    public float getPrecio_venta_d_factura() {
        return precio_venta_d_factura;
    }

    public void setPrecio_venta_d_factura(float precio_venta_d_factura) {
        this.precio_venta_d_factura = precio_venta_d_factura;
    }
    
    public float getExi_producto() {
        return exi_producto;
    }

    public void setExi_producto(float vExi_producto) {
        this.exi_producto = vExi_producto;
    }
    
}
