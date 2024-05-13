/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;

import inventory.objetos.ObjetosCliente;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */

public class AccesoCliente {
    
 public String eliminarCliente(ObjetosCliente pCliente){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete m_cliente where id_cliente = " + pCliente.getId_cliente();
        try{
            System.out.println("EJECUTANDO EN ACCESO CLIENTE SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:ELIMINAR_CLIENTE "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarCliente(ObjetosCliente pCliente){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_cliente values (0,"+pCliente.getId_persona()+",'"+
                pCliente.getDir_cliente()+"',"+pCliente.getTel_cliente()+ ", " +pCliente.getCelular_cliente()+ ", '" +pCliente.getEmail_cliente()+ "', " +pCliente.getLimite_credito()+ ", " +pCliente.getDias_de_credito()+ ", '" +pCliente.getTipo_cliente()+ "')";
        try{
            System.out.println("EJECUTANDO EN ACCESO CLIENTE SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:INSERTAR_CLIENTE "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarCliente(ObjetosCliente pCliente){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_cliente set dir_cliente = '"+pCliente.getDir_cliente()+"', tel_cliente = "+
                pCliente.getTel_cliente()+ ", celular_cliente = " +pCliente.getCelular_cliente()+ ", email_cliente = '" +
                pCliente.getEmail_cliente()+ "', limite_credito = " +pCliente.getLimite_credito()+ ", dias_de_credito = " +pCliente.getDias_de_credito()+
                ", tipo_cliente = '" +pCliente.getTipo_cliente()+ "' where id_cliente = "+pCliente.getId_cliente()+
                " and id_persona = "+pCliente.getId_persona(); 
        try{
            System.out.println("EJECUTANDO EN ACCESO CLIENTE SQL:  "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_CLIENTE:ACTUALIZAR_CLIENTE "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosCliente>seleccionarCliente(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_cliente";
        try{
            System.out.println("EJECUTANDO EN ACCESO CLIENTE SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosCliente Registros;
            while(tabla.next()){
                Registros = new ObjetosCliente();
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setId_persona(tabla.getInt("id_persona"));
                Registros.setDir_cliente(tabla.getString("dir_cliente"));
                Registros.setTel_cliente(tabla.getInt("tel_cliente"));
                Registros.setCelular_cliente(tabla.getInt("celular_cliente"));
                Registros.setEmail_cliente(tabla.getString("email_cliente"));
                Registros.setLimite_credito(tabla.getFloat("limite_credito"));
                Registros.setDias_de_credito(tabla.getInt("dias_de_credito"));
                Registros.setTipo_cliente(tabla.getString("tipo_cliente"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_CLIENTE:SELECCIONAR_CLIENTE "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosCliente>buscarCliente(int pIdPersona){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_cliente where id_persona = "+pIdPersona;
        try{
            System.out.println("EJECUTANDO EN ACCESO CLIENTE SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosCliente Registros;
            while(tabla.next()){
                Registros = new ObjetosCliente();
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setId_persona(tabla.getInt("id_persona"));
                Registros.setDir_cliente(tabla.getString("dir_cliente"));
                Registros.setTel_cliente(tabla.getInt("tel_cliente"));
                Registros.setCelular_cliente(tabla.getInt("celular_cliente"));
                Registros.setEmail_cliente(tabla.getString("email_cliente"));
                Registros.setLimite_credito(tabla.getFloat("limite_credito"));
                Registros.setDias_de_credito(tabla.getInt("dias_de_credito"));
                Registros.setTipo_cliente(tabla.getString("tipo_cliente"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_CLIENTE:BUSCAR_CLIENTE "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public String buscarNombreCliente(int id){
        String valor = null;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select nom_persona from m_persona where id_persona = (select id_persona from m_cliente where id_cliente = " + id + ")";
        try{
            System.out.println("Ejecutando: " + sql);
            ResultSet rs = acceso.listarRegistros(sql);
            while(rs.next()){
                valor = rs.getString("nom_persona");
            }
        }catch(Exception error){
            System.out.println("EC ACCESO CLIENTE : BUSCAR NOMBRE CLIENTE "+ error);
            return null;
        }
        return valor;
    }
    
    public String buscarNitCliente(int id){
        String valor = null;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select nit_persona from m_persona where id_persona = (select id_persona from m_cliente where id_cliente = " + id + ")";
        try{
            System.out.println("Ejecutando: " + sql);
            ResultSet rs = acceso.listarRegistros(sql);
            while(rs.next()){
                valor = rs.getString("nit_persona");
            }
        }catch(Exception error){
            System.out.println("EC ACCESO CLIENTE : BUSCAR NIT CLIENTE "+ error);
        }
        return valor;
    }
    
    public String actualizarNombreFactura(String pId_factura, String pNombre, String pPantalla, String pOpcion, String pUsuario, String pTerminal) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update  m_persona \n"
                + "set     nom_persona = replace('" + pNombre.replaceAll("'", "´") + "', ',', ' ') \n"
                + "where   id_persona in\n"
                + "        (\n"
                + "        select  id_persona\n"
                + "        from    m_cliente\n"
                + "        where   id_cliente in \n"
                + "                (\n"
                + "                select  id_cliente \n"
                + "                from    m_factura \n"
                + "                where   id_factura = " + pId_factura + "\n"
                + "                )\n"
                + "        )";
        System.out.println(sql);
        try {
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return error.getMessage();
        } finally {
            Acceso.desconectar();
        }
    }
    
}