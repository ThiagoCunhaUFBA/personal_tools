/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import converter.ToCSV;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import model.*;
import view.JCommit;

/**
 *
 * @author THIAGO
 */
public class FiltrosCommit {    
    public static ArrayList<Commit> FiltroCommitData (ArrayList<Commit> commits, Calendar dataini, Calendar datafim) {
        ArrayList<Commit> listatemporaria = new ArrayList<Commit>();        
        for(int i = 0; i < commits.size(); i++)
        {
            if ((commits.get(i).getDataehora().before(datafim)) && (commits.get(i).getDataehora().after(dataini)))
                                listatemporaria.add(commits.get(i));
            }                        
        return listatemporaria;
}
    
public static ArrayList<String> revisoesdistintas(ArrayList<Commit> listadecommits){
        ArrayList<String> listarevisoes = new ArrayList<String>();        
        for (Commit c:listadecommits){
                if (!listarevisoes.contains(c.getRevisao())) listarevisoes.add(c.getRevisao());
                
        }
            
        return listarevisoes;
}



public static ArrayList<Commit> Artefatosdisrevisao(ArrayList<Commit> listadecommits){
        ArrayList<Commit> listarevisoes = new ArrayList<Commit>();
        listarevisoes = listadecommits;
        for (int i = 0; i < listarevisoes.size(); i++){
            for (int j = 0; j < listarevisoes.size(); j++)
                if (listarevisoes.get(i).getRevisao().equals(listarevisoes.get(j).getRevisao()) && (listarevisoes.get(i).getFile().equals(listarevisoes.get(j).getFile())) && (listarevisoes.get(i).hashCode()!=listarevisoes.get(j).hashCode()) ){
                    listarevisoes.remove(j);
            }            
        }
        
        return listarevisoes;
}    



public static ArrayList<Commit> Pacotesdisrevisao(ArrayList<Commit> listadecommits){
        ArrayList<Commit> listarevisoes = new ArrayList<Commit>();
        listarevisoes = listadecommits;
        for (int i = 0; i < listarevisoes.size(); i++){
            for (int j = 0; j < listarevisoes.size(); j++)
                if (listarevisoes.get(i).getRevisao().equals(listarevisoes.get(j).getRevisao()) && (listarevisoes.get(i).getPackage().equals(listarevisoes.get(j).getPackage())) && (listarevisoes.get(i).hashCode()!=listarevisoes.get(j).hashCode()) ){
                    listarevisoes.remove(j);
            }            
        }
        
        return listarevisoes;
}    



    public static ArrayList<ArtefatoFrequencia> ContarArtefatosCommit (ArrayList<Commit> commits) {
        ArrayList<ArtefatoFrequencia> ListaSaida = new ArrayList<ArtefatoFrequencia>();
        ArrayList<String> ListadeRevisoes = new ArrayList<String>();
        ListadeRevisoes = revisoesdistintas(commits);
        ArrayList<String> Artefatos = new ArrayList<String>();
        for (String revisao:ListadeRevisoes){
            Artefatos.clear();
            for (Commit commit:commits){
                if (commit.getRevisao().equals(revisao)) {
                    if (!Artefatos.contains(commit.getFile())) {
                        Artefatos.add(commit.getFile());                        
                    }                
                }
                
            }
        ListaSaida.add(new ArtefatoFrequencia(String.valueOf(revisao), Artefatos.size()));        
        }        
        
        return ListaSaida;
        
    }
    
    
    
public static ArrayList<ArtefatoFrequencia> ContarPacotesCommit (ArrayList<Commit> commits) {
        ArrayList<ArtefatoFrequencia> ListaSaida = new ArrayList<ArtefatoFrequencia>();
        ArrayList<String> ListadeRevisoes = new ArrayList<String>();
        ListadeRevisoes = revisoesdistintas(commits);
        ArrayList<String> Artefatos = new ArrayList<String>();
        for (String revisao:ListadeRevisoes){
            Artefatos.clear();
            for (Commit commit:commits){
                if (commit.getRevisao().equals(revisao)) {
                    if (!Artefatos.contains(commit.getPackage())) {
                        Artefatos.add(commit.getPackage());                        
                    }                
                }
                
            }
        ListaSaida.add(new ArtefatoFrequencia(String.valueOf(revisao), Artefatos.size()));        
        }        
        
        return ListaSaida;
        
    }    
    
    
    
    
    
public static ArrayList<Commit> QuantidadedeAtributosMenor (ArrayList<Commit> commits, int limite) {    
            ArrayList<ArtefatoFrequencia> commitsdesaida = new ArrayList<ArtefatoFrequencia>();            
            ArrayList<Commit> listatemporaria = new ArrayList<Commit>();
            commitsdesaida = ContarArtefatosCommit(commits);
            
            for (int i = 0; i < commitsdesaida.size(); i++)
                
                if (commitsdesaida.get(i).getQuantidade() < limite){                    
                    //caso encontre uma quantidade inferior ao limite estabelecido
                    for (int j = 0; j < commits.size(); j++)
                        //varre a lista de commits em busca do respectivo commit
                        if (commits.get(j).getRevisao().equals(commitsdesaida.get(i).getAtributo() )) {
                            listatemporaria.add(commits.get(j));
                        }
            
                    
            }
            
            return listatemporaria;
}



public static ArrayList<Commit> QuantidadedePacotesMenor (ArrayList<Commit> commits, int limite) {    
            ArrayList<ArtefatoFrequencia> commitsdesaida = new ArrayList<ArtefatoFrequencia>();            
            ArrayList<Commit> listatemporaria = new ArrayList<Commit>();
            commitsdesaida = ContarPacotesCommit(commits);
            
            for (int i = 0; i < commitsdesaida.size(); i++)
                
                if (commitsdesaida.get(i).getQuantidade() < limite){
                    //caso encontre uma quantidade inferior ao limite estabelecido
                    for (int j = 0; j < commits.size(); j++)
                        //varre a lista de commits em busca do respectivo commit
                        if (commits.get(j).getRevisao().equals(commitsdesaida.get(i).getAtributo() )) {
                            listatemporaria.add(commits.get(j));
                        }
            
                    
            }
            
            return listatemporaria;
}




public static List<Commit> QuantidadedeAtributosLimiteInferior (ArrayList<Commit> commits, int limite) {    
            ArrayList<ArtefatoFrequencia> commitsdesaida = new ArrayList<ArtefatoFrequencia>();            
            ArrayList<Commit> listatemporaria = new ArrayList<Commit>();
            commitsdesaida = ContarArtefatosCommit(commits);
            
            for (int i = 0; i < commitsdesaida.size(); i++)
                
                if (commitsdesaida.get(i).getQuantidade() > limite){                    
                    //caso encontre uma quantidade inferior ao limite estabelecido
                    for (int j = 0; j < commits.size(); j++)
                        //varre a lista de commits em busca do respectivo commit
                        if (commits.get(j).getRevisao().equals(commitsdesaida.get(i).getAtributo() )) {
                            listatemporaria.add(commits.get(j));
                        }
            
                    
            }
            
            return listatemporaria;
}


public static ArrayList<Commit> FiltroExtensao (List<Commit> commits, String Extensao) {    
    ArrayList<Commit> listatemporaria = new ArrayList<Commit>();            
        
        for(Commit c:commits){            
            if ((c.getFile().toUpperCase().indexOf(Extensao.toUpperCase()) != -1 )&& (c.getFile().lastIndexOf('.')==c.getFile().lastIndexOf(Extensao)))
                    {
                listatemporaria.add(c);                
            }
        
        }                                
        
        return listatemporaria;
}

public static ArrayList<Commit> FiltroNomeFile (List<Commit> commits, String Extensao) {    
    ArrayList<Commit> listatemporaria = new ArrayList<Commit>();            
    
        for(Commit c:commits){                        
            if (c.getFile().toUpperCase().equals(Extensao.toUpperCase())){
                listatemporaria.add(c);                
            }           
            
        }                                
        return listatemporaria;
}

public static ArrayList<Commit> FiltroNomeFile_SemExtensao (List<Commit> commits, String Extensao) {    
    ArrayList<Commit> listatemporaria = new ArrayList<Commit>();            
    
        for(Commit c:commits){                        
            if (c.getFile().toUpperCase().contains(Extensao.toUpperCase())){
                listatemporaria.add(c);                
            }           
            
        }                                
        return listatemporaria;
}


public static ArrayList<Commit> FiltroOperacao (ArrayList<Commit> commits, String Extensao) {    
    ArrayList<Commit> listatemporaria = new ArrayList<Commit>();        
    

        for(Commit c:commits){
            if (c.getOperacao().indexOf(Extensao) != -1 ){
                listatemporaria.add(c);                
            }                       
        }                       
        return listatemporaria;
}

public static List<String> AgruparPorTempoArtefatoFrequencia (List<Commit> commits, int segundos) {
    List<ArtefatoFrequencia> listadesaida = new ArrayList<ArtefatoFrequencia>();    
    List<Commit> listadeparacomparar = new ArrayList<Commit>();    
    listadeparacomparar = commits;
    
    int contador = 1;
    Calendar datatempo = Calendar.getInstance();
    datatempo.setTime(listadeparacomparar.get(0).getDataehora().getTime());        
    datatempo.add(Calendar.SECOND, segundos);
            
    for (int i = 0; i < listadeparacomparar.size(); i++)
        if (listadeparacomparar.get(i).getFile().length()>0){
            if ((listadeparacomparar.get(i).getDataehora().before(datatempo))){
                listadesaida.add(new ArtefatoFrequencia(listadeparacomparar.get(i).getFile(), contador));                                
            }else{                
                contador = contador+1;                
                listadesaida.add(new ArtefatoFrequencia(listadeparacomparar.get(i).getFile(), contador));                
                datatempo.setTime(listadeparacomparar.get(i).getDataehora().getTime());
                datatempo.add(Calendar.SECOND, segundos);                
            }
        }
    
    //distintar ArtefatoFrequencia    
    for (int i = 0; i < listadesaida.size(); i++){     
        for (int j = 0; j < listadesaida.size(); j++)
            if ( listadesaida.get(i).getAtributo().equals(listadesaida.get(j).getAtributo()) && (listadesaida.get(i).getQuantidade()==listadesaida.get(j).getQuantidade()) && (listadesaida.get(i).hashCode()!=listadesaida.get(j).hashCode()) ){
                listadesaida.remove(j);
            }
    }

    List<String> saida = new ArrayList<String>();
    int temporaria = 0;
    for (ArtefatoFrequencia f:listadesaida)
        if (temporaria != f.getQuantidade()){
                temporaria = f.getQuantidade();
                saida.add(f.getAtributo());
        }
        else{
            String temp = saida.get(saida.size()-1);
            saida.set(saida.size()-1, temp+", "+f.getAtributo());            
        }
                
    
        
    
    return saida;
    
}

public static List<String> ToBasketSerie (List<Commit> commits, String separador, String finallinha) {
    List<String> saida = new ArrayList<String>();
    //inicializa a variavel
    String revisaotemporaria = null;
    
    for (Commit f:commits)
        if (f.getFile().length()>0){
            if (revisaotemporaria == null) revisaotemporaria = f.getRevisao();
                if (!f.getRevisao().equals(revisaotemporaria)){
                        //nova revisao                                                
                        revisaotemporaria = f.getRevisao();
                        saida.add(f.getFile());
                        }                                                                    
                else{
                    String linhatemporaria = "";
                        if (saida.size() > 0){
                            linhatemporaria = saida.get(saida.size()-1);
                            saida.set(saida.size()-1, saida.get(saida.size()-1)+separador+f.getFile());
                        }else
                            saida.add(f.getFile());
                     //   if (!linha.contains(f.getFile()))
                        //                                linha = linha + separador + f.getFile();                        
                }
                
        }    
    
    
    return saida;
    
}



public static List<String> ExtractCommits (List<Commit> commits, String nomefile, ArrayList<Commit> Sombra) {
    List<String> saida = new ArrayList<String>();    
    //inicializa a variavel
    int contador = 0;        
    for (Commit f:commits)
    {
        if (!saida.contains(f.getRevisao())){
            saida.add("=========================================================");
            saida.add(f.getRevisao());
            saida.add(f.getData());
            ArrayList<String> listaclasses = new ArrayList<String>();
            listaclasses = JListCommit.retornarnomedasclassesrevisao(Sombra, nomefile, f.getRevisao());            
            for(String l:listaclasses)
                saida.add(l);
            listaclasses.clear();
            contador ++;
        }else
        {            
            ArrayList<String> listaclasses = new ArrayList<String>();
            listaclasses = JListCommit.retornarnomedasclassesrevisao(Sombra, nomefile, f.getRevisao());
            for(String l:listaclasses)
                saida.add(l);
            listaclasses.clear();
        }
    
    }
        
               
    saida.add("");
    saida.add("");
    saida.add("Total de Commits "+contador);
    
    
    return saida;
    
}


public static List<String> similaridadeclasses(List<Commit> commits, String classe, ArrayList<Commit> sombra) {

    List<String> saida = new ArrayList<String>();    
    List<String> classes = new ArrayList<String>();    
    //inicializa a variavel       
    for (Commit f:commits)
    {
        classes = JListCommit.retornarnomedasclassesrevisao(sombra, classe, f.getRevisao());                
        for(String l:classes)
                saida.add(l);

    }
    List<ArtefatoFrequencia> listasaida = new ArrayList<ArtefatoFrequencia>();
    
    for (String s:saida){
        for (int i=0; i < listasaida.size(); i++){
            if (s.equals(listasaida.get(i).getAtributo())){
                listasaida.get(i).setQuantidade(listasaida.get(i).getQuantidade() + 1);
                i = listasaida.size();
            }
                
        }
        listasaida.add(new ArtefatoFrequencia(s, 1));        
        
    }
    
    saida.clear();
    for (ArtefatoFrequencia a:listasaida){
        saida.add(a.getAtributo()+"\t"+a.getQuantidade());
    }
    
    return saida;
    
}




public static List<String> ToBasketSerieEliminaExtensao (List<Commit> commits) {
List<String> saida = new ArrayList<String>();
    String temporaria = "";
    String separador = ", ";
    for (Commit f:commits)
        if (f.getFile().length()>0){
                if (!f.getRevisao().equals(temporaria)){
                        temporaria = f.getRevisao();
                        saida.add(f.getFile().substring(0, f.getFile().indexOf(".")));                        
                }
                else{
                        String temp = saida.get(saida.size()-1);                            
                        saida.set(saida.size()-1, temp+separador+f.getFile().substring(0, f.getFile().indexOf(".")));
                }
                    
                }        
    return saida;
    
}

public static List<String> ToBasketSerieCExtensao (List<Commit> commits) {
    List<String> saida = new ArrayList<String>();
    String temporaria = "";
    String separador = ", ";
    String Simbolo = "";
    List<String> extensoes = new ArrayList<String>();
    for (Commit f:commits)
        if (f.getFile().length()>0){
                if (!f.getRevisao().equals(temporaria)){
                        temporaria = f.getRevisao();
                        if (f.getFile().indexOf(".")!=-1){                            
                            if (!extensoes.contains(f.getFile().substring(f.getFile().indexOf("."), f.getFile().length()))){
                                    extensoes.add(f.getFile().substring(f.getFile().indexOf("."), f.getFile().length()));                                
                            }
                            saida.add(f.getFile().substring(0, f.getFile().indexOf("."))+Simbolo+extensoes.indexOf(f.getFile().substring(f.getFile().indexOf("."), f.getFile().length())));
                        }else
                        saida.add(f.getFile());
                }
                else{
                    //System.out.println("Nao ta entrando aqui");

                    
                        if (f.getFile().indexOf(".")!=-1){                            
                            if (!extensoes.contains(f.getFile().substring(f.getFile().indexOf("."), f.getFile().length()))){
                                    extensoes.add(f.getFile().substring(f.getFile().indexOf("."), f.getFile().length()));
                            }
                            String temp = saida.get(saida.size()-1);                            
                            saida.set(saida.size()-1, temp+separador+f.getFile().substring(0, f.getFile().indexOf("."))+Simbolo+extensoes.indexOf(f.getFile().substring(f.getFile().indexOf("."), f.getFile().length())));
                        }                    
                    

                }
        }    
        
    return saida;
    
}


public static ArrayList<Commit> AgruparPorTempoCommits (ArrayList<Commit> commits, int segundos) {    
    ArrayList<Commit> listadeparacomparar = new ArrayList<Commit>();
    ArrayList<Commit> commitsdesaida = new ArrayList<Commit>();
    listadeparacomparar = commits;
    
    int contador = 1;
    Calendar datatempo = Calendar.getInstance();
    datatempo.setTime(listadeparacomparar.get(0).getDataehora().getTime());    
    datatempo.add(Calendar.SECOND, segundos);
    String author = listadeparacomparar.get(0).getAutor();   
    

    String temp = "";
    for (int i = 0; i < listadeparacomparar.size(); i++){
        //System.out.println(listadeparacomparar.get(i).getOperacao().substring(0, 1));
       /* switch (listadeparacomparar.get(i).getOperacao()){            
            case "ADDED":   temp = "A";
            break;
            case "DELETED":   temp = "D";
            break;
            case "MODIFIED":   temp = "M";
            break;                  
        }*/
    
        
            if ((listadeparacomparar.get(i).getDataehora().before(datatempo))&&(author.equals(listadeparacomparar.get(i).getAutor()))){
                commitsdesaida.add(new Commit(String.valueOf(contador), listadeparacomparar.get(i).getPath(), listadeparacomparar.get(i).getOperacao().substring(0, 1), listadeparacomparar.get(i).getDataehora(), listadeparacomparar.get(i).getAutor()));
            }else{                
                
                
                contador = contador+1;
                commitsdesaida.add(new Commit(String.valueOf(contador), listadeparacomparar.get(i).getPath(), listadeparacomparar.get(i).getOperacao().substring(0, 1), listadeparacomparar.get(i).getDataehora(), listadeparacomparar.get(i).getAutor()));
                datatempo.setTime(listadeparacomparar.get(i).getDataehora().getTime());
                datatempo.add(Calendar.SECOND, segundos);
                author = listadeparacomparar.get(i).getAutor();
            }
        //}
}        
    //remover artefatos repetidos na mesma revisao
    for (int i = 0; i < commitsdesaida.size(); i++){     
        for (int j = 0; j < commitsdesaida.size(); j++)
            if ( commitsdesaida.get(i).getRevisao().equals(commitsdesaida.get(j).getRevisao()) && (commitsdesaida.get(i).getFile().equals(commitsdesaida.get(j).getFile())) && (commitsdesaida.get(i).hashCode()!=commitsdesaida.get(j).hashCode()) ){
                commitsdesaida.remove(j);
                
            }
    }
    
    return commitsdesaida;
    
}




public static List<ArtefatoFrequencia> DistintarAtributoporRevisao (ArrayList<Commit> commits) {    
    List<ArtefatoFrequencia> listatemporaria = new ArrayList<ArtefatoFrequencia>();        
    List<String> listaquantidadedistinta = new ArrayList<String>();        
    List<ArtefatoFrequencia> listafinal = new ArrayList<ArtefatoFrequencia>();            
    listatemporaria = ContarArtefatosCommit(commits);        
    
    for (ArtefatoFrequencia l:listatemporaria)   
        if (!listaquantidadedistinta.contains(String.valueOf(l.getQuantidade()))) 
                    listaquantidadedistinta.add(String.valueOf(l.getQuantidade()));
    
    for (String c:listaquantidadedistinta)
            listafinal.add(new ArtefatoFrequencia(c, 0));
    for (int i=0; i < listatemporaria.size(); i++)
         for (int j=0; j < listafinal.size(); j++)
             if (listafinal.get(j).getAtributo().equals(String.valueOf(listatemporaria.get(i).getQuantidade())))
                 listafinal.get(j).somarQuantidade();             
    Collections.sort(listafinal);
        return listafinal;
        
}


public static void ToBasketSerieTrans (List<Commit> commits, String caminho) {
    List<String> saida = new ArrayList<String>();
    List<String> revisao = new ArrayList<String>();
    List<String> llegenda = new ArrayList<String>();
    String caminhollegenda = caminho+".rlabel";    
    String caminhomatrix = caminho+".mat";
    String separador = " * ";    
    // criar o registro de legenda
    for (Commit f:commits){
        if ((f.getFile().length() > 0) && (!revisao.contains(f.getRevisao()))) revisao.add(f.getRevisao());
        if (!llegenda.contains(f.getFile().replace(" ", ""))&&(f.getFile().length() > 0)){
            llegenda.add(f.getFile().replace(" ", ""));            
        }
    }
    Collections.sort(llegenda);    
    ToCSV.createCsvFile(caminhollegenda, llegenda);    
    //salvou as legendas
    
    
    int contador = 0;
    String vtemp;
    for (String l:llegenda){
        vtemp = "";
        for (Commit f:commits)
                if (f.getFile().equals(l) && (!vtemp.contains("!"+f.getRevisao()+"!"))){
                    vtemp = vtemp + "!"+String.valueOf(revisao.indexOf(f.getRevisao())+1)+"!"+separador;
                    contador = contador + 1;                    
                }
                    
        saida.add(vtemp.replace("*", "1").replace("!", ""));
        
        }
    
    //quantidade de linhas, quantidade de colunas, contador    
    List<String> MatGravar = new ArrayList<String>();
    MatGravar.add(String.valueOf(saida.size())+" "+String.valueOf(revisao.size())+ " "+String.valueOf(contador));
    for (String f:saida)
        MatGravar.add(f);
    ToCSV.createCsvFile(caminhomatrix, MatGravar);
    
    
    
}


public static ArrayList<String> EvolucaoClasses(ArrayList<Commit> listadecommits){
        ArrayList<ArtefatoFrequencia> listarevisoes = new ArrayList<ArtefatoFrequencia>();
        ArrayList<String> saida = new ArrayList<String>();
        Boolean achou;        
        for (Commit c:listadecommits){
            achou = false;
            for (int i = 0; i < listarevisoes.size(); i++){                
                if (listarevisoes.get(i).getAtributo().equals(c.getFile())){
                    listarevisoes.get(i).somarQuantidade();
                    achou = true;
                    break;
                }
            
            }  
            if (!achou) listarevisoes.add(new ArtefatoFrequencia(c.getFile(), 1));
       }
       //Collections.sort(listarevisoes);
       for (ArtefatoFrequencia a:listarevisoes)
            saida.add(a.getAtributo()+"\t"+a.getQuantidade());

       return saida;
}

public static ArrayList<Commit> ReloadShadow (ArrayList<Commit> listadecommits, ArrayList<Commit> listadecommitsShadow){
    
    ArrayList<Commit> ListaTemp = new ArrayList<Commit>();
    
    for (Commit i:listadecommits)
        for (Commit j:listadecommitsShadow)
            if (i.getRevisao().equals(j.getRevisao()))
                    ListaTemp.add(j);
    
    return ListaTemp;
    
    
}


public static ArrayList<Commit> ReloadListaCommit (ArrayList<Commit> listadecommits, ArrayList<Commit> listadecommitsShadow){
    
    ArrayList<Commit> ListaTemp = new ArrayList<Commit>();
    
    for (Commit i:listadecommitsShadow)
        if ((i.getFile().length() > 0)&&(!Commit.verificarduplicidade(ListaTemp, i))){
            ListaTemp.add(i);
            System.out.println(i.getRevisao());
        }
            
        else{
            
            System.out.println(i.getRevisao());
            System.out.println(i.getPath());
            System.out.println(i.getFile());
            
        }             
        

    
    return ListaTemp;
    
    
}



}
