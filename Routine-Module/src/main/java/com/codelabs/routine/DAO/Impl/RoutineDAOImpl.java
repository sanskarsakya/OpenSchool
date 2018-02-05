/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.routine.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Routine;
import com.codelabs.routine.DAO.RoutineDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author koirala
 */
@Repository(value = "RoutineDAO")
public class RoutineDAOImpl extends GenericDAOImpl<Routine> implements RoutineDAO {

}
