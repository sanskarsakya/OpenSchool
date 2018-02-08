/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.relation.SERVICE.IMPL;

import com.codelabs.entity.Relation;
import com.codelabs.relation.DAO.RelationDAO;
import com.codelabs.relation.DTO.RelationDTO;
import com.codelabs.relation.SERVICE.RelationService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "RelationService")

public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationDAO relationDAO;

    @Override
    public List<RelationDTO> getAll() {
        List<RelationDTO> relationDTO = new ArrayList<>();
        for (Relation relation : relationDAO.getAll()) {
            ModelMapper mapper = new ModelMapper();
            RelationDTO relDTO = mapper.map(relation, RelationDTO.class);
            relationDTO.add(relDTO);
        }
        return relationDTO;
    }

    @Override
    public RelationDTO insert(RelationDTO relationDTO) {
        ModelMapper mapper = new ModelMapper();
        Relation relation = mapper.map(relationDTO, Relation.class);
        Relation r = relationDAO.insert(relation);
        relationDTO.setRelationId(r.getRelationId());
        return relationDTO;
    }

    @Override
    public void update(int id, RelationDTO t) {
        Relation r = new ModelMapper().map(t, Relation.class);
        relationDAO.update(r);
    }

    @Override
    public boolean delete(int id) {
        return relationDAO.delete(id);

    }

    @Override
    public RelationDTO getById(int id) {
           Relation relation = relationDAO.getById(id);
        if (relation == null) {
            return null;
        }
        return new ModelMapper().map(relation, RelationDTO.class);
    }

    }


