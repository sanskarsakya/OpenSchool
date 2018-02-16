/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.Service.Impl;

import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity.Student;
import com.codelabs.student.DAO.StudentDAO;
import com.codelabs.student.DTO.StudentDTO;
import com.codelabs.student.Mapper.StudentMapper;
import com.codelabs.student.Service.StudentService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author koirala
 */
@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO dao;
    private StudentMapper mapper;

    public StudentServiceImpl() {
        this.mapper = new StudentMapper();
    }

    @Override
    public List<StudentDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student entity : dao.getAll(pw, offset, limit)) {
            dtoList.add(mapper.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public StudentDTO insert(StudentDTO dto) {
        Student entity = mapper.toEntity(null, dto);
        entity.setPassword(dto.getUsername() + "123");
        dto.setStudentId(dao.insert(entity).getStudentId());
        return dto;
    }

    @Override
    public void update(int id, StudentDTO dto) {
        Student entity = dao.getById(id);
        entity.setModifiedDate(new Date());
        dao.update(mapper.toEntity(entity, dto));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public StudentDTO getById(int id) {
        Student entity = dao.getById(id);
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
