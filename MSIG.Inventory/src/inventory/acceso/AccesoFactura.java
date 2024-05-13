/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
import inventory.objetos.ObjetosFactura;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AccesoFactura {

    public String eliminarFactura(ObjetosFactura pFactura) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete from m_factura where id_factura = " + pFactura.getId_factura();

        try {
            System.out.println("EJECUTANDO EN ACCESO FACTURA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_FACTURA: ELIMINAR_FACTURA " + error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String cobrarFactura(String no_factura) {
        
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_factura set estado_factura = 'Cancelado' where id_factura = " + no_factura;

        try {
            System.out.println("Ejecutando: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_FACTURA: ELIMINAR_FACTURA " + error;
        } finally {
            Acceso.desconectar();
        }
    }

    public String insertarFactura(ObjetosFactura pFactura) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_factura values (0, "
                + pFactura.getNumero_factura() + ", '"
                + pFactura.getSerie_factura() + "', '"
                + pFactura.getFolio_factura() + "', "
                + pFactura.getId_cliente() + ", '"
                + pFactura.getFecha_emision_factura() + "', '"
                + pFactura.getDir_envio_factura() + "', '"
                + pFactura.getEstado_factura() + "', "
                + pFactura.getId_empleado() + ", "
                + pFactura.getTotal_factura() + ", '" 
                + pFactura.getTipo_venta() + "', '"
                + pFactura.getDias_de_credito() + "', "
                + pFactura.getMonto_credito() + ", "
                + pFactura.getMonto_contado() + ", "
                + pFactura.getIva_factura() + ", "
                + pFactura.getComision_factura() + ")";
        try {
            System.out.println("EJECUTANDO EN ACCESO FACTURA SQL: " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_FACTURA:INSERTAR_FACTURA " + error;
        } finally {
            Acceso.desconectar();
        }
    }

    public String actualizarFactura(ObjetosFactura pFactura) {
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_factura set num_factura = " + pFactura.getNumero_factura()
                + ", serie_factura = '" + pFactura.getSerie_factura()
                + "', folio_factura = '" + pFactura.getFolio_factura()
                + "', id_cliente = " + pFactura.getId_cliente()
                + ", fecha_emision_factura = '" + pFactura.getFecha_emision_factura()
                + "', dir_envio_factura = '" + pFactura.getDir_envio_factura()
                + "', estado_factura = '" + pFactura.getEstado_factura()
                + "', id_empleado = " + pFactura.getId_empleado()
                + "', total_factura = " + pFactura.getTotal_factura()
                + ", tipo_venta = '" + pFactura.getTipo_venta()
                + "', dias_de_credito = '" +pFactura.getDias_de_credito()
                + "', monto_credito = " +pFactura.getMonto_credito()
                + ", monto_contado = " +pFactura.getMonto_contado()
                + ", iva_factura = " +pFactura.getIva_factura()
                + ", comision_factura = " +pFactura.getComision_factura()
                + " where id_factura = " + pFactura.getId_factura();
        try {
            System.out.println("EJECUTANDO EN ACCESO FACTURA SQL:  " + sql);
            return Acceso.ejecutarConsulta(sql);
        } catch (Error error) {
            return "EC ACCESO_FACTURA:ACTUALIZAR_FACTURA " + error;
        } finally {
            Acceso.desconectar();
        }
    }

    public ArrayList<ObjetosFactura> seleccionarFactura() {
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select  a.*,\n"
                + "        c.nom_persona as nombre_cliente\n"
                + "from    m_factura as a,\n"
                + "        m_cliente as b,\n"
                + "        m_persona as c\n"
                + "where   a.estado_factura = 'Pendiente'\n"
                + "    and a.id_cliente = b.id_cliente\n"
                + "    and b.id_persona = c.id_persona";
        try {
            System.out.println("EJECUTANDO EN ACCESO FACTURA SQL: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosFactura Registros;
            while (tabla.next()) {
                Registros = new ObjetosFactura();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setNumero_factura(tabla.getInt("num_factura"));
                Registros.setSerie_factura(tabla.getString("serie_factura"));
                Registros.setFolio_factura(tabla.getString("folio_factura"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setFecha_emision_factura(tabla.getString("fecha_emision_factura"));
                Registros.setDir_envio_factura(tabla.getString("dir_envio_factura"));
                Registros.setEstado_factura(tabla.getString("estado_factura"));
                Registros.setTotal_factura(tabla.getFloat("total_factura"));
                Registros.setTipo_venta(tabla.getString("tipo_venta"));
                Registros.setDias_de_credito(tabla.getString("dias_de_credito"));
                Registros.setMonto_credito(tabla.getFloat("monto_credito"));
                Registros.setMonto_contado(tabla.getFloat("monto_contado"));
                Registros.setIva_factura(tabla.getFloat("iva_factura"));
                Registros.setComision_factura(tabla.getFloat("comision_factura"));
                Registros.setNombre_cliente(tabla.getString("nombre_cliente"));
                lista.add(Registros);
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO_FACTURA:SELECCIONAR_FACTURA " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }

    public ArrayList<ObjetosFactura> seleccionarIdFactura(ObjetosFactura pFactura) {
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_factura where num_factura = " + pFactura.getNumero_factura()
                + " and id_cliente = " + pFactura.getId_cliente()
                + " and dir_envio_factura = '" + pFactura.getDir_envio_factura()
                + "' and total_Factura = " + pFactura.getTotal_factura()
                + " and estado_factura = 'Pendiente' "
                + " and id_factura = ( select max(id_factura) from m_factura where id_cliente = " + pFactura.getId_cliente() + ")";
        System.out.println("Ejecutando: ID Factura " + sql);
        try {
            System.out.println("EJECUTANDO EN ACCESO FACTURA SQL: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosFactura Registros;
            while (tabla.next()) {
                Registros = new ObjetosFactura();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setNumero_factura(tabla.getInt("num_factura"));
                Registros.setSerie_factura(tabla.getString("serie_factura"));
                Registros.setFolio_factura(tabla.getString("folio_factura"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setFecha_emision_factura(tabla.getString("fecha_emision_factura"));
                Registros.setDir_envio_factura(tabla.getString("dir_envio_factura"));
                Registros.setEstado_factura(tabla.getString("estado_factura"));
                Registros.setTotal_factura(tabla.getFloat("total_factura"));
                Registros.setTipo_venta(tabla.getString("tipo_venta"));
                Registros.setDias_de_credito(tabla.getString("dias_de_credito"));
                Registros.setMonto_credito(tabla.getFloat("monto_credito"));
                Registros.setMonto_contado(tabla.getFloat("monto_contado"));
                Registros.setIva_factura(tabla.getFloat("iva_factura"));
                Registros.setComision_factura(tabla.getFloat("comision_factura"));
                lista.add(Registros);
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO_FACTURA:SELECCIONAR_FACTURA " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }

    /*public ArrayList<ObjetosFactura> seleccionarFacturaFecha(String pFecha_inicial, String pFecha_final) {
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * "
                + "from m_factura "
                + "where date_format(fecha_emision_factura, '%Y-%m-%d') between '"
                + pFecha_inicial
                + "' and '"
                + pFecha_final
                + "' order by fecha_emision_factura";

        try {
            System.out.println("EJECUTANDO EN ACCESO FACTURA SQL: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosFactura Registros;
            while (tabla.next()) {
                Registros = new ObjetosFactura();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setNumero_factura(tabla.getInt("num_factura"));
                Registros.setSerie_factura(tabla.getString("serie_factura"));
                Registros.setFolio_factura(tabla.getString("folio_factura"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setFecha_emision_factura(tabla.getString("fecha_emision_factura"));
                Registros.setDir_envio_factura(tabla.getString("dir_envio_factura"));
                Registros.setEstado_factura(tabla.getString("estado_factura"));
                Registros.setTotal_factura(tabla.getFloat("total_factura"));
                Registros.setTipo_venta(tabla.getString("tipo_venta"));
                Registros.setDias_de_credito(tabla.getString("dias_de_credito"));
                Registros.setMonto_credito(tabla.getFloat("monto_credito"));
                Registros.setMonto_contado(tabla.getFloat("monto_contado"));
                Registros.setIva_factura(tabla.getFloat("iva_factura"));
                Registros.setComision_factura(tabla.getFloat("comision_factura"));
                lista.add(Registros);
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO_FACTURA:SELECCIONAR_FACTURA_FECHA " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }*/
    
    public ArrayList<ObjetosFactura> seleccionarFacturaFecha(String pFecha_inicial, String pFecha_final) {
        ArrayList lista = new ArrayList(); System.out.println("1");
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select  a.*,\n"
                + "        d.nom_persona as nombre_factura,\n"
                + "        b.serie_factura_fel,\n"
                + "        b.numero_factura_fel,\n"
                + "        b.autorizacion_factura_fel,\n"  
                + "        b.tipo_documento_factura_fel\n"
                + "from    m_factura as a left join m_factura_fel as b on a.id_factura = b.id_factura,\n"
                + "        m_cliente as c,\n"
                + "        m_persona as d\n"
                + "where a.id_cliente = c.id_cliente\n"
                + "  and c.id_persona = d.id_persona\n"
                + "  and str_to_date(date_format(a.fecha_emision_factura, '%Y-%m-%d'), '%Y-%m-%d') between str_to_date('" + pFecha_inicial + "', '%Y-%m-%d')  and str_to_date('" + pFecha_final + "', '%Y-%m-%d') \n"
                + "order by a.fecha_emision_factura DESC";
        try {
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosFactura Registros;
            while (tabla.next()) {
                Registros = new ObjetosFactura();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setNumero_factura(tabla.getInt("num_factura"));
                Registros.setSerie_factura(tabla.getString("serie_factura"));
                Registros.setFolio_factura(tabla.getString("folio_factura"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setFecha_emision_factura(tabla.getString("fecha_emision_factura"));
                Registros.setDir_envio_factura(tabla.getString("dir_envio_factura"));
                Registros.setEstado_factura(tabla.getString("estado_factura"));
                Registros.setTotal_bruto_factura(tabla.getFloat("total_factura"));
                Registros.setTotal_factura(tabla.getFloat("total_factura"));
                Registros.setTipo_venta(tabla.getString("tipo_venta"));
                Registros.setDias_de_credito(tabla.getString("dias_de_credito"));
                Registros.setMonto_credito(tabla.getFloat("monto_credito"));
                Registros.setMonto_contado(tabla.getFloat("monto_contado"));
                Registros.setIva_factura(tabla.getFloat("iva_factura"));
                Registros.setComision_factura(tabla.getFloat("comision_factura"));
                Registros.setNombre_factura(tabla.getString("nombre_factura"));
                Registros.setSerie_factura_fel(tabla.getString("serie_factura_fel"));
                Registros.setNumero_factura_fel(tabla.getString("numero_factura_fel"));
                Registros.setAtorizacion_fel(tabla.getString("autorizacion_factura_fel"));
                //Validar si viene null al no tener factura FEL 
                String valor = "";
                if(tabla.getString("tipo_documento_factura_fel") == null || tabla.getString("tipo_documento_factura_fel").toString().equals("null")) {
                    valor = "S/F";
                } else {
                    valor = tabla.getString("tipo_documento_factura_fel");
                }
                Registros.setTipo_documento_factura_fel(valor);
                lista.add(Registros);
            }
        } catch (Exception error) {
            return null;
        } finally {
            Acceso.desconectar();
        } System.out.println("7");
        return lista; 
    }

    public int retornaNumeroCorrelativo(String pIdFactura) {
        int registro = 0;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_factura_correlativo where id_factura = '" + pIdFactura + "'";
        try {
            ResultSet tabla = acceso.listarRegistros(sql);
            while (tabla.next()) {
                registro = tabla.getInt("correlativo");
            }
        } catch (Exception error) {
            System.out.println("ACCESO USUARIO: RETORNA NUMERO CORRELATIVO");
            return 0;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
    
    public int retornaIDEmpleado(String pNombre) {
        int registro = 0;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select id_empleado from m_empleado where nombre_empleado = '" + pNombre + "'";

        try {
            ResultSet tabla = acceso.listarRegistros(sql);

            while (tabla.next()) {
                registro = tabla.getInt("id_empleado");
            }
        } catch (Exception error) {
            System.out.println("ACCESO USUARIO: SELECCION USUARIO");
            return 0;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }

    public ArrayList<ObjetosFactura> retornaNombreEmpleados() {
        ArrayList lista = new ArrayList();
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select * from m_empleado";

        try {
            System.out.println("Ejecutando en ACCESO USUARIO SQL " + sql);
            ResultSet tabla = acceso.listarRegistros(sql);
            ObjetosFactura registros;

            while (tabla.next()) {
                registros = new ObjetosFactura();
                registros.setId_empleado(tabla.getInt("id_empleado"));
                registros.setNombre_empleado(tabla.getString("nombre_empleado"));
                lista.add(registros);
            }
        } catch (Exception error) {
            System.out.println("ACCESO USUARIO: SELECCION USUARIO");
            return null;
        } finally {
            acceso.desconectar();
        }
        return lista;
    }
    
    public float retornaComisionEmpleado(int pIdEmpleado) {
        float registro = 0;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select porcentaje_comision from m_empleado where id_empleado = " + pIdEmpleado;
        
        
        try {
            ResultSet tabla = acceso.listarRegistros(sql);

            while (tabla.next()) {
                registro = tabla.getFloat("porcentaje_comision");
            }
        } catch (Exception error) {
            System.out.println("ACCESO FACTURA: retornaComisionEmpleado " + error);
            return 0;
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
    
    public float retornaCreditoDisponible(String pNit) {
        float registro = 0;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select (b.limite_credito - (sum(c.total_factura))) credito_disponible from m_persona a, m_cliente b, m_factura c where   a.id_persona = b.id_persona and b.id_cliente = c.id_cliente and c.estado_factura = 'Cancelado' and c.tipo_venta <> 'Contado' and a.nit_persona = '" +pNit+ "'";
        System.out.println(sql);
        
        try {
            ResultSet tabla = acceso.listarRegistros(sql);

            while (tabla.next()) {
                registro = tabla.getFloat(1);
            }
            
            if(registro == 0.0){
                sql = "select  b.limite_credito from m_persona a, m_cliente b where a.id_persona = b.id_persona and a.nit_persona = '" +pNit+ "'";
            
                try{
                    tabla = acceso.listarRegistros(sql);
                    
                    while (tabla.next()) {
                    registro = tabla.getFloat(1);
                }
                    
                }catch(Exception error){
                    System.out.println("ACCESO FACTURA: retornaLimiteCredito " + error);
                    return 0;
                }
            
            }
            
            
        } catch (Exception error) {
            System.out.println("ACCESO FACTURA: retornaLimiteCredito " + error);
            return 0;
        } finally {
            acceso.desconectar();
        }
        System.out.println("REGISTRO " + registro);
        return registro;
    }
    
    public String retornaCategoriaCliente(String pNit) {
        String registro = "";
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select c.tipo_cliente from m_persona a, m_cliente b, m_cliente c where a.id_persona = b.id_persona and b.id_cliente = c.id_cliente and a.nit_persona = '" +pNit+ "'";
        
        
        try {
            ResultSet tabla = acceso.listarRegistros(sql);

            while (tabla.next()) {
                registro = tabla.getString("tipo_cliente");
            }
        } catch (Exception error) {
            System.out.println("ACCESO FACTURA: retornaLimiteCredito " + error);
            return "";
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
    
    public String retornatRolUsuario(String pUsuario){
        String registro = "";
        
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select tipo_usuario from m_usuario where nombre_usuario = '" +pUsuario+ "'";
        
        try{
            ResultSet tabla = acceso.listarRegistros(sql);
            
            while(tabla.next()){
                registro = tabla.getString("tipo_usuario");
            }
        }catch(Exception error){
            System.out.println("ACCESO FACTURA: retornaLimiteCredito " + error);
            return "";
        } finally {
            acceso.desconectar();
        }
        return registro;
    }
    
    public ArrayList<ObjetosFactura> buscarFacturaPorId(String id_factura) {
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_factura where id_factura = " + id_factura;
        
        try {
            System.out.println("EJECUTANDO: " + sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosFactura Registros;
            while (tabla.next()) {
                Registros = new ObjetosFactura();
                Registros.setId_factura(tabla.getInt("id_factura"));
                Registros.setNumero_factura(tabla.getInt("num_factura"));
                Registros.setSerie_factura(tabla.getString("serie_factura"));
                Registros.setFolio_factura(tabla.getString("folio_factura"));
                Registros.setId_cliente(tabla.getInt("id_cliente"));
                Registros.setFecha_emision_factura(tabla.getString("fecha_emision_factura"));
                Registros.setDir_envio_factura(tabla.getString("dir_envio_factura"));
                Registros.setEstado_factura(tabla.getString("estado_factura"));
                Registros.setTotal_factura(tabla.getFloat("total_factura"));
                Registros.setTipo_venta(tabla.getString("tipo_venta"));
                Registros.setDias_de_credito(tabla.getString("dias_de_credito"));
                Registros.setMonto_credito(tabla.getFloat("monto_credito"));
                Registros.setMonto_contado(tabla.getFloat("monto_contado"));
                Registros.setIva_factura(tabla.getFloat("iva_factura"));
                Registros.setComision_factura(tabla.getFloat("comision_factura"));
                lista.add(Registros);
                
                System.out.println("Salio de la consulta de la factura OK");
            }
        } catch (Exception error) {
            System.out.println("EC ACCESO_FACTURA:BUSCAR_FACTURA_POR_FECHA " + error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
}
