/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author puzansakya
 */
@Entity
@Table(name = "tbl_parent_relation_students")
@NamedQueries({
    @NamedQuery(name = "ParentRelationStudent.findAll", query = "SELECT p FROM ParentRelationStudent p")})
public class ParentRelationStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParentRelationStudentPK parentRelationStudentPK;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "status")
    private Boolean status;
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parent parent;
    @JoinColumn(name = "relation_id", referencedColumnName = "relation_id")
    @ManyToOne(optional = false)
    private Relation relationId;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public ParentRelationStudent() {
    }

    public ParentRelationStudent(ParentRelationStudentPK parentRelationStudentPK) {
        this.parentRelationStudentPK = parentRelationStudentPK;
    }

    public ParentRelationStudent(int studentId, int parentId) {
        this.parentRelationStudentPK = new ParentRelationStudentPK(studentId, parentId);
    }

    public ParentRelationStudentPK getParentRelationStudentPK() {
        return parentRelationStudentPK;
    }

    public void setParentRelationStudentPK(ParentRelationStudentPK parentRelationStudentPK) {
        this.parentRelationStudentPK = parentRelationStudentPK;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Relation getRelationId() {
        return relationId;
    }

    public void setRelationId(Relation relationId) {
        this.relationId = relationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentRelationStudentPK != null ? parentRelationStudentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentRelationStudent)) {
            return false;
        }
        ParentRelationStudent other = (ParentRelationStudent) object;
        if ((this.parentRelationStudentPK == null && other.parentRelationStudentPK != null) || (this.parentRelationStudentPK != null && !this.parentRelationStudentPK.equals(other.parentRelationStudentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codelabs.entity.ParentRelationStudent[ parentRelationStudentPK=" + parentRelationStudentPK + " ]";
    }
    
}
