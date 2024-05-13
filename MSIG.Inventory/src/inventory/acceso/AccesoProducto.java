/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.acceso;

import inventory.objetos.ObjetosProducto;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class AccesoProducto {
    
    public String eliminarProducto(ObjetosProducto pProducto){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "delete m_producto where id_producto = "+pProducto.getId_producto();
        try{
            System.out.println("EJECUTANDO ACCESO PRODUCTO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PRODUCTO:ELIMINAR_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String insertarProducto(ObjetosProducto pProducto){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "insert into m_producto values ('"+pProducto.getId_producto()+
                "', '"+pProducto.getMarca_producto()+"','"+pProducto.getDesc_producto()+ "', '" +pProducto.getLinea_producto()+
                "', "+pProducto.getPrecio_compra_producto()+","+pProducto.getPrecio_est_producto()+
                ", "+pProducto.getId_proveedor()+","+pProducto.getExi_producto()+
                ", '"+pProducto.getUnidad_medida_producto()+"',"+pProducto.getMinimo_producto()+
                ", "+pProducto.getMaximo_producto()+","+pProducto.getPrj_est_producto()+
                ", "+pProducto.getPrj_min_producto()+","+pProducto.getPrecio_min_producto()+ ")";
        try{
            System.out.println("EJECUTANDO EN ACCESO PRODUCTO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "AC ACCESO_PRODUCTO:INSETAR_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarProducto(ObjetosProducto pProducto){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_producto set marca_producto = '"+pProducto.getMarca_producto()+
                "', desc_producto = '"+pProducto.getDesc_producto()+"', precio_compra_producto = "+pProducto.getPrecio_compra_producto()+
                ", linea_producto = '" +pProducto.getLinea_producto()+
                "', precio_est_producto = "+pProducto.getPrecio_est_producto()+
                ", exi_producto = "+pProducto.getExi_producto()+", id_proveedor = "+pProducto.getId_proveedor()+
                ", unidad_medida_producto = '"+pProducto.getUnidad_medida_producto()+
                "', minimo_producto = "+pProducto.getMinimo_producto()+", maximo_producto = "+pProducto.getMaximo_producto()+
                ", prj_est_producto = "+pProducto.getPrj_est_producto()+", prj_min_producto = "+pProducto.getPrj_min_producto()+
                ", precio_min_producto = "+pProducto.getPrecio_min_producto()+ " where id_producto = '"+pProducto.getId_producto()+"'";
        try{
            System.out.println("EJECUTANDO ACCESO PRODUCTO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PRODUCTO:ACTUALIZAR_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public ArrayList<ObjetosProducto>seleccionarProducto(){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_producto order by id_producto";
        try{
            System.out.println("EJECUTANDO ACCESO PRODUCTO SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            ObjetosProducto Registros;
            while(tabla.next()){
                Registros = new ObjetosProducto();
                Registros.setId_producto(tabla.getString("id_producto"));
                Registros.setMarca_producto(tabla.getString("marca_producto"));
                Registros.setDesc_producto(tabla.getString("desc_producto"));
                Registros.setLinea_producto(tabla.getString("linea_producto"));
                Registros.setPrecio_compra_producto(tabla.getFloat("precio_compra_producto"));
                Registros.setPrecio_est_producto(tabla.getFloat("precio_est_producto"));
                Registros.setId_provedor(tabla.getInt("id_proveedor"));
                Registros.setExi_producto(tabla.getFloat("exi_producto"));
                Registros.setUnidad_medida_producto(tabla.getString("unidad_medida_producto"));
                Registros.setMinimo_producto(tabla.getFloat("minimo_producto"));
                Registros.setMaximo_producto(tabla.getFloat("maximo_producto"));
                Registros.setPrj_est_producto(tabla.getFloat("prj_est_producto"));
                Registros.setPrj_min_producto(tabla.getFloat("prj_min_producto"));
                Registros.setPrecio_min_producto(tabla.getFloat("precio_min_producto"));
                lista.add(Registros);
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_PRODUCTO:SELECCIONAR_PRODUCTO "+error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public ArrayList<ObjetosProducto>buscarProducto(String pId_producto){
        ArrayList lista = new ArrayList();
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select * from m_producto where id_producto = '"+pId_producto+"'";
        
        try{
            System.out.println("EJECUANDO EN ACCESO PRODUCTO SQL: "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
            
            if(tabla != null){
                ObjetosProducto Registros;
                
                while(tabla.next()){
                    Registros = new ObjetosProducto();
                    Registros.setId_producto(tabla.getString("id_producto"));
                    Registros.setId_provedor(tabla.getInt("id_proveedor"));
                    Registros.setMarca_producto(tabla.getString("marca_producto"));
                    Registros.setDesc_producto(tabla.getString("desc_producto"));
                    Registros.setLinea_producto(tabla.getString("linea_producto"));
                    Registros.setPrecio_compra_producto(tabla.getFloat("precio_compra_producto"));
                    Registros.setPrecio_est_producto(tabla.getFloat("precio_est_producto"));
                    Registros.setExi_producto(tabla.getFloat("exi_producto"));
                    Registros.setUnidad_medida_producto(tabla.getString("unidad_medida_producto"));
                    Registros.setMaximo_producto(tabla.getFloat("maximo_producto"));
                    Registros.setMinimo_producto(tabla.getFloat("minimo_producto"));
                    Registros.setPrj_est_producto(tabla.getFloat("prj_est_producto"));
                    Registros.setPrj_min_producto(tabla.getFloat("prj_min_producto"));
                    Registros.setPrecio_min_producto(tabla.getFloat("precio_min_producto"));
                    lista.add(Registros);
                }
            }
            
        }catch(Exception error){
            System.out.println("EC ACCESO_PERSONA:BUSCAR_PRODUCTO "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return lista;
    }
    
    public String actualizarExistencia(String pId_producto, float pCantidad){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_producto set exi_producto = "+pCantidad+" where id_producto = '"+pId_producto+"'";
        try{
            System.out.println("EJECUTANDO ACCESO PRODUCTO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PRODUCTO:ACTUALIZAR_EXISTENCIA_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String disminuirExistencia(String pId_producto, float pCantidad){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_producto set exi_producto = exi_producto - " + pCantidad 
                + " where id_producto = '" + pId_producto + "'";
        try{
            System.out.println("EJECUTANDO ACCESO PRODUCTO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PRODUCTO:ACTUALIZAR_EXISTENCIA_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String actualizarPrecioCompra(String pId_producto, float pPrecioCompra){
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "update m_producto "
                + "set precio_compra_producto = "+pPrecioCompra+
                ", precio_est_producto = "+pPrecioCompra+" * (1 + (prj_est_producto/100))"
                +", precio_min_producto = "+pPrecioCompra+" * (1 + (prj_min_producto/100))"
                + " where id_producto = '"+pId_producto+"'";
        try{
            System.out.println("EJECUTANDO ACCESO PRODUCTO SQL: "+sql);
            return Acceso.ejecutarConsulta(sql);
        }catch(Error error){
            return "EC ACCESO_PRODUCTO:ACTUALIZAR_PRECIO_PRODUCTO "+error;
        } finally {
            Acceso.desconectar();
        }
    }
    
    public String buscarProveedor(int pIdProveedor){
        String cProveedor = null;
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select b.nom_persona from m_proveedor a, m_persona b where a.id_proveedor = "+
                pIdProveedor+" and b.id_persona = a.id_persona";
        try{
            System.out.println("EJECUTANDO EN ACCESO PRODUCTO SQL:  "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
        //    ObjetosProveedor Registros;
            
            while(tabla.next()){
                cProveedor = tabla.getString("nom_persona");
               
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_PRODUCTO:BUSCAR_PROVEEDOR "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return cProveedor;
    }

    public Integer buscarIdProveedor(String pNomProveedor){
        System.out.println("NOMBRE PROVEEDOR " + pNomProveedor);
        Integer cProveedor = null;
        AccesoInventario Acceso = new AccesoInventario();
        String sql = "select  a.id_proveedor from m_proveedor a, m_persona b where   b.nom_persona = '"+
                pNomProveedor+"' and a.id_persona = b.id_persona";
        
        try{
            System.out.println("EJECUTANDO EN ACCESO PRODUCTO SQL:  "+sql);
            ResultSet tabla = Acceso.listarRegistros(sql);
        //    ObjetosProveedor Registros;
            
            while(tabla.next()){
                cProveedor = tabla.getInt("id_proveedor");
               
            }
        }catch(Exception error){
            System.out.println("EC ACCESO_PRODUCTO:BUSCAR_PROVEEDOR "+ error);
            return null;
        } finally {
            Acceso.desconectar();
        }
        return cProveedor;
    }
    
    public String buscarDescripcion(String id){
        String valor = null;
        AccesoInventario acceso = new AccesoInventario();
        String sql = "select desc_producto from m_producto where id_producto = '" + id + "'";
        try{
            System.out.println("Ejecutando: " + sql);
            ResultSet rs = acceso.listarRegistros(sql);
            while(rs.next()){
                valor = rs.getString("desc_producto");
            }
        }catch(Exception error){
            System.out.println("EC ACCESO PRODUCTO : BUSCAR DESCRIPCION "+ error);
        }
        return valor;
    }
}
