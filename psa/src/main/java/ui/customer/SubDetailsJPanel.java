/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.example.Ecosystem;
import static org.example.dsa.MergeSort.mergeSort;
import org.example.persona.Customer;
import org.example.persona.SubDetails;


/**
 *
 * @author marri
 */
public class SubDetailsJPanel extends javax.swing.JPanel {

    Ecosystem es;
    javax.swing.JPanel CardSequencePanel;
    Customer cust;
    SubDetails selectedSubDetail;

    /**
     * Creates new form SubDetailsJPanel
     */
    public SubDetailsJPanel(Ecosystem es, JPanel clp, Customer cust) {
        this.es = es;
        this.CardSequencePanel = clp;
        this.cust = cust;
        initComponents();
        refreshSubDetailsTable();
    }

    void refreshSubDetailsTable() {
//clear supplier table
        int rc = tblDetails.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) tblDetails.getModel()).removeRow(i);
        }
        SubDetails[] subDetails = es.getSubDetailsDirectory().bagToArray();
        Comparator<SubDetails> comparator = Comparator.comparing(myObj -> myObj.getSDate());
        mergeSort(subDetails, comparator);

        for (SubDetails subDetail : subDetails) {
            if (cust.isMatch(subDetail.getCID())) {
                Object[] row = new Object[7];
                row[0] = subDetail; //.getAssociatedPersonProfile().getPerson().getName();
                row[1] = subDetail.getSubType();
                row[2] = subDetail.getSubPrice();
                row[3] = subDetail.getSDate();
                row[4] = subDetail.getEDate();
                row[5] = subDetail.getMealsLeft();
                ((DefaultTableModel) tblDetails.getModel()).addRow(row);
            }
            selectedSubDetail = null;
        }

    }

//        void refreshSubDetailsTable() {
////clear supplier table
//        int rc = tblDetails.getRowCount();
//        int i;
//        for (i = rc - 1; i >= 0; i--) {
//            ((DefaultTableModel) tblDetails.getModel()).removeRow(i);
//        }
//        ArrayList<MealOrder> mealOrders = es.get().getMealOrderlist();
//
//        for (MealOrder mealOrder : mealOrders) {
//            Object[] row = new Object[7];
//            row[0] = mealOrder; //.getAssociatedPersonProfile().getPerson().getName();
//            row[1] = mealOrder.getPp();
//            row[2] = mealOrder.getDp();
//            row[3] = mealOrder.getPp().getDietaryChoice();
//            row[4] = mealOrder.getStartDate();
//            row[5] = mealOrder.getPeriod() + " Weeks";
//            row[6] = mealOrder.isIsActive();
//            ((DefaultTableModel) tblMealOrders.getModel()).addRow(row);
//        }
//        selectedMealorder = null;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetails = new javax.swing.JTable();
        setLayout(null);


        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(57, 430, 72, 23);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Subscription Plan Details");
        add(jLabel1);
        jLabel1.setBounds(6, 6, 710, 71);

        tblDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sub ID", "Sub Type", "Price", "Start Date", "End Date", "Meals Left"
            }
        ));
        tblDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDetailsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetails);
        add(jScrollPane1);
        jScrollPane1.setBounds(50, 130, 640, 230);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblDetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetailsMousePressed
        // TODO add your handling code here:
        // Extracts the row (uaser account) in the table that is selected by the user
        int size = tblDetails.getRowCount();
        int selectedrow = tblDetails.getSelectionModel().getLeadSelectionIndex();
        if (selectedrow < 0 || selectedrow > size - 1) {
            return;
        }
        selectedSubDetail = (SubDetails) tblDetails.getValueAt(selectedrow, 0);
        if (selectedSubDetail == null) {
            return;

        }
    }//GEN-LAST:event_tblDetailsMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDetails;
    // End of variables declaration//GEN-END:variables
}

/*
    // Example usage
    public static void main(String[] args) {
        // Example class with date field
        class MyClass {
            String name;
            Date date;

            public MyClass(String name, Date date) {
                this.name = name;
                this.date = date;
            }
        }

        // Comparator to sort MyClass objects by date
        

        // Sample array of MyClass objects
        MyClass[] myArray = {
                new MyClass("Object 1", new Date(2024 - 1900, 3, 15)), // April 15, 2024
                new MyClass("Object 2", new Date(2024 - 1900, 3, 10)), // April 10, 2024
                new MyClass("Object 3", new Date(2024 - 1900, 3, 20)) // April 20, 2024
        };

        // Sort the array using merge sort
        mergeSort(myArray, comparator);

        // Print sorted array
        for (MyClass obj : myArray) {
            System.out.println(obj.name + " - " + obj.date);
        }
    }
 */
