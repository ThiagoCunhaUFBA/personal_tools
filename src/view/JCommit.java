/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import converter.FromCSVToCommit;
import java.sql.Connection;
import java.sql.*;
import model.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Commit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import converter.ToCSV;
import converter.ToMat;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.E;
import java.text.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import util.FiltrosCommit;
import util.GetPath;
import util.MostrarDados;
import util.ChamarAlgoritmo;

/**
 *
 * @author thiago
 */
public class JCommit extends javax.swing.JFrame {

    private boolean nothreshold;
    String CaminhoPadrao = null;    
    private boolean allperiod = true;    
    private ArrayList<model.Commit> ListadeCommits = null;
    private ArrayList<model.Commit> ListadeCommitsShadow = null;
    public JCommit() {
        
        initComponents();
        SimpleDateFormat data = new SimpleDateFormat("yyyy/MM/dd");  
        Calendar cal = Calendar.getInstance(); 
        String grava = data.format(cal.getTime());
        jFormattedTextField1.setText(grava);
        jFormattedTextField2.setText(grava);
        jFormattedTextField1.setEnabled(false);
        jFormattedTextField2.setEnabled(false);
        jCheckBox1.setSelected(true);        
        
 
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        panel1 = new java.awt.Panel();
        label1 = new java.awt.Label();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextRevision = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextRevision1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTextRevision2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        label2 = new java.awt.Label();
        jTexpackagetRevision = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();
        jLabel5 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label1.setText("Period");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFormattedTextField1.setToolTipText("Type in this box the initial date and final date on this format year/month/day");
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });

        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        jFormattedTextField2.setToolTipText("Type in this box the initial date and final date on this format year/month/day");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Threshold of Artifacts for Revision");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Type of Artefact");

        jTextRevision.setText("-1");
        jTextRevision.setToolTipText("Type in the maximum threshold of artefacts modified by a revision, type in the value -1 to ignore this option");
        jTextRevision.setName(""); // NOI18N

        jTextField2.setToolTipText("Type in the extension of file to be considered in the analysis or don't type anything to ignore this option");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCheckBox1.setText("All Period");
        jCheckBox1.setToolTipText("Check this to consider all period");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Type of Operation");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Added", "Modified", "Deleted" }));
        jComboBox1.setToolTipText("Kind of operation to be considered in the analysis");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Group by time");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Seconds");

        jTextRevision1.setText("-1");
        jTextRevision1.setToolTipText("This option to permit clustering the revision by time window. You have to inform the value in seconds. If you don't want consider this filter just type in the value -1");
        jTextRevision1.setName(""); // NOI18N

        jTextField3.setToolTipText("Type in the extension of file to be considered in the analysis or don't type anything to ignore this option");

        jButton9.setText("Select File");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("If you have any doubt keep the cursor of the mouse under the component. In case any other doubt please send e-mail to tiinf@hotmail.com thank you for join me.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Number of Cluster");

        jButton1.setText("Apply");
        jButton1.setToolTipText("Apply the filter to find and show the results");
        jButton1.setName(""); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.setToolTipText("Close the tool");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Histogram of Frequency");
        jButton4.setToolTipText("Show the frequency of amount of artefact affected by each revision. This graphic to help to choose correct value to the field \"Threshold of Artifacts for Revision\"");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton10.setText("Clear Filters");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTextRevision2.setText("10");
        jTextRevision2.setToolTipText("Type in this field a amount of clusters desired");
        jTextRevision2.setName("labelclusters"); // NOI18N

        jButton3.setText("Mining");
        jButton3.setToolTipText("Apply the algorithm and extract the co-change clusters");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Show Data");
        jButton6.setToolTipText("Show the indices of quality");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("Plot Quality");
        jButton5.setToolTipText("Plot the indice of quality");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("Export to Basket Serie Format");
        jButton8.setToolTipText("Export the information below in txt format following the basket serie patterns");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton11.setText("Get Commits");
        jButton11.setActionCommand("Export Commits");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton7.setText("Export to Mat Format");
        jButton7.setToolTipText("Export the information below in mat format");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label2.setText("Threshold of package by Revision");

        jTexpackagetRevision.setText("-1");
        jTexpackagetRevision.setToolTipText("Type in the maximum threshold of artefacts modified by a revision, type in the value -1 to ignore this option");
        jTexpackagetRevision.setName(""); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Name of Artefact");

        jButton12.setText("Get Class Similarities");
        jButton12.setActionCommand("Export Commits");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Get Number of Modification");
        jButton13.setActionCommand("Export Commits");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextRevision2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jTextRevision, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextRevision1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(jTexpackagetRevision, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13))
                            .addComponent(jLabel9))
                        .addGap(135, 135, 135)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2))
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextRevision1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel1)
                        .addComponent(jTextRevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexpackagetRevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jLabel8)
                    .addComponent(jTextRevision2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jLabel3)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //aqui o procedimento para chamar o formulario com histograma
        new Histogram("Graphic", "Histogram of number of artefacts affected by review", FiltrosCommit.DistintarAtributoporRevisao(ListadeCommits)).setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int quantidadedeclusters = 0;
        try{
            quantidadedeclusters = Integer.parseInt(jTextRevision2.getText());
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number of Clusters");            
        }
        
        
        String CaminhoMatrix = GetPath.main();
        FiltrosCommit.ToBasketSerieTrans(ListadeCommits, CaminhoMatrix+"temp");
        //MostrarResultados.Clusters(ChamarAlgoritmo.ClutoLucianaCosseno(CaminhoMatrix+"temp", quantidadedeclusters), quantidadedeclusters);
        ToCSV.createCsvFile(CaminhoMatrix+"Clustered_with_cosine_function.txt", MostrarResultados.Clusters(ChamarAlgoritmo.ClutoLucianaCosseno(CaminhoMatrix+"temp", quantidadedeclusters), quantidadedeclusters));
        MostrarDados.AbrirArquivoTxt(CaminhoMatrix+"Clustered_with_cosine_function.txt");
        
        ToCSV.createCsvFile(CaminhoMatrix+"Clustered_with_correlation_coefficient.txt", MostrarResultados.Clusters(ChamarAlgoritmo.ClutoLucianaCorrelacao(CaminhoMatrix+"temp", quantidadedeclusters), quantidadedeclusters));
        MostrarDados.AbrirArquivoTxt(CaminhoMatrix+"Clustered_with_correlation_coefficient.txt");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()){
            allperiod = true;
            jFormattedTextField1.setEnabled(false);
            jFormattedTextField2.setEnabled(false);
        }else{
            allperiod = false;
            jFormattedTextField1.setEnabled(true);
            jFormattedTextField2.setEnabled(true);

        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //carregamento inicial
        if (ListadeCommits == null)
                ListadeCommits = MostrarDados.CarregarCommits(CaminhoPadrao);                
        //filtro por extensao de arquivo
        if (!(jTextField2.getText()==null || jTextField2.getText().trim().equals(""))){
            if (!jTextField2.getText().contains("."))
                jTextField2.setText("."+jTextField2.getText());
            ListadeCommits = FiltrosCommit.FiltroExtensao(ListadeCommits, jTextField2.getText());
        }
        //filtro nome arquivo
        if (!(jTextField3.getText()==null || jTextField3.getText().trim().equals(""))){
            if (!(jTextField2.getText()==null || jTextField2.getText().trim().equals("")))
                ListadeCommits = FiltrosCommit.FiltroNomeFile(ListadeCommits, jTextField3.getText()+jTextField2.getText());
            else
                ListadeCommits = FiltrosCommit.FiltroNomeFile(ListadeCommits, jTextField3.getText());
            
        }

        //verificar se o valor para limite de artefatos é um valor valido
        try{
            Integer.parseInt(jTextRevision.getText());
        }catch (NumberFormatException e) {
            jTextRevision.setText("-1");
            JOptionPane.showMessageDialog(null, "Invalid Threshold");
        }
        
        //verifica se o valor da quantidade maxima de pacotes e valida
        try{
            Integer.parseInt(jTexpackagetRevision.getText());
        }catch (NumberFormatException e) {
            jTexpackagetRevision.setText("-1");
            JOptionPane.showMessageDialog(null, "Invalid Threshold");
        }
        

        //filtro por data

        if (jCheckBox1.isSelected() != true) {
            try {
                SimpleDateFormat formatoData = new SimpleDateFormat("yyyy/MM/dd");
                Calendar dataini = Calendar.getInstance();
                Calendar datafim = Calendar.getInstance();
                dataini.setTime(formatoData.parse(jFormattedTextField1.getText()));
                datafim.setTime(formatoData.parse(jFormattedTextField2.getText()));
                ListadeCommits = FiltrosCommit.FiltroCommitData(ListadeCommits, dataini, datafim);
            } catch (Exception e) {}

        }
        //filtro por quantidade maxima de atributos modificados
        if (Integer.parseInt(jTextRevision.getText()) > 1) ListadeCommits = FiltrosCommit.QuantidadedeAtributosMenor(ListadeCommits, Integer.parseInt(jTextRevision.getText()));
        //filtro para ignorar revisoes que modificam apenas 1 arquivo

        if (Integer.parseInt(jTexpackagetRevision.getText()) > 1) ListadeCommits = FiltrosCommit.QuantidadedePacotesMenor(ListadeCommits, Integer.parseInt(jTexpackagetRevision.getText()));
        //depois pensar sobre limite inferior
        //ListadeCommits = FiltrosCommit.QuantidadedeAtributosLimiteInferior(ListadeCommits, 1);
        //filtro para avaliar o tipo de operacao que sofreu cada artefato
        switch (jComboBox1.getSelectedIndex()){
            case 1:
            ListadeCommits = FiltrosCommit.FiltroOperacao(ListadeCommits, "ADDED");
            break;
            case 2:
            ListadeCommits = FiltrosCommit.FiltroOperacao(ListadeCommits, "MODIFIED");
            break;
            case 3:
            ListadeCommits = FiltrosCommit.FiltroOperacao(ListadeCommits, "DELETED");
            break;
        }

        //verificar se há agrupamento de tempo
        try{
            Integer.parseInt(jTextRevision1.getText());
        }catch (NumberFormatException e) {
            jTextRevision1.setText("-1");
            JOptionPane.showMessageDialog(null, "Invalid Number of Seconds");
        }

        if (Integer.parseInt(jTextRevision1.getText()) > 0){
            ListadeCommits = FiltrosCommit.AgruparPorTempoCommits(ListadeCommits, Integer.parseInt(jTextRevision1.getText()));
        }

        MostrarDados.MostrarTabelaPadrao(jTable1, ListadeCommits, jLabel5);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed

    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ToCSV.createCsvFile(CaminhoPadrao+"basketserie.txt", FiltrosCommit.ToBasketSerie(ListadeCommits, ", ", ""));
        MostrarDados.AbrirArquivoTxt(CaminhoPadrao+"basketserie.txt");        
            
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        FiltrosCommit.ToBasketSerieTrans(ListadeCommits, CaminhoPadrao+"temp.mat");
        

        try {
            Runtime.getRuntime().exec("explorer.exe /select," + CaminhoPadrao+"temp.mat");
        } catch (IOException ex) {
            Logger.getLogger(JCommit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        ArrayList<Integer> intervalo = new ArrayList<Integer>();
        //List<ArtefatoFrequencia> DistintarAtributoporRevisao (List<Commit> commits) {    
        //new HistogramFloat("Graphic", "Metrica de Qualidade por numero de Cluster", MostrarResultados.MostrarMelhoresQteClusters(ListadeCommits, )).setVisible(true);
        String StringIntervalo = JOptionPane.showInputDialog(null, "Type in the interval to plot the graphic in this format \"X-X\"", "Interval", JOptionPane.PLAIN_MESSAGE);
        try {
            intervalo.add(Integer.parseInt(StringIntervalo.substring(0, StringIntervalo.indexOf("-"))));
            intervalo.add(Integer.parseInt(StringIntervalo.substring(StringIntervalo.indexOf("-")+1, StringIntervalo.length())));
            if (intervalo.get(0)>intervalo.get(1))
                intervalo.set(0, -1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Interval");
        }
        if (intervalo.get(0)>intervalo.get(1))
            JOptionPane.showMessageDialog(null, "Invalid Interval");
        else
            new HistogramFloat("Graphic", "Index of Quality per Number of Clusters", MostrarResultados.MostrarMelhoresQteClusters(ListadeCommits, intervalo)).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        
        ArrayList<Integer> intervalo = new ArrayList<Integer>();
        
        String StringIntervalo = JOptionPane.showInputDialog(null, "Type in the interval to compute the indices of quality in this format \"X-X\"", "Interval", JOptionPane.PLAIN_MESSAGE);
        try {
            intervalo.add(Integer.parseInt(StringIntervalo.substring(0, StringIntervalo.indexOf("-"))));
            intervalo.add(Integer.parseInt(StringIntervalo.substring(StringIntervalo.indexOf("-")+1, StringIntervalo.length())));
            if (intervalo.get(0)>intervalo.get(1))
                intervalo.set(0, -1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Interval");
        }
        if (intervalo.get(0)>intervalo.get(1))
            JOptionPane.showMessageDialog(null, "Invalid Interval");
        else{
            List<String> listagemtemporaria = new ArrayList<String>();
            List<StringFloat> indices = new ArrayList<StringFloat>();
            indices = MostrarResultados.ObterIndiceClusters(ListadeCommits, intervalo);
            for(int x = 0; x < indices.size()-1; x++)
                listagemtemporaria.add(indices.get(x).getDescricao()+" Clusters "+indices.get(x).getValor());
        listagemtemporaria.add("");
        listagemtemporaria.add(indices.get(indices.size()-1).getDescricao());
        ToCSV.createCsvFile(CaminhoPadrao+"Quality_of_Clusters.txt", listagemtemporaria);
        MostrarDados.AbrirArquivoTxt(CaminhoPadrao+"Quality_of_Clusters.txt");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JFileChooser fc = new JFileChooser();
        CaminhoPadrao = null;
        if (fc.showOpenDialog(null)==0){
            try {
                CaminhoPadrao  =  fc.getSelectedFile().getPath();
                limparfiltros();
                ListadeCommits = MostrarDados.CarregarCommits(CaminhoPadrao);
                ListadeCommitsShadow = MostrarDados.CarregarCommits(CaminhoPadrao);
                MostrarDados.MostrarTabelaPadrao(jTable1, ListadeCommits, jLabel5);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "File is not in Valid Format, please check it");
            }
            
            
            
        }
            
        
        
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        limparfiltros();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        FiltrosCommit.ExtractCommits(ListadeCommits, jTextField2.getText(), ListadeCommitsShadow);
        ToCSV.createCsvFile(CaminhoPadrao+"commits.txt", FiltrosCommit.ExtractCommits(ListadeCommits, jTextField2.getText(), ListadeCommitsShadow));
        MostrarDados.AbrirArquivoTxt(CaminhoPadrao+"commits.txt");
        //lista = JListCommit.retornarnomedasclassesrevisao(ListadeCommitsShadow, jTextField2.getText(), obj.toString());
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
             
    }//GEN-LAST:event_jTable1MouseClicked

    
    
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
     @SuppressWarnings("unchecked")
     int tecla = evt.getKeyCode();
     if(tecla == 113){
         //JOptionPane.showInputDialog("Lista 1 \n teste de enter", "Lista 2 \n Lista3 \n Lista4");
         ArrayList<String> lista = new ArrayList<String>();
         Object obj = jTable1.getValueAt(jTable1.getSelectedRow(), 0);
         if (!jTextField2.getText().equals(""))
                lista = JListCommit.retornarnomedasclassesrevisao(ListadeCommitsShadow, jTextField2.getText(), obj.toString());
         else
                lista = JListCommit.retornarnomedasclassesrevisao(ListadeCommitsShadow, obj.toString());
         JFShowCustomized.main("Classes Afetadas pelo commit "+obj.toString(), lista);
         //JOptionPane.showMessageDialog(rootPane, "F2");
         }    
     
     if(tecla == 114){         
         ArrayList<String> lista = new ArrayList<String>();
         Object obj = jTable1.getValueAt(jTable1.getSelectedRow(), 0);         
         int x = JListCommit.retornarquantidadedasclassesrevisao(ListadeCommitsShadow, jTextField2.getText(), obj.toString());                  
         JOptionPane.showMessageDialog(rootPane, "Quantidade de Classes Afetada pelo commit "+String.valueOf(x));
         }    
     
     if(tecla == 115){
         //JOptionPane.showInputDialog("Lista 1 \n teste de enter", "Lista 2 \n Lista3 \n Lista4");
         ArrayList<String> lista = new ArrayList<String>();
         Object obj = jTable1.getValueAt(jTable1.getSelectedRow(), 0);         
         lista = JListCommit.retornarnomepacotesrevisao(ListadeCommitsShadow, obj.toString());
         JFShowCustomized.main("Pacotes Afetados pelo Commit "+obj.toString(), lista);         
         }    
     
     if(tecla == 116){
         //JOptionPane.showInputDialog("Lista 1 \n teste de enter", "Lista 2 \n Lista3 \n Lista4");
         ArrayList<String> lista = new ArrayList<String>();
         Object obj = jTable1.getValueAt(jTable1.getSelectedRow(), 0);         
         int x = JListCommit.retornarquantidadedaspacotesrevisao(ListadeCommitsShadow, obj.toString());  
         JOptionPane.showMessageDialog(rootPane, "Quantidade de Pacotes Afetados pelo commit "+String.valueOf(x));
         }    
          
     
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:        
        ToCSV.createCsvFile(CaminhoPadrao+"similaridade.txt", FiltrosCommit.similaridadeclasses(ListadeCommits, jTextField2.getText(), ListadeCommitsShadow));
        MostrarDados.AbrirArquivoTxt(CaminhoPadrao+"similaridade.txt");

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
                
        ToCSV.createCsvFile(CaminhoPadrao+"similaridade.txt", FiltrosCommit.EvolucaoClasses(ListadeCommits));
        MostrarDados.AbrirArquivoTxt(CaminhoPadrao+"similaridade.txt");
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void limparfiltros() {                                             
                //mostrar todos os resultados
        if (ListadeCommits != null){
            ListadeCommits = MostrarDados.CarregarCommits(CaminhoPadrao);
            MostrarDados.MostrarTabelaPadrao(jTable1, ListadeCommits, jLabel5);
        }        
        
        //limpar as opcoes de filtro
        jCheckBox1.setSelected(true);
        jComboBox1.setSelectedIndex(0);
        jTextField2.setText("");
        jTextField3.setText("");
        jTextRevision.setText("-1");
        jTexpackagetRevision.setText("-1");
        jTextRevision1.setText("-1");
        jTextRevision2.setText("10");      
        jFormattedTextField1.setEnabled(false);
        jFormattedTextField2.setEnabled(false);
        
        
    }
    
    
    
    
        
    
    
    

 //   ToCSV.createCsvFile("D:\\mestrado\\dados-ferramenta.csv", dadostemp);        
    
    
    
    
     
    public static void main(String[] args) {
        JCommit jCommit = new JCommit();
        jCommit.pack();
        jCommit.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTexpackagetRevision;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextRevision;
    private javax.swing.JTextField jTextRevision1;
    private javax.swing.JTextField jTextRevision2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    // End of variables declaration//GEN-END:variables
}
