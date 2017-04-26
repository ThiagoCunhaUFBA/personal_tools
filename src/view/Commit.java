/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author thiago
 */
@Entity
@Table(name = "commit", catalog = "baseapp", schema = "")
@NamedQueries({
    @NamedQuery(name = "Commit.findAll", query = "SELECT c FROM Commit c"),
    @NamedQuery(name = "Commit.findById", query = "SELECT c FROM Commit c WHERE c.id = :id"),
    @NamedQuery(name = "Commit.findByRevisao", query = "SELECT c FROM Commit c WHERE c.revisao = :revisao"),
    @NamedQuery(name = "Commit.findByPath", query = "SELECT c FROM Commit c WHERE c.path = :path"),
    @NamedQuery(name = "Commit.findByOperacao", query = "SELECT c FROM Commit c WHERE c.operacao = :operacao"),
    @NamedQuery(name = "Commit.findByTipo", query = "SELECT c FROM Commit c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Commit.findByData", query = "SELECT c FROM Commit c WHERE c.data = :data"),
    @NamedQuery(name = "Commit.findByHora", query = "SELECT c FROM Commit c WHERE c.hora = :hora"),
    @NamedQuery(name = "Commit.findByAutor", query = "SELECT c FROM Commit c WHERE c.autor = :autor")})
public class Commit implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "revisao")
    private Integer revisao;
    @Column(name = "path")
    private String path;
    @Column(name = "operacao")
    private String operacao;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "autor")
    private String autor;

    public Commit() {
    }

    public Commit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getRevisao() {
        return revisao;
    }

    public void setRevisao(Integer revisao) {
        Integer oldRevisao = this.revisao;
        this.revisao = revisao;
        changeSupport.firePropertyChange("revisao", oldRevisao, revisao);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        String oldPath = this.path;
        this.path = path;
        changeSupport.firePropertyChange("path", oldPath, path);
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        String oldOperacao = this.operacao;
        this.operacao = operacao;
        changeSupport.firePropertyChange("operacao", oldOperacao, operacao);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        String oldAutor = this.autor;
        this.autor = autor;
        changeSupport.firePropertyChange("autor", oldAutor, autor);
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
        if (!(object instanceof Commit)) {
            return false;
        }
        Commit other = (Commit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Commit[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
