/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.vistas;


import inventory.acceso.AccesoExcepciones;
import inventory.acceso.AccesoUsuario;
import inventory.objetos.ObjetosUsuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Megabyte Soluciones Integrales Guatemala
 */
public class wdwCatalogoUsuarios extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form CatalogoAdmonProductos
     */
    AccesoExcepciones Mensaje = new AccesoExcepciones();
    AccesoUsuario nuevoUsuario = new AccesoUsuario();
    ObjetosUsuario usuario = new ObjetosUsuario();
    String seleccion = "";

//AccesoProveedor nuevoProveedor = new AccesoProveedor();
    
    
    public wdwCatalogoUsuarios() {
        initComponents();
        cargaEmpleados();
        buscarEnRegistrosGuardados();
    }
    
    private void cargaEmpleados(){
        ArrayList<ObjetosUsuario> lUsuarios = new ArrayList();
            
        try{
            lUsuarios = nuevoUsuario.retornaNombreEmpleados();
            
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Error en busqueda de usuarios " + error);
        }
        
        // Lleno el combobox con los registros de empleados que existen
        for(ObjetosUsuario xUsuario : lUsuarios){
            cbxNombreEmpleado.addItem(xUsuario.getNombre_empleado());
        }
        
    }
    
    private void guardarRegistro(){
        // Si se ingresan todos los datos del producto asigno valor al objeto
        if(verificarDatosProducto()){
            usuario.setId_empleado(Integer.parseInt(txtIdEmpleado.getText()));
            usuario.setNombre_usuario(txtNombreUsuario.getText());
            usuario.setContrasenia_usuario(txtContraseniaUsuario.getText());
            usuario.setTipo_usuario(cbxTipoUsuario.getSelectedItem().toString());
        }
        
        try{
            nuevoUsuario.insertarUsuario(usuario);
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al guardar los datos del usuario " + error);
        }
    }
        
    private boolean verificarDatosProducto(){
        boolean vDatosCorrectos = true;
        
        if (txtIdEmpleado.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Ingrese el ID del empleado");
            vDatosCorrectos = false;
        }
        if (txtNombreUsuario.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Ingrese el nombre del usuario");
            vDatosCorrectos = false;
        }
        if (txtContraseniaUsuario.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Ingrese la contraseña del usuario");
            vDatosCorrectos = false;
        }
        
        if(cbxNombreEmpleado.getSelectedItem().equals("Seleccionar")){
            Mensaje.manipulacionExcepciones("critico", "Seleccione el nombre del empleado");
            vDatosCorrectos = false;
        }
        
        return vDatosCorrectos;
    }
    
    public void limpiarCampos(){
        btnGuardar.setEnabled(true);
        txtIdUsuario.setText("");
        txtIdEmpleado.setText("");
        txtNombreUsuario.setText("");
        txtContraseniaUsuario.setText("");
        txtBuscar.setText("");
        
        cbxNombreEmpleado.setSelectedItem("Seleccionar");
        cbxTipoUsuario.setSelectedItem("Administrador");
    }
    
    private void buscarEnRegistrosGuardados(){
        String busqueda = txtBuscar.getText();
    
        if(busqueda != null){
            DefaultTableModel tabla = new DefaultTableModel();
            ArrayList<ObjetosUsuario> listaUsuarios = new ArrayList();
            int contadorFilas = 1;
            int cProveedor = 0;
            
            try{
                listaUsuarios = nuevoUsuario.seleccionarUsuario(busqueda);
                System.out.println("SE CONSULTARON LOS DATOS DE USUARIOS");
                
            }catch(Exception error){
                Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar la informacion " + error);
            }
            
            if(listaUsuarios.isEmpty()){
                Mensaje.manipulacionExcepciones("critico", "No existen datos de usuarios almacenados");
            }else{
                tabla.addColumn("USUARIO");
                tabla.addColumn("CONTRASEÑA");
                tabla.addColumn("TIPO");
                tabla.addColumn("NOMBRE EMPLEADO");
                
                for(ObjetosUsuario xUsuario : listaUsuarios){
                    tabla.setRowCount(contadorFilas);
                    
                    tabla.setValueAt(xUsuario.getNombre_usuario(), cProveedor, 0);
                    tabla.setValueAt(xUsuario.getContrasenia_usuario(), cProveedor, 1); 
                    tabla.setValueAt(xUsuario.getTipo_usuario(), cProveedor, 2);
                    tabla.setValueAt(xUsuario.getNombre_empleado(), cProveedor, 3);
                    
                    System.out.println("Se encontro el registro " + xUsuario.getNombre_usuario());
                    cProveedor++;
                    contadorFilas++;
                }
                
                tblUsuario.setModel(tabla);
            }
        }else{
            mostrarRegistrosGuardados();
        }
    }
    
    public void mostrarRegistrosGuardados(){
         DefaultTableModel tabla = new DefaultTableModel();
         ArrayList<ObjetosUsuario> listaUsuarios = new ArrayList();
         int contadorFilas = 1;
         int cProveedor = 0;
         
         try{
             listaUsuarios = nuevoUsuario.retornaUsuario();
         }catch(Exception error){
             Mensaje.manipulacionExcepciones("critico", "Error en busqueda " + error);
         }
         
         if(listaUsuarios.isEmpty()){
                Mensaje.manipulacionExcepciones("critico", "No existen datos de usuarios almacenados");
            }else{
                tabla.addColumn("USUARIO");
                tabla.addColumn("CONTRASEÑA");
                tabla.addColumn("TIPO");
                tabla.addColumn("NOMBRE EMPLEADO");
                
                for(ObjetosUsuario xUsuario : listaUsuarios){
                    tabla.setRowCount(contadorFilas);
                    
                    tabla.setValueAt(xUsuario.getNombre_usuario(), cProveedor, 0);
                    tabla.setValueAt(xUsuario.getContrasenia_usuario(), cProveedor, 1); 
                    tabla.setValueAt(xUsuario.getTipo_usuario(), cProveedor, 2);
                    tabla.setValueAt(xUsuario.getNombre_empleado(), cProveedor, 3);
                    
                    System.out.println("Se encontro el registro " + xUsuario.getNombre_usuario());
                    cProveedor++;
                    contadorFilas++;
                }
                
                tblUsuario.setModel(tabla);
            }
    }
    
    private int obtenerIdUsuario(String pNombreUsuario){
        int vId_producto = 0;
        int idUsuario = 0;
        
        try{
            idUsuario = nuevoUsuario.retornaIdUsuario(pNombreUsuario);
            
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar el id del usuario " + error);
        }
        
        if(idUsuario <= 0){
            Mensaje.manipulacionExcepciones("informacion", "Debe crear el usuario en el sistema");
        }else{
            vId_producto = idUsuario;
            System.out.println("ID USUARIO " + vId_producto);
            
        }
        
        return vId_producto;
        
    }
    
    private void actualizarRegistro(){
        usuario.setId_usuario(Integer.parseInt(txtIdUsuario.getText()));
        usuario.setNombre_usuario(txtNombreUsuario.getText());
        usuario.setContrasenia_usuario(txtContraseniaUsuario.getText());
        usuario.setTipo_usuario(cbxTipoUsuario.getSelectedItem().toString());
        
        try{
            System.out.println("HASTA ANTES DE ACTUALIZAR " + usuario.getId_usuario());
            nuevoUsuario.actualizarUsuario(usuario);
            
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Error al actualizar el usuario " + error);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEncabezado = new javax.swing.JPanel();
        lblIdUsuario = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        lblEmpleado = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        lblContraseniaUsuario = new javax.swing.JLabel();
        txtContraseniaUsuario = new javax.swing.JTextField();
        lblTipoUsuario = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        cbxNombreEmpleado = new javax.swing.JComboBox();
        cbxTipoUsuario = new javax.swing.JComboBox();
        pnlBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/clientes.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 500));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));

        pnlEncabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblIdUsuario.setText("ID Usuario");

        txtIdUsuario.setEditable(false);
        txtIdUsuario.setToolTipText("");

        lblEmpleado.setText("Empleado");

        lblNombreUsuario.setText("Nombre");
        lblNombreUsuario.setToolTipText("");

        txtNombreUsuario.setToolTipText("Se ingresa el nombre del usuario sin espacios");

        lblContraseniaUsuario.setText("Contraseña");

        txtContraseniaUsuario.setToolTipText("Ingrese la contraseña del usuario");

        lblTipoUsuario.setText("Tipo");

        txtIdEmpleado.setEditable(false);

        cbxNombreEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbxNombreEmpleado.setToolTipText("Seleccione el usuario");
        cbxNombreEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNombreEmpleadoActionPerformed(evt);
            }
        });

        cbxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Bodeguero", "Jefe Sucursal", "Secretaria", "Cajero", "Vendedor" }));
        cbxTipoUsuario.setToolTipText("Seleccione e tipo de usuario");

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdUsuario)
                    .addComponent(lblNombreUsuario))
                .addGap(32, 32, 32)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(txtNombreUsuario))
                .addGap(18, 18, 18)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpleado)
                    .addComponent(lblContraseniaUsuario))
                .addGap(18, 18, 18)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(cbxNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdEmpleado))
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(txtContraseniaUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(lblTipoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUsuario)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpleado)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUsuario)
                    .addComponent(lblContraseniaUsuario)
                    .addComponent(txtContraseniaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoUsuario)
                    .addComponent(cbxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtContraseniaUsuario.getAccessibleContext().setAccessibleName("txtPrecioCompra");

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

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/editar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/buscar.png"))); // NOI18N
        btnBuscar.setActionCommand("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setToolTipText("Ingrese el nombre del usuario a buscar");

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btnModificar)
                        .addComponent(btnGuardar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDetalle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUsuario.getTableHeader().setReorderingAllowed(false);
        tblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuario);

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
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlEncabezado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       guardarRegistro();
       buscarEnRegistrosGuardados();
       limpiarCampos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxNombreEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNombreEmpleadoActionPerformed
        seleccion = "";
        seleccion = cbxNombreEmpleado.getSelectedItem().toString();
        
        int idEmpleado = 0;
            
        try{
            idEmpleado = nuevoUsuario.retornaIDEmpleado(seleccion);
            
            System.out.println("PASO 1 CARGA DE EMPLEADOS ");
            
            txtIdEmpleado.setText(String.valueOf(idEmpleado));
            
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Error al obtener codigo del usuario seleccionado " + error);
        }
        
    }//GEN-LAST:event_cbxNombreEmpleadoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEnRegistrosGuardados();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Mensaje.manipulacionExcepciones("interrogante", "¿Esta seguro que desea salir?");
        if (Mensaje.valor == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuarioMouseClicked
        btnGuardar.setEnabled(false);
        if(String.valueOf(tblUsuario.getSelectedColumn()).equals("0")){
            int fila_seleccionada = tblUsuario.getSelectedRow();
            int columna_seleccionada = tblUsuario.getSelectedColumn();
            
            txtNombreUsuario.setText(String.valueOf(tblUsuario.getValueAt(fila_seleccionada, columna_seleccionada + 0)));
            txtContraseniaUsuario.setText(String.valueOf(tblUsuario.getValueAt(fila_seleccionada, columna_seleccionada + 1)));
            cbxTipoUsuario.setSelectedItem(String.valueOf(tblUsuario.getValueAt(fila_seleccionada, columna_seleccionada + 2)));
            cbxNombreEmpleado.setSelectedItem(String.valueOf(tblUsuario.getValueAt(fila_seleccionada, columna_seleccionada + 3)));
            
            // Ya seleccionado el producto busco el ID
            txtIdUsuario.setText(String.valueOf(obtenerIdUsuario(txtNombreUsuario.getText())));
        }
        
    }//GEN-LAST:event_tblUsuarioMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(txtNombreUsuario.getText().isEmpty()){
            Mensaje.manipulacionExcepciones("informacion", "Debe seleccionar el registro a modificar");
        }else{
            actualizarRegistro();
            buscarEnRegistrosGuardados();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxNombreEmpleado;
    private javax.swing.JComboBox cbxTipoUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblContraseniaUsuario;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContraseniaUsuario;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
