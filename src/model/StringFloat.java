/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ivision
 */
public class StringFloat {
    private String Descricao;
    private float valor;

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public StringFloat(String Descricao, float valor) {
        this.Descricao = Descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return Descricao + " " + valor ;
    }
    
    
}
