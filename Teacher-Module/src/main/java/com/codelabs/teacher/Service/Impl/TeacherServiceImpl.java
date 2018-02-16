/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.Service.Impl;

import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity.Teacher;
import com.codelabs.teacher.DAO.TeacherDAO;
import com.codelabs.teacher.DTO.TeacherDTO;
import com.codelabs.teacher.Service.TeacherService;
import com.codelabs.teacher.Mapper.TeacherMapper;
import java.util.ArrayList;
import java.util.Date;
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
    private TeacherDAO dao;

    @Override
    public List<TeacherDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<TeacherDTO> tDTOList = new ArrayList<>();
        for (Teacher t : dao.getAll(pw, offset, limit)) {
            tDTOList.add(new TeacherMapper().toDTO(t));
        }
        return tDTOList;
    }

    @Override
    public TeacherDTO insert(TeacherDTO t) {
        Teacher teacher = new TeacherMapper().toEntity(null, t);
        teacher.setPassword(t.getUsername() + "123");
        Teacher rt = dao.insert(teacher);
        t.setTeacherId(rt.getTeacherId());
        return t;
    }

    @Override
    public void update(int id, TeacherDTO t) {
        Teacher teacher = dao.getById(id);
        teacher.setModifiedDate(new Date());
        dao.update(new TeacherMapper().toEntity(teacher, t));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public TeacherDTO getById(int id) {
        Teacher t = dao.getById(id);
        if (t == null) {
            return null;
        }
        return new TeacherMapper().toDTO(t);
    }

     @Override
    public Long count(ParamWrapper pw) {
        return dao.count(pw);
    }  
}
