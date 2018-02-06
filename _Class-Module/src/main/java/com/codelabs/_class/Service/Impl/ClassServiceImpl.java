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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuzaa_2
 */
@Service(value = "ClassService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDAO cd;

    @Override
    public List<ClassDTO> getAll() {
        List<ClassDTO> clslist = new ArrayList<>();
        for (_Class cls : cd.getAll()) {
            ModelMapper mapper = new ModelMapper();
            ClassDTO cDTO = mapper.map(cls, ClassDTO.class);
            clslist.add(cDTO);

        }
        return clslist;
    }

    @Override
    public ClassDTO insert(ClassDTO cDTO) {
        ModelMapper mapper = new ModelMapper();
        _Class cls = mapper.map(cDTO, _Class.class);
        _Class rc = cd.insert(cls);
        cDTO.setClassId(rc.getClassId());
        return cDTO;
    }

    @Override
    public void update(int id, ClassDTO cDTO) {
        _Class cls = new ModelMapper().map(cDTO, _Class.class);
        cd.update(cls);
    }

    @Override
    public boolean delete(int id) {
        return cd.delete(id);
    }

    @Override
    public ClassDTO getById(int id) {
        _Class c = cd.getById(id);
        if (c == null) {
            return null;
        }
        return new ModelMapper().map(c, ClassDTO.class);
    }
}