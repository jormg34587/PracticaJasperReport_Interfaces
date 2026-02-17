/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package practicajasperreport;

import static java.awt.event.KeyEvent.VK_ENTER;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Gonzalez
 */
public class GestionPedidos extends javax.swing.JDialog {
    
    private Connection con;
    TiposOperacion tipoOperacion = TiposOperacion.NO_SELECCIONADO;
    private float precioActual = 0;
    private float importeActual = 0;
    private float totalPedidoAcumulado = 0;
    private int codigoEntidadActual = 0; 
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GestionPedidos.class.getName());

    /**
     * Creates new form GestionPedidos
     */
    public GestionPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            con = ConnectionDB.getConnection();
            con.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showConfirmDialog(this, 
                    "Error de conexión con la BBDD", "Error de conexión", JOptionPane.CLOSED_OPTION);
            this.dispose();
        }
        setLocationRelativeTo(parent);
        initComponents();
    }
    
    private enum TiposOperacion {
                                NO_SELECCIONADO,
                                CLIENTE,
                                PROVEEDOR
    }

    private void cargarDatosEntidad(java.sql.ResultSet rs) throws SQLException {

        dni.setText(rs.getString("dni").substring(0,8));
        letraDni.setText(rs.getString("dni").substring(8));
        nombre.setText(rs.getString("nombre"));
        apellidos.setText(rs.getString("apellidos"));
        direccion.setText(rs.getString("direccion"));
        codigoPostal.setText(rs.getString("codigo_postal"));
        localidad.setText(rs.getString("localidad"));
        total.setText(String.valueOf(rs.getFloat("total")));
    }
    
    private void limpiarPedido() {
        nombreArticulo.setText("");
        descripcion.setText("");
        unidades.setText("");
        stock.setText("");
        precio.setText("");
        importe.setText("");

        nombreArticulo.setEnabled(true);
        unidades.setEnabled(false);
    }
    
    private void limpiarTodo() {
        codigo.setText("");
        dni.setText("");
        letraDni.setText("");
        nombre.setText("");
        apellidos.setText("");
        direccion.setText("");
        codigoPostal.setText("");
        localidad.setText("");
        total.setText("");

        limpiarPedido();
    }
    
    private void habilitarInicio() {
        codigo.setEnabled(true);
        nombreArticulo.setEnabled(false);
        unidades.setEnabled(false);
        aceptarButton.setEnabled(false);
        cancelButton.setEnabled(false);
        cancelEverythingButton.setEnabled(false);
        facturaButton.setEnabled(false);
    }
    
    private boolean calcularLetraDni() {

            String textoDni = dni.getText().trim();

            // Validar que no esté vacío y que sean números
            if (textoDni.isEmpty() || !textoDni.matches("\\d+")) {
                JOptionPane.showMessageDialog(this,
                        "Introduce un DNI válido (solo números)",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                letraDni.setText("");
                tipoOperacion = TiposOperacion.NO_SELECCIONADO;
                return false;

            }

            if (textoDni.length() != 8) {
                JOptionPane.showMessageDialog(this,
                    "El DNI debe tener 8 números",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                letraDni.setText("");
                tipoOperacion = TiposOperacion.NO_SELECCIONADO;
                return false;
            }

            int numeroDni;
            try {
                numeroDni = Integer.parseInt(textoDni);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "El DNI es demasiado grande",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                letraDni.setText("");
                tipoOperacion = TiposOperacion.NO_SELECCIONADO;
                return false;
            }

            // Letras del DNI
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            char letra = letras.charAt(numeroDni % 23);

            letraDni.setText(String.valueOf(letra));
            return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        letraDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        codigoPostal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        localidad = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        nombreArticulo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        unidades = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        importe = new javax.swing.JTextField();
        facturaButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        cancelEverythingButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        pedidosMenu = new javax.swing.JMenu();
        clientesButton = new javax.swing.JMenuItem();
        proveedoresButton = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        returnButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("N.I.F");

        dni.addActionListener(this::dniActionPerformed);

        jLabel3.setText("Nombre");

        letraDni.setEnabled(false);

        jLabel6.setText("C.P.");

        jLabel4.setText("Apellidos");

        jLabel7.setText("Localidad");

        jLabel5.setText("Domicilio");

        codigo.setName("codigo"); // NOI18N
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoKeyTyped(evt);
            }
        });

        jLabel1.setText("Código");

        total.addActionListener(this::totalActionPerformed);

        jLabel8.setText("Total");

        nombreArticulo.addActionListener(this::nombreArticuloActionPerformed);

        jLabel9.setText("Artículo");

        jLabel10.setText("Descripción");

        jLabel11.setText("Unidades");

        jLabel12.setText("Stock");

        jLabel13.setText("Precio");

        jLabel14.setText("Importe");

        unidades.addActionListener(this::unidadesActionPerformed);

        facturaButton.setText("Factura");
        facturaButton.addActionListener(this::facturaButtonActionPerformed);

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(this::aceptarButtonActionPerformed);

        exitButton.setText("Salir");
        exitButton.addActionListener(this::exitButtonActionPerformed);

        cancelButton.setText("Cancelar pedido");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

        cancelEverythingButton.setText("Cancelar todo");
        cancelEverythingButton.addActionListener(this::cancelEverythingButtonActionPerformed);

        pedidosMenu.setText("Pedidos");

        clientesButton.setText("Clientes");
        clientesButton.addActionListener(this::clientesButtonActionPerformed);
        pedidosMenu.add(clientesButton);

        proveedoresButton.setText("Proveedores");
        proveedoresButton.addActionListener(this::proveedoresButtonActionPerformed);
        pedidosMenu.add(proveedoresButton);
        pedidosMenu.add(jSeparator1);

        returnButton.setText("Volver");
        returnButton.addActionListener(this::returnButtonActionPerformed);
        pedidosMenu.add(returnButton);

        jMenuBar1.add(pedidosMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(direccion)
                    .addComponent(apellidos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(letraDni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(nombre)))
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(importe, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(facturaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aceptarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelEverythingButton)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letraDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facturaButton)
                    .addComponent(aceptarButton)
                    .addComponent(exitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(cancelEverythingButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniActionPerformed
        calcularLetraDni();
    }//GEN-LAST:event_dniActionPerformed

    private void codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyPressed

        if (evt.getKeyCode() == VK_ENTER && codigo.getText().length() == 5) {

            try {

                codigoEntidadActual = Integer.parseInt(codigo.getText());

                if (tipoOperacion == TiposOperacion.CLIENTE) {

                    var ps = con.prepareStatement("SELECT * FROM clientes WHERE codigo=?");
                    ps.setInt(1, codigoEntidadActual);
                    var rs = ps.executeQuery();

                    if (rs.next()) {
                        cargarDatosEntidad(rs);
                        codigo.setEnabled(false);
                        nombreArticulo.setEnabled(true);
                        nombreArticulo.grabFocus();
                        cancelEverythingButton.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Cliente no existe");
                    }

                } else if (tipoOperacion == TiposOperacion.PROVEEDOR) {

                    var ps = con.prepareStatement("SELECT * FROM proveedores WHERE codigo=?");
                    ps.setInt(1, codigoEntidadActual);
                    var rs = ps.executeQuery();

                    if (rs.next()) {
                        cargarDatosEntidad(rs);
                        codigo.setEnabled(false);
                        nombreArticulo.setEnabled(true);
                        nombreArticulo.grabFocus();
                        cancelEverythingButton.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Proveedor no existe");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_codigoKeyPressed

    private void codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyTyped

        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }

        if (codigo.getText().length() >= 5 ) {
            evt.consume();
        }
    }//GEN-LAST:event_codigoKeyTyped

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void proveedoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresButtonActionPerformed
        tipoOperacion = TiposOperacion.PROVEEDOR;
    
        limpiarTodo();
        habilitarInicio();

        facturaButton.setText("Finalizar");
        facturaButton.setEnabled(false);
    }//GEN-LAST:event_proveedoresButtonActionPerformed

    private void clientesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesButtonActionPerformed
        tipoOperacion = TiposOperacion.CLIENTE;
    
        limpiarTodo();
        habilitarInicio();

        facturaButton.setText("Factura");
        facturaButton.setEnabled(false);
    }//GEN-LAST:event_clientesButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        try {
            con.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

    private void nombreArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreArticuloActionPerformed
        try {

            int codArticulo = Integer.parseInt(nombreArticulo.getText());

            var ps = con.prepareStatement("SELECT * FROM articulos WHERE codigo=?");
            ps.setInt(1, codArticulo);
            var rs = ps.executeQuery();

            if (rs.next()) {

                descripcion.setText(rs.getString("descripcion"));
                stock.setText(String.valueOf(rs.getFloat("stock")));

                if (tipoOperacion == TiposOperacion.CLIENTE) {
                    precioActual = rs.getFloat("precio_venta");
                } else {
                    precioActual = rs.getFloat("precio_compra");
                }

                precio.setText(String.valueOf(precioActual));

                nombreArticulo.setEnabled(false);
                unidades.setEnabled(true);
                unidades.grabFocus();
                cancelButton.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "Artículo no existe");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_nombreArticuloActionPerformed

    private void unidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadesActionPerformed
        try {

            float unidadesPedidas = Float.parseFloat(unidades.getText());
            float stockActual = Float.parseFloat(stock.getText());

            if (tipoOperacion == TiposOperacion.CLIENTE && unidadesPedidas > stockActual) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente");
                return;
            }

            importeActual = unidadesPedidas * precioActual;
            importe.setText(String.valueOf(importeActual));

            unidades.setEnabled(false);
            aceptarButton.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_unidadesActionPerformed

    private void facturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaButtonActionPerformed
        try {

            con.commit();

            JOptionPane.showMessageDialog(this, "Transacción confirmada");

            limpiarTodo();
            habilitarInicio();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_facturaButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        try {

            float unidadesPedidas = Float.parseFloat(unidades.getText());
            int codArticulo = Integer.parseInt(nombreArticulo.getText());

            if (tipoOperacion == TiposOperacion.CLIENTE) {

                // actualizar cliente
                var ps1 = con.prepareStatement("UPDATE clientes SET total=total+? WHERE codigo=?");
                ps1.setFloat(1, importeActual);
                ps1.setInt(2, codigoEntidadActual);
                ps1.executeUpdate();

                // actualizar stock
                var ps2 = con.prepareStatement("UPDATE articulos SET stock=stock-? WHERE codigo=?");
                ps2.setFloat(1, unidadesPedidas);
                ps2.setInt(2, codArticulo);
                ps2.executeUpdate();

                // insertar histórico
                var ps3 = con.prepareStatement(
                    "INSERT INTO pedidos_clientes(codigo_cliente,codigo_articulo,unidades,fecha) VALUES(?,?,?,CURRENT_DATE)"
                );
                ps3.setInt(1, codigoEntidadActual);
                ps3.setInt(2, codArticulo);
                ps3.setFloat(3, unidadesPedidas);
                ps3.executeUpdate();

            } else {

                // actualizar proveedor
                var ps1 = con.prepareStatement("UPDATE proveedores SET total=total+? WHERE codigo=?");
                ps1.setFloat(1, importeActual);
                ps1.setInt(2, codigoEntidadActual);
                ps1.executeUpdate();

                // actualizar stock
                var ps2 = con.prepareStatement("UPDATE articulos SET stock=stock+? WHERE codigo=?");
                ps2.setFloat(1, unidadesPedidas);
                ps2.setInt(2, codArticulo);
                ps2.executeUpdate();

                var ps3 = con.prepareStatement(
                    "INSERT INTO pedidos_proveedores(codigo_proveedor,codigo_articulo,unidades,fecha) VALUES(?,?,?,CURRENT_DATE)"
                );
                ps3.setInt(1, codigoEntidadActual);
                ps3.setInt(2, codArticulo);
                ps3.setFloat(3, unidadesPedidas);
                ps3.executeUpdate();
            }

            totalPedidoAcumulado += importeActual;

            limpiarPedido();
            aceptarButton.setEnabled(false);
            facturaButton.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        try {
            con.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        limpiarPedido();
        aceptarButton.setEnabled(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cancelEverythingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEverythingButtonActionPerformed
       try {
            con.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        limpiarTodo();
        habilitarInicio();
    }//GEN-LAST:event_cancelEverythingButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GestionPedidos dialog = new GestionPedidos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField apellidos;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelEverythingButton;
    private javax.swing.JMenuItem clientesButton;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField codigoPostal;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField dni;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton facturaButton;
    private javax.swing.JTextField importe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField letraDni;
    private javax.swing.JTextField localidad;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombreArticulo;
    private javax.swing.JMenu pedidosMenu;
    private javax.swing.JTextField precio;
    private javax.swing.JMenuItem proveedoresButton;
    private javax.swing.JMenuItem returnButton;
    private javax.swing.JTextField stock;
    private javax.swing.JTextField total;
    private javax.swing.JTextField unidades;
    // End of variables declaration//GEN-END:variables

}
