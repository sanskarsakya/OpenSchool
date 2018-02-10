/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.examtype.Service.Impl;

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
    private ExamTypeDAO ed;

    @Override
    public List<ExamTypeDTO> getAll() {
        List<ExamTypeDTO> eDTOList = new ArrayList<>();
        for (ExamType et : ed.getAll()) {
            eDTOList.add(new ExamTypeMapper().toDTO(et));
        }
        return eDTOList;
    }

    @Override
    public ExamTypeDTO insert(ExamTypeDTO et) {
        ExamType examType = new ExamTypeMapper().toEntity(null, et);
        ExamType ret = ed.insert(examType);
        et.setExamTypeId(ret.getExamTypeId());
        return et;
    }

    @Override
    public void update(int id, ExamTypeDTO et) {
        ExamType etMapped = ed.getById(id);
        etMapped.setModifiedDate(new Date());
        ed.update(new ExamTypeMapper().toEntity(etMapped, et));
    }

    @Override
    public boolean delete(int id) {
        return ed.delete(id);
    }

    @Override
    public ExamTypeDTO getById(int id) {
        ExamType et = ed.getById(id);
        if (et == null) {
            return null;
        }
        return new ExamTypeMapper().toDTO(et);
    }

}
