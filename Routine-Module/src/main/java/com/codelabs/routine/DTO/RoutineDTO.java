/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.routine.DTO;

import com.codelabs.entity.Subject;
import com.codelabs.entity.Teacher;
import com.codelabs.entity.Time;
import com.codelabs.entity._Class;

/**
 *
 * @author koirala
 */
public class RoutineDTO {

    private Integer routineId;
    private _Class classId;
    private Subject subjectId;
    private Teacher teacherId;
    private Time timeId;

    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
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

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    public Time getTimeId() {
        return timeId;
    }

    public void setTimeId(Time timeId) {
        this.timeId = timeId;
    }

}
