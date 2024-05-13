/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.objetos;

/**
 *
 * @author Gigi
 */
public class ObjetosSucursal {
    private int     id_sucursal;
    private String  nombre_sucursal;
    private String  descripcion_sucursal;
    private String  direccion_sucursal;
    private String  nit_sucursal;
    private String  telefonos_sucursal;
    
    public int getId_sucursal(){
        int vId_sucursal = 0;
        try{
            vId_sucursal = id_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: getId_sucursal" + error);
        }
        return vId_sucursal;
    }
    
    public void setId_sucursal(int pId_sucursal){
        try{
            id_sucursal = pId_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: setId_sucursal " + error);
        }
    }
    
    public String getNombre_sucursal(){
        String vNombre_sucursal = "";
        try{
            vNombre_sucursal = nombre_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: getNombre_sucursal " + error);
        }
        return vNombre_sucursal;
    }
    
    public void setNombre_sucursal(String pNombre_sucursal){
        try{
            nombre_sucursal = pNombre_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: setNombre_sucursal" + error);
        }
    }
    
    public String getDescripcion_sucursal(){
        String vDescripcion_sucursal = "";
        try{
            vDescripcion_sucursal = descripcion_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: getDescripcion_sucursal " + error);
        }
        return vDescripcion_sucursal;
    }
    
    public void setDescripcion_sucursal(String pDescripcion_sucursal){
        try{
            descripcion_sucursal = pDescripcion_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: setDescripcion_sucursal " + error);
        }
    }
    
    public String getDireccion_sucursal(){
        String vDireccion_sucursal = "";
        try{
            vDireccion_sucursal = direccion_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: getDireccion_sucursal " + error);
        }
        return vDireccion_sucursal;
    }
    
    public void setDireccion_sucursal(String pDireccion_sucursal){
        try{
            direccion_sucursal = pDireccion_sucursal;
        }catch(Error error){
            System.out.println("OBJETO SUCRUSAL: setDireccion_sucursal " + error);
        }
    }

    public String getNit_sucursal() {
        return nit_sucursal;
    }

    public void setNit_sucursal(String nit_sucursal) {
        this.nit_sucursal = nit_sucursal;
    }

    public String getTelefonos_sucursal() {
        return telefonos_sucursal;
    }

    public void setTelefonos_sucursal(String telefonos_sucursal) {
        this.telefonos_sucursal = telefonos_sucursal;
    }
    
}
