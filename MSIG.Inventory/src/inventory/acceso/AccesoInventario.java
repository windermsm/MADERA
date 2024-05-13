/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.vistas.wdwBaseDeDatosMantenimiento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */
public class AccesoInventario {
    
    AccesoArchivo archivo = new AccesoArchivo();
    Connection conexion = null;

    public Connection conectar() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://" + archivo.leer("[IP]") + ":" + archivo.leer("[Port]") + "/" + archivo.leer("[DataBase]");
            String usuario = archivo.leer("[User]");
            String contrasenia = archivo.leer("[Password]");
            Class.forName(driver).newInstance();
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);
            return conexion;
        } catch (Exception error) {
            System.out.println("EC ACCESO INVENTARIO:CONEXION " + error);
            return null;
        }
    }

    public ResultSet listarRegistros(String pConsulta) {
        try {
            conexion = conectar();
            PreparedStatement acceso_datos = conexion.prepareStatement(pConsulta);
            ResultSet registros = acceso_datos.executeQuery();
            return registros;
        } catch (Exception error) {
            wdwBaseDeDatosMantenimiento.txtError.setText(error.getMessage());
            System.out.println("EC ACCESO INVENTARIO:LISTAR REGISTROS" + error);
            return null;
        }
    }

    public String ejecutarConsulta(String pScript) {
        try {
            conexion = conectar();
            PreparedStatement acceso_datos = conexion.prepareStatement(pScript);
            int registros = acceso_datos.executeUpdate();
            return " Registros Actualizados: " + registros;
        } catch (Exception error) {
            return "ERROR : " + error;
        }
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (Exception error) {
            System.out.println("EC ACCESO_INVENTARIO:DESCONECTAR " + error);
        }
    }
}