/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author thiago
 */

public class Commit implements Comparable<Commit>{
   private String revisao;
   private String path;
   private String operacao;   
   private Calendar dataehora;      
   private String autor;

@Override
    public int compareTo(Commit commit) {
        
        if  (this.dataehora.compareTo(commit.dataehora) > 1)
            return 1;        
        else if (this.dataehora.compareTo(commit.dataehora) < 1)  {
            return -1;
        }     
        return 0;
        
    }    
    
    
    public String getRevisao() {
        return revisao;
    }

    public void setRevisao(String revisao) {
        this.revisao = revisao;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOperacao() {        
    String temp = "";
    switch (operacao)        {
    case "A":   temp = "ADDED";
                break;
    case "D":   temp = "DELETED";
                break;
    case "M":   temp = "MODIFIED";
                break;
    default:temp = "IGNORED";
    }
    return temp;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Calendar getDataehora() {
        return dataehora;
    }

    public void setDataehora(Calendar dataehora) {
        this.dataehora = dataehora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
        public String getHora() {                    
        Format formato = new SimpleDateFormat("HH:mm:ss");        
        return formato.format(dataehora.getTime());              
    }
        
        public String getData() {                    
        Format formato = new SimpleDateFormat("yyyy/MM/dd");        
        return formato.format(dataehora.getTime());              
    }
        public String getFile() {                                
            String temp = "";
            if ((path.lastIndexOf('.') != -1) && (path.indexOf('/') != -1)){
                temp = path.substring(path.lastIndexOf('/')+1, path.length());                
            }            
            else temp = "";
            return temp;            
                
            }

        public String getExtensao() {                    
            String temp = "";
            if (getFile().lastIndexOf('.')!=-1){                    
                
                    return getFile().substring(getFile().lastIndexOf('.'), getFile().length());
                            
            }else
                    return "";
                                       
    }
        
        public String getPackage() {                
                
            String temp = "";                        
            //verifica se o path contem um arquivo
            if (!getFile().equals("")){
                int indicefinal = path.lastIndexOf(".");
                
                int indiceinicial = -1;
                if (path.indexOf(".") > path.indexOf("/")){
                        indiceinicial = path.indexOf("/");
                }else{
                        indiceinicial = path.indexOf(".");
                }
                
                if (path.lastIndexOf(".", indicefinal) > path.lastIndexOf("/", indicefinal)){
                        indicefinal = path.lastIndexOf("/", indicefinal);                
                }else{
                        indicefinal = path.lastIndexOf(".", indicefinal);
                }
                temp = path.substring(indiceinicial+1, indicefinal);                                  
            }
            return temp;
        }
        
        

    @Override
    public String toString() {
        return "Commit{" + "revisao=" + revisao + ", path=" + path + ", operacao=" + operacao + ", dataehora=" + dataehora + ", autor=" + autor + '}';
    }
        


    public Commit(String revisao, String path, String operacao, Calendar dataehora, String autor) {
        this.revisao = revisao;
        this.path = path;
        this.operacao = operacao;
        this.dataehora = dataehora;
        this.autor = autor;
    }

    

    
    public static boolean diferentes(Commit c1, Commit c2) {
        if ((c1.getRevisao().equals(c2.getRevisao()))&&(c1.getFile().equals(c2.getFile()))) {
            return false;
        }
        return true;
    }
    
    public static boolean verificarduplicidade(ArrayList<Commit> listadecommits, Commit c) {
        
        for (Commit l:listadecommits)
            if (!diferentes(l, c))
                return true;
        
        /* if (listadecommits.size() < 10)
            System.out.println(listadecommits.size()+" "+ c.toString());*/
        return false;
    }
}
