/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */

public class ObjetosBonificacion {
    
    private int id_bonificacion;
    private String descripcion_bonificacion;
    private float cantidad_bonificacion;
    private String estado_bonificacion;
    private float porcentaje_bonificacion;
    
    public int getId_bonificacion(){
        int vId_bonificacion = 0;
        try{
            vId_bonificacion = id_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:getId_bonificacion "+error);
        }
        return vId_bonificacion;
    }
    
    public void setId_bonificacion(int pId_bonificacion){
        try{
            id_bonificacion = pId_bonificacion;
        }catch(Error error){
            System.out.append("EC BONIFICACION:SETID_CLIENTE "+error);
        }
    }
    
    public String getDescripcion_bonificacion(){
        String vDescripcion_bonificacion = null;
        try{
            vDescripcion_bonificacion = descripcion_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:getDescripcion_bonificacion "+error);
        }
        return vDescripcion_bonificacion;
    }
    
    public void setDescripcion_bonificacion(String pDescripcion_bonificacion){
        try{
            descripcion_bonificacion = pDescripcion_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:setDescripcion_bonificacion "+error);
        }
    }
    
    public float getCantidad_bonificacion(){
        float vCantidad_bonificacion = 0;
        try{
            vCantidad_bonificacion = cantidad_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:getCantidad_bonificacion " + error);
        }
        return vCantidad_bonificacion;
    }
    
    public void setCantidad_bonificacion(float pCantidad_bonificacion){
        try{
            cantidad_bonificacion = pCantidad_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:setCantidad_bonificacion "+error);
        }
    }
    
    public String getEstado_bonificacion(){
        String vEstado_bonificacion = null;
        try{
            vEstado_bonificacion = estado_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:getEstado_bonificacion "+error);
        }
        return vEstado_bonificacion;
    }
    
    public void setEstado_bonificacion(String pEstado_bonificacion){
        try{
            estado_bonificacion = pEstado_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:SETTEL_CLIENTE "+error);
        }
    }
    
    public float getPorcentaje_bonificacion(){
        float vPorcentaje_bonificacion = 0;
        try{
            vPorcentaje_bonificacion = porcentaje_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:getPorcentaje_bonificacion "+error);
        }
        return vPorcentaje_bonificacion;
    }
    
    public void setPorcentaje_bonificacion(float pPorcentaje_bonificacion){
        try{
            porcentaje_bonificacion = pPorcentaje_bonificacion;
        }catch(Error error){
            System.out.println("EC BONIFICACION:setPorcentaje_bonificacion "+error);
        }
    }
    
}
