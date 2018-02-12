/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.DAO;

import com.codelabs.core.DAO.GenericDAO;
import com.codelabs.entity.Exam;
import java.util.List;

/**
 *
 * @author Prachin
 */
public interface ExamDAO extends GenericDAO<Exam> {

    List<Exam> getByClassAndExamType(int examTypeId, int classId);

}
