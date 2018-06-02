/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codershift.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISSAH OJIVO
 */
@Entity
@Table(name = "punch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punch.findAll", query = "SELECT p FROM Punch p")
    , @NamedQuery(name = "Punch.findById", query = "SELECT p FROM Punch p WHERE p.id = :id")
    , @NamedQuery(name = "Punch.findByStyle", query = "SELECT p FROM Punch p WHERE p.style = :style")
    , @NamedQuery(name = "Punch.findByTheURL", query = "SELECT p FROM Punch p WHERE p.theURL = :theURL")
    , @NamedQuery(name = "Punch.findByTitle", query = "SELECT p FROM Punch p WHERE p.title = :title")
    , @NamedQuery(name = "Punch.findBySummary", query = "SELECT p FROM Punch p WHERE p.summary = :summary")
    , @NamedQuery(name = "Punch.findByDa", query = "SELECT p FROM Punch p WHERE p.da = :da")})
public class Punch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 4000)
    @Column(name = "style")
    private String style;
    @Size(max = 4000)
    @Column(name = "theURL")
    private String theURL;
    @Size(max = 1000)
    @Column(name = "title")
    private String title;
    @Size(max = 10000)
    @Column(name = "summary")
    private String summary;
    @Size(max = 200)
    @Column(name = "da")
    private String da;

    public Punch() {
    }

    public Punch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTheURL() {
        return theURL;
    }

    public void setTheURL(String theURL) {
        this.theURL = theURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String date) {
        this.da = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punch)) {
            return false;
        }
        Punch other = (Punch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codershift.entity.Punch[ id=" + id + " ]";
    }
    
}
