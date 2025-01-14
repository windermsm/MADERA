/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.vistas;

import inventory.acceso.AccesoArchivo;
import inventory.acceso.AccesoCliente;
import inventory.acceso.AccesoExcepciones;
import inventory.acceso.AccesoFactura;
import inventory.acceso.AccesoFacturaFEL;
import inventory.acceso.AccesoInventario;
import inventory.acceso.AccesoSucursal;
import inventory.guatefacturas.GenerarDocumentoFEL;
import inventory.guatefacturas.GenerarDocumentoSinDecimalesFEL;
import inventory.guatefacturas.Resultado;
import inventory.objetos.ObjetosFactura;
import inventory.objetos.ObjetosFacturaFel;
import inventory.objetos.ObjetosSucursal;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */


public class wdwBaseDeDAtosHistorialDeVentas extends javax.swing.JInternalFrame {

    /**
     * Creates new form wdwBaseDeDAtosHistorialDeVentas
     */
    public wdwBaseDeDAtosHistorialDeVentas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    //VARIABLES GLOBALES
    AccesoFactura NuevaFactura = new AccesoFactura();
    AccesoExcepciones Mensaje = new AccesoExcepciones();
    AccesoArchivo archivo = new AccesoArchivo();
    
    private void mostrarRegistrosGuardados(String pFecha_incial , String pFecha_final){
        
        DefaultTableModel tabla = new DefaultTableModel();
        
        ArrayList<ObjetosFactura> listaFacturas = new ArrayList();
        
        //VERIFICAR ALGUN ERROR AL CARGAR LA INFORMACION DE LAS FACTURAS
        try{
            listaFacturas = NuevaFactura.seleccionarFacturaFecha(pFecha_incial, pFecha_final);
            System.out.println("SE CONSULTARON LOS DATOS DE LAS FACTURAS");
        }catch(Error error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar la informacion -> "+error);
        }
        
        //MOSTRAR LA INFORMACION DE LAS FACTURAS EN LA VITAS
        if(listaFacturas.isEmpty()){
            Mensaje.manipulacionExcepciones("critico", "No existen datos almacenados de las ventas");
        } else {
            tabla.addColumn("ID Venta");
            tabla.addColumn("No. Factura");
            tabla.addColumn("Serie");
            tabla.addColumn("Folio");
            tabla.addColumn("Fecha");
            tabla.addColumn("Total");
            tabla.addColumn("Serie FEL");
            tabla.addColumn("Numero FEL");
            tabla.addColumn("Autorizacion FEL");
            tabla.addColumn("Tipo Documento");
            tabla.addColumn("Nombre");
            tabla.setRowCount(listaFacturas.size());
            int cFactura = 0;
            
            for (ObjetosFactura xFactura : listaFacturas) {
                tabla.setValueAt(xFactura.getId_factura(), cFactura, 0);
                tabla.setValueAt(xFactura.getNumero_factura(), cFactura, 1);
                tabla.setValueAt(xFactura.getSerie_factura(), cFactura, 2);
                tabla.setValueAt(xFactura.getFolio_factura(), cFactura, 3);
                tabla.setValueAt(xFactura.getFecha_emision_factura(), cFactura, 4);
                tabla.setValueAt(xFactura.getTotal_factura(), cFactura, 5);
                tabla.setValueAt(xFactura.getSerie_factura_fel(), cFactura, 6);
                tabla.setValueAt(xFactura.getNumero_factura_fel(), cFactura, 7);
                tabla.setValueAt(xFactura.getAtorizacion_fel(), cFactura, 8);
                tabla.setValueAt(xFactura.getTipo_documento_factura_fel(), cFactura, 9);
                tabla.setValueAt(xFactura.getNombre_factura(), cFactura, 10);
                cFactura++;
            }
            
            tblDetalleVenta.setModel(tabla);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        pnlBotones = new javax.swing.JPanel();
        lblIdVenta = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        txtFechaFinal = new javax.swing.JTextField();
        lblHasta = new javax.swing.JLabel();
        txtFechaInicial = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        btnReporte = new javax.swing.JButton();
        btnTicket = new javax.swing.JButton();
        cbxTipoImpresion = new javax.swing.JComboBox<>();
        cbxTamanoImpresion = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        txtSerieFacturaFEL = new javax.swing.JTextField();
        txtNumFacturaFEL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAutorizacionFEL = new javax.swing.JTextField();
        btnGeneraFEL = new javax.swing.JButton();
        cbxTipoDocumento = new javax.swing.JComboBox<>();
        txtNombrePersona = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTipoDocumentoFEL = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Historial de Ventas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/historialVentas.png"))); // NOI18N

        pnlDetalle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venta", "Num. Factura", "Serie", "Folio", "Fecha", "Total", "Serie FEL", "Numero FEL", "Autorizacion FEL", "Tipo Documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalleVenta);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblIdVenta.setText("ID Venta");

        txtIdVenta.setToolTipText("Ingrese el ID de la venta o seleccionela de la lista de busqueda");

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        lblHasta.setText("Hasta");

        lblFecha.setText("Desde");

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/impresora.png"))); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/invoice.png"))); // NOI18N
        btnTicket.setToolTipText("Imprimir Comprobante de pago");
        btnTicket.setActionCommand("imprimirEnvio");
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
            }
        });

        cbxTipoImpresion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comprobante", "Factura Electronica", "Envio" }));

        cbxTamanoImpresion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carta", "1/2 Carta", "TMU 2.5" }));

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxTipoImpresion, 0, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTamanoImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTicket)
                .addGap(18, 18, 18)
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHasta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMostrar)
                .addContainerGap())
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTicket)
                    .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMostrar)
                        .addComponent(txtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHasta)
                        .addComponent(txtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFecha)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIdVenta)
                        .addComponent(cbxTipoImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxTamanoImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnReporte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSerieFacturaFEL.setEditable(false);
        txtSerieFacturaFEL.setBackground(new java.awt.Color(102, 102, 102));
        txtSerieFacturaFEL.setForeground(new java.awt.Color(255, 255, 255));
        txtSerieFacturaFEL.setText("0");

        txtNumFacturaFEL.setEditable(false);
        txtNumFacturaFEL.setBackground(new java.awt.Color(102, 102, 102));
        txtNumFacturaFEL.setForeground(new java.awt.Color(255, 255, 255));
        txtNumFacturaFEL.setText("0");

        jLabel4.setText("Serie");

        jLabel5.setText("Numero");

        jLabel6.setText("Autorizacion");

        txtAutorizacionFEL.setEditable(false);
        txtAutorizacionFEL.setBackground(new java.awt.Color(102, 102, 102));
        txtAutorizacionFEL.setForeground(new java.awt.Color(255, 255, 255));
        txtAutorizacionFEL.setText("0");

        btnGeneraFEL.setText("FEL");
        btnGeneraFEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneraFELActionPerformed(evt);
            }
        });

        cbxTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NIT", "DPI", "PAS" }));

        txtNombrePersona.setEditable(false);
        txtNombrePersona.setBackground(new java.awt.Color(102, 102, 102));
        txtNombrePersona.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombrre");

        txtTipoDocumentoFEL.setEditable(false);
        txtTipoDocumentoFEL.setBackground(new java.awt.Color(102, 102, 102));
        txtTipoDocumentoFEL.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSerieFacturaFEL, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumFacturaFEL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtAutorizacionFEL))
                    .addComponent(txtNombrePersona))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGeneraFEL))
                    .addComponent(txtTipoDocumentoFEL))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumFacturaFEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSerieFacturaFEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtAutorizacionFEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGeneraFEL)
                    .addComponent(cbxTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtTipoDocumentoFEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        if (txtFechaInicial.getText().isEmpty() || txtFechaFinal.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Por favor ingrese la Fechas");
        } else {
            mostrarRegistrosGuardados(txtFechaInicial.getText(), txtFechaFinal.getText());
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void tblDetalleVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleVentaMouseClicked

        if (String.valueOf(tblDetalleVenta.getSelectedColumn()).equals("0")) {   
            
            int fila_seleccionada = tblDetalleVenta.getSelectedRow();
            txtIdVenta.setText(tblDetalleVenta.getValueAt(fila_seleccionada, 0).toString());
            txtNombrePersona.setText(tblDetalleVenta.getValueAt(fila_seleccionada, 10).toString());
            
            //Buscar los datos de FEL
            String id = txtIdVenta.getText();
            
            if (!id.isEmpty()) {
                
                AccesoFacturaFEL FEL = new AccesoFacturaFEL();
                ObjetosFacturaFel FAC = new ObjetosFacturaFel();
                FAC = FEL.buscarFacturaFEL(id, "Historial Ventas", Inventory.lblUsuario.getText(), "");
                this.txtSerieFacturaFEL.setText(FAC.getSerie_factura_fel());
                this.txtNumFacturaFEL.setText(FAC.getNumero_factura_fel());
                this.txtAutorizacionFEL.setText(FAC.getAutorizacion_factura_fel());
                this.txtTipoDocumentoFEL.setText(FAC.getTipo_documento_factura_fel());
                
                if(FAC.getNumero_factura_fel().equals("0") || FAC.getNumero_factura_fel().isEmpty()) {
                    this.btnGeneraFEL.setEnabled(true);
                    this.cbxTipoImpresion.setSelectedItem("Comprobante");
                } else {
                    this.btnGeneraFEL.setEnabled(false);
                    this.cbxTipoImpresion.setSelectedItem("Factura Electronica");
                }
                
            } else {
                this.txtSerieFacturaFEL.setText("");
                this.txtNumFacturaFEL.setText("");
                this.txtAutorizacionFEL.setText("");
                this.cbxTipoImpresion.setSelectedItem("Comprobante");
            }
            
        }
        
    }//GEN-LAST:event_tblDetalleVentaMouseClicked

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        
        String archivo_jasper = "";
        String regimen_empresa = "";
      
        //El mensaje del regimen de la factura se toma del archivo de texto
        try {
            regimen_empresa = archivo.leer("[Regimen]");
        } catch (IOException ex) {
            regimen_empresa = "";
        }
        
        if (cbxTipoImpresion.getSelectedItem().equals("Comprobante")) {
            if (cbxTamanoImpresion.getSelectedItem().equals("Carta"))
                archivo_jasper = "rptComprobanteCarta";
            if(cbxTamanoImpresion.getSelectedItem().equals("1/2 Carta"))
                archivo_jasper = "rptComprobanteMediaCarta";
            if(cbxTamanoImpresion.getSelectedItem().equals("TMU 2.5"))
                archivo_jasper = "rptComprobanteTMU";
        }
        
        if (cbxTipoImpresion.getSelectedItem().equals("Factura Electronica")) {
            if (cbxTamanoImpresion.getSelectedItem().equals("Carta"))
                archivo_jasper = "rptFacturaCarta";
            if (cbxTamanoImpresion.getSelectedItem().equals("1/2 Carta"))
                archivo_jasper = "rptFacturaMediaCarta";
            if (cbxTamanoImpresion.getSelectedItem().equals("TMU 2.5"))
                archivo_jasper = "rptFacturaTMU";
        }
        
        if (cbxTipoImpresion.getSelectedItem().equals("Envio")) {
                archivo_jasper = "rptEnvio";
        }
        
        //ejecución del repote seleccionado
        try{
            
            AccesoInventario acceso_inventario = new AccesoInventario();
            AccesoSucursal acceso_sucursal = new AccesoSucursal();
            ObjetosSucursal objeto_sucursal = new ObjetosSucursal();
            
            URL url_reporte = this.getClass().getResource("/inventory/reportes/" + archivo_jasper + ".jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(url_reporte);
            HashMap parametro = new HashMap();
            
            //parametros generales del encabezado
            objeto_sucursal = acceso_sucursal.buscarSucursales(1, Inventory.lblUsuario.getText(), "");
            
            //parametros del reporte
            parametro.put("P_SERIE_FACTURA", "A");
            parametro.put("P_NUMERO_FACTURA", txtIdVenta.getText());
            parametro.put("P_ID_FACTURA", Integer.parseInt(txtIdVenta.getText()));
            parametro.put("P_DIRECCION_SUCURSAL", objeto_sucursal.getDireccion_sucursal());
            parametro.put("P_NIT", objeto_sucursal.getNit_sucursal().toString().toUpperCase());
            parametro.put("P_NOMBRE_EMPRESA", objeto_sucursal.getNombre_sucursal());
            parametro.put("P_SUCURSAL", objeto_sucursal.getDescripcion_sucursal());
            parametro.put("P_TELEFONO", objeto_sucursal.getTelefonos_sucursal());
            
            //parametros configuracion sistema
            parametro.put("P_REGIMEN_EMPRESA", regimen_empresa);
            
            //parametro para la impresión de vales
            parametro.put("P_RECIBIDO", "");
            
            //parametros facturación FEL implementarlos solo si se desea
            //obtener facturacion electronica de la venta realizada
            parametro.put("P_SERIE_FEL", txtSerieFacturaFEL.getText());
            parametro.put("P_NUMERO_FEL", txtNumFacturaFEL.getText());
            parametro.put("P_AUTORIZACION_FEL", txtAutorizacionFEL.getText());
            
            JasperPrint pantalla = JasperFillManager.fillReport(reporte, parametro, acceso_inventario.conectar());
            JInternalFrame ventana = new JInternalFrame("Inventory 3.0");
            ventana.getContentPane().add(new JRViewer(pantalla));
            ventana.setPreferredSize(new Dimension(900, 500));
            ventana.setClosable(true);
            ventana.setMaximizable(true);
            ventana.setResizable(true);
            ventana.setVisible(true);
            ventana.pack();
            
            int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
            int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
            int x  = (ancho  - ventana.getWidth() ) / 2;
            int y  = ( alto - ventana.getHeight() - 100 ) / 2;
            
            Inventory.pnlPrincipal.add(ventana);
            
            ventana.setLocation(x, y);
            ventana.setVisible(true);
            ventana.toFront();
            
        } catch (JRException error) {
            Mensaje.manipulacionExcepciones("critico", error.getMessage());
        }
        
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        //obtener el encabezado mediante el archivo de configuraciones
        String nombre = "";
        String direccion_uno = "";
        String direccion_dos = "";
        String telefono = "";
        try {
            nombre = archivo.leer("[name]");
            direccion_uno = archivo.leer("[adress]");
            direccion_dos = archivo.leer("[city]");
            telefono = archivo.leer("[phone]");
        } catch (IOException ex) {
            Logger.getLogger(wdwMovimientoVentaDeProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Buscar el corelativo del recibo de pago
        int numero_correlativo = 0;
        AccesoFactura accesoFactura = new AccesoFactura();
        try {
            numero_correlativo = accesoFactura.retornaNumeroCorrelativo(txtIdVenta.getText());
        } catch(Exception exception) {
            System.out.println("Error al buscar el correlativo: " + exception.toString());
        }
        
        try {
            AccesoInventario Acceso = new AccesoInventario();
            URL url_reporte = this.getClass().getResource("/inventory/reportes/rptComprobante.jasper");
            JasperReport reporte = (JasperReport) JRLoader.loadObject(url_reporte);
            //ENVIAR EL PARAMETRO AL REPORTES
            HashMap parametro = new HashMap();
            parametro.put("P_ID_FACTURA", Integer.parseInt(txtIdVenta.getText()));
            parametro.put("P_EMPRESA", nombre);
            parametro.put("P_DIRECCION_UNO", direccion_uno);
            parametro.put("P_DIRECCION_DOS", direccion_dos);
            parametro.put("P_TELEFONO", telefono);
            parametro.put("P_CORRELATIVO", String.valueOf(numero_correlativo));
            JasperPrint pantalla = JasperFillManager.fillReport(reporte, parametro, Acceso.conectar());
            JasperViewer visualizador = new JasperViewer(pantalla, false);
            visualizador.show();
        } catch (JRException error) {
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al imprimir factura -> " + error);
        }
    }//GEN-LAST:event_btnTicketActionPerformed

    private void btnGeneraFELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneraFELActionPerformed
        if (!txtAutorizacionFEL.getText().equals("0")) {
            Mensaje.manipulacionExcepciones("critico", "Este documento ya tiene Factura Electronica");
        } else {
            ObjetosFacturaFel det = new ObjetosFacturaFel();
            AccesoFacturaFEL fel = new AccesoFacturaFEL();
            try {
                det = fel.buscarFacturaFEL(txtIdVenta.getText().trim(), "Ventas Activas", Inventory.lblUsuario.getText(), "");
                if (det.getNumero_factura_fel().equals("0")) {
                    generaFacturaElectronicaFEL();
                } else {
                    this.txtSerieFacturaFEL.setText(det.getSerie_factura_fel());
                    this.txtNumFacturaFEL.setText(det.getNumero_factura_fel());
                    this.txtAutorizacionFEL.setText(det.getAutorizacion_factura_fel());
                }
            } catch (Exception error) {
                Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al buscar datos de FEL.");
            }
        }
    }//GEN-LAST:event_btnGeneraFELActionPerformed

    
    private void generaFacturaElectronicaFEL() {
        
        Resultado resultado = new Resultado();
        
        if (Integer.parseInt(txtIdVenta.getText()) > 0 && txtAutorizacionFEL.getText().equals("0")
                && txtSerieFacturaFEL.getText().equals("0") && txtNumFacturaFEL.getText().endsWith("0")) {
            
            System.out.println("Intentando generar Factura Electronica");
            
            int id = Integer.parseInt(txtIdVenta.getText());
            
            System.out.println("ID Venta: " + id);
            
            GenerarDocumentoFEL felConDecimales = new GenerarDocumentoFEL();
            //GenerarDocumentoSinDecimalesFEL felConDecimales = new GenerarDocumentoSinDecimalesFEL();

            System.out.println("Se utilizará el metodo con decimales");
            resultado = felConDecimales.generarFacturaElectronica("GFN", id, txtNombrePersona.getText(), "", "Venta de Productos", "FEL", 
                    Inventory.lblUsuario.getText(), "", cbxTipoDocumento.getSelectedItem().toString());

            String autorizacion_guatefactruas_fel = "";
            
            System.out.println("AUTORIZACION: |" + resultado.getAutorizacion() +"|");
            
            if (resultado.getAutorizacion().equals("0")) {
                
                System.out.println("GeneraDOcumento: " + resultado.getResultado());
                String respuesta_fel = resultado.getResultado().replaceAll("<Resultado>", "").replaceAll("</Resultado>", "").replaceAll("-", " ").replaceAll("&", "");
                Mensaje.manipulacionExcepciones("critico", respuesta_fel);
                
            } else {
                
                String nombre_cliente_sat = resultado.getNombre().replaceAll("'", "´").replaceAll(",", " ");
                
                if(txtNombrePersona.equals(nombre_cliente_sat)) {
                    System.out.println("El nombre del cliente es correcto según SAT.");
                } else {
                    System.out.println("Actualizando nombre del Cliente para esta factura");
                    AccesoCliente acceso_cliente = new AccesoCliente();
                    //acceso_cliente.actualizarDireccionCliente(txtIdCliente.getText(), resultado.getDireccion(), "Venta de Producto", "Generar FEL", Inventory.lblUsuario.getText(), Inventory.lblTerminal.getText());
                    acceso_cliente.actualizarNombreFactura(txtIdVenta.getText(), resultado.getNombre(), "Venta de Producto", "Generar FEL", Inventory.lblUsuario.getText(), "");
                }
                
                System.out.println("ALmacenando informacion en Base de Datos FEL");
                
                autorizacion_guatefactruas_fel = resultado.getAutorizacion();

                //almacenar datos de FEL en la base de datos
                AccesoFacturaFEL FEL = new AccesoFacturaFEL();
                ObjetosFacturaFel FAC = new ObjetosFacturaFel();
                FAC.setId_factura(Integer.parseInt(txtIdVenta.getText()));
                FAC.setSerie_factura_fel(resultado.getSerie());
                FAC.setNumero_factura_fel(resultado.getPreimpreso());
                FAC.setAutorizacion_factura_fel(resultado.getAutorizacion());
                FAC.setTipo_documento_factura_fel(cbxTipoDocumento.getSelectedItem().toString());
                
                String resultado_actualizacion_fel = FEL.actualizarDatosFEL(FAC, "Venta de Productos", "Generar FEL", Inventory.lblUsuario.getText(), "");

                System.out.println("Resultado: " + resultado_actualizacion_fel);
                
                if (resultado_actualizacion_fel.equals(" Registros Actualizados: 1")) {
                    btnGeneraFEL.setEnabled(false);
                    txtAutorizacionFEL.setText(resultado.getAutorizacion());
                    txtSerieFacturaFEL.setText(resultado.getSerie());
                    txtNumFacturaFEL.setText(resultado.getPreimpreso());
                    Mensaje.manipulacionExcepciones("informacion", "Numero de autorización:\n" + autorizacion_guatefactruas_fel);
                } else {
                    Mensaje.manipulacionExcepciones("informacion", "No se pudeo actualizar los valores de FEL en la Base de Datos");
                }
                
            }
        
        } else {
            
            Mensaje.manipulacionExcepciones("informacion", "No se puede generar Facutara a esta Venta");
        
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGeneraFEL;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnTicket;
    private javax.swing.JComboBox<String> cbxTamanoImpresion;
    private javax.swing.JComboBox<String> cbxTipoDocumento;
    private javax.swing.JComboBox<String> cbxTipoImpresion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblIdVenta;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTextField txtAutorizacionFEL;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicial;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNombrePersona;
    private javax.swing.JTextField txtNumFacturaFEL;
    private javax.swing.JTextField txtSerieFacturaFEL;
    private javax.swing.JTextField txtTipoDocumentoFEL;
    // End of variables declaration//GEN-END:variables
}
