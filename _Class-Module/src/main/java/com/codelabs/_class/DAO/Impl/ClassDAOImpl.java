/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.DAO.Impl;

import com.codelabs._class.DAO.ClassDAO;
import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity._Class;
import org.springframework.stereotype.Repository;

/**
 *
 * @author koirala
 */
@Repository(value = "ClassDAO")
public class ClassDAOImpl extends GenericDAOImpl<_Class> implements ClassDAO {

}
