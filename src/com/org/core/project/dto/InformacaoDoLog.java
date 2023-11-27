/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.core.project.dto;

import com.org.core.project.bussinesLogic.AlgoritimosEnum;
import java.util.ArrayList;


public class InformacaoDoLog {
    public AlgoritimosEnum algoritimo;
    public int valores; 
    public ArrayList<Caso> casos;  

    /**
     * @return the Algoritimo
     */
    public AlgoritimosEnum getAlgoritimo() {
        return algoritimo;
    }

    /**
     * @param algoritimo the Algoritimo to set
     */
    public void setAlgoritimo(AlgoritimosEnum algoritimo) {
        this.algoritimo = algoritimo;
    }

    /**
     * @return the casos
     */
    public ArrayList<Caso> getCasos() {
        return casos;
    }

    /**
     * @param casos the casos to set
     */
    public void setCasos(ArrayList<Caso> casos) {
        this.casos = casos;
    }

    /**
     * @return the valores
     */
    public int getValores() {
        return valores;
    }

    /**
     * @param valores the valores to set
     */
    public void setValores(int valores) {
        this.valores = valores;
    }
    
    
}
