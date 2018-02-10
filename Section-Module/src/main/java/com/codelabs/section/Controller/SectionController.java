/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.section.Controller;

import com.codelabs.section.DTO.SectionDTO;
import com.codelabs.section.Service.SectionService;
import java.util.List;
import org.apache.log4j.Logger;
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
 * @author puzansakya
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/sections")
public class SectionController {

    static final Logger logger = Logger.getLogger(SectionController.class);
    @Autowired
    private SectionService ss;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<SectionDTO>> getAll() {
        return new ResponseEntity<>(ss.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SectionDTO> insert(@RequestBody SectionDTO t) {
        return new ResponseEntity<SectionDTO>(ss.insert(t), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody SectionDTO t) {
        t.setSectionId(id);
        ss.update(id, t);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id) {
        ss.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<SectionDTO> getById(@PathVariable("id") int id) {
        SectionDTO teacher = ss.getById(id);
        if (teacher == null) {
            return new ResponseEntity<SectionDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SectionDTO>(teacher, HttpStatus.OK);
    }

}
