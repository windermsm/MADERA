/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.objetos.ObjetosDetalleFactura;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */

public class AccesoDetalleFactura {
    
    public String eliminarDetalleFactura(ObjetosDetalleFactura pDetalleFactura){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete d_factura where id_d_factura = "+pDetalleFactura.getId_d_factura()+
                "id_factura = "+pDetalleFactura.getId_factura();
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE FACTURA SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:ELIMINAR_DETALLE_FACTURA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarDetalleFactura(ObjetosDetalleFactura pDetalleFactura){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into d_factura values (0,"+pDetalleFactura.getId_factura()+",'"+
                pDetalleFactura.getId_producto()+"',"+pDetalleFactura.getCant_d_factura()+
                ","+pDetalleFactura.getPrecio_venta_d_factura()+","+pDetalleFactura.getSub_total_d_factura()+
                ", '" +pDetalleFactura.getComentario_d_factura()+ "', " +pDetalleFactura.getArancel_factura()+ ", " + pDetalleFactura.getPrecio_estandar() + ")";
        System.out.println("Ejecutando inserta detalle factura: " + sql);
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE FACTURA SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:INSERTAR_DETALLE_FACTURA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarDetalleFactura(ObjetosDetalleFactura pDetalleFactura){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update d_factura set id_producto = '"+pDetalleFactura.getId_producto()+
                "', cant_d_factura = "+pDetalleFactura.getCant_d_factura()+", precio_venta_factura = "+
                pDetalleFactura.getPrecio_venta_d_factura()+", sub_total_d_factura = "+pDetalleFactura.getSub_total_d_factura()+
                ", comentario_factura = " +pDetalleFactura.getComentario_d_factura()+ ", arancel_factura = " +pDetalleFactura.getArancel_factura()+
                " where id_d_factura = "+pDetalleFactura.getId_d_factura()+" and id_factura = "+pDetalleFactura.getId_factura();
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE FACTURA SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:ACTUALIZAR_DETALLE_FACTURA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosDetalleFactura>seleccionarDetalleFactura(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_cliente";
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE FACTURA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosDetalleFactura Registros;
            while(tabla.next()){
                Registros = new ObjetosDetalleFactura();
                Registros.setId_d_factura(tabla.getInt("id_d_factura"));
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setCant_d_factura(tabla.getFloat("cant_d_producto"));
                Registros.setPrecio_venta_d_factura(tabla.getFloat("precio_venta_d_factura"));
                Registros.setSub_total_d_factura(tabla.getFloat("sub_total_d_factura"));
                Registros.setComentario_d_factura(tabla.getString("comentario_factura"));
                Registros.setArancel_factura(tabla.getFloat("arancel_factura"));
                Registros.setPrecio_estandar(tabla.getFloat("precio_estandar_d_factura"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_CLIENTE:SELECCIONAR_DETALLE_FACTURA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosDetalleFactura>buscarDetalleFactura(int id_factura){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from d_factura where id_factura = " + id_factura;
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE FACTURA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosDetalleFactura Registros;
            while(tabla.next()){
                Registros = new ObjetosDetalleFactura();
                Registros.setId_d_factura(tabla.getInt("id_d_factura"));
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setCant_d_factura(tabla.getFloat("cant_d_factura"));
                Registros.setPrecio_venta_d_factura(tabla.getFloat("precio_venta_d_factura"));
                Registros.setSub_total_d_factura(tabla.getFloat("sub_total_d_factura"));
                Registros.setComentario_d_factura(tabla.getString("comentario_factura"));
                Registros.setArancel_factura(tabla.getFloat("arancel_factura"));
                Registros.setPrecio_estandar(tabla.getFloat("precio_estandar_d_factura"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_CLIENTE:BUSCAR_DETALL_FACTURA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
}
