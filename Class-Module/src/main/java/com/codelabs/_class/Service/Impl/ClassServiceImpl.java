/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.Service.Impl;

import com.codelabs._class.DAO.ClassDAO;
import com.codelabs._class.DTO.ClassDTO;
import com.codelabs._class.Service.ClassService;
import com.codelabs.entity._Class;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuzaa_2
 */
@Service(value = "ClassService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDAO cd;

    @Override
    public List<ClassDTO> getAll() {
        List<ClassDTO> clslist = new ArrayList<>();
        for (_Class cls : cd.getAll()) {
            ClassDTO cDTO = new ClassDTO();
            cDTO.setClassId(cls.getClassId());
            cDTO.setClassName(cls.getClassName());

            clslist.add(cDTO);

        }
        return clslist;
    }

    @Override
    public ClassDTO insert(ClassDTO cDTO) {
        _Class cls = new _Class();
        cls.setClassId(cDTO.getClassId());
        cls.setClassName(cDTO.getClassName());
        _Class ret_Class = cd.insert(cls);
        cDTO.setClassId(ret_Class.getClassId());

        return cDTO;
    }

    @Override
    public void update(int id, ClassDTO cDTO) {
        _Class cls = new _Class();
        cls.setClassId(id);
        cls.setClassName(cDTO.getClassName());
        cd.update(cls);
    }

    @Override
    public boolean delete(int id) {
        return cd.delete(id);
    }

    @Override
    public ClassDTO getById(int id) {
        _Class cls = new _Class();
        ClassDTO cDTO = new ClassDTO();
        cDTO.setClassId(cls.getClassId());
        cDTO.setClassName(cls.getClassName());
        return cDTO;
    }
}
