/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author THIAGO
 */
public class ArtefatoFrequencia implements Comparable<ArtefatoFrequencia>{
    private String atributo;
    private int quantidade;
    
    
    @Override
    public int compareTo(ArtefatoFrequencia artefatofrequencia) {
        
        return this.atributo.compareTo(artefatofrequencia.atributo);
    }

    public String getAtributo() {
        return atributo;
    }
    


    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void somarQuantidade() {
        this.quantidade = this.quantidade+1;
    }
    

    public ArtefatoFrequencia(String atributo, int quantidade) {
        this.atributo = atributo;
        this.quantidade = quantidade;
    }
    


    @Override
    public String toString() {
        return atributo + " - " + quantidade;
    }

    @Override
    public boolean equals(Object obj) {
        ArtefatoFrequencia af = (ArtefatoFrequencia)obj;
        if(af.getAtributo().equals(this.atributo)&& af.getQuantidade()==this.quantidade)
            return true;
        return false; //To change body of generated methods, choose Tools | Templates.
    }
        
}          

    


