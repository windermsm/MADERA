/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.objetos.ObjetosLoggin;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class AccesoLoggin {
    
        public ArrayList<ObjetosLoggin>seleccionarLoggin(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from loggin";
        try{
            System.out.println("EJECUTANDO EN ACCESO LOGGIN SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosLoggin Registros;
            while(tabla.next()){
                Registros = new ObjetosLoggin();
                Registros.setId_loggin(tabla.getInt("id_loggin"));
                Registros.setUser_loggin(tabla.getString("user_loggin"));
                Registros.setEstado_loggin(tabla.getString("estado_loggin"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_LOGGIN:SELECCIONAR_LOGGIN "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
        
    public String actualizar(ObjetosLoggin pLoggin) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update loggin set user_loggin = '" + pLoggin.getUser_loggin()+
                "', estado_loggin = '"+pLoggin.getEstado_loggin()+"' where id_loggin = "+pLoggin.getId_loggin();
        try {
            System.out.println("EJECUTANDO EN ACCESO LOGGIN SQL:  " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_LOGGIN:ACTUALIZAR_LOGGIN " + error;
        } finally {
            Acceso.desconectar();
        }
    }
}