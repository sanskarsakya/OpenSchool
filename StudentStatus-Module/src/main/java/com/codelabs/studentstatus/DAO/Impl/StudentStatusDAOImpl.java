/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.studentstatus.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.StudentStatus;
import com.codelabs.studentstatus.DAO.StudentStatusDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value = "StudentStatusDAO")
public class StudentStatusDAOImpl extends GenericDAOImpl<StudentStatus> implements StudentStatusDAO{
    
    
}
