/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.BoletoControl;
import Controlador.PasajeroControl;
import Controlador.TDA.Listas.Exception.EmptyException;
import Controlador.TDA.Listas.ListaEnlazada;
import static Controlador.Validacion.Cedula.validadorDeCedula;
import Controlador.VentaControl;
import Controlador.dao.Implements.ControlVenta;
import Vista.Tabla.ModeloTablaBoleto;
import Vista.Tabla.ModeloTablaVentas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Venta;

/**
 *
 * @author Usuario
 */
public class FrmListaVenta extends javax.swing.JFrame {

    /**
     * Creates new form FrmListaVenta
     *
     * @param vc
     */
    public FrmListaVenta(VentaControl vc) throws EmptyException {
        initComponents();
        VentaControl = vc;

        txtTotalBoleto.setText(Double.toString(VentaControl.getVenta().getTotal_Boleto()));
        txtMonto_Total.setText(Double.toString(montoTotal()));

    }
    private VentaControl VentaControl = new VentaControl();
    private ModeloTablaVentas mtv = new ModeloTablaVentas();
    private PasajeroControl PasajeroControl = new PasajeroControl();
    private BoletoControl BoletoControl = new BoletoControl();

    public void cargarVentas() {

        mtv.setVentas(VentaControl.getVentas());
        Tabla3.setModel(mtv);
        Tabla3.updateUI();
    }

    public Boolean verificar() {
        return (!txtnum_Venta.getText().trim().isEmpty()
                  && !txtfecha_Compra.getText().trim().isEmpty());
    }

    private void guardar() throws EmptyException {
        if (verificar()) {

            VentaControl.getVenta().setNum_Venta(txtnum_Venta.getText());
            VentaControl.getVenta().setFecha(txtfecha_Compra.getText());
            VentaControl.getVenta().setTotal_Boleto(Double.valueOf(txtTotalBoleto.getText()));
            VentaControl.getVenta().setMonto_Total(Double.valueOf(txtMonto_Total.getText()));
            if (VentaControl.guardar()) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
                ControlVenta cv = new ControlVenta();
                cv.guardar(VentaControl.getVenta());
                cargarVentas();

                limpiar();
            }
            else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar, hubo un error");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        txtnum_Venta.setText("");
        txtfecha_Compra.setText("");
        cargarVentas();
    }

    private Double montoTotal() throws EmptyException {
        Double total = 0.0;

        for (int i = 0; i < VentaControl.getVentas().getLength(); i++) {
            total += VentaControl.getVentas().getInfo(i).getTotal_Boleto();
        }

        System.out.println(total);
        return total;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JToggleButton();
        btnAgregarNuevaVenta = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        txtMonto_Total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnum_Venta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfecha_Compra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTotalBoleto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla3);

        jLabel1.setText("Total Boletos Vendidos ");

        btnModificar.setText("Modificar");

        btnAgregarNuevaVenta.setText("Agregar Nueva Venta");
        btnAgregarNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNuevaVentaActionPerformed(evt);
            }
        });

        jLabel2.setText("Monto Total");

        txtMonto_Total.setEnabled(false);
        txtMonto_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonto_TotalActionPerformed(evt);
            }
        });

        jLabel3.setText("Numero de Venta:");

        txtnum_Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_VentaActionPerformed(evt);
            }
        });

        jLabel4.setText("fecha_Compra:");

        txtfecha_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfecha_CompraActionPerformed(evt);
            }
        });

        jLabel7.setText("Total Boleto:");

        txtTotalBoleto.setEnabled(false);
        txtTotalBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalBoletoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnModificar)
                        .addGap(43, 43, 43)
                        .addComponent(btnAgregarNuevaVenta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtMonto_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(txtnum_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtTotalBoleto)))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(txtfecha_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtnum_Venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtfecha_Compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotalBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnAgregarNuevaVenta))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtMonto_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfecha_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfecha_CompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfecha_CompraActionPerformed

    private void txtTotalBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalBoletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalBoletoActionPerformed

    private void txtnum_VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_VentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_VentaActionPerformed

    private void txtMonto_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonto_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonto_TotalActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            guardar();
        }
        catch (EmptyException ex) {
            Logger.getLogger(FrmListaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtfecha_Compra.disable();
        txtnum_Venta.disable();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNuevaVentaActionPerformed
        FrmListaVenta frmListaVenta = null;

        FrmVentaBoleto frm = new FrmVentaBoleto();

        frm.setVisible(true);

    }//GEN-LAST:event_btnAgregarNuevaVentaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla3;
    private javax.swing.JToggleButton btnAgregarNuevaVenta;
    private javax.swing.JToggleButton btnGuardar;
    private javax.swing.JToggleButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtMonto_Total;
    private javax.swing.JTextField txtTotalBoleto;
    private javax.swing.JTextField txtfecha_Compra;
    private javax.swing.JTextField txtnum_Venta;
    // End of variables declaration//GEN-END:variables
}
