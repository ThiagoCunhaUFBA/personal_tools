/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import converter.ToCSV;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.ArtefatoFrequencia;
import util.ComparatorArtefatoFrequencia;
import util.GetPath;
import util.MostrarDados;

/**
 *
 * @author Thiago
 */
public class JFShowArtefatoFrequencia extends javax.swing.JFrame {

    private ArrayList<ArtefatoFrequencia> listagem;
    private char operacao;
    
    public JFShowArtefatoFrequencia(String titulo, ArrayList<ArtefatoFrequencia> lista, char op) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        listagem = new ArrayList<ArtefatoFrequencia>();
        jLabel1.setText(titulo);
        listagem = lista;
        if (op == 'S'){
            rname.setEnabled(false);
            rquantity.setEnabled(false);            
            jPanel2.setEnabled(false);
            operacao = op;
        }
        MontarTabela(jTable1, listagem, operacao); 
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rname = new javax.swing.JRadioButton();
        rquantity = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Aharoni", 1, 10)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("order by"));

        buttonGroup1.add(rname);
        rname.setText("Name");
        rname.setActionCommand("n");
        rname.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rnameStateChanged(evt);
            }
        });
        rname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rnameMouseClicked(evt);
            }
        });

        buttonGroup1.add(rquantity);
        rquantity.setSelected(true);
        rquantity.setText("Quantity");
        rquantity.setActionCommand("q");
        rquantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rquantityStateChanged(evt);
            }
        });
        rquantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rquantityMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rname)
                    .addComponent(rquantity))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rquantity)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Export"));

        jButton1.setText("Generate Txt File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(297, 297, 297))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rnameStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rnameStateChanged

    }//GEN-LAST:event_rnameStateChanged

    private void rnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rnameMouseClicked
        // TODO add your handling code here:
        EscolherOrdem(listagem);
    }//GEN-LAST:event_rnameMouseClicked

    private void rquantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rquantityStateChanged
        
    }//GEN-LAST:event_rquantityStateChanged

    private void rquantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rquantityMouseClicked
        EscolherOrdem(listagem);
    }//GEN-LAST:event_rquantityMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:        
    if (operacao=='S')    {
        
    }
        ArrayList<String> listasaida = new ArrayList<String>();
        
        for (ArtefatoFrequencia l:listagem){
            
            if (l.getQuantidade()<0)
                
                    listasaida.add("\t*"+l.getAtributo());
            else
                
                    listasaida.add(l.getAtributo()+"\t"+l.getQuantidade());
        }
            
        
        String CaminhoPadrao = GetPath.main();
        
        ToCSV.createCsvFile(CaminhoPadrao+"similaridade.txt", listasaida);
        MostrarDados.AbrirArquivoTxt(CaminhoPadrao+"similaridade.txt");
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String titulo, ArrayList<ArtefatoFrequencia> lista, char op) {
        
        JFShowArtefatoFrequencia jFShowArtefatoFrequencia = new JFShowArtefatoFrequencia(titulo, lista, op); 
        jFShowArtefatoFrequencia.pack();        
        jFShowArtefatoFrequencia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFShowArtefatoFrequencia.setVisible(true);

    }
    
    
    
    private static void MontarTabela (JTable Tabela, List<ArtefatoFrequencia> listatemp, char operacao){
    //pensar sobre
    //Label.setText("Number of Records 0");
    
    Tabela.removeAll();
    
    //tornar a tabela somente leitura
        DefaultTableModel modelo = new DefaultTableModel(){
        
            @Override
            public boolean isCellEditable(int row, int column) {       
                return false;
            }
        
    };
    
    
        
    
    Tabela.setModel(modelo);
    modelo.addColumn("Name");
    modelo.addColumn("Quantity");
            
    
    for (ArtefatoFrequencia j:listatemp){
        
        if (j.getQuantidade() > 0)    
            
            modelo.addRow(new Object[]{j.getAtributo(), j.getQuantidade()});
        
        else
            
            modelo.addRow(new Object[]{j.getAtributo(), " "});
            
    }
        
            
    
    if (operacao == 'S')
        
        ColorTable(Tabela);
    
    Tabela.setVisible(true);    
        
        
    }
    
    private void EscolherOrdem (ArrayList<ArtefatoFrequencia> lista){
        
        if (buttonGroup1.getSelection().getActionCommand().equals("n")){
             Collections.sort(lista);
             
        }else{
            Collections.sort(lista, new ComparatorArtefatoFrequencia());
            
        }
        
        MontarTabela(jTable1, listagem, operacao);
    }
    
public static void ColorTable(JTable tabela){
        
        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            
            @Override
            public Component getTableCellRendererComponent (JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column){
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                Font normal = new Font("Tahoma", Font.PLAIN, 11);
                Font negrito = new Font("Tahoma", Font.BOLD, 11);
                
                //aqui que vai pintar as celulas
                Color azul = Color.BLUE;
                Color branco = Color.WHITE;
                
                
                
                Object celula = tabela.getValueAt(row, 1);
                String celString = celula.toString();
                if (celString.equals(" ")){
                        label.setBackground(azul);
                        label.setForeground(branco);                        
                        label.setFont(negrito);
                }else{
                        label.setBackground(branco);
                        label.setForeground(azul);
                        label.setFont(normal);
                }
                
                return label;
            }
        });
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rname;
    private javax.swing.JRadioButton rquantity;
    // End of variables declaration//GEN-END:variables
}
