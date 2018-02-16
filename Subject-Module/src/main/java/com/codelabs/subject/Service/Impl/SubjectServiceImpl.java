/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Service.Impl;

import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity.Subject;
import com.codelabs.subject.DAO.SubjectDAO;
import com.codelabs.subject.DTO.SubjectDTO;
import com.codelabs.subject.Mapper.SubjectMapper;
import com.codelabs.subject.Service.SubjectService;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuzaa_2
 */
@Service(value = "SubjectService")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO dao;

    private SubjectMapper mapper;

    public SubjectServiceImpl() {
        mapper = new SubjectMapper();
    }

    @Override
    public List<SubjectDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<SubjectDTO> dtoList = new ArrayList<>();
        for (Subject entity : dao.getAll(pw, offset, limit)) {
            dtoList.add(mapper.toDTO(entity));
        }
        return dtoList;

    }  

    @Override
    public SubjectDTO insert(SubjectDTO dto) {
        dto.setSubjectId(dao.insert(mapper.toEntity(null, dto)).getSubjectId());
        return dto;
    }

    @Override
    public void update(int id, SubjectDTO dto) {
        Subject entity = dao.getById(id);
        entity.setModifiedDate(new Date());
        dao.update(mapper.toEntity(entity, dto));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public SubjectDTO getById(int id) {
        Subject entity = dao.getById(id);
        if (entity == null) {
            return null;
        }
        return mapper.toDTO(entity);
    }

    @Override
    public Long count(ParamWrapper pw) {
        return dao.count(pw);
    }  
   
}
