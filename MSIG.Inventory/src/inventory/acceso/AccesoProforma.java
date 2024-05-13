/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */

import inventory.objetos.ObjetosProforma;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccesoProforma {
     public String eliminarProforma(ObjetosProforma pProforma){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete from m_proforma where id_proforma = " + pProforma.getId_proforma();
        
        try{
            System.out.println("EJECUTANDO EN ACCESO PROFORMA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch(Error error){
            return "EC ACCESO_FACTURA: ELIMINAR_PROFORMA " + error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    
    public String insertarProforma(ObjetosProforma pProforma){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_proforma values (0, " +
                                                    pProforma.getId_cliente() + ", " +
                                                    pProforma.getId_empleado() + ", '" +
                                                    pProforma.getFecha_emision_proforma() + "', '" +
                                                    pProforma.getDir_envio_proforma() + "', " +
                                                    pProforma.getTotal_proforma() + ")";
        System.out.println("Insertando en m_proforma " + sql);
        try{
            System.out.println("EJECUTANDO EN ACCESO PROFORMA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PROFORMA:INSERTAR_PROFORMA " + error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    
    public String actualizarProforma(ObjetosProforma pProforma){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_proforma set id_cliente = " + pProforma.getId_cliente() +
                                        ", fecha_emision_proforma = '" + pProforma.getFecha_emision_proforma() + 
                                        "', dir_envio_proforma = '" + pProforma.getDir_envio_proforma() +
                                        "', id_empleado = " +pProforma.getId_empleado()+
                             " where id_proforma = " + pProforma.getId_proforma();
        try{
            System.out.println("EJECUTANDO EN ACCESO PROFORMA SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PROFORMA:actualizarProforma "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosProforma>seleccionarProforma(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_proforma";
        try{
            System.out.println("EJECUTANDO EN ACCESO PROFORMA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosProforma Registros;
            while(tabla.next()){
                Registros = new ObjetosProforma();
                Registros.setId_proforma(tabla.getInt("id_proforma"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setId_empleado(tabla.getInt("id_empleado"));
                Registros.setFecha_emision_proforma(tabla.getString("fecha_emision_proforma"));
                Registros.setDir_envio_proforma(tabla.getString("dir_envio_proforma"));
                Registros.setTotal_proforma(tabla.getFloat("total_proforma"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_PROFORMA:seleccionarProforma "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosProforma>seleccionarIdProforma(ObjetosProforma pProforma){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_proforma where id_cliente = " + pProforma.getId_cliente() +
                " and id_empleado = "+pProforma.getId_empleado()+
                " and dir_envio_proforma = '"+pProforma.getDir_envio_proforma()+
                "' and total_proforma = "+pProforma.getTotal_proforma();
        try{
            System.out.println("EJECUTANDO EN ACCESO PROFORMA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosProforma Registros;
            while(tabla.next()){
                Registros = new ObjetosProforma();
                Registros.setId_proforma(tabla.getInt("id_proforma"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_PROFORMA:seleccionarIdProforma "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosProforma>seleccionarProformaFecha(String pFecha_inicial, String pFecha_final){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * "
                + "from m_proforma "
                + "where date_format(fecha_emision_proforma, '%Y-%m-%d') between '"
                + pFecha_inicial
                + "' and '"
                + pFecha_final
                + "' order by fecha_emision_proforma";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO PROFORMA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosProforma Registros;
            while(tabla.next()){
                Registros = new ObjetosProforma();
                Registros.setId_proforma(tabla.getInt("id_proforma"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setId_empleado(tabla.getInt("id_empleado"));
                Registros.setFecha_emision_proforma(tabla.getString("fecha_emision_proforma"));
                Registros.setDir_envio_proforma(tabla.getString("dir_envio_proforma"));
                Registros.setTotal_proforma(tabla.getFloat("total_proforma"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_FACTURA:SELECCIONAR_FACTURA_FECHA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
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
            System.out.println("ACCESO USUARIO: SELECCION USUARIO " + error);
            return 0;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
     
    public ArrayList<ObjetosProforma> retornaNombreEmpleados(){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_empleado";
        
        try{
            System.out.println("Ejecutando en ACCESO USUARIO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosProforma registros;
            
            while(tabla.next()){
                registros = new ObjetosProforma();
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO USUARIO: SELECCION USUARIO " + error);
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
}
