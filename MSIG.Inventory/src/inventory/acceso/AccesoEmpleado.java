/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;
import inventory.objetos.ObjetosEmpleado;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gigi
 */
public class AccesoEmpleado {
    
    public String insertarEmpleado(ObjetosEmpleado pEmpleado){
        
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "";
        
        if(pEmpleado.getFecha_salida() != null){
            pEmpleado.setFecha_salida("'"+pEmpleado.getFecha_salida()+"'");
        }
        
        sql = "insert into m_empleado values (null, " +pEmpleado.getId_sucursal()+ ", '" +pEmpleado.getTipo_empleado()+ "', '" +pEmpleado.getNombre_empleado()+ "', '" +pEmpleado.getEstado_empleado()+ "', " +pEmpleado.getSalario_empleado()+ ", " +pEmpleado.getBono_empleado()+ ", '" +pEmpleado.getFecha_ingreso()+ "'," +pEmpleado.getFecha_salida()+ ", " +pEmpleado.getPorcentaje_comision()+ ")";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO EMPLEADO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PROVEEDORE:INSERTAR_EMPLEADO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarEmpleado(ObjetosEmpleado pEmpleado){
        AccesoInventario Acceso = new AccesoInventario();
        
        System.out.println("FECHA SALIDA TRAE " + pEmpleado.getFecha_salida());
        if(pEmpleado.getFecha_salida().isEmpty() || pEmpleado.getFecha_salida().equals(" ")){
            System.out.println("ENTRO");
            pEmpleado.setFecha_salida(null);
        }else{
            pEmpleado.setFecha_salida("'"+pEmpleado.getFecha_salida()+"'");
        }
        
        String sql = "update m_empleado set tipo_empleado = '"+pEmpleado.getTipo_empleado()+"', nombre_empleado = '" +pEmpleado.getNombre_empleado()+ "', estado_empleado = '" +pEmpleado.getEstado_empleado()+ "', bono_empleado = " +pEmpleado.getBono_empleado()+ ", fecha_ingreso_empleado = '" +pEmpleado.getFecha_ingreso()+ "', fecha_salida_empleado = " +pEmpleado.getFecha_salida()+ ", id_sucursal = " +pEmpleado.getId_sucursal()+ ", salario_empleado = " +pEmpleado.getSalario_empleado()+ ", porcentaje_comision = " +pEmpleado.getPorcentaje_comision()+ " where id_empleado = " +pEmpleado.getId_empleado(); 
        System.out.println("Actualizar query " +sql);
        
        try{
            System.out.println("EJECUTANDO EN ACCESO EMPLEADO SQL actualizarEmpleado: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PROVEEDOR:ACTUALIZAR_EMPLEADO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
     public ArrayList<ObjetosEmpleado> retornaNombreSucursal(){
        
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_sucursal";
        
        try{
            System.out.println("CARGANDO SUCURSALES " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosEmpleado registros;
            
            while(tabla.next()){
                System.out.println("Ejecutando WHILE ");
                registros = new ObjetosEmpleado();
                registros.setId_sucursal(tabla.getInt("id_sucursal"));
                registros.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO EMPLEADO: SELECCION SUCRUSAL");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
     
     public int retornaIdSucursal(String pNombre){
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_sucursal where nombre_sucursal = '" +pNombre+ "'";
        int registro = 0;
        
        try{
            System.out.println("Ejecutando en ACCESO EMPLEADO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            while(tabla.next()){
                registro = tabla.getInt("id_sucursal");
            }
        }catch(Exception error){
            System.out.println("ACCESO EMPLEADO: SELECCION retornaIdSucursal");
            return 0;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
     
      public ArrayList<ObjetosEmpleado> retornaEmpleados(){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select a.id_empleado, a.id_sucursal, a.tipo_empleado, a.nombre_empleado, a.estado_empleado, a.bono_empleado, a.fecha_ingreso_empleado, ifnull(a.fecha_salida_empleado, '') as fecha_salida_empleado, b.nombre_sucursal, a.salario_empleado, a.porcentaje_comision from m_empleado a, m_sucursal b where a.id_sucursal = b.id_sucursal";
        
        try{
            System.out.println("Ejecutando en ACCESO EMPLEADO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosEmpleado registros;
            
            while(tabla.next()){
                registros = new ObjetosEmpleado();
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setTipo_empleado(tabla.getString("tipo_empleado"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                registros.setEstado_empleado(tabla.getString("estado_empleado"));
                registros.setBono_empleado(tabla.getDouble("bono_empleado"));
                registros.setFecha_ingreso(tabla.getString("fecha_ingreso_empleado"));
                registros.setFecha_salida(tabla.getString("fecha_salida_empleado"));
                registros.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                registros.setSalario_empleado(tabla.getDouble("salario_empleado"));
                registros.setPorcentaje_comision(tabla.getDouble("porcentaje_comision"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO EMPLEADO: SELECCION EMPLEADO");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
      
      public ArrayList<ObjetosEmpleado> retornaIdEmpleado(String pNombre){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select a.id_empleado, a.id_sucursal, a.tipo_empleado, a.nombre_empleado, a.estado_empleado, a.bono_empleado, a.fecha_ingreso_empleado, ifnull(a.fecha_salida_empleado, '') as fecha_salida_empleado, b.nombre_sucursal, a.salario_empleado, a.porcentaje_comision from m_empleado a, m_sucursal b where a.id_sucursal = b.id_sucursal and a.nombre_empleado = '" +pNombre+ "'";
        
        try{
            System.out.println("Ejecutando en ACCESO EMPLEADO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosEmpleado registros;
            
            System.out.println("Ejecutando WHILE 2");
                
            while(tabla.next()){
                registros = new ObjetosEmpleado();
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setTipo_empleado(tabla.getString("tipo_empleado"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                registros.setEstado_empleado(tabla.getString("estado_empleado"));
                registros.setBono_empleado(tabla.getDouble("bono_empleado"));
                registros.setFecha_ingreso(tabla.getString("fecha_ingreso_empleado"));
                registros.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                registros.setFecha_salida(tabla.getString("fecha_salida_empleado"));
                registros.setSalario_empleado(tabla.getDouble("salario_empleado"));
                registros.setPorcentaje_comision(tabla.getDouble("porcentaje_comision"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO EMPLEADO: SELECCION EMPLEADO");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
      
      public ArrayList<ObjetosEmpleado> retornaEmpleado(String pNombre){
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select a.id_empleado, a.id_sucursal, a.tipo_empleado, a.nombre_empleado, a.estado_empleado, a.bono_empleado, a.fecha_ingreso_empleado, ifnull(a.fecha_salida_empleado, '') as fecha_salida_empleado, b.nombre_sucursal, a.salario_empleado, a.porcentaje_comision from m_empleado a, m_sucursal b where a.id_sucursal = b.id_sucursal and a.nombre_empleado like '%" +pNombre+ "%'";
        
        try{
            System.out.println("Ejecutando en ACCESO EMPLEADO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosEmpleado registros;
            
            System.out.println("Ejecutando WHILE 2");
                
            while(tabla.next()){
                registros = new ObjetosEmpleado();
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setTipo_empleado(tabla.getString("tipo_empleado"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                registros.setEstado_empleado(tabla.getString("estado_empleado"));
                registros.setBono_empleado(tabla.getDouble("bono_empleado"));
                registros.setFecha_ingreso(tabla.getString("fecha_ingreso_empleado"));
                registros.setNombre_sucursal(tabla.getString("nombre_sucursal"));
                registros.setFecha_salida(tabla.getString("fecha_salida_empleado"));
                registros.setSalario_empleado(tabla.getDouble("salario_empleado"));
                registros.setPorcentaje_comision(tabla.getDouble("porcentaje_comision"));
                lista.add(registros);
            }
        }catch(Exception error){
            System.out.println("ACCESO EMPLEADO: SELECCION EMPLEADO");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
      
      public String buscarNombreEmpleado(int id){
        String valor = null;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select nombre_empleado from m_empleado where id_empleado = " + id;
        try{            
            System.out.println("Ejecutando: " + sql);
            ResultSet rs = acceso.listarRegistros(sql);
            while(rs.next()){
                valor = rs.getString("nombre_empleado");
            }
        }catch(Exception error){
            System.out.println("EC ACCESO EMPLEADO : BUSCAR NOMBRE EMPLEADO "+ error);
            return null;
        } finally {
            acceso.desconectar();
        }
        return valor;
    }
}
