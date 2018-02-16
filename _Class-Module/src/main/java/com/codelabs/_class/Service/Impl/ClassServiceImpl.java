/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.Service.Impl;

import com.codelabs._class.DAO.ClassDAO;
import com.codelabs._class.DTO._ClassDTO;
import com.codelabs._class.Mapper._ClassMapper;
import com.codelabs._class.Service.ClassService;
import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity._Class;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author koirala
 */
@Service(value = "ClassService")
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDAO dao;
    private _ClassMapper mapper;

    public ClassServiceImpl() {
        mapper = new _ClassMapper();
    }

    @Override
    public List<_ClassDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<_ClassDTO> dtoList = new ArrayList<>();
        for (_Class entity : dao.getAll(pw, offset, limit)) {
            dtoList.add(mapper.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public _ClassDTO insert(_ClassDTO dto) {
        dto.setClassId(dao.insert(mapper.toEntity(null, dto)).getClassId());
        return dto;
    }

    @Override
    public void update(int id, _ClassDTO dto) {
        _Class entity = dao.getById(id);
        entity.setModifiedDate(new Date());
        dao.update(mapper.toEntity(entity, dto));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public _ClassDTO getById(int id) {
        _Class entity = dao.getById(id);
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
