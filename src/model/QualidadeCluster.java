/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivision
 */
public class QualidadeCluster {
    private float MediaSimInterna;
    private float MediaSimExterna;

    public float getMediaSimInterna() {
        return MediaSimInterna;
    }

    public void setMediaSimInterna(float MediaSimInterna) {
        this.MediaSimInterna = MediaSimInterna;
    }

    public float getMediaSimExterna() {
        return MediaSimExterna;
    }

    public void setMediaSimExterna(float MediaSimExterna) {
        this.MediaSimExterna = MediaSimExterna;
    }

    
    public float Qualidade() {
        return this.MediaSimInterna-this.MediaSimExterna;
    }

    
    public List<String> toList() {
        List<String> listagem = new ArrayList<String>();
        listagem.add(String.valueOf(this.MediaSimInterna));
        listagem.add(String.valueOf(this.MediaSimExterna));
        listagem.add(String.valueOf(this.Qualidade()));
        return listagem;
    }

    @Override
    public String toString() {
        return "Cluster " + MediaSimInterna + " " + MediaSimExterna + " "+ this.Qualidade();
    }
    
    
}
