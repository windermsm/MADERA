/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;

import inventory.objetos.ObjetosBonificacion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */

public class AccesoBonificacion {
    
 public String eliminarBonificacion(ObjetosBonificacion pBonificacion){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete m_bonificacion where id_bonificacion = " + pBonificacion.getId_bonificacion();
        try{
            System.out.println("EJECUTANDO EN ACCESO BONIFICACION SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_BONIFICACION:ELIMINAR_BONIFICACION "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarBonificacion(ObjetosBonificacion pBonificacion){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_bonificacion values (0, '"+pBonificacion.getDescripcion_bonificacion()+"', "+
                pBonificacion.getCantidad_bonificacion()+", '"+pBonificacion.getEstado_bonificacion()+ "', " +pBonificacion.getPorcentaje_bonificacion()+ ")";
        try{
            System.out.println("EJECUTANDO EN ACCESO BONIFICACION SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_BONIFICACION:INSERTAR_BONIFICACION "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarBonificacion(ObjetosBonificacion pBonificacion){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_bonificacion set descripcion_bonificacion = '"+pBonificacion.getDescripcion_bonificacion()+"', cantidad_bonificacion = "+
                pBonificacion.getCantidad_bonificacion()+ ", estado_bonificacion = '" +pBonificacion.getEstado_bonificacion()+ "', porcentaje_bonificacion = " +
                pBonificacion.getPorcentaje_bonificacion()+ " where id_bonificacion = "+pBonificacion.getId_bonificacion();
        
        try{
            System.out.println("EJECUTANDO EN ACCESO BONIFICACION SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_BONIFICACION:ACTUALIZAR_BONIFICACION "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosBonificacion>seleccionarBonificacion(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_bonificacion";
        try{
            System.out.println("EJECUTANDO EN ACCESO BONIFICACION SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosBonificacion Registros;
            while(tabla.next()){
                Registros = new ObjetosBonificacion();
                Registros.setId_bonificacion(tabla.getInt("id_bonificacion"));
                Registros.setDescripcion_bonificacion(tabla.getString("descripcion_bonificacion"));
                Registros.setCantidad_bonificacion(tabla.getFloat("cantidad_bonificacion"));
                Registros.setEstado_bonificacion(tabla.getString("estado_bonificacion"));
                Registros.setPorcentaje_bonificacion(tabla.getFloat("porcentaje_bonificacion"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_BONIFICACION:SELECCIONAR_BONIFICACION "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosBonificacion>buscarBonificacion(String pIdBonificacion){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_bonificacion where descripcion_bonificacion = '" +pIdBonificacion+ "'";
        try{
            System.out.println("EJECUTANDO EN ACCESO BONIFICACION SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosBonificacion Registros;
            while(tabla.next()){
                Registros = new ObjetosBonificacion();
                Registros.setId_bonificacion(tabla.getInt("id_bonificacion"));
                Registros.setDescripcion_bonificacion(tabla.getString("descripcion_bonificacion"));
                Registros.setCantidad_bonificacion(tabla.getFloat("cantidad_bonificacion"));
                Registros.setEstado_bonificacion(tabla.getString("estado_bonificacion"));
                Registros.setPorcentaje_bonificacion(tabla.getFloat("porcentaje_bonificacion"));
                
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_BONIFICACION:BUSCAR_BONIFICACION "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
}