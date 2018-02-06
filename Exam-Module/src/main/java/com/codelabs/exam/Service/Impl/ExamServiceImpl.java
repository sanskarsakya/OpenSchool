/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.Service.Impl;

import com.codelabs.entity.Exam;
import com.codelabs.exam.DAO.ExamDAO;
import com.codelabs.exam.DTO.ExamDTO;
import com.codelabs.exam.Service.ExamService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prachin
 */
@Service(value = "ExamService")
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamDAO eDAO;

    @Override
    public List<ExamDTO> getAll() {
        List<ExamDTO> eDTOList = new ArrayList<>();
        for (Exam e : eDAO.getAll()) {
            ModelMapper mapper = new ModelMapper();
            ExamDTO eDTO = mapper.map(e, ExamDTO.class);
            eDTOList.add(eDTO);
        }
        return eDTOList;
    }

    @Override
    public ExamDTO insert(ExamDTO e) {
        ModelMapper mapper = new ModelMapper();
        Exam exam = mapper.map(e, Exam.class);
        Exam ex = eDAO.insert(exam);
        e.setExamId(ex.getExamId());
        return e;
    }

    @Override
    public void update(int id, ExamDTO e) {
        Exam exam = new ModelMapper().map(e, Exam.class);
        eDAO.update(exam);
    }

    @Override
    public boolean delete(int id) {
        return eDAO.delete(id);
    }

    @Override
    public ExamDTO getById(int id) {
        Exam e = eDAO.getById(id);
        if (e == null) {
            return null;
        }
        return new ModelMapper().map(e, ExamDTO.class);
    }

}
