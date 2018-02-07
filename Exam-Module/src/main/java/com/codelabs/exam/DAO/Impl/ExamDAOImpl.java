/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Exam;
import com.codelabs.exam.DAO.ExamDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prachin
 */
@Repository(value="ExamDAO")
public class ExamDAOImpl extends GenericDAOImpl<Exam> implements ExamDAO{
    
}
