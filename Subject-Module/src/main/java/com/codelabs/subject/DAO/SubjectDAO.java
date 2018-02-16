/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.DAO;

import com.codelabs.core.DAO.GenericDAO;
import com.codelabs.entity.Subject;
import java.util.List;

/**
 *
 * @author Anuzaa_2
 */
public interface SubjectDAO extends GenericDAO<Subject> {

    List<Subject> getSubjectByClass(int classId,int offset, int limit);

}
