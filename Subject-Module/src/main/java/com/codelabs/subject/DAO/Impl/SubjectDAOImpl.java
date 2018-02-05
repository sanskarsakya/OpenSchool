/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Subject;
import com.codelabs.subject.DAO.SubjectDAO;
import org.springframework.stereotype.Repository;


@Repository(value = "SubjectDAO")
public class SubjectDAOImpl extends GenericDAOImpl<Subject> implements SubjectDAO {
    
}
