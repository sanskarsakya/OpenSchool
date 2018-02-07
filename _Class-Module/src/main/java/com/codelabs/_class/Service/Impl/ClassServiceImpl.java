/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.Service.Impl;

import com.codelabs._class.DAO.ClassDAO;
import com.codelabs._class.DTO._ClassDTO;
import com.codelabs._class.Service.ClassService;
import com.codelabs.entity._Class;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author koirala
 */
@Service(value = "ClassService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDAO cDAO;

    @Override
    public List<_ClassDTO> getAll() {
        List<_ClassDTO> cList = new ArrayList<>();
        for (_Class c : cDAO.getAll()) {
            ModelMapper mapper = new ModelMapper();
            _ClassDTO cDTO = mapper.map(c, _ClassDTO.class);
            cList.add(cDTO);
        }
        return cList;
    }

    @Override
    public _ClassDTO insert(_ClassDTO cDTO) {
        ModelMapper mapper = new ModelMapper();
        _Class cl = mapper.map(cDTO, _Class.class);
        _Class ct = cDAO.insert(cl);
        cDTO.setClassId(ct.getClassId());
        return cDTO;
    }

    @Override
    public void update(int id, _ClassDTO cDTO) {
        _Class cl = new ModelMapper().map(cDTO, _Class.class);
        cDAO.update(cl);
    }

    @Override
    public boolean delete(int id) {
        return cDAO.delete(id);
    }

    @Override
    public _ClassDTO getById(int id) {
        _Class cl = cDAO.getById(id);
        if (cl == null) {
            return null;
        }
        return new ModelMapper().map(cl, _ClassDTO.class);
    }
}
