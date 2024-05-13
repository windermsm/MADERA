/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.objetos;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class ObjetosAbono {
    
    private int id_abono;
    private int id_cliente;
    private int id_persona;
    private int id_factura;
    private String fecha_abono;
    private float monto_abono;
    private float saldo_disponible;
    private int dias_transcurridos;
    private float comision_sobre_abono;
    private String nit_persona;
    private String nom_persona;
    private String factura;
    private float total;
    private float monto_credito;
    private float monto_contado;
    private int dias_de_credito;
    private float total_abonado;
    private float saldo_pendiente;
    private String fecha_emision_factura;
    private float total_factura;
    private int id_empleado;
    private String estado_factura;
    private String tipo_venta;
    private float iva_factura;
    private float comision_factura;
    private String fecha;
    
    public int getId_abono() {
        int vId_abono = 0;
        try{
            vId_abono = id_abono;
        }catch(Error error){
            System.out.println("EC ABONO:getId_abono "+error);
        }
        return vId_abono;
    }

    public void setId_abono(int pId_abono){
        try{
            id_abono = pId_abono;
        }catch(Error error){
            System.out.println("EC ABONO:setId_abono " + error);
        }
    }
    
    public int getId_cliente() {
        int vId_cliente = 0;
        try{
            vId_cliente = id_cliente;
        }catch(Error error){
            System.out.println("EC ABONO:getId_cliente "+error);
        }
        return vId_cliente;
    }

    public void setId_cliente(int pId_cliente){
        try{
            id_cliente = pId_cliente;
        }catch(Error error){
            System.out.println("EC ABONO:setId_cliente " + error);
        }
    }
    
    public int getId_persona() {
        int vId_persona = 0;
        try{
            vId_persona = id_persona;
        }catch(Error error){
            System.out.println("EC ABONO:getId_persona "+error);
        }
        return vId_persona;
    }

    public void setId_persona(int pId_persona){
        try{
            id_persona = pId_persona;
        }catch(Error error){
            System.out.println("EC ABONO:setId_persona " + error);
        }
    }
    
    public int getId_factura() {
        int vId_factura = 0;
        try{
            vId_factura = id_factura;
        }catch(Error error){
            System.out.println("EC ABONO:GETID_FACTURA "+error);
        }
        return vId_factura;
    }

    public void setId_factura(int pId_factura){
        try{
            id_factura = pId_factura;
        }catch(Error error){
            System.out.println("EC ABONO:SETID_FACTURA " + error);
        }
    }
    
    public String getFecha_abono(){
        String vFecha_abono = null;
        try{
            vFecha_abono = fecha_abono;
        }catch(Error error){
            System.out.println("EC ABONO:getFecha_abono "+error);
        }
        return vFecha_abono;
    }
    
    public void setFecha_abono(String pFecha_abono){
        try{
            fecha_abono = pFecha_abono;
        }catch(Error error){
            System.out.println("EC ABONO:setFecha_abono "+error);
        }
    }
    
    public float getMonto_abono(){
        float vMonto_abono = 0;
        try{
            vMonto_abono = monto_abono;
        }catch(Error error){
            System.out.println("EC ABONO:getMonto_abono "+error);
        }
        return vMonto_abono;
    }
    
    public void setMonto_abono(float pMonto_abono){
        try{
            monto_abono = pMonto_abono;
        }catch(Error error){
            System.out.println("EC ABONO:setMonto_abono "+error);
        }
    }
    
    public float getSaldo_disponible(){
        float vSaldo_disponible = 0;
        try{
            vSaldo_disponible = saldo_disponible;
        }catch(Error error){
            System.out.println("EC ABONO:getSaldo_disponible "+error);
        }
        return vSaldo_disponible;
    }
    
    public void setSaldo_disponibles(float pSaldo_disponible){
        try{
            saldo_disponible = pSaldo_disponible;
        }catch(Error error){
            System.out.println("EC ABONO:setSaldo_disponibles "+error);
        }
    }
    
    public int getDias_transcurridos() {
        int vDias_transcurridos = 0;
        try{
            vDias_transcurridos = dias_transcurridos;
        }catch(Error error){
            System.out.println("EC ABONO:getDias_transcurridos "+error);
        }
        return vDias_transcurridos;
    }

    public void setDias_transcurridos(int pDias_transcurridos){
        try{
            dias_transcurridos = pDias_transcurridos;
        }catch(Error error){
            System.out.println("EC ABONO:setDias_transcurridos " + error);
        }
    }
    
    public float getComision_sobre_abono(){
        float vComision = 0;
        try{
            vComision = comision_sobre_abono;
        }catch(Error error){
            System.out.println("EC ABONO:getComision_sobre_abono "+error);
        }
        return vComision;
    }
    
    public void setComision_sobre_abono(float pComision){
        try{
            comision_sobre_abono = pComision;
        }catch(Error error){
            System.out.println("EC ABONO:setComision_sobre_abono "+error);
        }
    }
    
    public String getNit_persona(){
        String vNit_persona = null;
        try{
            vNit_persona = nit_persona;
        }catch(Error error){
            System.out.println("EC ABONO:GETNIT "+error);
        }
        return vNit_persona;
    }
    
    public void setNit_persona(String pNit_persona){
        try{
            nit_persona = pNit_persona;
        }catch(Error error){
            System.out.println("EC ABONO:GETNIT "+error);
        }
    }
    
    public String getNom_persona(){
        String vNom_persona = null;
        try{
            vNom_persona = nom_persona;
        }catch(Error error){
            System.out.println("EC ABONO:GETNOM_PERSONA "+error);
        }
        return vNom_persona;
    }
    
    public void setNom_persona(String pNom_persona){
        try{
            nom_persona = pNom_persona;
        }catch(Error error){
            System.out.println("EC ABONO:GETNOM_PERSONA "+error);
        }
    }
    
    public String getFactura(){
        String vFactura = null;
        try{
            vFactura = factura;
        }catch(Error error){
            System.out.println("EC ABONO:getFactura "+error);
        }
        return vFactura;
    }
    
    public void setFactura(String pFactura){
        try{
            factura = pFactura;
        }catch(Error error){
            System.out.println("EC ABONO:pFactura "+error);
        }
    }
    
    public float getTotal(){
        float vTotal = 0;
        try{
            vTotal = total;
        }catch(Error error){
            System.out.println("EC ABONO:getTotal "+error);
        }
        return vTotal;
    }
    
    public void setTotal(float pTotal){
        try{
            total = pTotal;
        }catch(Error error){
            System.out.println("EC ABONO:setTotal "+error);
        }
    }
    
     public float getMonto_credito(){
        float vMonto_credito = 0;
        try{
            vMonto_credito = monto_credito;
        }catch(Error error){
            System.out.println("EC ABONO:getMonto_credito "+error);
        }
        return vMonto_credito;
    }
    
    public void setMonto_credito(float pMonto_credito){
        try{
            monto_credito = pMonto_credito;
        }catch(Error error){
            System.out.println("EC ABONO:setMonto_credito "+error);
        }
    }
    
    public float getMonto_contado(){
        float vMonto_contado = 0;
        try{
            vMonto_contado = monto_contado;
        }catch(Error error){
            System.out.println("EC ABONO:getMonto_contado "+error);
        }
        return vMonto_contado;
    }
    
    public void setMonto_contado(float pMonto_contado){
        try{
            monto_contado = pMonto_contado;
        }catch(Error error){
            System.out.println("EC ABONO:setMonto_contado "+error);
        }
    }
    
    public int getDias_de_credito(){
        int vDias_de_credito = 0;
        try{
            vDias_de_credito = dias_de_credito;
        }catch(Error error){
            System.out.println("EC ABONO:getDias_de_credito "+error);
        }
        return vDias_de_credito;
    }
    
    public void setDias_de_credito(int pDias_de_credito){
        try{
            dias_de_credito = pDias_de_credito;
        }catch(Error error){
            System.out.println("EC ABONO:setDias_de_credito "+error);
        }
    }
    
    public float getTotal_abonado(){
        float vTotal_abonado = 0;
        try{
            vTotal_abonado = total_abonado;
        }catch(Error error){
            System.out.println("EC ABONO:getTotal_abonado "+error);
        }
        return vTotal_abonado;
    }
    
    public void setTotal_abonado(float pTotal_abonado){
        try{
            total_abonado = pTotal_abonado;
        }catch(Error error){
            System.out.println("EC ABONO:setTotal_abonado "+error);
        }
    }
    
    public float getSaldo_pendiente(){
        float vSaldo_pendiente = 0;
        try{
            vSaldo_pendiente = saldo_pendiente;
        }catch(Error error){
            System.out.println("EC ABONO:getSaldo_pendiente "+error);
        }
        return vSaldo_pendiente;
    }
    
    public void setSaldo_pendiente(float pSaldo_pendiente){
        try{
            saldo_pendiente = pSaldo_pendiente;
        }catch(Error error){
            System.out.println("EC ABONO:setSaldo_pendiente "+error);
        }
    }
    
    public String getFecha_emision_factura(){
        String vFecha_emision_factura = null;
        try{
            vFecha_emision_factura = fecha_emision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETFECHA_EMISION_FACTURA "+error);
        }
        return vFecha_emision_factura;
    }
    
    public void setFecha_emision_factura(String pFecha_emision_factura){
        try{
            fecha_emision_factura = pFecha_emision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETFECHA_EMISION_FACTURA "+error);
        }
    }
    
    public float getTotal_factura(){
        float vTotal_factura = 0;
        try{
            vTotal_factura = total_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:GETTOTAL_FACTURA "+error);
        }
        return vTotal_factura;
    }
    
    public void setTotal_factura(float pTotal_factura){
        try{
            total_factura = pTotal_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:SETTOTAL_FACTURA "+error);
        }
    }
    
    public int getId_empleado() {
        int vId_empleado = 0;
        try{
            vId_empleado = id_empleado;
        }catch(Error error){
            System.out.println("EC FACTURA:getId_empleado "+error);
        }
        return vId_empleado;
    }

    public void setId_empleado(int pId_empledo){
        try{
            id_empleado = pId_empledo;
        }catch(Error error){
            System.out.println("EC FACTURA:setId_empleado " + error);
        }
    }
    
    public String getEstado_factura(){
        String vEstado_factura = null;
        try{
            vEstado_factura = estado_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:getEstado_factura "+error);
        }
        return vEstado_factura;
    }
    
    public void setEstado_factura(String pEstado_factura){
        try{
            estado_factura = pEstado_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:setEstado_factura "+error);
        }
    }
    
    public String getTipo_venta(){
        String vTipo_venta = null;
        try{
            vTipo_venta = tipo_venta;
        }catch(Error error){
            System.out.println("EC FACTURA:getTipo_venta "+error);
        }
        return vTipo_venta;
    }
    
    public void setTipo_venta(String pTipo_venta){
        try{
            tipo_venta = pTipo_venta;
        }catch(Error error){
            System.out.println("EC FACTURA:setTipo_venta "+error);
        }
    }
    
    public float getIva_factura(){
        float vIva_factura = 0;
        try{
            vIva_factura = iva_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:getIva_factura "+error);
        }
        return vIva_factura;
    }
    
    public void setIva_factura(float pIva_factura){
        try{
            iva_factura = pIva_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:setIva_factura "+error);
        }
    }
    
    public float getComision_factura(){
        float vComision_factura = 0;
        try{
            vComision_factura = comision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:getComision_factura "+error);
        }
        return vComision_factura;
    }
    
    public void setComision_factura(float pComision_factura){
        try{
            comision_factura = pComision_factura;
        }catch(Error error){
            System.out.println("EC FACTURA:setComision_factura "+error);
        }
    }
    
    public String getFecha(){
        String vFecha = null;
        try{
            vFecha = fecha;
        }catch(Error error){
            System.out.println("EC ABONO:getFecha "+error);
        }
        return vFecha;
    }
    
    public void setFecha(String pFecha){
        try{
            fecha = pFecha;
        }catch(Error error){
            System.out.println("EC ABONO:setFecha "+error);
        }
    }
   
}
