/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.Service.Impl;

import com.codelabs.entity.Teacher;
//import com.codelabs.teacher.Builder.TeacherBuilder;
import com.codelabs.teacher.DAO.TeacherDAO;
import com.codelabs.teacher.DTO.TeacherDTO;
import com.codelabs.teacher.Service.TeacherService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author puzansakya
 */
@Service(value = "TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO tDAO;

    @Override
    public List<TeacherDTO> getAll() {
        List<TeacherDTO> tDTOList = new ArrayList<>();
        for (Teacher t : tDAO.getAll()) {
            ModelMapper mapper = new ModelMapper();
            TeacherDTO tdto = mapper.map(t, TeacherDTO.class);
            tDTOList.add(tdto);
        }
        return tDTOList;
    }

    @Override
    public TeacherDTO insert(TeacherDTO t) {
        ModelMapper mapper = new ModelMapper();
        Teacher teacher = mapper.map(t, Teacher.class);
        teacher.setPassword(t.getUsername() + "123");
        Teacher rt = tDAO.insert(teacher);
        t.setTeacherId(rt.getTeacherId());
        return t;
    }

    @Override
    public void update(int id, TeacherDTO t) {
        Teacher teacher = new ModelMapper().map(t, Teacher.class);
        teacher.setPassword(t.getUsername() + "123");
        tDAO.update(teacher);
    }

    @Override
    public boolean delete(int id) {
        return tDAO.delete(id);
    }

    @Override
    public TeacherDTO getById(int id) {
        Teacher t = tDAO.getById(id);
        if (t == null) {
            return null;
        }
        return new ModelMapper().map(t, TeacherDTO.class);
    }

}
