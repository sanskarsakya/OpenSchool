/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.relation.DAO.IMPL;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Relation;
import com.codelabs.relation.DAO.RelationDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value ="RelationDAO")
public class RelationDAOImpl extends GenericDAOImpl<Relation> implements RelationDAO {
    
}
