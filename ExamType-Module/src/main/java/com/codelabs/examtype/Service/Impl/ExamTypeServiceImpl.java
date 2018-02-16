/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.examtype.Service.Impl;

import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity.ExamType;
import com.codelabs.examtype.DAO.ExamTypeDAO;
import com.codelabs.examtype.DTO.ExamTypeDTO;
import com.codelabs.examtype.Mapper.ExamTypeMapper;
import com.codelabs.examtype.Service.ExamTypeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author puzansakya
 */
@Service(value = "ExamTypeService")
public class ExamTypeServiceImpl implements ExamTypeService {

    @Autowired
    private ExamTypeDAO dao;

    @Override
    public List<ExamTypeDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<ExamTypeDTO> eDTOList = new ArrayList<>();
        for (ExamType et : dao.getAll(pw, offset, limit)) {
            eDTOList.add(new ExamTypeMapper().toDTO(et));
        }
        return eDTOList;
    }

    @Override
    public ExamTypeDTO insert(ExamTypeDTO et) {
        ExamType examType = new ExamTypeMapper().toEntity(null, et);
        ExamType ret = dao.insert(examType);
        et.setExamTypeId(ret.getExamTypeId());
        return et;
    }

    @Override
    public void update(int id, ExamTypeDTO et) {
        ExamType etMapped = dao.getById(id);
        etMapped.setModifiedDate(new Date());
        dao.update(new ExamTypeMapper().toEntity(etMapped, et));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public ExamTypeDTO getById(int id) {
        ExamType et = dao.getById(id);
        if (et == null) {
            return null;
        }
        return new ExamTypeMapper().toDTO(et);
    }

    @Override
    public Long count(ParamWrapper pw) {
        return dao.count(pw);
    }
}
