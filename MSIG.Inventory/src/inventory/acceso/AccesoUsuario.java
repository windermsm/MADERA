/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;

import inventory.objetos.ObjetosUsuario;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gigi
 */
public class AccesoUsuario {
    AccesoExcepciones mensaje = new AccesoExcepciones();
    
    public String insertarUsuario(ObjetosUsuario pUsuario){
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "insert into m_usuario(id_usuario, id_empleado, tipo_usuario, nombre_usuario, contrasenia_usuario) " + 
                     "values (0," +pUsuario.getId_usuario()+ ", '" +pUsuario.getTipo_usuario()+ "', '" +pUsuario.getNombre_usuario()+ "', '" +pUsuario.getContrasenia_usuario()+ "')";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO PRODUCTO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "AC ACCESO_PRODUCTO:INSETAR_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarUsuario(ObjetosUsuario pUsuario){
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "update m_usuario set nombre_usuario = '" +pUsuario.getNombre_usuario()+ "', contrasenia_usuario= '" +pUsuario.getContrasenia_usuario()+ "', tipo_usuario = '" +pUsuario.getTipo_usuario()+ "' " +
                     "where id_usuario = " +pUsuario.getId_usuario();
        
        try{
            System.out.println("EJECUTANDO EN ACCESO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "AC ACCESO_PRODUCTO:INSETAR_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosUsuario> seleccionarUsuario(String pNombre_usuario){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        
        String sql = "select a.id_usuario, a.id_empleado, a.nombre_usuario, a.contrasenia_usuario, a.tipo_usuario, b.nombre_empleado from m_usuario a, m_empleado b where a.id_empleado = b.id_empleado and a.nombre_usuario like '%" +pNombre_usuario+ "%'";
        
        try{
            System.out.println("Ejecutando en ACCESO USUARIO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosUsuario registros;
            
            while(tabla.next()){
                registros = new ObjetosUsuario();
                registros.setId_usuario(tabla.getInt("id_usuario"));
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setNombre_usuario(tabla.getString("nombre_usuario"));
                registros.setContrasenia_usuario(tabla.getString("contrasenia_usuario"));
                registros.setTipo_usuario(tabla.getString("tipo_usuario"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                lista.add(registros);
                
            }
        }catch(Exception error){
            System.out.println("ACCESO USUARIO: SELECCION USUARIO");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    public int retornaIdUsuario(String pNombre_usuario){
        int registro = 0;
        AccesoInventario acceso = new AccesoInventario();
        
        String sql = "select a.id_usuario, a.id_empleado, a.nombre_usuario, a.contrasenia_usuario, a.tipo_usuario, b.nombre_empleado from m_usuario a, m_empleado b where a.id_empleado = b.id_empleado and a.nombre_usuario like '%" +pNombre_usuario+ "%'";
        
        try{
            System.out.println("Ejecutando en ACCESO USUARIO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            
            while(tabla.next()){
                registro = tabla.getInt("id_usuario");
                
            }
        }catch(Exception error){
            System.out.println("ACCESO USUARIO: SELECCION USUARIO");
            return 0;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
    
    public ArrayList<ObjetosUsuario> retornaUsuario(){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select a.id_usuario, a.id_empleado, a.nombre_usuario, a.contrasenia_usuario, a.tipo_usuario, b.nombre_empleado from m_usuario a, m_empleado b where a.id_empleado = b.id_empleado";
        
        try{
            System.out.println("Ejecutando en ACCESO USUARIO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosUsuario registros;
            
            while(tabla.next()){
                registros = new ObjetosUsuario();
                registros.setId_usuario(tabla.getInt("id_usuario"));
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setTipo_usuario(tabla.getString("tipo_usuario"));
                registros.setNombre_usuario(tabla.getString("nombre_usuario"));
                registros.setContrasenia_usuario(tabla.getString("contrasenia_usuario"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO USUARIO: SELECCION USUARIO");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosUsuario> retornaNombreEmpleados(){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_empleado order by nombre_empleado asc";
        
        try{
            System.out.println("Ejecutando en ACCESO USUARIO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosUsuario registros;
            
            while(tabla.next()){
                registros = new ObjetosUsuario();
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO USUARIO: SELECCION USUARIO");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    public int retornaIDEmpleado(String pNombre){
        int registro = 0;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select id_empleado from m_empleado where nombre_empleado = '" +pNombre+ "'";
        
        try{
            ResultSet tabla = acceso.listarRegistros(sql);
            while(tabla.next()){
                registro = tabla.getInt("id_empleado");
            }
        }catch(Exception error){
            System.out.println("ACCESO USUARIO: SELECCION USUARIO");
            return 0;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
    
    public ArrayList<ObjetosUsuario> validaCredenciales(String usr, String pass){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario(); 
        String sql = "select * from m_usuario where nombre_usuario = '" + usr + "' and contrasenia_usuario = '" + pass + "'";
        
        try{
            System.out.println("Ejecutando en ACCESO USUARIO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosUsuario registros;            
            while(tabla.next()){
                registros = new ObjetosUsuario();
                registros.setId_usuario(tabla.getInt("id_usuario"));
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setTipo_usuario(tabla.getString("tipo_usuario"));
                registros.setNombre_usuario(tabla.getString("nombre_usuario"));
                registros.setContrasenia_usuario(tabla.getString("contrasenia_usuario"));
                lista.add(registros);
            }
            
        }catch(Exception error){
            System.out.println("ACCESO USUARIO: VERIFICAR CREDENCIALES");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosUsuario> seleccionarCajeros(String tipos, String pUsuario, String pTerminal) {
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();

        String sql = "select * from m_usuario a, "
                + "m_empleado b where a.id_empleado = b.id_empleado "
                + "and a.tipo_usuario in (" + tipos + ") and b.estado_empleado = 'A' "
                + "order by nombre_usuario";

        try {

            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosUsuario registros;

            while (tabla.next()) {
                registros = new ObjetosUsuario();
                registros.setId_usuario(tabla.getInt("id_usuario"));
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setNombre_usuario(tabla.getString("nombre_usuario"));
                registros.setContrasenia_usuario(tabla.getString("contrasenia_usuario"));
                registros.setTipo_usuario(tabla.getString("tipo_usuario"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                lista.add(registros);

            }
        } catch (Exception error) {
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
}
