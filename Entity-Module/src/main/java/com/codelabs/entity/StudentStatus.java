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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author puzansakya
 */
@Entity
@Table(name = "tbl_student_statuses")
@NamedQueries({
    @NamedQuery(name = "StudentStatus.findAll", query = "SELECT s FROM StudentStatus s")})
public class StudentStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column(name = "student_status_id")
    private Integer studentStatusId;    
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private List<Student> studentList;

    public StudentStatus() {
    }

    public StudentStatus(Integer studentStatusId) {
        this.studentStatusId = studentStatusId;
    }

    public StudentStatus(Integer studentStatusId, String status) {
        this.studentStatusId = studentStatusId;
        this.status = status;
    }

    public Integer getStudentStatusId() {
        return studentStatusId;
    }

    public void setStudentStatusId(Integer studentStatusId) {
        this.studentStatusId = studentStatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentStatusId != null ? studentStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentStatus)) {
            return false;
        }
        StudentStatus other = (StudentStatus) object;
        if ((this.studentStatusId == null && other.studentStatusId != null) || (this.studentStatusId != null && !this.studentStatusId.equals(other.studentStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codelabs.entity.StudentStatus[ studentStatusId=" + studentStatusId + " ]";
    }
    
}
