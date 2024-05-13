/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;

import inventory.objetos.ObjetosSucursal;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gigi
 */
public class AccesoSucursal {
    AccesoExcepciones mensaje = new AccesoExcepciones();
    
    public String insertarSucursal(ObjetosSucursal pSucursal){
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "insert into m_sucursal values (" +pSucursal.getId_sucursal()+ ", '"+pSucursal.getNombre_sucursal()+ "', '" +pSucursal.getDescripcion_sucursal()+ "', '" +pSucursal.getDireccion_sucursal()+ "');";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO SUCRUSAL SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "AC ACCESO_SUCURSAL:INSETAR_SUCURSAL "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarSucursal(ObjetosSucursal pSucursal){
        AccesoInventario Acceso = new AccesoInventario();      
        String sql = "update m_sucursal set descripcion_sucursal = '" +pSucursal.getDescripcion_sucursal()+ "', direccion_sucursal= '" +pSucursal.getDireccion_sucursal()+ "' " +
                     ", nombre_sucursal = '" + pSucursal.getNombre_sucursal() + "', nit_sucursal = '" + pSucursal.getNit_sucursal() + 
                    "', telefonos_sucursal = '" + pSucursal.getTelefonos_sucursal() + "' where id_sucursal = " +pSucursal.getId_sucursal();
        try{
            System.out.println("EJECUTANDO EN ACCESO SUCRUSAL SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "AC ACCESO_SUCURSAL: ACTUALIZAR SUCURSAL "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosSucursal> seleccionarSucursal(String pNombreSucursal){
        
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_sucursal where nombre_sucursal like '%" +pNombreSucursal+ "%';";
        
        try{
            System.out.println("Ejecutando en ACCESO SUCURSAL SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosSucursal registros;
            
            while(tabla.next()){
                registros = new ObjetosSucursal();
                registros.setId_sucursal(tabla.getInt("id_sucursal"));
                registros.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                registros.setDescripcion_sucursal(tabla.getString("descripcion_sucursal"));
                registros.setDireccion_sucursal(tabla.getString("direccion_sucursal"));
                registros.setNit_sucursal(tabla.getString("nit_sucursal"));
                registros.setTelefonos_sucursal(tabla.getString("telefonos_sucursal"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO SUCRUSAL: SELECCION SUCURSAL");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosSucursal> retornaSucursales(){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_sucursal;";
        
        try{
            System.out.println("Ejecutando en ACCESO SUCURSAL SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosSucursal registros;
            
            while(tabla.next()){
                registros = new ObjetosSucursal();
                registros.setId_sucursal(tabla.getInt("id_sucursal"));
                registros.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                registros.setDescripcion_sucursal(tabla.getString("descripcion_sucursal"));
                registros.setDireccion_sucursal(tabla.getString("direccion_sucursal"));
                registros.setNit_sucursal(tabla.getString("nit_sucursal"));
                registros.setTelefonos_sucursal(tabla.getString("telefonos_sucursal"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO SUCRUSAL: SELECCION SUCURSAL");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosSucursal> obtenerIdSuc(String pNombre, String pDescripcion, String pDireccion){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_sucursal where nombre_sucursal = '" +pNombre+ "' and descripcion_sucursal = '" +pDescripcion+ "' and direccion_sucursal = '" +pDireccion+ "';";
        
        try{
            System.out.println("Ejecutando en ACCESO SUCURSAL SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosSucursal registros;
            
            while(tabla.next()){
                registros = new ObjetosSucursal();
                registros.setId_sucursal(tabla.getInt("id_sucursal"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO SUCRUSAL: OBTENER ID SUCURSAL");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    
    public ObjetosSucursal obtenerSucursal(String id){
        
        ObjetosSucursal registros = null;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_sucursal where id_sucursal = " + id;
        
        try{
            System.out.println("Ejecutando en ACCESO SUCURSAL SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            while(tabla.next()){
                registros = new ObjetosSucursal();
                registros.setId_sucursal(tabla.getInt("id_sucursal"));
                registros.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                registros.setDescripcion_sucursal(tabla.getString("descripcion_sucursal"));
                registros.setDireccion_sucursal(tabla.getString("direccion_sucursal"));
            }
        }catch(Exception error){
            System.out.println("ACCESO SUCRUSAL : OBTENER SUCURSAL");
            System.out.println(error.toString());
            return null;
        } finally {
            acceso.desconectar();
        }
        return registros;
    }
    
    public ObjetosSucursal buscarSucursales(int pIdSucursal, String pUsuario, String pTerminal) {
        AccesoInventario acceso = new AccesoInventario();
        ObjetosSucursal registro = new ObjetosSucursal();
        String sql = "select * from m_sucursal where id_sucursal = " + pIdSucursal;
        try {
            ResultSet tabla = acceso.listarRegistros(sql);
            while (tabla.next()) {
                registro.setId_sucursal(tabla.getInt("id_sucursal"));
                registro.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                registro.setDescripcion_sucursal(tabla.getString("descripcion_sucursal"));
                registro.setDireccion_sucursal(tabla.getString("direccion_sucursal"));
                registro.setNit_sucursal(tabla.getString("nit_sucursal"));
                registro.setTelefonos_sucursal(tabla.getString("telefonos_sucursal"));
            }
        } catch (Exception error) {
            return null;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
    
}
