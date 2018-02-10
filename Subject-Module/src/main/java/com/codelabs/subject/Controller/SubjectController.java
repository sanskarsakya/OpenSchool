/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Controller;

import com.codelabs.subject.DTO.SubjectDTO;
import com.codelabs.subject.Service.SubjectService;
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
@RequestMapping(value = "/subjects")
public class SubjectController {
   @Autowired
    private SubjectService service;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<SubjectDTO>> getAll() {        
          return new ResponseEntity<List<SubjectDTO>>(
                service.getAll(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public  ResponseEntity<SubjectDTO>insert(@RequestBody SubjectDTO dto) {
        return new ResponseEntity<SubjectDTO>(service.insert(dto), HttpStatus.CREATED);      
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody SubjectDTO dto) {        
        service.update(id, dto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<SubjectDTO> getById(@PathVariable("id") int id) {
        SubjectDTO dto = service.getById(id);
        if (dto == null) {
            return new ResponseEntity<SubjectDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SubjectDTO>(dto, HttpStatus.OK);
    }
 
}
