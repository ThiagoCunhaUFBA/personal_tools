/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.GetPath;


/**
 *
 * @author ivision
 */
public class ToMat {
public static void WriteMat(String arquivo)  {
    List<String> listatemp = new ArrayList<String>();    
    List<String> legenda = new ArrayList<String>();
    List<String> MatGravar = new ArrayList<String>();
    List<String> corpomatrix = new ArrayList<String>();
    int nlinha=0, ncoluna=0;
    try{
        BufferedReader bufferleitura = new BufferedReader(new FileReader(arquivo));
        String Str;
        nlinha = 0;
        ncoluna = 0;
        while( (Str = bufferleitura.readLine()) != null ){
            nlinha++;
            listatemp = quebrastring(Str);            
            ncoluna = ncoluna + listatemp.size();
            String linhamat = "";
            for (String c:listatemp){
                if (!legenda.contains(c.replace(" ", "")))
                    legenda.add(c.replace(" ", ""));                
            linhamat = linhamat + String.valueOf(legenda.indexOf(c.replace(" ", ""))+1)+" 1 ";    
            }
            corpomatrix.add(linhamat);
            
         }
       
       bufferleitura.close();
        // return bufSaida.toString();
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException ex){
        ex.printStackTrace();
    }
    MatGravar.add(String.valueOf(nlinha)+" "+String.valueOf(legenda.size())+" "+String.valueOf(ncoluna));
    for (String c:corpomatrix)
        MatGravar.add(c);
    ToCSV.createCsvFile(arquivo+".mat", MatGravar);
    ToCSV.createCsvFile(arquivo+".clabel", legenda);        
    
    
    }

public static List<String> quebrastring (String linha){    
    List<String> listatemporaria = new ArrayList<String>();
    if (!linha.contains(","))
        listatemporaria.add(linha);
    while (linha.contains(",")){
        listatemporaria.add(linha.substring(0, linha.indexOf(",")));
        linha = linha.substring(linha.indexOf(",")+1, linha.length());        
    }
    

return listatemporaria;
}


}



