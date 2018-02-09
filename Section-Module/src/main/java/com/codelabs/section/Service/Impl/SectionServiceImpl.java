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
import com.codelabs.section.Mapper.SectionMapper;
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
            sDTOList.add(new SectionMapper().toDTO(s));
        }
        return sDTOList;
    }

    @Override
    public SectionDTO insert(SectionDTO s) {
        Section section = new SectionMapper().toEntity(null, s);
        Section rs = sd.insert(section);
        s.setSectionId(rs.getSectionId());
        return s;
    }

    @Override
    public void update(int id, SectionDTO s) {
        Section section = sd.getById(id);
        sd.update(new SectionMapper().toEntity(section, s));
    }

    @Override
    public boolean delete(int id) {
        return sd.delete(id);
    }

    @Override
    public SectionDTO getById(int id) {
        Section s = sd.getById(id);
        if (s == null) {
            return null;
        }
        return new SectionMapper().toDTO(s);
    }

}
