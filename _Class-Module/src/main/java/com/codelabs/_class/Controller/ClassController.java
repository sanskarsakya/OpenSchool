/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.Controller;

import com.codelabs._class.DTO.ClassDTO;
import com.codelabs._class.Service.ClassService;
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
 * @author Anuzaa_2
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/classes")
public class ClassController {

    /*
    parents->get->getAll
    parents->post->insert
    parents/->patch->update
    parents/{id}->delete->delete
    parents/{id}->get->getById
    
     */
    @Autowired
    ClassService cs;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ClassDTO> getAll() {
        return cs.getAll();

    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ClassDTO save(@RequestBody ClassDTO cDTO) {
        return cs.insert(cDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody ClassDTO cDTO) {
        cDTO.setClassId(id);
        cs.update(id, cDTO);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ClassDTO> getById(@PathVariable("id") int id) {
        ClassDTO cdto= cs.getById(id);
        System.out.println(id);
        if (cdto == null) {
            return new ResponseEntity<ClassDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ClassDTO>(cdto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        cs.delete(id);
        return "{response:\"success\"}";
    }

}
