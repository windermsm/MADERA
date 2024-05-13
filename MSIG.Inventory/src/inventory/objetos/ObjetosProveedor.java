/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosProveedor {
    
    private int id_proveedor;
    private int id_persona;
    private String dir_proveedor;
    private int tel_proveedor;
    
    public int getId_proveedor(){
        int vId_proveedor = 0;
        try{
            vId_proveedor = id_proveedor;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETID_PROVEEDOR "+error);
        }
        return vId_proveedor;
    }
    
    public void setId_proveedor(int pId_proveedor){
        try{
            id_proveedor = pId_proveedor;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETID_PROVEEDOR "+error);
        }
    }
    
    public int getId_persona(){
        int vId_persona = 0;
        try{
            vId_persona = id_persona;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETID_PERSONA "+error);
        }
        return vId_persona;
    }
    
    public void setId_persona(int pId_persona){
        try{
            id_persona = pId_persona;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETID_PERSONA "+error);
        }
    }
    
    public String getDir_proveedor(){
        String vDir_proveedor = null;
        try{
            vDir_proveedor = dir_proveedor;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETDIR_PROVEEDOR "+error);
        }
        return vDir_proveedor;
    }
    
    public void setDir_proveedor(String pDir_proveedor){
        try{
            dir_proveedor = pDir_proveedor;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETDRI_PROVEEDOR");
        }
    }
    
    public int getTel_proveedor(){
        int vTel_proveedor = 0;
        try{
            vTel_proveedor = tel_proveedor;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETTEL_PROVEEDOR "+error);
        }
        return vTel_proveedor;
    }
    
    public void setTel_proveedor(int pTel_proveedor){
        try{
            tel_proveedor = pTel_proveedor;
        }catch(Error error){
            System.out.println("EC PROVEEDOR:GETTEL_PROVEEDOR "+error);
        }
    }
   
}
