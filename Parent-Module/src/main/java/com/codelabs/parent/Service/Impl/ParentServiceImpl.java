/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.Service.Impl;

import com.codelabs.entity.Parent;
import com.codelabs.parent.DAO.ParentDAO;
import com.codelabs.parent.DTO.ParentDTO;
import com.codelabs.parent.Service.ParentService;
import java.util.ArrayList;
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
    private ParentDAO pd;

    @Override
    public List<ParentDTO> getAll() {
        List<ParentDTO> parentlist = new ArrayList<>();
        for (Parent parent : pd.getAll()) {
            ModelMapper mapper = new ModelMapper();
            ParentDTO pDTO = mapper.map(parent, ParentDTO.class);
            parentlist.add(pDTO);

        }
        return parentlist;
    }

    @Override
    public ParentDTO insert(ParentDTO pDTO) {
        ModelMapper mapper = new ModelMapper();
        Parent parent = mapper.map(pDTO, Parent.class);
        parent.setPassword(pDTO.getUsername() + "sample");
        Parent rt = pd.insert(parent);
        pDTO.setParentId(rt.getParentId());
        return pDTO;

    }

    @Override
    public void update(int id, ParentDTO pDTO) {
//        Parent parent = new Parent();
//        parent.setParentId(id);
//        parent.setFirstName(pDTO.getFirstName());
//        parent.setLastName(pDTO.getLastName());
//        parent.setCity(pDTO.getCity());
//        parent.setStreet(pDTO.getStreet());
//        parent.setContactNo(pDTO.getContactNo());
//        parent.setCreatedDate(pDTO.getCreatedDate());
//        parent.setStatus(pDTO.getStatus());
//        pd.update(parent);

        Parent parent = new ModelMapper().map(pDTO, Parent.class);
        parent.setPassword(pDTO.getUsername() + "sample");
        pd.update(parent);
    }

    @Override
    public ParentDTO getById(int id) {
//        Parent parent = new Parent();
//        ParentDTO pDTO = new ParentDTO();
//        pDTO.setParentId(parent.getParentId());
//        pDTO.setFirstName(parent.getFirstName());
//        pDTO.setLastName(parent.getLastName());
//        pDTO.setCity(parent.getCity());
//        pDTO.setStreet(parent.getStreet());
//        pDTO.setContactNo(parent.getContactNo());
//        pDTO.setCreatedDate(parent.getCreatedDate());
//        pDTO.setStatus(parent.getStatus());
//        return pDTO;

        Parent p = pd.getById(id);
        if (p == null) {
            return null;
        }
        return new ModelMapper().map(p, ParentDTO.class);
    }

@Override
        public boolean delete(int id) {
        return pd.delete(id);
    }

}
