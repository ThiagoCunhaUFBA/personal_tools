/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import converter.FromCSVToCommit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Commit;
import view.JCommit;

/**
 *
 * @author THIAGO
 */
public class MostrarDados {
    
    
    
    public static void MostrarTabelaPadrao (JTable Tabela, List<Commit> listatemp, JLabel Label){
    Label.setText("Number of Records 0");
    Tabela.removeAll();
    
    //tornar a tabela somente leitura
    DefaultTableModel modelo = new DefaultTableModel(){
        
            @Override
            public boolean isCellEditable(int row, int column) {       
                return false;
            }
        
    };
    
    
        
    
    Tabela.setModel(modelo);
    modelo.addColumn("Review");
    modelo.addColumn("Affected File");
    modelo.addColumn("Author");         
    modelo.addColumn("Operation");    
    modelo.addColumn("Date");    
    modelo.addColumn("Time");
    String revisaotemp;
    int contadorrevisao = 1;
    revisaotemp = listatemp.get(0).getRevisao();
    for (Commit j:listatemp){
            modelo.addRow(new Object[]{j.getRevisao(), j.getFile(), j.getAutor(), j.getOperacao(), j.getData(), j.getHora()});
            if (!(revisaotemp.equals(j.getRevisao()))){
                    
                    contadorrevisao++;
                    revisaotemp = j.getRevisao();
        }

    }
    
    
    Tabela.setVisible(true);
    Label.setText("Number of Records "+String.valueOf(modelo.getRowCount())+" Number of Commits "+contadorrevisao);
    
}
    
    
    public static ArrayList<Commit> CarregarCommits (String caminho, boolean shadow){
           
    ArrayList<model.Commit> listatemp = new ArrayList<model.Commit>();        

    
    listatemp = FromCSVToCommit.leArquivo(caminho, ',', shadow);    
    // se a tag shadow for verdadeira o leitor não irá verificar duplicidade
    // remocao de commits duplicados
    // nao precisa mais usar a função para remover repetidos listatemp = FiltrosCommit.Artefatosdisrevisao(listatemp);    
    Collections.sort(listatemp);    
    return listatemp;
}    
    
    public static void AbrirArquivoTxt (String caminho){
            try {
            java.awt.Desktop.getDesktop().open( new File(caminho) );
        } catch (IOException ex) {
            Logger.getLogger(JCommit.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }    


    
}
