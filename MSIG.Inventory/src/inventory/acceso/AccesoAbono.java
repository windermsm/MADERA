/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.acceso;

import inventory.objetos.ObjetosAbono;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */

public class AccesoAbono {
    
    public String insertarAbono(ObjetosAbono pAbono){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_abono values (0, " +pAbono.getId_factura()+ ", now(), " +pAbono.getMonto_abono()+ ", " +pAbono.getSaldo_pendiente()+ "-" +pAbono.getMonto_abono()+ ", 0, " +pAbono.getComision_sobre_abono()+ ")";
        try{
            System.out.println("EJECUTANDO EN AccesoAbono SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC AccesoAbono:insertarAbono "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosAbono>buscarCreditosCliente(String pNit){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        
        if(pNit.equals(null) || pNit.equals("")){
            pNit = "null";
        }else{
            pNit = "'" +pNit+ "'"; 
        }
        
        System.out.println("pNit " +pNit);
        
        String sql = "select c.id_factura as id_factura, a.nit_persona as nit, a.nom_persona as nombre, concat(c.num_factura, '-', serie_factura, '-', c.folio_factura) as factura, c.total_factura as total, c.monto_credito as credito, c.monto_contado as contado, c.dias_de_credito as dias_credito, sum(d.monto_abono) as total_abonado, b.id_cliente as id_cliente, a.id_persona as id_persona, c.monto_credito - sum(d.monto_abono) as saldo_pendiente from m_persona a, m_cliente b, m_factura c, m_abono d where a.id_persona = b.id_persona and b.id_cliente = c.id_cliente and c.id_factura = d.id_factura and c.tipo_venta <> 'Contado' and c.estado_factura = 'Cancelado' and a.nit_persona = ifnull(" +pNit+ ", nit_persona) group by c.id_factura, a.nit_persona, a.nom_persona";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO ABONO SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosAbono Registros;
            while(tabla.next()){
                Registros = new ObjetosAbono();
                Registros.setId_factura(tabla.getInt(1));
                Registros.setNit_persona(tabla.getString(2));
                Registros.setNom_persona(tabla.getString(3));
                Registros.setFactura(tabla.getString(4));
                Registros.setTotal(tabla.getFloat(5));
                Registros.setMonto_credito(tabla.getFloat(6));
                Registros.setMonto_contado(tabla.getInt(7));
                Registros.setDias_de_credito(tabla.getInt(8));
                Registros.setTotal_abonado(tabla.getFloat(9));
                Registros.setId_cliente(tabla.getInt(10));
                Registros.setId_persona(tabla.getInt(11));
                Registros.setSaldo_pendiente(tabla.getFloat(12));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_ABONO:buscarCliente "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public float obtieneComisionEmpleado(Integer pId_factura){
        float vPorcentaje_comision = 0;
        
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select a.porcentaje_comision from m_empleado a, m_factura b where a.id_empleado = b.id_empleado and b.id_Factura = " +pId_factura;

        try{
            ResultSet tabla = Acceso.listarRegistros(sql);
            
            while(tabla.next()){
                vPorcentaje_comision = tabla.getFloat("porcentaje_comision");
            }
        
        }catch(Exception error){
            System.out.println("EC ACCESO_ABONO:obtieneComisionEmpleado "+ error);
            return 0;
        }
        
        return vPorcentaje_comision;
    }
    
    public ArrayList<ObjetosAbono>listadoFacturasCredito(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "select id_factura, id_cliente, fecha_emision_factura, id_empleado, tipo_venta, total_factura, monto_credito, monto_contado, comision_factura, dias_de_credito, sysdate() from m_factura where estado_factura = 'Cancelado' and tipo_venta <> 'Contado'";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO ABONO listadoFacturasCredito SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosAbono Registros;
            while(tabla.next()){
                Registros = new ObjetosAbono();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setFecha_emision_factura(tabla.getString("fecha_emision_factura"));
                Registros.setId_empleado(tabla.getInt("id_empleado"));
                Registros.setTipo_venta(tabla.getString("tipo_venta"));
                Registros.setTotal_factura(tabla.getFloat("total_factura"));
                Registros.setMonto_credito(tabla.getFloat("monto_credito"));
                Registros.setMonto_contado(tabla.getFloat("monto_contado"));
                Registros.setComision_factura(tabla.getFloat("comision_factura"));
                Registros.setDias_de_credito(tabla.getInt("dias_de_credito"));
                Registros.setFecha(tabla.getString("fecha"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_ABONO:listadoFacturasCredito "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosAbono>listadoCreditosPagados(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "select id_factura, fecha_abono, monto_abono, saldo_pendiente, dias_transcurridos, comision_sobre_abono from m_abono where saldo_pendiente = 0";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO ABONO listadoCreditosPagados SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosAbono Registros;
            while(tabla.next()){
                Registros = new ObjetosAbono();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setFecha_abono(tabla.getString("fecha_abono"));
                Registros.setMonto_abono(tabla.getFloat("monto_abono"));
                Registros.setSaldo_pendiente(tabla.getFloat("saldo_pendiente"));
                Registros.setDias_transcurridos(tabla.getInt("dias_transcurridos"));
                Registros.setComision_sobre_abono(tabla.getFloat("comision_sobre_abono"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_ABONO:listadoCreditosPagados "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosAbono>listadoCreditosPendientes(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        
        String sql = "select id_factura, fecha_abono, monto_abono, saldo_pendiente, dias_transcurridos, comision_sobre_abono from m_abono where saldo_pendiente > 0";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO ABONO listadoCreditosPendientes SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosAbono Registros;
            while(tabla.next()){
                Registros = new ObjetosAbono();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setFecha_abono(tabla.getString("fecha_abono"));
                Registros.setMonto_abono(tabla.getFloat("monto_abono"));
                Registros.setSaldo_pendiente(tabla.getFloat("saldo_pendiente"));
                Registros.setDias_transcurridos(tabla.getInt("dias_transcurridos"));
                Registros.setComision_sobre_abono(tabla.getFloat("comision_sobre_abono"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_ABONO:listadoCreditosPendientes "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
}