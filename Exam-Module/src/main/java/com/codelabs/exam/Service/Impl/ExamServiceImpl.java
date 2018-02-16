/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.Service.Impl;

import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity.Exam;
import com.codelabs.exam.DAO.ExamDAO;
import com.codelabs.exam.DTO.ExamDTO;
import com.codelabs.exam.Mapper.ExamMapper;
import com.codelabs.exam.Service.ExamService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prachin
 */
@Service(value = "ExamService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDAO dao;
    private ExamMapper mapper;

    public ExamServiceImpl() {
        this.mapper = new ExamMapper();
    }

    @Override
    public List<ExamDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<ExamDTO> dtoList = new ArrayList<>();
        for (Exam entity : dao.getAll(pw, offset, limit)) {
            dtoList.add(mapper.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public ExamDTO insert(ExamDTO dto) {
        Exam entity = mapper.toEntity(null, dto);
        dto.setExamId(dao.insert(entity).getExamId());
        return dto;
    }

    @Override
    public void update(int id, ExamDTO dto) {
        Exam entity = dao.getById(id);
        entity.setModifiedDate(new Date());
        dao.update(mapper.toEntity(entity, dto));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ExamDTO getById(int id) {
        Exam entity = dao.getById(id);
        if (entity == null) {
            return null;
        }
        return mapper.toDTO(entity);
    }

    @Override
    public List<ExamDTO> getByClassAndExamType(int examTypeId, int classId) {
        List<ExamDTO> dtoList = new ArrayList<>();
        for (Exam entity : dao.getByClassAndExamType(examTypeId, classId)) {
            dtoList.add(mapper.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public Long count(ParamWrapper pw) {
        return dao.count(pw);
    }

}
