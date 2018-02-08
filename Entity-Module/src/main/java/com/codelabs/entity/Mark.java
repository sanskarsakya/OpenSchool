/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author puzansakya
 */
@Entity
@Table(name = "tbl_marks")
@NamedQueries({
    @NamedQuery(name = "Mark.findAll", query = "SELECT m FROM Mark m")})
public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mark_id")
    private Integer markId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "obtained_mark")
    private Double obtainedMark;
    @JoinColumn(name = "exam_id", referencedColumnName = "exam_id")
    @ManyToOne(optional = false)
    private Exam examId;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne(optional = false)
    private Student studentId;

    public Mark() {
    }

    public Mark(Integer markId) {
        this.markId = markId;
    }

    public Integer getMarkId() {
        return markId;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public Double getObtainedMark() {
        return obtainedMark;
    }

    public void setObtainedMark(Double obtainedMark) {
        this.obtainedMark = obtainedMark;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (markId != null ? markId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.markId == null && other.markId != null) || (this.markId != null && !this.markId.equals(other.markId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.codelabs.entity.Mark[ markId=" + markId + " ]";
    }
    
}
