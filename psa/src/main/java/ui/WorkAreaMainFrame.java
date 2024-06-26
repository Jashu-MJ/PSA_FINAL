/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.example.BookingDirectory;
import org.example.ConfigureSystem;
import org.example.Ecosystem;
import org.example.persona.Customer;
import org.example.dsa.ArrayBag;
import org.example.persona.DelPartner;
import org.example.utils.DBConn;
import org.example.utils.Utils;
import ui.customer.CustomerHomeJPanel;
import ui.deliveryPartner.DPHomeJPanel;
import ui.manager.ManagerJPanel;


/**
 *
 * @author kal bugrara
 */
public class WorkAreaMainFrame extends javax.swing.JFrame {

    Ecosystem es;

    /**
     * Creates new form PricingMainFrame
     */
    public WorkAreaMainFrame() {
        initComponents();
            es = ConfigureSystem.initialize();
        
        


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserNameTextField = new javax.swing.JTextField();
        SplitHomeArea = new javax.swing.JSplitPane();
        actionsidejpanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        ddUser = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        CardSequencePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        UserNameTextField.setText("admin");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actionsidejpanel.setBackground(new java.awt.Color(0, 153, 153));
        actionsidejpanel.setMinimumSize(new java.awt.Dimension(200, 200));

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("User Name");

        PasswordTextField.setText("XXXX");
        PasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        btnSignup.setText("Sign Up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupLoginButtonActionPerformed(evt);
            }
        });

        ddUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Del Partner","Manager"}));
        ddUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddUserActionPerformed(evt);
            }
        });

        txtUsername.setText("username");

        javax.swing.GroupLayout actionsidejpanelLayout = new javax.swing.GroupLayout(actionsidejpanel);
        actionsidejpanel.setLayout(actionsidejpanelLayout);
        actionsidejpanelLayout.setHorizontalGroup(
            actionsidejpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsidejpanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(actionsidejpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSignup)
                    .addGroup(actionsidejpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        actionsidejpanelLayout.setVerticalGroup(
            actionsidejpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsidejpanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(ddUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        SplitHomeArea.setLeftComponent(actionsidejpanel);

        CardSequencePanel.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Spice Squad");
        CardSequencePanel.add(jLabel3, "card2");

        SplitHomeArea.setRightComponent(CardSequencePanel);

        getContentPane().add(SplitHomeArea, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        //      WorkAreaJPanel ura = new WorkAreaJPanel(workareajpanl);
        
        String un = txtUsername.getText();
        String pw = PasswordTextField.getText();
        ArrayBag<Customer> testBag = new ArrayBag<Customer>();
        Connection conn = DBConn.establishConnection();

        if ("Customer".toLowerCase().equals((ddUser.getSelectedItem()).toString().toLowerCase())) {
            Customer customer = es.getCustomerDirectory().findCustomerByEmail(un);

            if (customer == null || !(Utils.authenticateUser(es,"customer", customer, pw))) {
            JOptionPane.showMessageDialog(this, "Username or password is incorrect or User doesn't exists");
            return;
        }
            CustomerHomeJPanel customerHomeJPanel = new CustomerHomeJPanel(es, CardSequencePanel, customer);
            //CardSequencePanel.removeAll();
            CardSequencePanel.add("customer", customerHomeJPanel);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        }
        else if ("Del Partner".toLowerCase().equals((ddUser.getSelectedItem()).toString().toLowerCase())) {
            DelPartner dp = es.getDPDirectory().findDPByEmail(un);
            if(dp == null || !(Utils.authenticateUser(es,"dp", dp, pw))) {
            JOptionPane.showMessageDialog(this, "Username or password is incorrect or User doesn't exists");
            return;
        }
            DPHomeJPanel dPHomeJPanel = new DPHomeJPanel(es, CardSequencePanel, dp);
            //CardSequencePanel.removeAll();
            CardSequencePanel.add("Dp", dPHomeJPanel);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        }
        //if ("Manager".toLowerCase().equals((ddUser.getSelectedItem()).toString().toLowerCase())) {
        else{            
            if(!(Utils.authenticateUser(es, "manager", un, pw))) {
            JOptionPane.showMessageDialog(this, "Username or password is incorrect or User doesn't exists");
            return;
        }
            ManagerJPanel managerJPanel = new ManagerJPanel(es, CardSequencePanel);
            //CardSequencePanel.removeAll();
            CardSequencePanel.add("Manager", managerJPanel);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        }

    }//GEN-LAST:event_LoginButtonActionPerformed

    private void PasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTextFieldActionPerformed

    private void btnSignupLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupLoginButtonActionPerformed

    if ("Customer".toLowerCase().equals((ddUser.getSelectedItem()).toString().toLowerCase())){
        SignUpCustomerJPanel signupJPanel = new SignUpCustomerJPanel(es, CardSequencePanel);
        //CardSequencePanel.removeAll();
        CardSequencePanel.add("SignUpCustomer", signupJPanel);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }
    if ("Del Partner".toLowerCase().equals((ddUser.getSelectedItem()).toString().toLowerCase())) {
        
        SignUpDPJPanel signupJPanel = new SignUpDPJPanel(es, CardSequencePanel);
        //CardSequencePanel.removeAll();
        CardSequencePanel.add("SignUpDP", signupJPanel);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }

    }//GEN-LAST:event_btnSignupLoginButtonActionPerformed

    private void ddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddUserActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkAreaMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardSequencePanel;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JSplitPane SplitHomeArea;
    private javax.swing.JTextField UserNameTextField;
    private javax.swing.JPanel actionsidejpanel;
    private javax.swing.JButton btnSignup;
    private javax.swing.JComboBox<String> ddUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
