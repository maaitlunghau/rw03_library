/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "library_cards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibraryCards.findAll", query = "SELECT l FROM LibraryCards l"),
    @NamedQuery(name = "LibraryCards.findByCardno", query = "SELECT l FROM LibraryCards l WHERE l.cardno = :cardno"),
    @NamedQuery(name = "LibraryCards.findByIssueDate", query = "SELECT l FROM LibraryCards l WHERE l.issueDate = :issueDate"),
    @NamedQuery(name = "LibraryCards.findByExpiryDate", query = "SELECT l FROM LibraryCards l WHERE l.expiryDate = :expiryDate"),
    @NamedQuery(name = "LibraryCards.findByStatus", query = "SELECT l FROM LibraryCards l WHERE l.status = :status")})
public class LibraryCards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "cardno")
    private String cardno;
    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "student_no", referencedColumnName = "stdno")
    @ManyToOne
    private Students studentNo;

    public LibraryCards() {
    }

    public LibraryCards(String cardno) {
        this.cardno = cardno;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Students getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Students studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardno != null ? cardno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibraryCards)) {
            return false;
        }
        LibraryCards other = (LibraryCards) object;
        if ((this.cardno == null && other.cardno != null) || (this.cardno != null && !this.cardno.equals(other.cardno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fpt.entity.LibraryCards[ cardno=" + cardno + " ]";
    }
    
}
