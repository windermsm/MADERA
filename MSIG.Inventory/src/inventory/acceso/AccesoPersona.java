/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */
import inventory.objetos.ObjetosPersona;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccesoPersona {

    public String eliminarPersona(ObjetosPersona pPersona) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete m_persona where id_persona = " + pPersona.getId_persona();
        try {
            System.out.println("EJECUTANDO EN ACCESO PERSONA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_PERSONA:ELIMINAR_PERSONA " + error;
        } finally {
            Acceso.desconectar();
        }
    }

    public String insertarPersona(ObjetosPersona pPersona) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_persona values (0,'" + pPersona.getNit_persona()
                + "','" + pPersona.getNom_persona() + "')";
        try {
            System.out.println("EJECUTANDO EN ACCESO PERSONA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_PERSONA:INSERTAR_PERSONA " + error;
        } finally {
            Acceso.desconectar();
        }
    }

    public String actualizarPersona(ObjetosPersona pPersona) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_persona set nit_persona = '" + pPersona.getNit_persona()
                + "', nom_persona = '" + pPersona.getNom_persona() + "' where id_persona = "
                + pPersona.getId_persona();
        try {
            System.out.println("EJECUTANDO EN ACCESO PERSONA SQL:  " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_PERSONA:ACTUALIZAR_PERSONA " + error;
        } finally {
            Acceso.desconectar();
        }
    }

    public ArrayList<ObjetosPersona> seleccionarPersona() {
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_persona";

        try {
            System.out.println("EJECUTANDO EN ACCESO PERSONA SQL:  " + sql);
            ResultSet tablaPersona = Acceso.listarRegistros(sql);
            ObjetosPersona RegistrosPersona;
            while (tablaPersona.next()) {
                RegistrosPersona = new ObjetosPersona();
                RegistrosPersona.setId_persona(tablaPersona.getInt("id_persona"));
                RegistrosPersona.setNit_persona(tablaPersona.getString("nit_persona"));
                RegistrosPersona.setNom_persona(tablaPersona.getString("nom_persona"));
                lista.add(RegistrosPersona);
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO_PERSONA:SELECCIONAR_PERSONA " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }

    public ArrayList<ObjetosPersona> buscarPersona(String pNitPersona) {
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_persona where nit_persona = '" + pNitPersona + "'";
        try {
            System.out.println("EJECUTANDO EN ACCESO PERSONA SQL: " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);

            if (tabla != null) {
                ObjetosPersona Registros;

                while (tabla.next()) {
                    Registros = new ObjetosPersona();
                    Registros.setId_persona(tabla.getInt("id_persona"));
                    Registros.setNit_persona(tabla.getString("nit_persona"));
                    Registros.setNom_persona(tabla.getString("nom_persona"));
                    lista.add(Registros);
                }
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO_PERSONA:BUSCAR_PERSONA " + error);
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
}
