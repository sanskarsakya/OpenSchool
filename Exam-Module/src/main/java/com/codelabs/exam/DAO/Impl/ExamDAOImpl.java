/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Exam;
import com.codelabs.exam.DAO.ExamDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prachin
 */
@Repository(value = "ExamDAO")
public class ExamDAOImpl extends GenericDAOImpl<Exam> implements ExamDAO {

    @Override
    public List<Exam> getByClassAndExamType(int examTypeId, int classId) {
        session = sessionFactory.openSession();
        List<Exam> examList = session
                .createQuery("from Exam where examTypeId.examTypeId =:examTypeId AND classId.classId=:classId")
                .setParameter("examTypeId", examTypeId)
                .setParameter("classId", classId)
                .list();
        session.close();
        return examList;
    }

}
