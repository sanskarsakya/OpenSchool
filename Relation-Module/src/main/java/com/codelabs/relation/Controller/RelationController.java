/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.relation.Controller;

import com.codelabs.relation.DTO.RelationDTO;
import com.codelabs.relation.SERVICE.RelationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sd14d
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/relation")
public class RelationController {

    @Autowired
    RelationService relationService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RelationDTO> getAll() {
        return relationService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RelationDTO save(@RequestBody RelationDTO relationDTO) {
        return relationService.insert(relationDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody RelationDTO relationDTO) {
        relationDTO.setRelationId(id);

        relationService.update(id, relationDTO);
        return "success";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RelationDTO> getById(@PathVariable("id") int id) {
        RelationDTO relationDTO = relationService.getById(id);
        if (relationDTO == null) {
            return new ResponseEntity<RelationDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RelationDTO>(relationDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        relationService.delete(id);
        return "{response:\"success\"}";
    }

}
