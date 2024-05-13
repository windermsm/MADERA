/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
import inventory.objetos.ObjetosAnulacionFacturas;
import inventory.objetos.ObjetosProducto;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccesoAnulacionFacturas {
    
    public ArrayList<ObjetosAnulacionFacturas> BuscarFactura(int pEnvio) {
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select  a.id_factura, b.id_d_factura, a.num_factura, a.serie_factura, a.folio_factura, a.fecha_emision_factura, a.total_factura, c.id_producto, c.marca_producto, b.cant_d_factura, b.precio_venta_d_factura, (cant_d_factura * precio_venta_d_factura) as subtotal " +
                     " from    m_factura a, d_factura b, m_producto c " +
                     " where   a.id_factura = b.id_factura and b.id_producto = c.id_producto and a.estado_factura = 'Cancelado' and a.id_factura = " +pEnvio;
        try {
            System.out.println("EJECUTANDO EN ACCESO ANULACION FACTURAS SQL: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosAnulacionFacturas Registros;
            while (tabla.next()) {
                Registros = new ObjetosAnulacionFacturas();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setId_d_factura(tabla.getInt("id_d_factura"));
                Registros.setNum_factura(tabla.getInt("num_factura"));
                Registros.setSerie_factura(tabla.getString("serie_factura"));
                Registros.setFolio_factura(tabla.getString("folio_factura"));
                Registros.setFecha_emision_factura(tabla.getString("fecha_emision_factura"));
                Registros.setTotal_factura(tabla.getFloat("total_factura"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setMarca_producto(tabla.getString("marca_producto"));
                Registros.setCant_d_factura(tabla.getFloat("cant_d_factura"));
                Registros.setPrecio_venta_d_factura(tabla.getFloat("precio_venta_d_factura"));
                Registros.setSubTotal_factura(tabla.getFloat("subtotal"));
                lista.add(Registros);
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO_ANULAR_FACTURA:BUSCAR_FACTURA " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    // Le cambio estado a la factura
    public String CambiarEstadoFactura(int pId_Factura){
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "update m_factura set estado_factura = 'Anulado' where id_factura = " +pId_Factura;
        
        try{
            System.out.println("EJECUTANDO EN ACCESO CAMBIAR ESTADO FACTURAS SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "AC ACCESO_ANULARFACTURAS: CAMBIAR ESTADO FACTURA "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    // Devuelvo los productos al inventario
    public String DevuelveAlInventario(String pId_producto, float pCantidad_producto_devuelto) {
        //ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "select exi_producto from m_producto where id_producto = '" +pId_producto+ "'";
        float vProducto_actual_inventario = 0;
        
        try {
            System.out.println("EJECUTANDO EN ACCESO ANULACION FACTURAS DevuelveAlInventario SQL: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            //ObjetosAnulacionFacturas Registros;
            
            while (tabla.next()) {
                vProducto_actual_inventario = tabla.getFloat("exi_producto");
                System.out.println("EXISTENCIA EN TEMPORAL " + vProducto_actual_inventario + "EXISTENCIA EN CANTIDAD ACTUAL " +pCantidad_producto_devuelto);
                
            }
            
            float vNueva_existenacia_producto = vProducto_actual_inventario + pCantidad_producto_devuelto;
            String sql2 = "update m_producto set exi_producto = " +vNueva_existenacia_producto+ " where id_producto = '" +pId_producto+ "'";
            
            System.out.println("Actualizando inventario por devolucion: "+sql2);
            return Acceso.ejecutarConsulta(sql2);
            
        } catch (Exception error) {
            System.out.println("EC ACCESO_ANULAR_FACTURA:DevuelveAlInventario " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
    }
    
}
