/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.customer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.example.Ecosystem;
import org.example.persona.Customer;
import org.example.utils.DBConn;
import ui.SignUpDPJPanel;

/**
 *
 * @author marri
 */
public class SubscribePlanJPanel extends javax.swing.JPanel {

    Ecosystem es;
    javax.swing.JPanel CardSequencePanel;
    Customer cust;
    /**
     * Creates new form SubscribePlanJPanel
     */
    public SubscribePlanJPanel(Ecosystem es, JPanel clp, Customer cust) {
        this.es=es;
        this.CardSequencePanel = clp;
        this. cust = cust;
        initComponents();
        txtPrice.setEnabled(false);
        txtMealCount.setEnabled(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbSubType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMealCount = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnSubscribe = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Subscribe to a Meal Plan");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 71);

        cmbSubType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Weekly", "Monthly"}));
        cmbSubType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSubTypeActionPerformed(evt);
            }
        });
        cmbSubType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbSubTypeKeyPressed(evt);
            }
        });
        add(cmbSubType);
        cmbSubType.setBounds(250, 110, 150, 40);

        jLabel2.setText("Subscription Type");
        add(jLabel2);
        jLabel2.setBounds(120, 110, 108, 32);

        jLabel3.setText("Price");
        add(jLabel3);
        jLabel3.setBounds(130, 190, 80, 16);

        jLabel4.setText("Meal Count");
        add(jLabel4);
        jLabel4.setBounds(120, 250, 90, 16);

        txtMealCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMealCountActionPerformed(evt);
            }
        });
        add(txtMealCount);
        txtMealCount.setBounds(250, 240, 150, 30);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        add(txtPrice);
        txtPrice.setBounds(250, 180, 150, 30);

        btnSubscribe.setText("Subscribe to plan");
        btnSubscribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscribeActionPerformed(evt);
            }
        });
        add(btnSubscribe);
        btnSubscribe.setBounds(200, 350, 190, 30);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(60, 390, 72, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscribeActionPerformed
        
        Connection conn = DBConn.establishConnection();
        try {
            CallableStatement callableStatement = conn.prepareCall("{call PurchaseSubscription(?,?,?)}");
            callableStatement.setInt(1, Integer.parseInt(cust.getId()));
            callableStatement.setString(2, cmbSubType.getSelectedItem().toString());
            callableStatement.setInt(3, Integer.parseInt(txtPrice.getText()));
            callableStatement.execute();
            JOptionPane.showMessageDialog(this, "Subscribed to the Plan!");
            es.refreshSubDetails();
        } catch (SQLException ex) {
            Logger.getLogger(SignUpDPJPanel.class.getName()).log(Level.SEVERE, ex.toString(), ex);
        }catch(NumberFormatException nEx){
            System.out.println(nEx.toString());
            JOptionPane.showMessageDialog(this, "Price is inCorrect!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubscribeActionPerformed

    private void cmbSubTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbSubTypeKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbSubTypeKeyPressed

    private void txtMealCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMealCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMealCountActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void cmbSubTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSubTypeActionPerformed
        // TODO add your handling code here:
                if(cmbSubType.getSelectedItem().toString().equalsIgnoreCase("Weekly")){
            txtPrice.setText("50");
            txtMealCount.setText("10");
        }else{
            txtPrice.setText("180");
            txtMealCount.setText("45");
        }
    }//GEN-LAST:event_cmbSubTypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);           // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubscribe;
    private javax.swing.JComboBox<String> cmbSubType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtMealCount;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
