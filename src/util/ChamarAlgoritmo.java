/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javax.swing.JOptionPane;
import org.eclipse.persistence.internal.libraries.antlr.runtime.misc.Stats;
import view.JCommit;



/**
 *
 * @author ivision
 */
public class ChamarAlgoritmo  {


    
    public static List<String> ClutoLucianaCosseno (String lugararquivo, int quantidade){
        //chamar programa
        String comando = GetPath.main()+"\\vcluster.exe -clmethod=agglo -sim=cos -crfun=i2 -agglocrfun=wslink -mincomponent=1 -nnbrs=40 "
                + "-agglofrom="+String.valueOf(quantidade*3)+" "+lugararquivo+".mat "+String.valueOf(quantidade) ;
        
//        String comando = GetPath.main()+"\\vcluster.exe -clmethod=agglo -sim=cos -cstype=large -agglocrfun=i2 -mincomponent=1 -nnbrs=40 "
  //              + "-agglofrom=10 "+lugararquivo+".mat  "+String.valueOf(quantidade) ;
        //JOptionPane.showMessageDialog(null, comando);            
        //-cstype= especifica o metodo a ser usado para selecionar o proximo cluster a ser biseccionado large, best
        
        
        
        
        
        
        
        return ChamarPrograma(comando);
        
    
}

    public static List<String> ClutoLucianaCorrelacao (String lugararquivo, int quantidade){
        List<String> results = new ArrayList<String>();
        //chamar programa
        String comando = GetPath.main()+"\\vcluster.exe -clmethod=agglo -sim=corr -crfun=i2 -agglocrfun=wslink -mincomponent=1 -nnbrs=40 "
                + "-agglofrom="+String.valueOf(quantidade*3)+" "+lugararquivo+".mat "+String.valueOf(quantidade) ;
        //-cstype= especifica o metodo a ser usado para selecionar o proximo cluster a ser biseccionado large, best

        return ChamarPrograma(comando);
        
    
}    
    
    private static List<String> ChamarPrograma (String comando){    
        List<String> results = new ArrayList<String>();
        try{
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec(comando);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String linha = null;                        
		while ((linha = br.readLine()) != null) {
			results.add(linha);
		}            
        } catch (IOException ex) {
            Logger.getLogger(JCommit.class.getName()).log(Level.SEVERE, null, ex);
        }
    return results;           
    }
    
    public static List<String> ClutoDirect (String lugararquivo, int quantidade){
        List<String> results = new ArrayList<String>();
        //chamar programa
        String comando = GetPath.main()+"\\vcluster.exe -clmethod=agglo -cstype=large -agglocrfun=i2 -mincomponent=1 -nnbrs=40 "
                + "-agglofrom=10 "+lugararquivo+".mat -clabelfile="+lugararquivo+".rlabel "+String.valueOf(quantidade-1) ;
        //-cstype= especifica o metodo a ser usado para selecionar o proximo cluster a ser biseccionado large, best

        return ChamarPrograma(comando);
        
    
}    
    
    
     
}
