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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuzaa_2
 */
@Service(value = "ParentService")
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentDAO pd;

    @Override
    public List<ParentDTO> getAll() {
        List<ParentDTO> parentlist = new ArrayList<>();
        for (Parent parent : pd.getAll()) {
            ParentDTO pDTO = new ParentDTO();
            pDTO.setParentId(parent.getParentId());
            pDTO.setFatherName(parent.getFatherName());
            pDTO.setFatherContactNo(parent.getFatherContactNo());
            pDTO.setMotherName(parent.getMotherName());
            pDTO.setMotherContactNo(parent.getMotherContactNo());
            pDTO.setGuardianName(parent.getGuardianName());
            pDTO.setGuardianContactNo(parent.getGuardianContactNo());
            pDTO.setAddress(parent.getAddress());

            parentlist.add(pDTO);

        }
        return parentlist;
    }

    @Override
    public ParentDTO insert(ParentDTO pDTO) {
        Parent parent = new Parent();
        parent.setParentId(pDTO.getParentId());
        parent.setFatherName(pDTO.getFatherName());
        parent.setFatherContactNo(pDTO.getFatherContactNo());
        parent.setMotherName(pDTO.getMotherName());
        parent.setMotherContactNo(pDTO.getMotherContactNo());
        parent.setGuardianName(pDTO.getGuardianName());
        parent.setGuardianContactNo(pDTO.getMotherContactNo());
        parent.setAddress(pDTO.getAddress());
        Parent retParent = pd.insert(parent);
        pDTO.setParentId(retParent.getParentId());
        return pDTO;

    }

    @Override
    public void update(int id, ParentDTO pDTO) {
        Parent parent = new Parent();
        parent.setParentId(id);
        parent.setFatherName(pDTO.getFatherName());
        parent.setFatherContactNo(pDTO.getFatherContactNo());
        parent.setMotherName(pDTO.getMotherName());
        parent.setMotherContactNo(pDTO.getMotherContactNo());
        parent.setGuardianName(pDTO.getGuardianName());
        parent.setGuardianContactNo(pDTO.getMotherContactNo());
        parent.setAddress(pDTO.getAddress());
        pd.update(parent);
    }

    @Override
    public ParentDTO getById(int id) {
        Parent parent = new Parent();
        ParentDTO pDTO = new ParentDTO();
        pDTO.setParentId(parent.getParentId());
        pDTO.setFatherName(parent.getFatherName());
        pDTO.setFatherContactNo(parent.getFatherContactNo());
        pDTO.setMotherName(parent.getMotherName());
        pDTO.setMotherContactNo(parent.getMotherContactNo());
        pDTO.setGuardianName(parent.getGuardianName());
        pDTO.setGuardianContactNo(parent.getGuardianContactNo());
        pDTO.setAddress(parent.getAddress());
        return pDTO;
    }

    @Override
    public boolean delete(int id) {
        return pd.delete(id);
    }

}
