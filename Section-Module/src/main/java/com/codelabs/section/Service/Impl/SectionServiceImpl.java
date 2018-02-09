/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.section.Service.Impl;

import com.codelabs.core.Service.GenericService;
import com.codelabs.entity.Section;
import com.codelabs.section.DAO.SectionDAO;
import com.codelabs.section.DTO.SectionDTO;
import com.codelabs.section.Service.SectionService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author puzansakya
 */
@Service(value = "SectionService")
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionDAO sd;

    @Override
    public List<SectionDTO> getAll() {
        List<SectionDTO> sDTOList = new ArrayList<>();
        for (Section s : sd.getAll()) {
            sDTOList.add(new ModelMapper().map(s, SectionDTO.class));
        }
        return sDTOList;
    }

    @Override
    public SectionDTO insert(SectionDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int id, SectionDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SectionDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
