/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.vistas;

import inventory.acceso.AccesoEmpleado;
import inventory.acceso.AccesoExcepciones;
import inventory.objetos.ObjetosEmpleado;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Megabytes Soluciones Integrales Guatemala
 */
public class wdwCatalogoEmpleados extends javax.swing.JInternalFrame {

    AccesoExcepciones Mensaje = new AccesoExcepciones();
    ObjetosEmpleado empleado = new ObjetosEmpleado();
    AccesoEmpleado nuevoEmpleado = new AccesoEmpleado();
    
    /**
     * Creates new form wdwIngresoClientes
     */
    public wdwCatalogoEmpleados() {
        initComponents();
        cargaSucursales();
        buscarEnRegistrosGuardados();
    }
    
    private void cargaSucursales(){
        ArrayList<ObjetosEmpleado> lSucursales = new ArrayList();
        
        try{
            lSucursales = nuevoEmpleado.retornaNombreSucursal();
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Error en carga de sucursales " + error);
        }
        
        // Lleno el combobox con los registros de sucursales que existen
        for(ObjetosEmpleado xSucursal : lSucursales){
            cbxSucursal.addItem(xSucursal.getNombre_sucursal());
        }
    }
    
    private String estadoEmpleado(String pEstado){
        String vEstado = "";
        
        if(pEstado.equals("Activo")){
            vEstado = "A";
        }
        
        if(pEstado.equals("Vacaciones")){
            vEstado = "V";
        }
        
        if(pEstado.equals("Inactivo")){
            vEstado = "I";
        }
        
        if(pEstado.equals("A")){
            vEstado = "Activo";
        }
        
        if(pEstado.equals("V")){
            vEstado = "Vacaciones";
        }
        
        if(pEstado.equals("I")){
            vEstado = "Inactivo";
        }
        
        return vEstado;        
    }
    
    private boolean verificarDatosEmpleado(){
        boolean vDatosCorrectos = true;
        
        if(cbxSucursal.getSelectedItem().toString().equals("Seleccione")){
            Mensaje.manipulacionExcepciones("critico", "Seleccione la sucursal");
            vDatosCorrectos = false;
        }
        if(txtNombreEmpleado.getText().isEmpty()){
            Mensaje.manipulacionExcepciones("critico", "Ingrese el nombre");
            vDatosCorrectos = false;
        }
        if(txtBonoEmpleado.getText().isEmpty()){
            Mensaje.manipulacionExcepciones("critico", "Ingrese un bono");
            vDatosCorrectos = false;
        }
        if (txtFechaIngresoEmpleado.getText().isEmpty()) {
            Mensaje.manipulacionExcepciones("critico", "Ingrese la fecha de ingreso del empleado");
            vDatosCorrectos = false;
        }
        
        return vDatosCorrectos;
    }
    
    private void guardarRegistro(){
        
        // Si se ingresan todos los datos del proveedor asigno valor a los objetos
        if(verificarDatosEmpleado()){
            
            String estado = estadoEmpleado(cbxEstadoEmpleado.getSelectedItem().toString());
            String tipo = cbxTipoEmpleado.getSelectedItem().toString();
            String sucursal = cbxSucursal.getSelectedItem().toString();
            
            int idSucursal = nuevoEmpleado.retornaIdSucursal(sucursal);
            
            System.out.println(txtFechaSalidaEmpleado.getText());
            
            if(txtFechaSalidaEmpleado.getText().equals("")){
                empleado.setFecha_salida(null);
            }else{
                empleado.setFecha_salida("'"+txtFechaSalidaEmpleado.getText()+"'");
            }
            
            System.out.println("Fecha salida empleado " + empleado.getFecha_salida());
            
            empleado.setTipo_empleado(tipo);
            empleado.setNombre_empleado(txtNombreEmpleado.getText());
            empleado.setEstado_empleado(estado);
            empleado.setBono_empleado(Double.parseDouble(txtBonoEmpleado.getText()));
            empleado.setId_sucursal(idSucursal);
            empleado.setFecha_ingreso(txtFechaIngresoEmpleado.getText());
            empleado.setSalario_empleado(Double.parseDouble(txtSalarioEmpleado.getText()));
            empleado.setPorcentaje_comision(Double.parseDouble(txtComision.getText()));
        }
        
        try{
            nuevoEmpleado.insertarEmpleado(empleado);
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al guardar los datos del empleado " + error);
        }
        
    }
    
    private void limpiarCampos(){
        btnGuardar.setEnabled(true);
        txtIdEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtFechaIngresoEmpleado.setText("");
        txtFechaSalidaEmpleado.setText("");
        txtBonoEmpleado.setText("");
        cbxTipoEmpleado.setSelectedItem("Gerente");
        cbxEstadoEmpleado.setSelectedItem("Activo");
        cbxSucursal.setSelectedItem("Seleccione");
        txtSalarioEmpleado.setText("");
        txtBuscar.setText("");
        txtComision.setText("");
    }
    
    private void buscarEnRegistrosGuardados(){
        String busqueda = txtBuscar.getText();
        
        if(busqueda == null || busqueda.equals("")){
            
            System.out.println("CON NADA " + busqueda);
            
            DefaultTableModel tabla = new DefaultTableModel();
            
            ArrayList<ObjetosEmpleado> listaEmpleados = new ArrayList();
            
            int contadorFilas = 1;
            int cProveedor = 0;
            
            // Verificar algun erro al cargar la informacion de los proveedores
            try{
                
                listaEmpleados = nuevoEmpleado.retornaEmpleados();
                
                System.out.println("SE CONSULTARON LOS DATOS DE LOS EMPLEADOS");
                
            }catch(Error error){
                Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar la informacion " + error);
            }
            
            // Mostrar la informacion de los proveedores en la tabla de la vista
            if(listaEmpleados.isEmpty()){
                Mensaje.manipulacionExcepciones("critico", "No existe datos almacenados de los empleados");
            }else{
                tabla.addColumn("TIPO");
                tabla.addColumn("NOMBRE");
                tabla.addColumn("ESTADO");
                tabla.addColumn("SUCURSAL");
                tabla.addColumn("BONO");
                tabla.addColumn("FECHA INGRESO");
                tabla.addColumn("FECHA SALIDA");
                tabla.addColumn("SALARIO");
                tabla.addColumn("COMISION (%)");
                
                for(ObjetosEmpleado xEmpleado : listaEmpleados){
                    tabla.setRowCount(contadorFilas);
                    
                    String estado = estadoEmpleado(xEmpleado.getEstado_empleado());
                    
                    tabla.setValueAt(xEmpleado.getTipo_empleado(), cProveedor, 0);
                    tabla.setValueAt(xEmpleado.getNombre_empleado(), cProveedor, 1);
                    tabla.setValueAt(estado, cProveedor, 2);
                    tabla.setValueAt(xEmpleado.getNombre_sucursal(), cProveedor, 3);
                    tabla.setValueAt(xEmpleado.getBono_empleado(), cProveedor, 4);
                    tabla.setValueAt(xEmpleado.getFecha_ingreso(), cProveedor, 5);
                    tabla.setValueAt(xEmpleado.getFecha_salida(), cProveedor, 6);
                    tabla.setValueAt(xEmpleado.getSalario_empleado(), cProveedor, 7);
                    tabla.setValueAt(xEmpleado.getPorcentaje_comision(), cProveedor, 8);
                    
                    System.out.println("Se encontro el registro " + xEmpleado.getNombre_empleado());
                    cProveedor++;
                    contadorFilas++;
                    
                }
                tblEmpleados.setModel(tabla);
            }
            
        }else{
            mostrarRegistrosGuardados();
        }   
    }
    
    public void mostrarRegistrosGuardados(){
        String busqueda = txtBuscar.getText();
        DefaultTableModel tabla = new DefaultTableModel();
        
        System.out.println("TRAE FILTRO " + busqueda);
        
        int contadorFilas = 1;
        int cProveedor = 0;
        
         ArrayList<ObjetosEmpleado> listaEmpleados = new ArrayList();
         
         try{
             listaEmpleados = nuevoEmpleado.retornaEmpleado(busqueda);
             System.out.println("Tamanio " + listaEmpleados.size());
             
         }catch(Exception error){
             Mensaje.manipulacionExcepciones("critico", "Error en busqueda " + error);
         }
         
         if(listaEmpleados.isEmpty()){
             Mensaje.manipulacionExcepciones("critico", "No existen datos almacenados de clientes");
         }else{
                tabla.addColumn("TIPO");
                tabla.addColumn("NOMBRE");
                tabla.addColumn("ESTADO");
                tabla.addColumn("SUCURSAL");
                tabla.addColumn("BONO");
                tabla.addColumn("FECHA INGRESO");
                tabla.addColumn("FECHA SALIDA");
                tabla.addColumn("SALARIO");
                tabla.addColumn("COMISION (%)");
                
                for(ObjetosEmpleado xEmpleado : listaEmpleados){
                    tabla.setRowCount(contadorFilas);
                    
                    String estado = estadoEmpleado(xEmpleado.getEstado_empleado());
                    
                    tabla.setValueAt(xEmpleado.getTipo_empleado(), cProveedor, 0);
                    tabla.setValueAt(xEmpleado.getNombre_empleado(), cProveedor, 1);
                    tabla.setValueAt(estado, cProveedor, 2);
                    tabla.setValueAt(xEmpleado.getBono_empleado(), cProveedor, 4);
                    tabla.setValueAt(xEmpleado.getFecha_ingreso(), cProveedor, 5);
                    tabla.setValueAt(xEmpleado.getFecha_salida(), cProveedor, 6);
                    tabla.setValueAt(xEmpleado.getNombre_sucursal(), cProveedor, 3);
                    tabla.setValueAt(xEmpleado.getSalario_empleado(), cProveedor, 7);
                    tabla.setValueAt(xEmpleado.getPorcentaje_comision(), cProveedor, 8);
                    
                    System.out.println("Se encontro el registro " + xEmpleado.getNombre_empleado());
                    cProveedor++;
                    contadorFilas++;
                    
                }
         }
         tblEmpleados.setModel(tabla);
    }
    
    private int obtenerIdEmpleado(String pNombre_empleado){
        int vId_empleado = 0;
        ArrayList<ObjetosEmpleado> BuscarEmpleado = new ArrayList();
        
        try{
            BuscarEmpleado = nuevoEmpleado.retornaIdEmpleado(pNombre_empleado);
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Ocurrio un error al consultar el empleado " + error);
        }
        
        if(BuscarEmpleado.isEmpty()){
            Mensaje.manipulacionExcepciones("informacion", "Debe crear el empleado en el sistema");
        }else{
            if(BuscarEmpleado.size() > 1){
                System.out.println("EXISTEN " + BuscarEmpleado.size() + " EMPLEADOS CON ESTE DATO ");
                Mensaje.manipulacionExcepciones("critico", "Este empleado esta repetido");
            }else{
                vId_empleado = BuscarEmpleado.get(0).getId_empleado();
            }
        }
        
        return vId_empleado;
    }
    
    private void actualizarRegistro(){
        String estado = estadoEmpleado(cbxEstadoEmpleado.getSelectedItem().toString());
        int idSucursal = nuevoEmpleado.retornaIdSucursal(cbxSucursal.getSelectedItem().toString());
                   
        System.out.println("ACTUALIZANDO EMPLEADO");
        
        empleado.setId_empleado(Integer.parseInt(txtIdEmpleado.getText()));
        empleado.setTipo_empleado(cbxTipoEmpleado.getSelectedItem().toString());
        empleado.setNombre_empleado(txtNombreEmpleado.getText());
        empleado.setEstado_empleado(estado);
        empleado.setBono_empleado(Double.parseDouble(txtBonoEmpleado.getText()));
        empleado.setId_sucursal(idSucursal);
        empleado.setFecha_ingreso(txtFechaIngresoEmpleado.getText());
        empleado.setFecha_salida(txtFechaSalidaEmpleado.getText());
        empleado.setSalario_empleado(Double.parseDouble(txtSalarioEmpleado.getText()));
        empleado.setPorcentaje_comision(Double.parseDouble(txtComision.getText()));
        
        try{
            nuevoEmpleado.actualizarEmpleado(empleado);
        }catch(Exception error){
            Mensaje.manipulacionExcepciones("critico", "Error al actualizar el empleado " + error);
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
        lblIdCliente = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        lblNombreCliente = new javax.swing.JLabel();
        lblTelCliente = new javax.swing.JLabel();
        lblDirCliente = new javax.swing.JLabel();
        txtBonoEmpleado = new javax.swing.JTextField();
        txtNombreEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFechaSalidaEmpleado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFechaIngresoEmpleado = new javax.swing.JTextField();
        cbxEstadoEmpleado = new javax.swing.JComboBox();
        cbxSucursal = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoEmpleado = new javax.swing.JComboBox();
        lblSalarioEmpleado = new javax.swing.JLabel();
        txtSalarioEmpleado = new javax.swing.JTextField();
        lblComision = new javax.swing.JLabel();
        txtComision = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empleados");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/proveedores.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));

        pnlEncabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblIdCliente.setText("ID Empleado");

        txtIdEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        txtIdEmpleado.setToolTipText("Este campo no se puede editar el programa asigana automaticamente un numero de ID");

        lblNombreCliente.setText("Nombre");

        lblTelCliente.setText("Estado");

        lblDirCliente.setText("Bono");

        txtBonoEmpleado.setToolTipText("Ingrese el bono asignado al empleado si tuviese, sino ingrese 0");

        txtNombreEmpleado.setToolTipText("Ingrese el nombre completo del empleado este nombre no puede contener simbolos ni numeros");

        jLabel1.setText("Tipo");

        txtFechaSalidaEmpleado.setToolTipText("Fecha de salida del empleado de la empres, si no tuviese se queda en blanco. Formato de la fcha yyyy-mm-dd");

        jLabel2.setText("Salida");

        jLabel3.setText("Ingreso");

        txtFechaIngresoEmpleado.setToolTipText("Fecha de ingreso del empleado a la empresa. Formato de la fecha yyyy-mm-dd");

        cbxEstadoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Vacaciones", "Inactivo" }));

        cbxSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

        jLabel5.setText("Sucursal");

        cbxTipoEmpleado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Propietario", "Gerente", "Administrador", "Jefe Sucursal", "Secretaria", "Cajero", "Vendedor", "Bodeguero" }));
        cbxTipoEmpleado.setToolTipText("");

        lblSalarioEmpleado.setText("Salario");

        txtSalarioEmpleado.setToolTipText("Ingrese el salario del empleado");

        lblComision.setText("Comision");

        txtComision.setToolTipText("Fecha de ingreso del empleado a la empresa. Formato de la fecha yyyy-mm-dd");

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelCliente)
                    .addComponent(lblIdCliente)
                    .addComponent(jLabel3)
                    .addComponent(lblComision))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdEmpleado)
                    .addComponent(txtFechaIngresoEmpleado)
                    .addComponent(cbxEstadoEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtComision))
                .addGap(18, 18, 18)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(lblDirCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxTipoEmpleado, 0, 137, Short.MAX_VALUE)
                    .addComponent(txtBonoEmpleado)
                    .addComponent(txtFechaSalidaEmpleado))
                .addGap(18, 18, 18)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreCliente)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEmpleado)
                            .addComponent(cbxSucursal, 0, 229, Short.MAX_VALUE)))
                    .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                        .addComponent(lblSalarioEmpleado)
                        .addGap(26, 26, 26)
                        .addComponent(txtSalarioEmpleado)))
                .addContainerGap())
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdCliente)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreCliente)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbxTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDirCliente)
                    .addComponent(txtBonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelCliente)
                    .addComponent(cbxEstadoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaSalidaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtFechaIngresoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalarioEmpleado)
                    .addComponent(txtSalarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComision)
                    .addComponent(txtComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBotones.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblBuscar.setText("Buscar");

        txtBuscar.setToolTipText("Ingrese el nombre del empleado a buscar");

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventory/imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setToolTipText("");
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

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar)
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
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnlDetalle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Mensaje.manipulacionExcepciones("interrogante", "¿Esta seguro que desea salir?");
        if (Mensaje.valor == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarEnRegistrosGuardados();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        
        btnGuardar.setEnabled(false);
        if (String.valueOf(tblEmpleados.getSelectedColumn()).equals("0")) {
            int fila_seleccionada = tblEmpleados.getSelectedRow();
            int columna_seleccionada = tblEmpleados.getSelectedColumn();
            
            String estado = estadoEmpleado(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 2)));
            estado = estadoEmpleado(estado);
            
            // ASIGNAR AL ENCABEZADO LOS DATOS
            txtNombreEmpleado.setText(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 1)));
            cbxEstadoEmpleado.setSelectedItem(estado);
            cbxTipoEmpleado.setSelectedItem(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada));
            txtBonoEmpleado.setText(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 4)));
            cbxSucursal.setSelectedItem(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 3)); //.setText(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 4)));
            txtFechaIngresoEmpleado.setText(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada +5)));
            txtFechaSalidaEmpleado.setText(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 6)));
            txtSalarioEmpleado.setText(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 7)));
            txtComision.setText(String.valueOf(tblEmpleados.getValueAt(fila_seleccionada, columna_seleccionada + 8)));
            
            //YA SELECCIONADO EL NIT BUSCO EL PROVEEDOR
            txtIdEmpleado.setText(String.valueOf(obtenerIdEmpleado(txtNombreEmpleado.getText())));
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(txtIdEmpleado.getText().isEmpty()){
            Mensaje.manipulacionExcepciones("informacion", "Debe seleccionar el registro a modificar");
        }else{
            actualizarRegistro();
            mostrarRegistrosGuardados();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnModificarActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbxEstadoEmpleado;
    private javax.swing.JComboBox cbxSucursal;
    private javax.swing.JComboBox cbxTipoEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblComision;
    private javax.swing.JLabel lblDirCliente;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblSalarioEmpleado;
    private javax.swing.JLabel lblTelCliente;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBonoEmpleado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtComision;
    private javax.swing.JTextField txtFechaIngresoEmpleado;
    private javax.swing.JTextField txtFechaSalidaEmpleado;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtSalarioEmpleado;
    // End of variables declaration//GEN-END:variables
}
