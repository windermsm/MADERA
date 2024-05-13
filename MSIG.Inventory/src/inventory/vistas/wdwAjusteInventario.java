/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.vistas;

import inventory.acceso.*;
import inventory.objetos.ObjetosAjuste;
import inventory.objetos.ObjetosPersona;
import inventory.objetos.ObjetosProducto;
import inventory.objetos.ObjetosProveedor;
import inventory.servicios.Matematicas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class wdwAjusteInventario extends javax.swing.JInternalFrame {

    //VARIABLES GLOBALES
    AccesoExcepciones Mensaje = new AccesoExcepciones();
    ObjetosProducto Producto = new ObjetosProducto();
    AccesoProducto NuevoProducto = new AccesoProducto();
    
    //VARIABLES PUBLICAR PARA ENVIAR EL ID DEL PRODUCTO
    //SELECCIONADO A LA PATALLA DE VENTAS
    public int fila_seleccionada = 0;
    public int columan_seleccionada = 0;
    String id_producto = null;
   
    
    /**
     * Creates new form wdwCatalogoProductos
     */
    public wdwAjusteInventario() {
        initComponents();
        mostrarRegistrosGuardados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox();
        txtMotivo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/buscar.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(625, 350));
        setMinimumSize(new java.awt.Dimension(625, 350));
        setPreferredSize(new java.awt.Dimension(625, 350));

        pnlBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBuscar.setText("Buscar");

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setActionCommand("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setToolTipText("Ingrese el nombre del producto que desea buscar");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(20, 20, 20)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscar)
                        .addComponent(btnSalir)
                        .addComponent(btnLimpiar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDetalle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducto.getTableHeader().setReorderingAllowed(false);
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID Producto");

        txtIdProducto.setBackground(new java.awt.Color(102, 102, 102));
        txtIdProducto.setEditable(false);
        txtIdProducto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Motivo");

        jLabel3.setText("Cantidad");

        txtCantidadProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CantidadLostFocus(evt);
            }
        });

        jLabel5.setText("Tipo");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Agregar", "Quitar" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtMotivo))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        buscarEnRegistrosGuardados();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed

        Mensaje.manipulacionExcepciones("interrogante", "¿Esta seguro que desea salir?");
        if(Mensaje.valor == 0){
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseClicked
        if (String.valueOf(tblProducto.getSelectedColumn()).equals("0")) {
            txtIdProducto.setText(tblProducto.getValueAt(tblProducto.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tblProductoMouseClicked

    private void CantidadLostFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CantidadLostFocus
        
    }//GEN-LAST:event_CantidadLostFocus

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ObjetosAjuste obj_ajuste = new ObjetosAjuste();
        AccesoAjuste con_ajuste = new AccesoAjuste();
        obj_ajuste.setId_producto(txtIdProducto.getText());
        obj_ajuste.setTipo_ajuste(cbxTipo.getSelectedItem().toString());
        obj_ajuste.setCantidad_ajuste(Float.parseFloat(txtCantidadProducto.getText()));
        obj_ajuste.setMotivo_ajuste(txtMotivo.getText());
        obj_ajuste.setUsuario_ajuste(Inventory.lblUsuario.getText());
        con_ajuste.insertarAjuste(obj_ajuste);
        Mensaje.manipulacionExcepciones("informacion", con_ajuste.actualizarAjuste(obj_ajuste));
        mostrarRegistrosGuardados();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void mostrarRegistrosGuardados(){
        

        DefaultTableModel tabla = new DefaultTableModel();
        AccesoProducto Producto = new AccesoProducto();
        AccesoProveedor Proveedor = new AccesoProveedor();
        AccesoPersona Persona = new AccesoPersona();
        
        ArrayList<ObjetosProducto> listaProductos = new ArrayList();
        ArrayList<ObjetosProveedor> listaProveedores = new ArrayList();
        ArrayList<ObjetosPersona> listaPersonas = new ArrayList();
        
        try{
            listaProductos = Producto.seleccionarProducto();
            listaProveedores = Proveedor.seleccionarProveedor();
            listaPersonas = Persona.seleccionarPersona();
            
            System.out.println("SE CONSULTARON LOS DATOS DE PRODUCTO O DE PROVEEDOR");
        }catch(Error error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar la informacion -> "+error);
        }
        
        //MOSTRAR LA INFORMACION DE LOS PRODUCTOS EN LA TABLA DE LA VISTA
        if(listaProductos.isEmpty()){
            Mensaje.manipulacionExcepciones("critico", "No existen datos almacenados de productos");
        } else {
            
            tabla.addColumn("ID Producto");
            tabla.addColumn("Marca");
            tabla.addColumn("Descripcion");
            tabla.addColumn("Linea/Familia");
            tabla.addColumn("Proveedor");
            tabla.addColumn("Existencias");
            tabla.addColumn("Unidad de Medida");
            tabla.addColumn("Precio Estandar");
            tabla.addColumn("Precio Minimo");
            
            tabla.setRowCount(listaProductos.size());
            int cProducto = 0;
            
            // RECORRO LA LISTA DE PRODUCTOS
            for(ObjetosProducto xProducto:listaProductos ){
                
                // POR CADA PRODUCTO RECORRO LA LISTA DE PROVEEDORES
                for(ObjetosProveedor xProveedor:listaProveedores){
                    
                    // VERIFICO SI EL ID DEL PROVEEDOR EN PRODUCTO ES EL MISMO QUE EN PROVEEDORES
                    if(xProducto.getId_proveedor() == xProveedor.getId_proveedor()){
                        
                        // SOLO SI COINCIDE EL ID PROVEEDOR ARRIBA RECORRO  LA LISTA DE PERSONAS
                        for(ObjetosPersona xPersona:listaPersonas){
                            
                            // SI EL ID PERSONA ES EL MISMO EN PERSONA QUE EN PROVEEDOR PINTO LOS DATOS
                            if(xProveedor.getId_persona() == xPersona.getId_persona()){
                                tabla.setValueAt(xProducto.getId_producto(), cProducto, 0);
                                tabla.setValueAt(xProducto.getMarca_producto(), cProducto, 1);
                                tabla.setValueAt(xProducto.getDesc_producto(), cProducto, 2);
                                tabla.setValueAt(xProducto.getLinea_producto(), cProducto, 3);
                                tabla.setValueAt(xPersona.getNom_persona(), cProducto, 4);
                                tabla.setValueAt(xProducto.getExi_producto(), cProducto, 5);   
                                tabla.setValueAt(xProducto.getUnidad_medida_producto(), cProducto, 6);
                                tabla.setValueAt(xProducto.getPrecio_est_producto(), cProducto, 7);
                                tabla.setValueAt(xProducto.getPrecio_min_producto(), cProducto, 8);
                                cProducto++;
                                
                                //System.out.println("SE CONSULTO CON EXITO EL PRODUCTO: "+xProducto.getId_producto());
                            }
                        }
                    }
                }
            }
            
            tblProducto.setModel(tabla);
            //CAMBIAR DE TAMAÑO LA TERCERA COLUMNA 'DESCRIPCION'
            tblProducto.getColumnModel().getColumn(2).setPreferredWidth(200);
        }
    }
    
    private void limpiarCampos(){
        txtBuscar.setText("");
        txtCantidadProducto.setText("");
        txtMotivo.setText("");
        txtIdProducto.setText("");
        txtMotivo.setText("");
    }
    
    private void totalFactura(){
        float total_factura = 0;
        for(int cFilas = 0; cFilas <= 14; cFilas++) {
            try{
                total_factura = total_factura + (float) wdwMovimientoVentaDeProductos.tblDetalleFactura.getValueAt(cFilas, 3) * (float) wdwMovimientoVentaDeProductos.tblDetalleFactura.getValueAt(cFilas, 4);
            } catch(Exception error) {
                total_factura = total_factura + 0;
            }
        }
        wdwMovimientoVentaDeProductos.txtTotalFactura.setText(String.valueOf(Math.rint(total_factura * 100)/100));
        Double total_iva = Double.parseDouble(wdwMovimientoVentaDeProductos.txtTotalFactura.getText())*0.12;
        Matematicas operacion = new Matematicas();
        wdwMovimientoVentaDeProductos.txtIva.setText(String.valueOf(operacion.redondear(total_iva)));
    }
    
    private void totalProforma(){
        System.out.println("ENTRO TOTAL PROFORMA");
        float total_proforma = 0;
        for(int cFilas = 0; cFilas <= 14; cFilas++) {
            try{
                total_proforma = total_proforma + (float) wdwMovimientoProforma.tblDetalleProforma.getValueAt(cFilas, 3) * (float) wdwMovimientoProforma.tblDetalleProforma.getValueAt(cFilas, 4);
                System.out.println(total_proforma);
            } catch(Exception error) {
                total_proforma = total_proforma + 0;
            }
        }
        wdwMovimientoProforma.txtTotalProforma.setText(String.valueOf(Math.rint(total_proforma * 100)/100));
    }
    
    private void buscarEnRegistrosGuardados(){
        
        // CAPTURO EL DATO A BUSCAR
        String busqueda = txtBuscar.getText().toUpperCase();
        System.out.println("Se esta buscando la cadena " + busqueda);
        
        if(busqueda != null){
            DefaultTableModel tabla = new DefaultTableModel();
            
            AccesoProducto Producto = new AccesoProducto();
            AccesoProveedor Proveedor = new AccesoProveedor();
            AccesoPersona Persona = new AccesoPersona();

            ArrayList<ObjetosProducto> listaProductos = new ArrayList();
            ArrayList<ObjetosProveedor> listaProveedores = new ArrayList();
            ArrayList<ObjetosPersona> listaPersonas = new ArrayList();

            //VERIFICAR ALGUN ERROR AL CARGAR LA INFORMACION DE LOS PRODUCTOS
            try{
                listaProductos = Producto.seleccionarProducto();
                listaProveedores = Proveedor.seleccionarProveedor();
                listaPersonas = Persona.seleccionarPersona();
                
                System.out.println("SE CONSULTARON LOS DATOS DE PRODUCTOS");
            }catch(Error error){
                Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar la informacion -> "+error);
            }

            //MOSTRAR LA INFORMACION DE LOS PRODUCTOS EN LA TABLA DE LA VISTA
            if(listaProductos.isEmpty()){
                Mensaje.manipulacionExcepciones("critico", "No existen datos almacenados de productos");
            } else {
                
                tabla.addColumn("ID Producto");
                tabla.addColumn("Marca");
                tabla.addColumn("Descripcion");
                tabla.addColumn("Linea/Familia");
                tabla.addColumn("Proveedor");
                tabla.addColumn("Existencias");
                tabla.addColumn("Unidad de Medida");
                tabla.addColumn("Precio Estandar");
                tabla.addColumn("Precio Minimo");
               

                int cProducto = 0;
                int contadorFilas = 1;

                // RECORRO LA LISTA DE PRODUCTOS
                for (ObjetosProducto xProducto : listaProductos) {

                    // POR CADA PRODUCTO RECORRO LA LISTA DE PROVEEDORES
                    for (ObjetosProveedor xProveedor : listaProveedores) {

                        // VERIFICO SI EL ID DEL PROVEEDOR EN PRODUCTO ES EL MISMO QUE EN PROVEEDORES
                        if (xProducto.getId_proveedor() == xProveedor.getId_proveedor()) {

                            // SOLO SI COINCIDE LE ID PROVEEDOR ARRIBA RECORRO  LA LISTA DE PERSONAS
                            for (ObjetosPersona xPersona : listaPersonas) {

                                // SI EL ID PERSONA ES EL MISMO EN PERSONA QUE EN PROVEEDOR COMPARO CON EL STRING BUSCADO
                                if (xProveedor.getId_persona() == xPersona.getId_persona()) {
                                   
                                    // SI EXISTE ALGUNA COINCIDENCIA CON EL STRING BUSCADO PINTO LA TUPLA EN EL DETALLE
                                    if (xProducto.getId_producto().toUpperCase().indexOf(busqueda) >= 0
                                            || xProducto.getMarca_producto().toUpperCase().indexOf(busqueda) >= 0
                                            || xProducto.getDesc_producto().toUpperCase().indexOf(busqueda) >= 0
                                            || xPersona.getNom_persona().toUpperCase().indexOf(busqueda) >= 0
                                            || xProducto.getLinea_producto().toUpperCase().indexOf(busqueda) >= 0) {

                                        System.out.println("SE ENCONTRO COINCIDENCIA");

                                        // ESTABLECE EL TAMAÑO DE LA TABLA
                                        tabla.setRowCount(contadorFilas);

                                        tabla.setValueAt(xProducto.getId_producto(), cProducto, 0);
                                        tabla.setValueAt(xProducto.getMarca_producto(), cProducto, 1);
                                        tabla.setValueAt(xProducto.getDesc_producto(), cProducto, 2);
                                        tabla.setValueAt(xProducto.getLinea_producto(), cProducto, 3);
                                        tabla.setValueAt(xPersona.getNom_persona(), cProducto, 4);
                                        tabla.setValueAt(xProducto.getExi_producto(), cProducto, 5);
                                        tabla.setValueAt(xProducto.getUnidad_medida_producto(), cProducto, 6);
                                        tabla.setValueAt(xProducto.getPrecio_est_producto(), cProducto, 7);
                                        tabla.setValueAt(xProducto.getPrecio_min_producto(), cProducto, 8);
                                        cProducto++;
                                        contadorFilas++;

                                    }
                                }
                            }
                        }
                    }
                }

                tblProducto.setModel(tabla);
                //CAMBIAR DE TAMAÑO LA TERCERA COLUMNA 'DESCRIPCION'
                tblProducto.getColumnModel().getColumn(2).setPreferredWidth(200);
            }
        }else{
            // SI NO HAY CARACTER DE BUSQUEDA SE DESPLIEGAN TODOS LOS DATOS
            mostrarRegistrosGuardados();
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
}