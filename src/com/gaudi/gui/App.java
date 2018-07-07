package com.gaudi.gui;

import com.gaudi.model.Autor;
import com.gaudi.model.Data;
import com.gaudi.model.Genero;
import com.gaudi.model.Sala;
import com.gaudi.model.TableModelObras;
import com.gaudi.model.Tecnica;
import com.gaudi.model.ViewObra;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier Vergara Lee
 */
public class App extends javax.swing.JFrame {

    Data d;
    TableModelObras tmO;
    boolean first;

    public App() {
        this.first = true;
        try {
            this.d = new Data();
        } catch (ClassNotFoundException | SQLException e) {
        }

        initComponents();
        initGui();
        loadTblObra();
    }

    private void initGui() {
        setTitle("GAUDI");
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        tmO = new TableModelObras();
        tblObras.setModel(tmO);
        setResizable(true);

        try {
            List<Sala> s = this.d.selectSala();
            cboObraSala.removeAllItems();
            String[] cboObraSalaItems = {"Todas"};
            for (String c : cboObraSalaItems) {
                cboObraSala.addItem(c);
            }
            for (Sala sala : s) {
                cboObraSala.addItem(sala.getNombreSala());
            }

            cboSala.removeAllItems();
            for (Sala sala : s) {
                cboSala.addItem(sala.getNombreSala());
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnBorrar.setEnabled(false);

        try {
            List<Autor> a = this.d.selectAutor();
            cboAutor.removeAllItems();
            for (Autor autor : a) {
                cboAutor.addItem(autor.getNombreAutor());
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<Tecnica> t = this.d.selectTecnica();
            cboTecnica.removeAllItems();
            for (Tecnica tecnica : t) {
                cboTecnica.addItem(tecnica.getTecnica());
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<Genero> g = this.d.selectGenero();
            cboGenero.removeAllItems();
            for (Genero genero : g) {
                cboGenero.addItem(genero.getGenero());
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.first = false;
    }

    private void resetComponents() {
        txtCodigo.setText(null);
        txtNombre.setText(null);
        cboAutor.setSelectedIndex(0);
        cboTecnica.setSelectedIndex(0);
        cboGenero.setSelectedIndex(0);
        txtAnio.setText(null);
        spnAlto.setValue(0);
        spnAncho.setValue(0);
        cboSala.setSelectedIndex(0);
        txtCodigo.requestFocus();
        btnCrear.setEnabled(true);
        btnBorrar.setEnabled(false);
    }

    private void loadTblObra() {
        try {
            List<ViewObra> v = this.d.viewObra();
            for (ViewObra viewObra : v) {
                Object[] viewObject = {viewObra.getCodigo(), viewObra.getNombreObra(),
                    viewObra.getAnio(), viewObra.getAlto() + " x " + viewObra.getAncho(),
                    viewObra.getTecnica(), viewObra.getGenero(), viewObra.getNombreAutor(),
                    viewObra.getNombreSala()};
                tmO.addRow(viewObject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reloadTblObra() {
        for (int i = tmO.getRowCount() - 1; i > -1; i--) {
            tmO.removeRow(i);
        }

        loadTblObra();
    }

    private void filterTblObraSala(String sala) {
        for (int i = tmO.getRowCount() - 1; i > -1; i--) {
            tmO.removeRow(i);
        }

        try {
            List<ViewObra> v = this.d.filterObraSala(sala);
            for (ViewObra viewObra : v) {
                Object[] viewObject = {viewObra.getCodigo(), viewObra.getNombreObra(),
                    viewObra.getAnio(), viewObra.getAlto() + " x " + viewObra.getAncho(),
                    viewObra.getTecnica(), viewObra.getGenero(), viewObra.getNombreAutor(),
                    viewObra.getNombreSala()};
                tmO.addRow(viewObject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void filterTblObraNombre(String nombre) {
        for (int i = tmO.getRowCount() - 1; i > -1; i--) {
            tmO.removeRow(i);
        }

        try {
            List<ViewObra> v = this.d.filterObraNombre(nombre);
            for (ViewObra viewObra : v) {
                Object[] viewObject = {viewObra.getCodigo(), viewObra.getNombreObra(),
                    viewObra.getAnio(), viewObra.getAlto() + " x " + viewObra.getAncho(),
                    viewObra.getTecnica(), viewObra.getGenero(), viewObra.getNombreAutor(),
                    viewObra.getNombreSala()};
                tmO.addRow(viewObject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void filterTblObraNombreSala(String nombre, String sala) {
        for (int i = tmO.getRowCount() - 1; i > -1; i--) {
            tmO.removeRow(i);
        }

        try {
            List<ViewObra> v = this.d.filterObraNombreSala(nombre, sala);
            for (ViewObra viewObra : v) {
                Object[] viewObject = {viewObra.getCodigo(), viewObra.getNombreObra(),
                    viewObra.getAnio(), viewObra.getAlto() + " x " + viewObra.getAncho(),
                    viewObra.getTecnica(), viewObra.getGenero(), viewObra.getNombreAutor(),
                    viewObra.getNombreSala()};
                tmO.addRow(viewObject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void enableComponents(boolean state) {
        txtCodigo.setEnabled(state);
        txtNombre.setEnabled(state);
        cboAutor.setEnabled(state);
        cboTecnica.setEnabled(state);
        cboGenero.setEnabled(state);
        txtAnio.setEnabled(state);
        spnAlto.setEnabled(state);
        spnAncho.setEnabled(state);
        cboSala.setEnabled(state);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cboAutor = new javax.swing.JComboBox<>();
        cboTecnica = new javax.swing.JComboBox<>();
        cboGenero = new javax.swing.JComboBox<>();
        txtAnio = new javax.swing.JFormattedTextField();
        cboSala = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        spnAncho = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spnAlto = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObras = new javax.swing.JTable();
        cboObraSala = new javax.swing.JComboBox<>();
        txtBuscarObra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Obra"));

        jLabel1.setText("Código:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Técnica:");

        jLabel4.setText("Género:");

        jLabel5.setText("Año:");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Tamaño:");

        jLabel8.setText("Sala:");

        cboAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboTecnica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtAnio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy"))));

        cboSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel12.setText("x");

        jLabel13.setText("cm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo)
                            .addComponent(txtNombre)
                            .addComponent(cboAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTecnica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAnio)
                            .addComponent(cboSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(spnAncho, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnAlto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spnAncho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(spnAlto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnBorrar)
                    .addComponent(btnCrear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblObras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblObras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblObrasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblObras);

        cboObraSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboObraSala.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboObraSalaPropertyChange(evt);
            }
        });

        txtBuscarObra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarObraKeyReleased(evt);
            }
        });

        jLabel10.setText("Filtrar por Sala:");

        jLabel11.setText("Nombre de la Obra:");

        jMenu1.setText("Archivo");

        miSalir.setText("Salir");
        miSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalirActionPerformed(evt);
            }
        });
        jMenu1.add(miSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboObraSala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscarObra))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboObraSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        enableComponents(true);
        resetComponents();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            if (String.valueOf(anio).length() > 4) {
                resetComponents();
                JOptionPane.showMessageDialog(this, "El año ingresado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float alto = Float.parseFloat(spnAlto.getValue().toString());
            float ancho = Float.parseFloat(spnAncho.getValue().toString());
            String tecnica = (String) cboTecnica.getSelectedItem();
            String genero = (String) cboGenero.getSelectedItem();
            String autor = (String) cboAutor.getSelectedItem();
            String sala = (String) cboSala.getSelectedItem();

            this.d.createObra(codigo, nombre, anio, alto, ancho, tecnica, genero, autor, sala);

            resetComponents();
            reloadTblObra();

            JOptionPane.showMessageDialog(this, "Obra creada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | NumberFormatException | SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            resetComponents();
            JOptionPane.showMessageDialog(this, "Hubo un error en el ingreso de la obra.\n"
                    + "Inténtelo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void tblObrasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblObrasMouseReleased
        if (evt.getClickCount() == 2) {
            txtCodigo.setText(tblObras.getValueAt(tblObras.getSelectedRow(), 0).toString());
            txtNombre.setText((String) tblObras.getValueAt(tblObras.getSelectedRow(), 1));
            cboAutor.setSelectedItem(tblObras.getValueAt(tblObras.getSelectedRow(), 6));
            cboTecnica.setSelectedItem(tblObras.getValueAt(tblObras.getSelectedRow(), 4));
            cboGenero.setSelectedItem(tblObras.getValueAt(tblObras.getSelectedRow(), 5));
            txtAnio.setText(tblObras.getValueAt(tblObras.getSelectedRow(), 2).toString());
            String[] dimensiones = tblObras.getValueAt(tblObras.getSelectedRow(), 3).toString().trim().split("x");
            spnAlto.setValue(Float.parseFloat(dimensiones[0]));
            spnAncho.setValue(Float.parseFloat(dimensiones[1]));
            cboSala.setSelectedItem(tblObras.getValueAt(tblObras.getSelectedRow(), 7));
            btnCrear.setEnabled(false);
            btnBorrar.setEnabled(true);

            enableComponents(false);
        }
    }//GEN-LAST:event_tblObrasMouseReleased

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {
            int deleteconfirm = JOptionPane.showConfirmDialog(this,
                    "¿Desea borrar la obra seleccionada?", "Confirmación",
                    JOptionPane.YES_NO_OPTION);
            if (deleteconfirm == JOptionPane.YES_OPTION) {
                this.d.deleteObra(Integer.parseInt(txtCodigo.getText()));
                reloadTblObra();
                resetComponents();
            } else {
                resetComponents();
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void cboObraSalaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboObraSalaPropertyChange
        if (this.first) {
            return;
        }

        String sala = (String) cboObraSala.getSelectedItem();
        if (sala.equals("Todas")) {
            reloadTblObra();
        } else {
            filterTblObraSala(sala);
        }
    }//GEN-LAST:event_cboObraSalaPropertyChange

    private void txtBuscarObraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarObraKeyReleased
        String sala = (String) cboObraSala.getSelectedItem();
        String nombre = txtBuscarObra.getText();

        if (!sala.equals("Todas")) {
            filterTblObraNombreSala(nombre, sala);
        } else {
            filterTblObraNombre(nombre);
        }
    }//GEN-LAST:event_txtBuscarObraKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> cboAutor;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JComboBox<String> cboObraSala;
    private javax.swing.JComboBox<String> cboSala;
    private javax.swing.JComboBox<String> cboTecnica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miSalir;
    private javax.swing.JSpinner spnAlto;
    private javax.swing.JSpinner spnAncho;
    private javax.swing.JTable tblObras;
    private javax.swing.JFormattedTextField txtAnio;
    private javax.swing.JTextField txtBuscarObra;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
