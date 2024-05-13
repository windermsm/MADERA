/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.objetos.ObjetosDetalleTraslado;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lizbeth Marroquin
 */
public class AccesoDetalleTraslado {
    
    public String eliminarDetalleTraslado(ObjetosDetalleTraslado detalle){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete d_traslado where id_d_traslado = " + detalle.getId_d_traslado() +
                " AND id_traslado = " + detalle.getId_traslado();
        try{
            System.out.println("EJECUTANDO: " + sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO DETALLE PROFORMA: ELIMINA DETALLE TRASLADO " + error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarDetalleTraslado(ObjetosDetalleTraslado detalle){    
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into d_traslado values (0, " + detalle.getId_traslado() +", '"+
                detalle.getId_producto() + "', " + detalle.getCantidad_d_traslado() +
                ", " + detalle.getTotal_d_traslado() + ")";
        try{
            System.out.println("EJECUTANDO: " + sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO DETALLE TRASLADO : INSERTA DETALLE TRASLADO " + error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosDetalleTraslado> listarDeralleTraslado(int id){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from d_traslado where id_traslado = " +  id;
        try{
            System.out.println("EJECUTANDO: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosDetalleTraslado Registros;
            while(tabla.next()){
                Registros = new ObjetosDetalleTraslado();
                Registros.setId_d_traslado(tabla.getInt("id_d_traslado"));
                Registros.setId_traslado(tabla.getInt("id_traslado"));
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setCantidad_d_traslado(tabla.getFloat("cantidad_d_traslado"));
                Registros.setTotal_d_traslado(tabla.getFloat("total_d_traslado"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO DETALLE TRASLADO : LISTAR DETALLE TRASLADO " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
}
