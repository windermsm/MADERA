/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */

public class ObjetosDetalleCompra {
    
    private int id_d_compra;
    private int id_compra;
    private String id_producto;
    private float cant_d_compra;
    private float precio_d_compra;
    private float sub_total_d_compra;
    private String comentario_compra;
    private float arancel_compra;
    
    public int getId_d_compra(){
        int vId_d_compra = 0;
        try{
            vId_d_compra = id_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:GETID_D_COMPRA "+error);
        }
        return vId_d_compra;
    }
    
    public void setId_d_compra(int pId_d_compra){
        try{
            id_d_compra =pId_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:SETID_D_COMPRA "+error);
        }
    }
    
    public int getId_compra(){
        int vId_compra = 0;
        try{
            vId_compra = id_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:GETID_COMPRA "+error);
        }
        return vId_compra;
    }
    
    public void setId_compra(int pId_compra){
        try{
            id_compra = pId_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:SETID_COMPRA "+error);
        }
    }
    
    public String getId_producto(){
        String vId_producto = null;
        try{
            vId_producto = id_producto;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:GETID_PRODUCTO "+error);
        }
        return vId_producto;
    }
    
    public void setId_producto(String pId_producto){
        try{
            id_producto = pId_producto;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:SETID_COMPRA "+error);
        }
    }
    
    public float getCant_d_compra(){
        float vCant_d_compra = 0;
        try{
            vCant_d_compra = cant_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:GETCATN_D_COMPRA "+error);
        }
        return vCant_d_compra;
    }
    
    public void setCant_d_compra(float pCant_d_compra){
        try{
            cant_d_compra = pCant_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:SETCANT_D_COMPRA "+error);
        }
    }
    
    public float getPrecio_d_compra(){
        float vPrecio_d_compra = 0;
        try{
            vPrecio_d_compra = precio_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:GETPRECIO_D_COMPRA "+error);
        }
        return vPrecio_d_compra;
    }
    
    public void setPrecio_d_compra(float pPrecio_d_compra){
        try{
            precio_d_compra = pPrecio_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:SETPRECIO_D_COMPRA "+error);
        }
    }
    
     public float getSub_total_d_compra(){
        float vSub_total_d_compra = 0;
        try{
            vSub_total_d_compra = sub_total_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:GETSUB_TOTAL_D_COMPRA "+error);
        }
        return vSub_total_d_compra;
    }
    
    public void setSub_total_d_compra(float pSub_total_d_compra){
        try{
            sub_total_d_compra = pSub_total_d_compra;
        }catch(Error error){
            System.out.println("EC DETALLE_COMPRA:SETSUB_TOTAL_D_COMPRA "+error);
        }
    }
    
    public String getComentario_compra(){
        String vComentario_compra = null;
        try{
            vComentario_compra = comentario_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:getComentario_compra "+error);
        }
        return vComentario_compra;
    }
    
    public void setComentario_compra(String pComentario_compra){
        try{
            comentario_compra = pComentario_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:setComentario_compra "+error);
        }
    }
    
    public float getArancel_compra(){
        float vArancel_compra = 0;
        try{
            vArancel_compra = arancel_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:getArancel_compra "+error);
        }
        return vArancel_compra;
    }
    
    public void setAracel_compra(float pAracel_compra){
        try{
            arancel_compra = pAracel_compra;
        }catch(Error error){
            System.out.println("EC COMPRA:setAracel_compra "+error);
        }
    }
}
