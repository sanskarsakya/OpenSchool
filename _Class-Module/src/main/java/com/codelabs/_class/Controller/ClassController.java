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
    private ClassService cService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<_ClassDTO> getAll() {
        return cService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public _ClassDTO insert(@RequestBody _ClassDTO cDTO) {
        return cService.insert(cDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody _ClassDTO cDTO) {
        cDTO.setClassId(id);
        cService.update(id, cDTO);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        cService.delete(id);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<_ClassDTO> getById(@PathVariable("id") int id) {
        _ClassDTO cDTO = cService.getById(id);
        if (cDTO == null) {
            return new ResponseEntity<_ClassDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<_ClassDTO>(cDTO, HttpStatus.OK);
    }
}
