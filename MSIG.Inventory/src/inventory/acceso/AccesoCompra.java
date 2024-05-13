/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */

import inventory.objetos.ObjetosCompra;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccesoCompra {
    
    public String eliminarCompra(ObjetosCompra pCompra){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete from m_compra where id_compra = " + pCompra.getId_compra();
        
        try{
            System.out.println("EJECUTANDO EN ACCESO COMPRA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch(Error error){
            return "EC ACCESO_COMPRA: ELIMINAR_COMPRA";
        } finally {
            Acceso.desconectar();
        }
    }
    
    
    public String insertarCompra(ObjetosCompra pCompra){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_compra values (" + pCompra.getId_compra() + ", " +
                                                    pCompra.getId_proveedor() + ", '" +
                                                    pCompra.getFecha_factura_compra() + "', " +
                                                    pCompra.getNumero_factura_compra() + ", '" +
                                                    pCompra.getSerie_factura_compra() + "', '" +
                                                    pCompra.getFolio_factura_compra() + "', " +
                                                    pCompra.getTotal_factura_compra() + ")";
        try{
            System.out.println("EJECUTANDO EN ACCESO COMPRA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_COMPRA:INSERTAR_COMPRA " + error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    
    public String actualizarCompra(ObjetosCompra pCompra){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_compra set fecha_factura_compra = '"+pCompra.getFecha_factura_compra() +
                "', num_factura_compra = " + pCompra.getNumero_factura_compra() + 
                ", serie_factura_compra = '" + pCompra.getSerie_factura_compra() +
                "', folio_factura_compra = '" + pCompra.getFolio_factura_compra() +
                "', total_factura = " + pCompra.getTotal_factura_compra() + 
                " where id_compra = " + pCompra.getId_compra();
        try{
            System.out.println("EJECUTANDO EN ACCESO COMPRA SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_COMPRA:ACTUALIZAR_COMPRA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosCompra>seleccionarCompra(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_compra";
        try{
            System.out.println("EJECUTANDO EN ACCESO COMPRA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosCompra Registros;
            while(tabla.next()){
                Registros = new ObjetosCompra();
                Registros.setId_compra(tabla.getInt("id_compra"));
                Registros.setId_proveedor(tabla.getInt("id_proveedor"));
                Registros.setFecha_factura_compra(tabla.getString("fecha_factura_compra"));
                Registros.setNumero_factura_compra(tabla.getString("num_factura_compra"));
                Registros.setSerie_factura_compra(tabla.getString("serie_factura_compra"));
                Registros.setFolio_factura_compra(tabla.getString("folio_factura_compra"));
                Registros.setTotal_factura_compra(tabla.getFloat("total_factura_compra"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_COMPRA:SELECCIONAR_COMPRA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosCompra>seleccionarIdCompra(ObjetosCompra pCompra){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_compra where num_factura_compra = " + pCompra.getNumero_factura_compra() +
                " and id_proveedor = "+pCompra.getId_proveedor()+
                " and total_factura_compra = "+pCompra.getTotal_factura_compra();
        try{
            System.out.println("EJECUTANDO EN ACCESO COMPRA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosCompra Registros;
            while(tabla.next()){
                Registros = new ObjetosCompra();
                Registros.setId_compra(tabla.getInt("id_compra"));
                Registros.setId_proveedor(tabla.getInt("id_proveedor"));
                Registros.setFecha_factura_compra(tabla.getString("fecha_factura_compra"));
                Registros.setNumero_factura_compra(tabla.getString("num_factura_compra"));
                Registros.setSerie_factura_compra(tabla.getString("serie_factura_compra"));
                Registros.setFolio_factura_compra(tabla.getString("fecha_factura_compra"));
                Registros.setTotal_factura_compra(tabla.getFloat("total_factura_compra"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_FACTURA:SELECCIONAR_ID_COMPRA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosCompra>seleccionarCompraFecha(String pFecha_inicial, String pFecha_final){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * "
                + "from m_compra "
                + "where date_format(fecha_factura_compra, '%Y-%m-%d') between '"
                + pFecha_inicial
                + "' and '"
                + pFecha_final
                + "' order by fecha_factura_compra desc";
        try{
            System.out.println("EJECUTANDO EN ACCESO COMPRA SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosCompra Registros;
            while(tabla.next()){
                Registros = new ObjetosCompra();
                Registros.setId_compra(tabla.getInt("id_compra"));
                Registros.setId_proveedor(tabla.getInt("id_proveedor"));
                Registros.setFecha_factura_compra(tabla.getString("fecha_factura_compra"));
                Registros.setNumero_factura_compra(tabla.getString("num_factura_compra"));
                Registros.setSerie_factura_compra(tabla.getString("serie_factura_compra"));
                Registros.setFolio_factura_compra(tabla.getString("folio_factura_compra"));
                Registros.setTotal_factura_compra(tabla.getFloat("total_factura_compra"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_COMPRA:SELECCIONAR_COMPRA "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
}