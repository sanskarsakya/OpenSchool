/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Service.Impl;

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
    private SubjectDAO sdao;

    @Override
    public List<SubjectDTO> getAll() {
        List<SubjectDTO> sDTOList = new ArrayList<>();
        for (Subject subject : sdao.getAll()) {
            sDTOList.add(new SubjectMapper().toDTO(subject));
        }
        return sDTOList;

    }

    @Override
    public SubjectDTO insert(SubjectDTO subDTO) {
        Subject subject = new SubjectMapper().toEntity(null, subDTO);
        Subject rs = sdao.insert(subject);
        subDTO.setSubjectId(rs.getSubjectId());
        return subDTO;
    }

    @Override
    public void update(int id, SubjectDTO subDTO) {
        Subject subject = sdao.getById(id);
        subject.setModifiedDate(new Date());
        sdao.update(new SubjectMapper().toEntity(subject, subDTO));
    }

    @Override
    public boolean delete(int id) {
        return sdao.delete(id);
    }

    @Override
    public SubjectDTO getById(int id) {
        Subject subject = sdao.getById(id);
        if (subject == null) {
            return null;
        }
        return new SubjectMapper().toDTO(subject);
    }
}
