/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.status.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Status;
import com.codelabs.status.DAO.StatusDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzansakya
 */
@Repository(value = "StatusDAO")
public class StatusDTOImpl extends GenericDAOImpl<Status> implements StatusDAO {

}
