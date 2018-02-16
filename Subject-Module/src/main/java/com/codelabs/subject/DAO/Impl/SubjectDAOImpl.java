/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Subject;
import com.codelabs.subject.DAO.SubjectDAO;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anuzaa_2
 */
@Repository(value = "SubjectDAO")
public class SubjectDAOImpl extends GenericDAOImpl<Subject> implements SubjectDAO {

    @Override
    public List<Subject> getSubjectByClass(int classId, int offset, int limit) {
         session = sessionFactory.openSession();
        List<Subject> subjectList = session
                .createQuery("from Subject where classId.classId=:classId")
                .setParameter("classId", classId)
                .list();
        session.close();
        return subjectList;
    }

  

}
