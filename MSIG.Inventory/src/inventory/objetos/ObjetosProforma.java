/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosProforma {
    
    private int id_proforma;
    private int id_cliente;
    private String fecha_emision_proforma;
    private String dir_envio_proforma;
    private float total_proforma;
    private int id_empleado;
    private String nombre_empleado;
    
    public int getId_proforma() {
        int vId_proforma = 0;
        try{
            vId_proforma = id_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:getId_proforma "+error);
        }
        return vId_proforma;
    }

    public void setId_proforma(int pId_proforma){
        try{
            id_proforma = pId_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:setId_proforma " + error);
        }
    }
    
    public int getId_cliente(){
        int vId_cliente = 0;
        try{
            vId_cliente = id_cliente;
        }catch(Error error){
            System.out.println("EC PROFORMA:GETID_CLIENTE "+error);
        }
        return vId_cliente;
    }
    
    public void setId_cliente(int pId_cliente){
        try{
            id_cliente = pId_cliente;
        }catch(Error error){
            System.out.println("EC PROFORMA:SETID_CLIENTE "+error);
        }
    }
    
    public String getFecha_emision_proforma(){
        String vFecha_emision_proforma = null;
        try{
            vFecha_emision_proforma = fecha_emision_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:getFecha_emision_proforma "+error);
        }
        return vFecha_emision_proforma;
    }
    
    public void setFecha_emision_proforma(String pFecha_emision_proforma){
        try{
            fecha_emision_proforma = pFecha_emision_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:setFecha_emision_factura "+error);
        }
    }
    
    public String getDir_envio_proforma(){
        String vDir_envio_proforma = null;
        try{
            vDir_envio_proforma = dir_envio_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:getDir_envio_proforma "+error);
        }
        return vDir_envio_proforma;
    }
    
    public void setDir_envio_proforma(String pDir_envio_proforma){
        try{
            dir_envio_proforma = pDir_envio_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:setDir_envio_proforma "+error);
        }
    }
    
    public float getTotal_proforma(){
        float vTotal_proforma = 0;
        try{
            vTotal_proforma = total_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:getTotal_proforma "+error);
        }
        return vTotal_proforma;
    }
    
    public void setTotal_proforma(float pTotal_proforma){
        try{
            total_proforma = pTotal_proforma;
        }catch(Error error){
            System.out.println("EC PROFORMA:setTotal_proforma "+error);
        }
    }
    
    public int getId_empleado() {
        int vId_empleado = 0;
        try{
            vId_empleado = id_empleado;
        }catch(Error error){
            System.out.println("EC PROFORMA:getId_empleado "+error);
        }
        return vId_empleado;
    }

    public void setId_empleado(int pId_empledo){
        try{
            id_empleado = pId_empledo;
        }catch(Error error){
            System.out.println("EC PROFORMA:setId_empleado " + error);
        }
    }
    
    public String getNombre_empleado(){
        String vNombre = null;
        try{
            vNombre = nombre_empleado;
        }catch(Error error){
            System.out.println("EC PROFORMA:getNombre_empleado "+error);
        }
        return vNombre;
    }
    
    public void setNombre_empleado(String pNombre){
        try{
            nombre_empleado = pNombre;
        }catch(Error error){
            System.out.println("EC PROFORMA:setNombre_empleado "+error);
        }
    }
}
