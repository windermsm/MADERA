/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.objetos.ObjetosDetalleCompra;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */
public class AccesoDetalleCompra {
    
    public String eliminarDetalleCompra(ObjetosDetalleCompra pDetalleCompra){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete d_compra where id_d_compra = "+pDetalleCompra.getId_d_compra()+
                "id_compra = "+pDetalleCompra.getId_compra();
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE COMPRA SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:ELIMINAR_DETALLE_COMPRA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarDetalleCompra(ObjetosDetalleCompra pDetalleCompra){
        AccesoInventario Acceso = new AccesoInventario();
       String sql = "insert into d_compra values (0,"+pDetalleCompra.getId_compra()+",'"+
                pDetalleCompra.getId_producto()+"',"+pDetalleCompra.getCant_d_compra()+
                ","+pDetalleCompra.getPrecio_d_compra()+","+pDetalleCompra.getSub_total_d_compra()+
                ", '" +pDetalleCompra.getComentario_compra()+ "',"+pDetalleCompra.getArancel_compra()+")";
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE COMPRA SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO CLIENTE:INSERTAR DETALLE COMPRA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarDetalleCompra(ObjetosDetalleCompra pDetalleCompra){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update d_compra set id_producto = '"+pDetalleCompra.getId_producto()+
                "', cant_d_compra = "+pDetalleCompra.getCant_d_compra()+", precio_d_compra = "+
                pDetalleCompra.getPrecio_d_compra()+", sub_total_d_compra = "+pDetalleCompra.getSub_total_d_compra()+
                ", comentario_compra = '" +pDetalleCompra.getComentario_compra()+ "', arancel_compra = " +pDetalleCompra.getArancel_compra()+
                " where id_d_compra = "+pDetalleCompra.getId_d_compra()+" and id_compra = "+pDetalleCompra.getId_compra();
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE COMPRA SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:ACTUALIZAR_DETALLE_COMPRA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosDetalleCompra>seleccionarDetalleCompra(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from d_compra";
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE COMPRA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosDetalleCompra Registros;
            while(tabla.next()){
                Registros = new ObjetosDetalleCompra();
                Registros.setId_d_compra(tabla.getInt("id_d_compra"));
                Registros.setId_compra(tabla.getInt("id_compra"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setCant_d_compra(tabla.getFloat("cant_d_compra"));
                Registros.setPrecio_d_compra(tabla.getFloat("precio_d_compra"));
                Registros.setSub_total_d_compra(tabla.getFloat("sub_total_d_compra"));
                Registros.setComentario_compra(tabla.getString("comentario_compra"));
                Registros.setAracel_compra(tabla.getFloat("arancel_compra"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_CLIENTE:SELECCIONAR_DETALLE_COMPRA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosDetalleCompra>buscarDetalleCompra(int pIdDCompra, int pIdCompra){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from d_compra where id_d_compra = "+pIdDCompra+
                " and id_compra = "+pIdCompra;
        try{
            System.out.println("EJECUTANDO EN ACCESO DETALLE COMPRA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosDetalleCompra Registros;
            while(tabla.next()){
                Registros = new ObjetosDetalleCompra();
                Registros.setId_d_compra(tabla.getInt("id_d_compra"));
                Registros.setId_compra(tabla.getInt("id_compra"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setCant_d_compra(tabla.getFloat("cant_d_compra"));
                Registros.setPrecio_d_compra(tabla.getFloat("precio_d_compra"));
                Registros.setSub_total_d_compra(tabla.getFloat("sub_total_d_compra"));
                Registros.setComentario_compra(tabla.getString("comentraio_compra"));
                Registros.setAracel_compra(tabla.getFloat("arancel_compra"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_CLIENTE:BUSCAR_COMPRA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
}
