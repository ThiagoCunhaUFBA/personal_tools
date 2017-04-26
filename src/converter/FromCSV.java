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


/**
 *
 * @author ivision
 */
public class FromCSV {


public static List<String> leArquivo(String arquivo)  {
    List<String> listatemp = new ArrayList<String>();
    try{
        BufferedReader bufferleitura = new BufferedReader(new FileReader(arquivo));        
        String Str;        
        while( (Str = bufferleitura.readLine()) != null ){            
            listatemp.add(Str);
         }
       bufferleitura.close();       
        // return bufSaida.toString();
    }catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException ex){
        ex.printStackTrace();
    }
        
    return listatemp;
    }

    
}
