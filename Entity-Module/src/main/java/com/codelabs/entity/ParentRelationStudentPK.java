/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author puzansakya
 */
@Embeddable
public class ParentRelationStudentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "student_id")
    private int studentId;
    @Basic(optional = false)
    @Column(name = "parent_id")
    private int parentId;

    public ParentRelationStudentPK() {
    }

    public ParentRelationStudentPK(int studentId, int parentId) {
        this.studentId = studentId;
        this.parentId = parentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentId;
        hash += (int) parentId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentRelationStudentPK)) {
            return false;
        }
        ParentRelationStudentPK other = (ParentRelationStudentPK) object;
        if (this.studentId != other.studentId) {
            return false;
        }
        if (this.parentId != other.parentId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codelabs.entity.ParentRelationStudentPK[ studentId=" + studentId + ", parentId=" + parentId + " ]";
    }
    
}
