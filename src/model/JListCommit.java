/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import util.MostrarDados;


public class JListCommit {
    public static ArrayList<String> retornarnomedasclassesrevisao(ArrayList<Commit> ListadeCommitsShadow, String extensao, String revisao){        
        ArrayList<String> saida = new ArrayList<String>();
        
        for(Commit c:ListadeCommitsShadow){
            if ((c.getFile().contains(extensao))&&(c.getRevisao().equals(revisao))){
                saida.add(c.getFile());
            }
        }
        return saida;
    }
    
    public static ArrayList<String> retornarnomedasclassesrevisao(ArrayList<Commit> ListadeCommitsShadow, String revisao){
        ArrayList<String> saida = new ArrayList<String>();
        
        for(Commit c:ListadeCommitsShadow){
            if ((c.getRevisao().equals(revisao))&&(!saida.contains(c.getFile()))){
                saida.add(c.getFile());
            }
        }
        return saida;
    }
    
    
    public static int retornarquantidadedasclassesrevisao(ArrayList<Commit> ListadeCommitsShadow, String extensao, String revisao){
        ArrayList<String> saida = new ArrayList<String>();
        
        for(Commit c:ListadeCommitsShadow){
            if ((c.getFile().contains(extensao))&&(c.getRevisao().equals(revisao))){
                saida.add(c.getFile().substring(0, c.getFile().indexOf(extensao)));
            }
        }
        return saida.size();
    }
    
    public static int retornarquantidadedasclassesrevisao(ArrayList<Commit> ListadeCommitsShadow, String revisao){
        ArrayList<String> saida = new ArrayList<String>();

        
        for(Commit c:ListadeCommitsShadow){
            if ((c.getRevisao().equals(revisao))&&(!saida.contains(c.getFile()))){
                saida.add(c.getFile());
            }
        }
        return saida.size();
    }
    
    
    public static int retornarquantidadedaspacotesrevisao(ArrayList<Commit> ListadeCommitsShadow, String revisao){
        ArrayList<String> saida = new ArrayList<String>();
        
        for(Commit c:ListadeCommitsShadow){
            if (!saida.contains(c.getPackage())&&(c.getRevisao().equals(revisao))){
                saida.add(c.getPackage());
            }
        }
        return saida.size();
    }
    
    public static ArrayList<String> retornarnomepacotesrevisao(ArrayList<Commit> ListadeCommitsShadow, String revisao){
        ArrayList<String> saida = new ArrayList<String>();
        
        for(Commit c:ListadeCommitsShadow){
            if (!saida.contains(c.getPackage())&&(c.getRevisao().equals(revisao))){
                saida.add(c.getPackage());
            }
        }
        return saida;
    }
    
    
}
