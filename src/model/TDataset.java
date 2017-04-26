/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author THIAGO
 */
public class TDataset {
   
   private int frequencia;
   private int acumulado;

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    public TDataset(int frequencia, int acumulado) {
        this.frequencia = frequencia;
        this.acumulado = acumulado;
    }
   
}
