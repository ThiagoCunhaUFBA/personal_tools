/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author thiago
 */
public class ToCSV {

public static void createCsvFile(String NomeArquivo, List<String> Lista){
    try{
        BufferedWriter StrW = new BufferedWriter(new FileWriter(NomeArquivo));
        for(int i=0; i < Lista.size(); i++)
        {            
            StrW.write(Lista.get(i)+System.lineSeparator()); 
        }
        StrW.close();         
    }catch(FileNotFoundException ex){
        ex.printStackTrace(); 
    }catch (IOException e){
        e.printStackTrace(); 
    } 
}
}
