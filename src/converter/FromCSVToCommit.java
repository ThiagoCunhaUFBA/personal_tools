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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import model.*;
/**
 *
 * @author THIAGO
 */
public class FromCSVToCommit {


public static ArrayList<Commit> leArquivo(String arquivo, char Separador, boolean shadow)  {
    ArrayList<Commit> listatemp = new ArrayList<Commit>();
    try{
        BufferedReader bufferleitura = new BufferedReader(new FileReader(arquivo));
        
        String Str;        
        
        while( (Str = bufferleitura.readLine()) != null ){            
            String revisao = Str.substring(0, Str.indexOf(Separador));            
            //path
            String path = Str.substring(Str.indexOf(Separador) + 1, Str.length());                        
            String autor = path.substring(path.indexOf(Separador)+2, path.length());            
            path = path.substring(1, path.indexOf(Separador));                        
            
            //autor
            String operacao = autor.substring(autor.indexOf(Separador)+1, autor.length());            
            autor = autor.substring(0, autor.indexOf(Separador));            
            
            //operacao
            String data = operacao.substring(operacao.indexOf(Separador)+1, operacao.length());
            operacao = operacao.substring(1, operacao.indexOf(Separador));
            
            //hora
            String hora = data.substring(data.indexOf(Separador), data.length() );
            data = data.substring(1, data.indexOf(Separador));
            hora = hora.substring(hora.indexOf(Separador)+2, hora.length());
            Calendar c = Calendar.getInstance();                     
            try { 
                    SimpleDateFormat formatoData = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");                                         
                    c.setTime(formatoData.parse(data+" "+hora)); 
            } catch (Exception e) {}                                   
            try {
                //verificar se já existe na lista para posteriormente inserir
                //implementar função de comparação
                //if (Commit.verificarduplicidade(listatemp, new Commit(revisao, path, operacao, c, autor)));
                if (!shadow){
                        if ((new Commit(revisao, path, operacao, c, autor).getFile().length() > 0)&&(!Commit.verificarduplicidade(listatemp, new Commit(revisao, path, operacao, c, autor))))
                            listatemp.add(new Commit(revisao, path, operacao, c, autor));                        
                    
                }
                else
                    listatemp.add(new Commit(revisao, path, operacao, c, autor));                    
                
                        
            } catch (OutOfMemoryError e) {
                System.out.println(e);
                System.out.println("Quantidade de Registros até estourar a memoria: " + listatemp.size());
            }
 
            
           /* linhatabela = Str.split(",");
            for (String campo : linhatabela)
                
                listatemporaria.add(new Commit(arquivo, Str, campo, dataehora, Str));*/
         }
       bufferleitura.close();       
        // return bufSaida.toString();
    }catch (FileNotFoundException e){
        e.printStackTrace();
        System.out.println("File not found");
    }catch (IOException ex){
        ex.printStackTrace();
        System.out.println("another error");
    }
        
    return listatemp;
    }


  }    
