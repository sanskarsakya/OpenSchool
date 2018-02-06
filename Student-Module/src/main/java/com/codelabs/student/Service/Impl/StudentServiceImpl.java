/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.Service.Impl;

import com.codelabs.entity.Student;
import com.codelabs.student.DAO.StudentDAO;
import com.codelabs.student.DTO.StudentDTO;
import com.codelabs.student.Service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author koirala
 */
@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO sd;

    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> sDtoList = new ArrayList<>();
        for (Student student : sd.getAll()) {
            ModelMapper mapper = new ModelMapper();
            StudentDTO stdDTO = mapper.map(student, StudentDTO.class);
            sDtoList.add(stdDTO);
        }
        return sDtoList;
    }

    @Override
    public StudentDTO insert(StudentDTO sDTO) {
        ModelMapper mapper = new ModelMapper();
        Student student = mapper.map(sDTO, Student.class);
        student.setPassword(sDTO.getUsername() + "sSample");
        Student rt = sd.insert(student);
        return sDTO;
    }

    @Override
    public void update(int id, StudentDTO sDTO) {
        Student student = new ModelMapper().map(sDTO, Student.class);
        student.setPassword(sDTO.getUsername() + "sSample");
        sd.update(student);
    }

    @Override
    public boolean delete(int id) {
        return sd.delete(id);
    }

    @Override
    public StudentDTO getById(int id) {
        Student s = sd.getById(id);
        if (s == null) {
            return null;
        }
        return new ModelMapper().map(s, StudentDTO.class);
    }
}
