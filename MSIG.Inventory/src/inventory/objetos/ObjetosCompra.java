/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosCompra {
    
    private int id_compra;
    private int id_proveedor;
    private String fecha_factura_compra;
    private String numero_factura_compra;
    private String serie_factura_compra;
    private String folio_factura_compra;
    private float total_factura_compra;
    
    public int getId_compra(){
        int vId_compra = 0;
        try{
            vId_compra = id_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:GETID_COMPRA "+error);
        }
        return vId_compra;
    }
    
    public void setId_compra(int pId_compra){
        try{
            id_compra = pId_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:SETID_COMPRA "+error);
        }
    }
    
    public int getId_proveedor(){
        int vId_proveedor = 0;
        try{
            vId_proveedor = id_proveedor;
        }catch(Error error){
            System.out.println("EC COMPRA:SETID_COMPRA "+error);
        }
        return vId_proveedor;
    }
    
    public void setId_proveedor(int pId_proveedor){
        try{
            id_proveedor = pId_proveedor;
        }catch(Error error){
            System.out.println("EC COMPRA:SETID_PROVEEDOR "+error);
        }
    }
    
    public String getFecha_factura_compra(){
        String vFecha_factura_compra = null;
        try{
            vFecha_factura_compra = fecha_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:GETFECHA_FACTURA_COMPRA "+error);
        }
        return vFecha_factura_compra;
    }
    
    public void setFecha_factura_compra(String pFecha_factura_compra){
        try{
            fecha_factura_compra = pFecha_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:SETFECHA_FACTURA_COMPRA "+error);
        }
    }
    
   public String getNumero_factura_compra(){
        String vNumero_factura_compra = "";
        try{
            vNumero_factura_compra = numero_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:GETNUMERO_FACTURA_COMPRA "+error);
        }
        return vNumero_factura_compra;
    }
    
    public void setNumero_factura_compra(String pNumero_factura_compra){
        try{
            numero_factura_compra = pNumero_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:SETNUMERO_COMPRA "+error);
        }
    }
    
    public String getSerie_factura_compra(){
        String vSerie_factura_compra = null;
        try{
            vSerie_factura_compra = serie_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:GETSERIE_FACTURA_COMPRA "+error);
        }
        return vSerie_factura_compra;
    }
    
    public void setSerie_factura_compra(String pSerie_factura_compra){
        try{
            serie_factura_compra = pSerie_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:SETSERIE_FACTURA_COMPRA "+error);
        }
    }
    
    public String getFolio_factura_compra(){
        String vFolio_factura_compra = null;
        try{
            vFolio_factura_compra = folio_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:SETSERIE_FACTURA_COMPRA "+error);
        }
        return vFolio_factura_compra;
    }
    
    public void setFolio_factura_compra(String pFolio_factura_compra){
        try{
            folio_factura_compra = pFolio_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:SETFOLIO_FACTURA_COMPRA "+error);
        }
    }
    
    public float getTotal_factura_compra(){
        float vTotal_factura_compra = 0;
        try{
            vTotal_factura_compra = total_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:GETTOTAL_FACTURA_COMPRA "+error);
        }
        return vTotal_factura_compra;
    }
    
    public void setTotal_factura_compra(float pTotal_factura_compra){
        try{
            total_factura_compra = pTotal_factura_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:SETTOTAL_FACTURA_COMPRA "+error);
        }
    }
    
}
