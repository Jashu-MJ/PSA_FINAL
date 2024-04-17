/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.customer;

import javax.swing.JPanel;
import org.example.Ecosystem;
import org.example.persona.Customer;



/**
 *
 * @author marri
 */
public class CustomerHomeJPanel extends javax.swing.JPanel {

    Ecosystem es;
    javax.swing.JPanel CardSequencePanel;
    Customer cust;

    /**
     * Creates new form CustomerHomeJPanel
     * @param es
     * @param clp
     */
    public CustomerHomeJPanel(Ecosystem es, JPanel clp, Customer customer) {
        this.es=es;
        this.CardSequencePanel = clp;
        this.cust = customer;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSubscribe = new javax.swing.JButton();
        btnSubDetails = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnMealStatus = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        jButton6.setText("jButton6");

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 478, 55);

        btnSubscribe.setText("Subscribe To Meal Plan");
        btnSubscribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscribeActionPerformed(evt);
            }
        });
        add(btnSubscribe);
        btnSubscribe.setBounds(40, 130, 170, 40);

        btnSubDetails.setText("Subscription Details");
        btnSubDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubDetailsActionPerformed(evt);
            }
        });
        add(btnSubDetails);
        btnSubDetails.setBounds(290, 130, 154, 40);

        btnBook.setText("Book a Meal");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        add(btnBook);
        btnBook.setBounds(40, 240, 170, 38);

        btnMealStatus.setText("Meal Status");
        btnMealStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMealStatusActionPerformed(evt);
            }
        });
        add(btnMealStatus);
        btnMealStatus.setBounds(290, 240, 154, 38);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        add(btnLogout);
        btnLogout.setBounds(300, 350, 105, 29);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscribeActionPerformed
        // TODO add your handling code here:
          SubscribePlanJPanel subscribePlanJPanel = new SubscribePlanJPanel(es, CardSequencePanel, cust);
          //CardSequencePanel.removeAll();
          CardSequencePanel.add("subPlan", subscribePlanJPanel);
         ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnSubscribeActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
BookMealJPanel bookMealJPanel= new BookMealJPanel(es, CardSequencePanel, cust);
  CardSequencePanel.add("bookMealPlan", bookMealJPanel);
         ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSubDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubDetailsActionPerformed
        // TODO add your handling code here:
        SubDetailsJPanel subDetailsJPanel = new SubDetailsJPanel(es, CardSequencePanel, cust);
          //CardSequencePanel.removeAll();
          subDetailsJPanel.refreshSubDetailsTable();
          CardSequencePanel.add("subPlan", subDetailsJPanel);
         ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnSubDetailsActionPerformed

    private void btnMealStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMealStatusActionPerformed
        // TODO add your handling code here:
            MealStatusJPanel mealStatusJPanel = new MealStatusJPanel(es, CardSequencePanel, cust);
            CardSequencePanel.add("mealStatus", mealStatusJPanel);
         ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnMealStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMealStatus;
    private javax.swing.JButton btnSubDetails;
    private javax.swing.JButton btnSubscribe;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
