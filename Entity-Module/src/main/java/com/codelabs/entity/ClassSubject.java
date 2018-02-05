/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author puzansakya
 */
@Entity
@Table(name = "tbl_class_subjects")
@NamedQueries({
    @NamedQuery(name = "ClassSubject.findAll", query = "SELECT c FROM ClassSubject c")})
public class ClassSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "class_subject_id")
    private Integer classSubjectId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "full_marks")
    private Double fullMarks;
    @Column(name = "pass_marks")
    private Double passMarks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classSubjectId")
    private List<Report> reportList;
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @ManyToOne(optional = false)
    private _Class classId;
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @ManyToOne(optional = false)
    private Subject subjectId;

    public ClassSubject() {
    }

    public ClassSubject(Integer classSubjectId) {
        this.classSubjectId = classSubjectId;
    }

    public Integer getClassSubjectId() {
        return classSubjectId;
    }

    public void setClassSubjectId(Integer classSubjectId) {
        this.classSubjectId = classSubjectId;
    }

    public Double getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(Double fullMarks) {
        this.fullMarks = fullMarks;
    }

    public Double getPassMarks() {
        return passMarks;
    }

    public void setPassMarks(Double passMarks) {
        this.passMarks = passMarks;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public _Class getClassId() {
        return classId;
    }

    public void setClassId(_Class classId) {
        this.classId = classId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classSubjectId != null ? classSubjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassSubject)) {
            return false;
        }
        ClassSubject other = (ClassSubject) object;
        if ((this.classSubjectId == null && other.classSubjectId != null) || (this.classSubjectId != null && !this.classSubjectId.equals(other.classSubjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codelabs.entity.ClassSubject[ classSubjectId=" + classSubjectId + " ]";
    }
    
}
