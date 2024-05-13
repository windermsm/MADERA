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
public class ObjetosUsuario {
    private int     id_usuario;
    private int     id_empleado;
    private String  tipo_usuario;
    private String  nombre_usuario;
    private String  contrasenia_usuario;
    private String  nombre_empleado;
    
    public int getId_usuario(){
        int vId_usuario = 0;
        try{
            vId_usuario = id_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: GETID_USUARIO " + error);
        }
        return vId_usuario;
    }
    
    public void setId_usuario(int pId_usuario){
        try{
            id_usuario = pId_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: SETID_CLIENTE " + error);
        }
    }
    
    public int getId_empleado(){
        int vId_empleado = 0;
        try{
            vId_empleado = id_empleado;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: GETID_EMPLEADO " + error);
        }
        return vId_empleado;
    }
    
    public void setId_empleado(int pId_empleado){
        try{
            id_usuario = pId_empleado;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: SETID_EMPLEADO " + error);
        }
    }
    
    public String getTipo_usuario(){
        String vTipo_usuario = "";
        try{
            vTipo_usuario = tipo_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: GETTIPO_USUARIO " + error);
        }
        return vTipo_usuario;
    }
    
    public void setTipo_usuario(String pTipo_usuario){
        try{
            tipo_usuario = pTipo_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: SETTIPO_USUARIO " + error);
        }
    }
    
    public String getNombre_usuario(){
        String vNombre_usuario = "";
        try{
            vNombre_usuario = nombre_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: GETNOMBRE_USUARIO " + error);
        }
        return vNombre_usuario;
    }
    
    public void setNombre_usuario(String pNombre_usuario){
        try{
            nombre_usuario = pNombre_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: SETNOMBRE_USUARIO " + error);
        }
    }
    
    public String getContrasenia_usuario(){
        String vContrasenia_usuario = "";
        try{
            vContrasenia_usuario = contrasenia_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: GETCONTRASENIA_USUARIO " + error);
        }
        return vContrasenia_usuario;
    }
    
    public void setContrasenia_usuario(String pContrasenia_usuario){
        try{
            contrasenia_usuario = pContrasenia_usuario;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: SETTIPO_USUARIO " + error);
        }
    }
    
    public String getNombre_empleado(){
        String vNombre_empleado = "";
        try{
            vNombre_empleado = nombre_empleado;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: GETNOMBRE_EMPLEADO" + error);
        }
        return vNombre_empleado;
    }
    
    public void setNombre_empleado(String pNombre_empleado){
        try{
            nombre_empleado = pNombre_empleado;
        }catch(Error error){
            System.out.println("OBJETO USUARIO: SETNOMBRE_EMPLEADO " + error);
        }
    }
}
