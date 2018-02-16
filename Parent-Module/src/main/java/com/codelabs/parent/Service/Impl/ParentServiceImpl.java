/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.Service.Impl;

import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity.Parent;
import com.codelabs.parent.DAO.ParentDAO;
import com.codelabs.parent.DTO.ParentDTO;
import com.codelabs.parent.Mapper.ParentMapper;
import com.codelabs.parent.Service.ParentService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kamal
 */
@Service(value = "ParentService")
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentDAO dao;

    @Override
    public List<ParentDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<ParentDTO> pDTOList = new ArrayList<>();
        for (Parent parent : dao.getAll(pw, offset, limit)) {
            pDTOList.add(new ParentMapper().toDTO(parent));
        }
        return pDTOList;
    }

    @Override
    public ParentDTO insert(ParentDTO pDTO) {
        Parent parent = new ParentMapper().toEntity(null, pDTO);
        parent.setPassword(pDTO.getUsername() + "123");
        Parent rp = dao.insert(parent);
        pDTO.setParentId(rp.getParentId());
        return pDTO;

    }

    @Override
    public void update(int id, ParentDTO pDTO) {
        Parent parent = dao.getById(id);
        parent.setModifiedDate(new Date());
        dao.update(new ParentMapper().toEntity(parent, pDTO));
    }

    @Override
    public ParentDTO getById(int id) {
        Parent parent = dao.getById(id);
        if (parent == null) {
            return null;
        }
        return new ParentMapper().toDTO(parent);
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Long count(ParamWrapper pw) {
        return dao.count(pw);
    }
}
