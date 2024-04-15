/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.manager;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.example.BookingDirectory;
import org.example.DPDirectory;
import org.example.Ecosystem;
import org.example.dsa.DoublyLinkedListPriorityQueue;
import org.example.persona.Booking;



public class ManagerJPanel extends javax.swing.JPanel {

     Ecosystem es;
    javax.swing.JPanel CardSequencePanel;
    BookingDirectory bookingDirectory;
    //DPDirectory dpDirectory;

    /**
     * Creates new form ManagerJPanel
     */
    public ManagerJPanel(Ecosystem eco, JPanel clp) {
        this.es=eco;
        this.CardSequencePanel = clp;
        this.bookingDirectory = es.getBookingDirectory();  // Initialize BookingDirectory
        initComponents();
        populateBookingTable();
        populateDPComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manager Home");

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "Customer ID", "Subscription ID", "Meal ID", "Booking Date", "Date of Delivery", "Time Slot", "Delivery Partner ID", "Is Delivered"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Assign");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Delivery Partner");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(473, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(466, 466, 466))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // Get the selected booking from the table
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        // No booking selected
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a booking to assign a delivery partner.");
        return;
    }

    // Get the booking ID from the selected row
    String bookingID = jTable1.getValueAt(selectedRow, 0).toString();

    // Get the selected delivery partner from jComboBox2
    String deliveryPartnerDet = jComboBox2.getSelectedItem().toString();
    String[] parts = deliveryPartnerDet.split("-");
    String deliveryPartnerName = parts[0].trim();
    String deliveryPartnerID = parts[1].trim();
    

    // Find the booking with the booking ID
    Booking booking = bookingDirectory.getBookingById(bookingID);

    if (booking != null) {
        // Assign the selected delivery partner to the booking
        booking.setDeliveryPersonId(deliveryPartnerID);

        // Update the booking directory
        bookingDirectory.updateBooking(booking);

        // Show a confirmation message
        javax.swing.JOptionPane.showMessageDialog(this, "Delivery partner assigned successfully.");

        // Refresh the booking table
        populateBookingTable();
    } else {
        // Booking not found
        javax.swing.JOptionPane.showMessageDialog(this, "Booking not found.");
    }
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


    
    private void populateBookingTable() {
// Initialize the DoublyLinkedListPriorityQueue for Booking objects
    DoublyLinkedListPriorityQueue<Booking> priorityQueue = new DoublyLinkedListPriorityQueue<>();
    
    

    // Add all bookings from BookingDirectory to the priority queue
    if (bookingDirectory != null && bookingDirectory.getBookingList() != null) {
        for (Booking booking : bookingDirectory.getBookingList()) {
            //System.out.println("Test:"+booking.getBookId()+"---");
            priorityQueue.add(booking);
        }
        
    }
       

    // Define columns for the table model
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Booking ID");
    model.addColumn("Customer ID");
    model.addColumn("Subscription ID");
    model.addColumn("Meal ID");
    model.addColumn("Booking Date");
    model.addColumn("Date of Delivery");
    model.addColumn("Time Slot");
    model.addColumn("Delivery Partner ID");
    model.addColumn("Is Delivered");

    // Iterate through the priority queue and add rows to the model
    while (!priorityQueue.isEmpty()) {
        Booking booking = priorityQueue.remove();
        model.addRow(new Object[]{
            booking.getBookId(),
            booking.getCustomerId(),
            booking.getSubscriptionId(),
            booking.getMealId(),
            booking.getBookingDate(),
            booking.getDateOfDelivery(),
            booking.getTimeSlot(),
            booking.getDeliveryPersonId(),
            booking.isDelivered()
        });
    }

    // Set the model for the jTable1
    jTable1.setModel(model);
    }
    
    private void populateDPComboBox() {
    // Retrieve the DPDirectory instance from the Ecosystem
    DPDirectory dpDirectory = es.getDPDirectory();
    
    // Ensure DPDirectory is not null
    if (dpDirectory != null) {
        // Retrieve the list of delivery partner names from DPDirectory
        List<String> dpNames = dpDirectory.getAllDPNames();

        // Clear the current items in the combo box
        jComboBox2.removeAllItems();

        // Add each delivery partner name to the combo box
        for (String dpName : dpNames) {
            jComboBox2.addItem(dpName);
        }
    } else {
        // Handle the case where DPDirectory is null
        System.out.println("DPDirectory instance is null.");
    }
    
    }
    
    



}
