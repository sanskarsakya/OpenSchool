/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.section.Service.Impl;

import com.codelabs.core.Service.GenericService;
import com.codelabs.core.Wrapper.ParamWrapper;
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
    private SectionDAO dao;

    @Override
    public List<SectionDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<SectionDTO> sDTOList = new ArrayList<>();
        for (Section s : dao.getAll(pw, offset, limit)) {
            sDTOList.add(new SectionMapper().toDTO(s));
        }
        return sDTOList;
    }

    @Override
    public SectionDTO insert(SectionDTO s) {
        Section section = new SectionMapper().toEntity(null, s);
        Section rs = dao.insert(section);
        s.setSectionId(rs.getSectionId());
        return s;
    }

    @Override
    public void update(int id, SectionDTO s) {
        Section section = dao.getById(id);
        dao.update(new SectionMapper().toEntity(section, s));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public SectionDTO getById(int id) {
        Section s = dao.getById(id);
        if (s == null) {
            return null;
        }
        return new SectionMapper().toDTO(s);
    }

   @Override
    public Long count(ParamWrapper pw) {
        return dao.count(pw);
    }  

}
