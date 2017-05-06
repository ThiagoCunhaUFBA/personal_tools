/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Comparator;
import model.ArtefatoFrequencia;

/**
 *
 * @author Thiago
 */
public class ComparatorArtefatoFrequencia implements Comparator<ArtefatoFrequencia>{
    
    @Override
    public int compare(ArtefatoFrequencia a1, ArtefatoFrequencia a2){
        
        if (a1.getQuantidade() > a2.getQuantidade())
            return -1;
        
        if (a1.getQuantidade() < a2.getQuantidade())
            return 1;
        
        return 0;
            
    }
}
