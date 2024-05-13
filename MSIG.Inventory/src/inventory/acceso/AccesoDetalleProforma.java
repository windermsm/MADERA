/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.objetos.ObjetosDetalleProforma;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */

public class AccesoDetalleProforma {
    
    public String eliminarDetalleProforma(ObjetosDetalleProforma pDetalleProforma){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete d_proforma where id_d_proforma = "+pDetalleProforma.getId_d_proforma()+
                "id_factura = "+pDetalleProforma.getId_d_proforma();
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE PROFORMA SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_DETALLE_PROFORMA:eliminarDetalleProforma "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarDetalleProforma(ObjetosDetalleProforma pDetalleProforma){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into d_proforma values (0,"+pDetalleProforma.getId_proforma()+",'"+
                pDetalleProforma.getId_producto()+"',"+pDetalleProforma.getCant_d_proforma()+
                ","+pDetalleProforma.getPrecio_venta_d_proforma()+","+pDetalleProforma.getSub_total_proforma()+")";
        try{
            System.out.println("EJECUTANDO EN ACCESO_DETALLE_PROFORMA SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_DETALLE_PROFORMA:insertarDetalleProforma "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarDetalleProforma(ObjetosDetalleProforma pDetalleProforma){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update d_proforma set id_producto = '"+pDetalleProforma.getId_producto()+
                "', cant_d_proforma = "+pDetalleProforma.getCant_d_proforma()+", precio_venta_d_proforma = "+
                pDetalleProforma.getPrecio_venta_d_proforma()+", sub_total_d_proforma = "+pDetalleProforma.getSub_total_proforma()+
                " where id_d_proforma = "+pDetalleProforma.getId_d_proforma()+" and id_proforma = "+pDetalleProforma.getId_proforma();
        try{
            System.out.println("EJECUTANDO EN ACCESO_DETALLE_PROFORMA SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_DETALLE_PROFORMA:actualizarDetalleProforma "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosDetalleProforma>seleccionarDetalleProforma(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from d_proforma";
        try{
            System.out.println("EJECUTANDO EN ACCESO_DETALLE_PROFORMA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosDetalleProforma Registros;
            while(tabla.next()){
                Registros = new ObjetosDetalleProforma();
                Registros.setId_d_proforma(tabla.getInt("id_d_proforma"));
                Registros.setId_proforma(tabla.getInt("id_proforma"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setCant_d_proforma(tabla.getFloat("cant_d_proforma"));
                Registros.setPrecio_venta_d_proforma(tabla.getFloat("precio_venta_d_proforma"));
                Registros.setSub_total_proforma(tabla.getFloat("sub_total_d_proforma"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_DETALLE_PROFORMA:SELECCIONAR_DETALLE_PROFORMA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosDetalleProforma>buscarDetalleProforma(int pIdDProforma, int pIdProforma){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from d_proforma where id_d_proforma = "+pIdDProforma+
                " and id_proforma = "+pIdProforma;
        try{
            System.out.println("EJECUTANDO EN ACCESO_DETALLE_PROFORMA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosDetalleProforma Registros;
            while(tabla.next()){
                Registros = new ObjetosDetalleProforma();
                Registros.setId_d_proforma(tabla.getInt("id_d_factura"));
                Registros.setId_proforma(tabla.getInt("id_factura"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setCant_d_proforma(tabla.getFloat("cant_d_producto"));
                Registros.setPrecio_venta_d_proforma(tabla.getFloat("precio_venta_d_factura"));
                Registros.setSub_total_proforma(tabla.getFloat("sub_total_d_factura"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_DETALLE_PROFORMA:BUSCAR_CLIENTE "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
}
