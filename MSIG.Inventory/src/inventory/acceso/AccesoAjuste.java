/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;

import inventory.objetos.ObjetosAjuste;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */

public class AccesoAjuste {
    
    public void insertarAjuste(ObjetosAjuste ajuste){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into d_ajuste values (0, '" + ajuste.getId_producto() + "','" + ajuste.getTipo_ajuste()+ "'," + ajuste.getCantidad_ajuste() + ",'" + ajuste.getMotivo_ajuste() + "','" + ajuste.getUsuario_ajuste() +  "', now())";
        try{
            System.out.println("EJECUTANDO SQL: "+sql);
            Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            System.out.println("EC AccesoAjuste:InsertarAjuste " + error);
        } finally {
            Acceso.desconectar();
        }
    }
    
    
    public String actualizarAjuste(ObjetosAjuste ajuste){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "";
        if(ajuste.getTipo_ajuste().equals("Agregar")) {
            sql = "update m_producto set exi_producto = exi_producto + " + ajuste.getCantidad_ajuste() + " where id_producto = '" + ajuste.getId_producto() + "'";
        } else {
            sql = "update m_producto set exi_producto = exi_producto - " + ajuste.getCantidad_ajuste() + " where id_producto = '" + ajuste.getId_producto() + "'";
        }
        try{
            System.out.println("EJECUTANDO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC AccesoAjuste:ActualizarAjuste " + error;
        } finally {
            Acceso.desconectar();
        }
    }
}