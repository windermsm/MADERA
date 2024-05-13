/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosProducto {
    
    private String id_producto;
    private int id_proveedor;
    private String marca_producto;
    private String desc_producto;
    private float precio_compra_producto;
    private float precio_est_producto;
    private float exi_producto;
    private String unidad_medida_producto;
    private float maximo_producto;
    private float minimo_producto;
    //SE AGREGARON A PETICION DEL CLIENTE
    private float prj_est_producto;
    private float prj_min_producto;
    private float precio_min_producto;
    private float comision_producto;
    private String linea_producto;
    
    public String getId_producto(){
        String vId_producto = null;
        try{
            vId_producto = id_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETID_PRODUCTO : "+error);
        }
        return vId_producto;
    }
    
    public void setId_producto(String pId_producto){
        try{
            id_producto = pId_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETID_PRODUCTO "+error);
        }
    }
    
    public String getMarca_producto(){
        String vMarca_producto = null;
        try{
            vMarca_producto = marca_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETMARCA_PRODUCTO "+error);
        }
        return vMarca_producto;
    }
    
    public void setMarca_producto(String pMarca_producto){
        try{
            marca_producto = pMarca_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETMARCA_PRODUCTO"+error);
        }
    }
    
    public String getDesc_producto(){
        String vDesc_producto = null;
        try{
            vDesc_producto = desc_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETDESC_PRODUCTO "+error);
        }
        return vDesc_producto;
    }
    
    public void setDesc_producto(String pDesc_producto){
        try{
            desc_producto = pDesc_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETDESC_PRODUCTO "+error);
        }
    }
    
    public float getPrecio_compra_producto(){
        float vPrecio_compra_producto = 0;
        try{
            vPrecio_compra_producto = precio_compra_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETPRECIO_COMPRA_PRODUCTO "+error);
        }
        return vPrecio_compra_producto;
    }
    
    public void setPrecio_compra_producto(float pPrecio_compra_producto){
        try{
            precio_compra_producto = pPrecio_compra_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETPRECIO_COMPRA_PRODUCTO "+error);
        }
    }
    
    public float getPrecio_est_producto(){
        float vPrecio_est_producto = 0;
        try{
            vPrecio_est_producto = precio_est_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETPRECIO_EST_PRODUCTO "+error);
        }
        return vPrecio_est_producto;
    }
    
    public void setPrecio_est_producto(float pPrecio_est_producto){
        try{
            precio_est_producto = pPrecio_est_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETPRECIO_EST_PRODUCTO "+error);
        }
    }
    
    public int getId_proveedor(){
        int vId_proveedor = 0;
        try{
            vId_proveedor = id_proveedor;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETID_PROVEEDORF "+error);
        }
        return vId_proveedor;
    }
    
    public void setId_provedor(int pId_proveedor){
        try{
            id_proveedor = pId_proveedor;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETID_PROVEEDOR "+error);
        }
    }
    
    public float getExi_producto(){
        float vExi_producto = 0;
        try{
            vExi_producto = exi_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETEXI_PRODUCTO "+error);
        }
        return vExi_producto;
    }
    
    public void setExi_producto(float pExi_producto){
        try{
            exi_producto = pExi_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETEXI_PRODUCTO "+error);
        }
    }
    
    public String getUnidad_medida_producto(){
        String vUncidad_medida_producto = null;
        try{
            vUncidad_medida_producto = unidad_medida_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETUNIDAD_MEDIDA_PRODUCTO "+error);
        }
        return vUncidad_medida_producto;
    }
    
    public void setUnidad_medida_producto(String pUnidad_medida_producto){
        try{
            unidad_medida_producto = pUnidad_medida_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETUNIDAD_MEDIDA_PRODUCTO "+error);
        }
    }
    
    public float getMaximo_producto(){
        float vMaximo_producto = 0;
        try{
            vMaximo_producto = maximo_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETMAXIMO_PRODUCTO "+error);
        }
        return vMaximo_producto;
    }
    
    public void setMaximo_producto(float pMaximo_producto){
        try{
            maximo_producto = pMaximo_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETMAXIMO_PRODUCTO "+error);
        }
    }
    
    public float getMinimo_producto(){
        float vMinimo_producto = 0;
        try{
            vMinimo_producto = minimo_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETMAXIMO_PRODUCTO "+error);
        }
        return vMinimo_producto;
    }
    
    public void setMinimo_producto(float pMinimo_producto){
        try{
            minimo_producto = pMinimo_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETMAXIMO_PRODUCTO "+error);
        }
    }
    
    public float getPrj_est_producto(){
        float vPrj_est_producto = 0;
        try{
            vPrj_est_producto = prj_est_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETPRJ_EST_PRODUCTO "+error);
        }
        return vPrj_est_producto;
    }
    
    public void setPrj_est_producto(float pPrj_est_producto){
        try{
            prj_est_producto = pPrj_est_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETPRJ_EST_PRODUCTO "+error);
        }
    }
    
    public float getPrj_min_producto(){
        float vPrj_min_producto = 0;
        try{
            vPrj_min_producto = prj_min_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETPRJ_MIN_PRODUCTO "+error);
        }
        return vPrj_min_producto;
    }
    
    public void setPrj_min_producto(float pPrj_min_producto){
        try{
            prj_min_producto = pPrj_min_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETPRJ_min_PRODUCTO "+error);
        }
    }

    public float getPrecio_min_producto(){
        float vPrecio_min_producto = 0;
        try{
            vPrecio_min_producto = precio_min_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:GETPRECIO_MIN_PRODUCTO "+error);
        }
        return vPrecio_min_producto;
    }
    
    public void setPrecio_min_producto(float pPrecio_min_producto){
        try{
            precio_min_producto = pPrecio_min_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:SETPRECIO_MIN_PRODUCTO "+error);
        }
    }
    
    public float getComision_producto(){
        float vComision_producto = 0;
        try{
            vComision_producto = comision_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:getComision_producto "+error);
        }
        return vComision_producto;
    }
    
    public void setComision_producto(float pComision_producto){
        try{
            comision_producto = pComision_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:setComision_producto "+error);
        }
    }
    
    public String getLinea_producto(){
        String vLinea_producto = null;
        try{
            vLinea_producto = linea_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:getLinea_producto "+error);
        }
        return vLinea_producto;
    }
    
    public void setLinea_producto(String pLinea_producto){
        try{
            linea_producto = pLinea_producto;
        }catch(Error error){
            System.out.println("EC PRODUCTO:setLinea_producto"+error);
        }
    }
}
