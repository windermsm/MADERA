/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;

import inventory.objetos.ObjetosProveedor;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gigi
 */
public class AccesoProveedor {
  public String eliminarProveedor(ObjetosProveedor pProveedor){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete m_proveedor where id_proveedor = " + pProveedor.getId_proveedor();
        try{
            System.out.println("EJECUTANDO EN ACCESO PROVEEDOR SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PROVEEDOR:ELIMINAR_PROVEEDOR "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarProveedor(ObjetosProveedor pProveedor){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_proveedor values (0,"+pProveedor.getId_persona()+",'"+
                pProveedor.getDir_proveedor()+"',"+pProveedor.getTel_proveedor()+")";
        try{
            System.out.println("EJECUTANDO EN ACCESO PROVEEDOR SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PROVEEDORE:INSERTAR_PROVEEDOR "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarProveedor(ObjetosProveedor pProveedor){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_proveedor set dir_proveedor = '"+pProveedor.getDir_proveedor()+"', tel_proveedor = "+
                pProveedor.getTel_proveedor()+" where id_proveedor = "+pProveedor.getId_proveedor()+
                " and id_persona = "+pProveedor.getId_persona(); 
        try{
            System.out.println("EJECUTANDO EN ACCESO PROVEEDOR SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PROVEEDOR:ACTUALIZAR_PROVEEDOR "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosProveedor>seleccionarProveedor(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_proveedor";
        try{
            System.out.println("EJECUTANDO EN ACCESO PROVEEDOR SQL:  "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosProveedor Registros;
            while(tabla.next()){
                Registros = new ObjetosProveedor();
                Registros.setId_proveedor(tabla.getInt("id_proveedor"));
                Registros.setId_persona(tabla.getInt("id_persona"));
                Registros.setDir_proveedor(tabla.getString("dir_proveedor"));
                Registros.setTel_proveedor(tabla.getInt("tel_proveedor"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_PROVEEDOR:SELECCIONAR_PROVEEDOR "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosProveedor>buscarProveedor(int pIdPersona){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_proveedor where id_persona = "+pIdPersona;
        try{
            System.out.println("EJECUTANDO EN ACCESO PROVEEDOR SQL:  "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosProveedor Registros;
            while(tabla.next()){
                Registros = new ObjetosProveedor();
                Registros.setId_proveedor(tabla.getInt("id_proveedor"));
                Registros.setId_persona(tabla.getInt("id_persona"));
                Registros.setDir_proveedor(tabla.getString("dir_proveedor"));
                Registros.setTel_proveedor(tabla.getInt("tel_proveedor"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_PROVEEDOR:BUSCAR_PROVEEDOR "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
}