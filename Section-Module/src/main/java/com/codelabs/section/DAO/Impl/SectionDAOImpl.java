/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.section.DAO.Impl;

import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Section;
import com.codelabs.section.DAO.SectionDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author puzansakya
 */
@Repository(value = "SectionDAO")
public class SectionDAOImpl extends GenericDAOImpl<Section> implements SectionDAO {

}
