/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Student;
import com.codelabs.student.DAO.StudentDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author koirala
 */
@Repository(value = "StudentDAO")
public class StudentDAOImpl extends GenericDAOImpl<Student> implements StudentDAO {

}
