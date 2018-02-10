/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.examtype.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.ExamType;
import com.codelabs.examtype.DAO.ExamTypeDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzansakya
 */
@Repository(value = "ExamTypeDAO")
public class ExamTypeDAOImpl extends GenericDAOImpl<ExamType> implements ExamTypeDAO {

}
