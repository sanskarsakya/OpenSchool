/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.Service.Impl;

import com.codelabs.entity.Teacher;
import com.codelabs.teacher.Builder.TeacherBuilder;
import com.codelabs.teacher.DAO.TeacherDAO;
import com.codelabs.teacher.DTO.TeacherDTO;
import com.codelabs.teacher.Service.TeacherService;
import java.util.ArrayList;
import java.util.List;
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
            TeacherDTO td = TeacherBuilder
                    .create()
                    .setId(t.getTeacherId())
                    .setFirstName(t.getFirstName())
                    .setLastName(t.getLastName())
                    .setAddress(t.getAddress())
                    .setContactNo(t.getContactNo())
                    .buildDTO();
            tDTOList.add(td);
        }
        return tDTOList;
    }
    
    @Override
    public TeacherDTO insert(TeacherDTO t) {
        Teacher teacher = TeacherBuilder
                .create()
                .setFirstName(t.getFirstName())
                .setLastName(t.getLastName())
                .setAddress(t.getAddress())
                .setContactNo(t.getContactNo())
                .build();
        
        Teacher rt = tDAO.insert(teacher);
        t.setTeacherId(rt.getTeacherId());
        
        return t;
    }
    
    @Override
    public void update(int id, TeacherDTO t) {
        Teacher teacher = TeacherBuilder
                .create()
                .setId(t.getTeacherId())
                .setFirstName(t.getFirstName())
                .setLastName(t.getLastName())
                .setAddress(t.getAddress())
                .setContactNo(t.getContactNo())
                .build();
        
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
        TeacherDTO td = TeacherBuilder
                .create()
                .setFirstName(t.getFirstName())
                .setLastName(t.getLastName())
                .setAddress(t.getAddress())
                .setContactNo(t.getContactNo())
                .buildDTO();
        
        return td;
    }
    
}
