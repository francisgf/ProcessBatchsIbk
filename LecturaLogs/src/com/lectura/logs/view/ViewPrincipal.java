/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lectura.logs.view;

import com.lectura.logs.entities.Logs;
import com.lectura.logs.logic.LecturaLogsInterface;
import com.lectura.logs.logic.impl.LecturaLogsImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 15-AX222LA
 */
public class ViewPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ViewPrincipal
     */
    public ViewPrincipal() {
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

        label1 = new java.awt.Label();
        btn_filter = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_viewLog = new javax.swing.JTable();
        cb_info = new javax.swing.JCheckBox();
        cb_error = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        label1.setText("Filtrar Logs Por:");

        btn_filter.setLabel("Filtrar");
        btn_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filterActionPerformed(evt);
            }
        });

        tb_viewLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line Log", "Text Log", "Type Log"
            }
        ));
        jScrollPane2.setViewportView(tb_viewLog);

        cb_info.setText("Level Info");

        cb_error.setText("Level Error");
        cb_error.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_errorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cb_info)
                .addGap(55, 55, 55)
                .addComponent(cb_error)
                .addGap(60, 60, 60)
                .addComponent(btn_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_info)
                        .addComponent(cb_error))
                    .addComponent(btn_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filterActionPerformed
        try {
            LecturaLogsInterface lectura = new LecturaLogsImpl();
            DefaultTableModel dtm = (DefaultTableModel) tb_viewLog.getModel();
            List<String> list = new ArrayList<>();
            if(cb_error.isSelected()) {
                list.add(cb_error.getText().replace("Level ",""));
            }
            if(cb_info.isSelected()) {
                list.add(cb_info.getText().replace("Level ",""));
            }
            addRowsTable(dtm, lectura.filterError(list));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_filterActionPerformed

    private void cb_errorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_errorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_errorActionPerformed
    private void addRowsTable(DefaultTableModel dtm, List<Logs> logs) {
        int rowCount = dtm.getRowCount();
        if (rowCount > 0) {
            dtm.setRowCount(0);
        }
        logs.forEach(log -> {
            dtm.addRow(new String[]{log.getLine(), log.getText(), log.getTypeError().getValueName()});
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btn_filter;
    private javax.swing.JCheckBox cb_error;
    private javax.swing.JCheckBox cb_info;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JTable tb_viewLog;
    // End of variables declaration//GEN-END:variables
}