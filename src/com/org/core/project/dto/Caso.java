/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.core.project.dto;

import java.util.Date;

public  class Caso {
    private String descCaso;
    private Date dateInicio;
    private long inicio;
    private long fim;
    private Date dateFim;
    private long total;

    /**
     * @return the descCaso
     */
    public String getDescCaso() {
        return descCaso;
    }

    /**
     * @param descCaso the descCaso to set
     */
    public void setDescCaso(String descCaso) {
        this.descCaso = descCaso;
    }

    /**
     * @return the inicio
     */
    public long getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public long getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(long fim) {
        this.fim = fim;
    }

    /**
     * @return the total
     */
    public long getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * @return the dateInicio
     */
    public Date getDateInicio() {
        return dateInicio;
    }

    /**
     * @param dateInicio the dateInicio to set
     */
    public void setDateInicio(Date dateInicio) {
        this.dateInicio = dateInicio;
    }

    /**
     * @return the dateFim
     */
    public Date getDateFim() {
        return dateFim;
    }

    /**
     * @param dateFim the dateFim to set
     */
    public void setDateFim(Date dateFim) {
        this.dateFim = dateFim;
    }
    
    
       
    
}
