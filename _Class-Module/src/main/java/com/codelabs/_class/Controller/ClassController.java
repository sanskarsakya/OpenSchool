/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.Controller;

import com.codelabs._class.DTO._ClassDTO;
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
 * @author koirala
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/classes")
public class ClassController {

    @Autowired
    private ClassService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<_ClassDTO>> getAll() {
        return new ResponseEntity<List<_ClassDTO>>(
                service.getAll(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<_ClassDTO> insert(@RequestBody _ClassDTO dto) {
        return new ResponseEntity<_ClassDTO>(service.insert(dto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody _ClassDTO dto) {        
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
    public ResponseEntity<_ClassDTO> getById(@PathVariable("id") int id) {
        _ClassDTO dto = service.getById(id);
        if (dto == null) {
            return new ResponseEntity<_ClassDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<_ClassDTO>(dto, HttpStatus.OK);
    }
}
