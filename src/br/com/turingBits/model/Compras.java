/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turingBits.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author caio
 */
@Entity
@Table(name = "COMPRAS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findById", query = "SELECT c FROM Compras c WHERE c.id = :id"),
    @NamedQuery(name = "Compras.findByData", query = "SELECT c FROM Compras c WHERE c.data = :data"),
    @NamedQuery(name = "Compras.findByDescricao", query = "SELECT c FROM Compras c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Compras.findByQtd", query = "SELECT c FROM Compras c WHERE c.qtd = :qtd"),
    @NamedQuery(name = "Compras.findByPrecouni", query = "SELECT c FROM Compras c WHERE c.precouni = :precouni")})
public class Compras implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "QTD")
    private int qtd;
    @Basic(optional = false)
    @Column(name = "PRECOUNI")
    private long precouni;

    public Compras() {
    }

    public Compras(Integer id) {
        this.id = id;
    }

    public Compras(Integer id, int qtd, long precouni) {
        this.id = id;
        this.qtd = qtd;
        this.precouni = precouni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        int oldQtd = this.qtd;
        this.qtd = qtd;
        changeSupport.firePropertyChange("qtd", oldQtd, qtd);
    }

    public long getPrecouni() {
        return precouni;
    }

    public void setPrecouni(long precouni) {
        long oldPrecouni = this.precouni;
        this.precouni = precouni;
        changeSupport.firePropertyChange("precouni", oldPrecouni, precouni);
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
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.turingBits.view.Compras[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
