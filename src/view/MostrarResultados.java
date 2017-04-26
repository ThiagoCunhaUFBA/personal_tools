/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import converter.FromCSV;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import model.ArtefatoFrequencia;
import model.QualidadeCluster;
import model.StringFloat;
import util.ChamarAlgoritmo;
import util.FiltrosCommit;
import util.GetPath;

/**
 *
 * @author ivision
 */
public class MostrarResultados {
    public static List<String> Clusters (List<String> ListaEntrada, int quantidadedeclusters){
    String ArquivoResultado = null;
    String ArquivoLegenda = null;
    try{
      ArquivoResultado = ListaEntrada.get(4).substring(ListaEntrada.get(4).indexOf("Name: ")+6, ListaEntrada.get(4).indexOf(".mat"))+".mat.clustering."+String.valueOf(quantidadedeclusters);
      ArquivoLegenda = ListaEntrada.get(4).substring(ListaEntrada.get(4).indexOf("Name: ")+6, ListaEntrada.get(4).indexOf(".mat"))+".rlabel";
    }catch(Exception e){
        List<String> falha = new ArrayList<String>();
        falha.add("");
        return falha;
    }
    
    //selecionar apenas o conteúdo
    List<String> conteudovalido = new ArrayList<String>();
    int inicio = ListaEntrada.size(), fim=0;
    for (int i = 0; i < ListaEntrada.size(); i++){
        if (ListaEntrada.get(i).contains("cid")) inicio = i+1;
        if (ListaEntrada.get(i).contains("----------")&&( i > inicio)) fim = i-2;
    }
    for (int i = 0; i < ListaEntrada.size(); i++){
        if ((i > inicio)&&(i < fim)) conteudovalido.add(ListaEntrada.get(i));
    }
    
    
      List<String> listaresultado = new ArrayList<String>();
      List<String> listalegenda = new ArrayList<String>();
      List<String> listasaida = new ArrayList<String>();
      
      listaresultado = FromCSV.leArquivo(ArquivoResultado);
      listalegenda = FromCSV.leArquivo(ArquivoLegenda);  
      
      for (int i = 0; i < listaresultado.size(); i++){
          if (Integer.parseInt(listaresultado.get(i).replace(" ", "")) < 0)
              listasaida.add(listaresultado.get(i)+"\t"+listalegenda.get(i)+"\tDATA NOT CLASSIFIED");
          else
              listasaida.add(listaresultado.get(i)+"\t"+listalegenda.get(i));
      }
      Collections.sort(listasaida);
      return listasaida;
    }
    
public static QualidadeCluster ExtrairQualidade(String linharesultado){
    QualidadeCluster qualidadeCluster = new QualidadeCluster();    
    
    float similaridade = Float.valueOf(linharesultado.substring(11, 16)+"f");
    
    qualidadeCluster.setMediaSimInterna(similaridade);
    
    similaridade = Float.valueOf(linharesultado.substring(24, 30)+"f");
    qualidadeCluster.setMediaSimExterna(similaridade);
    
    return qualidadeCluster;
}    

public static List<String> ObterClustersResultado (List<String> ListaEntrada){   
    
    List<String> conteudovalido = new ArrayList<String>();
    int inicio = ListaEntrada.size(), fim=0;
    for (int i = 0; i < ListaEntrada.size(); i++){
        if (ListaEntrada.get(i).contains("cid")) inicio = i+1;
        if (ListaEntrada.get(i).contains("Timing Information ------")) fim = i-2;
    }
    for (int i = 0; i < ListaEntrada.size(); i++){
        if ((i > inicio)&&(i < fim)) conteudovalido.add(ListaEntrada.get(i));
    }
    return conteudovalido;
    
}

public static List<StringFloat> ObterIndiceClusters (List<model.Commit> Commits, ArrayList<Integer> intervalo){   
    
    List<StringFloat> listagemcosseno = new ArrayList<StringFloat>();
    
    String caminhopadrao = GetPath.main()+"temp";
    
     //*apagar
    
    float maxqualidadecosseno = 0, qualidadecosseno = 0;
    
    FiltrosCommit.ToBasketSerieTrans(Commits, caminhopadrao);
    for (int i = intervalo.get(0); i < intervalo.get(1)+1; i++){
        qualidadecosseno = 0;
        for (String c:ObterClustersResultado(ChamarAlgoritmo.ClutoLucianaCosseno(caminhopadrao, i)))
            qualidadecosseno = qualidadecosseno + MostrarResultados.ExtrairQualidade(c).Qualidade();
        listagemcosseno.add(new StringFloat( String.valueOf(i), qualidadecosseno/i));
        if (maxqualidadecosseno < qualidadecosseno) 
                    maxqualidadecosseno = qualidadecosseno;
    }
    List<StringFloat> listagemcorrelacao = new ArrayList<StringFloat>();
        
    float maxqualidadecorrelacao = 0, qualidadecorrelacao = 0;
    FiltrosCommit.ToBasketSerieTrans(Commits, caminhopadrao);
    for (int i = intervalo.get(0); i < intervalo.get(1)+1; i++){
        qualidadecorrelacao = 0;
        for (String c:ObterClustersResultado(ChamarAlgoritmo.ClutoLucianaCorrelacao(caminhopadrao, i)))
            qualidadecorrelacao = qualidadecorrelacao + MostrarResultados.ExtrairQualidade(c).Qualidade();
        listagemcorrelacao.add(new StringFloat( String.valueOf(i), qualidadecorrelacao/i));        
        if (maxqualidadecorrelacao < qualidadecorrelacao) 
                    maxqualidadecorrelacao = qualidadecorrelacao;
        
    }
    
    if (maxqualidadecorrelacao > maxqualidadecosseno) {
        listagemcorrelacao.add(new StringFloat("Index Using Correlation Coefficient", -1));
        return listagemcorrelacao;
    }else {
        listagemcosseno.add(new StringFloat("Index Using Cosine Function", -1));
        return listagemcosseno;
    }
    
}



public static List<StringFloat> MostrarMelhoresQteClusters (List<model.Commit> Commits, ArrayList<Integer> intervalo){   
    
    List<StringFloat> indices = new ArrayList<StringFloat>();
    indices = ObterIndiceClusters(Commits, intervalo);
    
    List<StringFloat> IndicesSaida = new ArrayList<StringFloat>();
    for (int x = 0; x < indices.size()-1; x++)
        if (Integer.parseInt(indices.get(x).getDescricao())>= intervalo.get(0)&&(Integer.parseInt(indices.get(x).getDescricao()) <= intervalo.get(1)))
            IndicesSaida.add(indices.get(x));
    IndicesSaida.add(indices.get(indices.size()-1));
            
    return IndicesSaida;
    

    
}







protected static int QteDistintaClasse (List<model.Commit> Commits){
    List<String> classes = new ArrayList<String>();
    
    for (model.Commit c:Commits)
        if (!classes.contains(c.getFile())&&(c.getFile().length() > 0)) classes.add(c.getFile());
    return classes.size();
}

}
