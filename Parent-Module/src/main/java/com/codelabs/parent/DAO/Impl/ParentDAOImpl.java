/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Parent;
import com.codelabs.parent.DAO.ParentDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anuzaa_2
 */
@Repository(value = "ParentDAO")
public class ParentDAOImpl extends GenericDAOImpl<Parent> implements ParentDAO {
    
}
