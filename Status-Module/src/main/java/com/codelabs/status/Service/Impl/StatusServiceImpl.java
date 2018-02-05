/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.status.Service.Impl;

import com.codelabs.entity.Status;
import com.codelabs.status.DAO.StatusDAO;
import com.codelabs.status.DTO.StatusDTO;
import com.codelabs.status.Service.StatusService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author puzansakya
 */
@Service(value = "StatusService")
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusDAO sd;

    @Override
    public List<StatusDTO> getAll() {
        List<StatusDTO> sDTOList = new ArrayList<>();
        for (Status status : sd.getAll()) {
            StatusDTO sd = new StatusDTO();
            sd.setStatusId(status.getStatusId());
            sd.setStatus(status.getStatus());

            sDTOList.add(sd);
        }
        return sDTOList;
    }

    @Override
    public StatusDTO insert(StatusDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int id,StatusDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatusDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
