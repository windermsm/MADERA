/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.objetos.ObjetosTraslado;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Derwin Santa Cruz
 */
public class AccesoTraslado {
    
    public String eliminarTraslado(ObjetosTraslado traslado) {
        
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete from m_traslado where id_traslado = " + traslado.getId_traslado();

        try {
            System.out.println("EJECUTANDO EN ACCESO TRASLADO SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO TRASLADO : ELIMINAR TRASLADO " + error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarTraslado(ObjetosTraslado traslado) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_traslado values (null, "
                + traslado.getId_sucursal() + ", '"
                + traslado.getFecha_trasaldo() + "', "
                + traslado.getTotal_traslado() + ", '"
                + traslado.getUsuario_traslado() + "', now())";
        try {
            System.out.println("EJECUTANDO EN ACCESO TRASLADO SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO TRASLADO : INSERTAR TRASLADO " + error;
        } finally {
            Acceso.desconectar();
        }
    }

    public ArrayList<ObjetosTraslado> listarTrasladosPorFecha(String fecha_inicial, String fecha_final) {
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * "
                + "from m_traslado "
                + "where fecha_traslado between str_to_date('" + fecha_inicial + "', '%Y-%m-%d') AND str_to_date('" + fecha_final + "', '%Y-%m-%d')";
        try {
            System.out.println("EJECUTANDO: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosTraslado Registros;
            while (tabla.next()) {
                Registros = new ObjetosTraslado();
                Registros.setId_traslado(tabla.getInt("id_traslado"));
                Registros.setId_sucursal(tabla.getInt("id_sucursal"));
                Registros.setFecha_trasaldo(tabla.getString("fecha_traslado"));
                Registros.setTotal_traslado(tabla.getFloat("total_traslado"));
                Registros.setUsuario_traslado(tabla.getString("usuario_traslado"));
                lista.add(Registros);
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO TRASLADO : LISTAR TRASLADOS POR FECHA -> " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public int obtenerIdTraslado(ObjetosTraslado traslado) {
        AccesoInventario Acceso = new AccesoInventario();
        int numero = 0;
        String sql = "select max(id_traslado) as id_traslado "
                + "from m_traslado "
                + "where usuario_traslado = '" + traslado.getUsuario_traslado() + "'"
                + " and id_sucursal = " + traslado.getId_sucursal() + " "
                + " and fecha_traslado = str_to_date('" + traslado.getFecha_trasaldo() + "', '%Y-%m-%d')"
                + " and total_traslado = " + traslado.getTotal_traslado();
        try {
            System.out.println("EJECUTANDO EN ACCESO TRASLADO SQL: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            while (tabla.next()) {
                numero =  tabla.getInt("id_traslado");
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO TRASLADO : OBTENER ID TRASLADO " + error);
            numero = 0;
        } finally {
            Acceso.desconectar();
        }
        return numero;
    }

}