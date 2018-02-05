/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Teacher;
import com.codelabs.teacher.DAO.TeacherDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzansakya
 */
@Repository(value = "TeacherDAO")
public class TeacherDAOImpl extends GenericDAOImpl<Teacher> implements TeacherDAO {

}
