/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.examtype.Controller;

import com.codelabs.examtype.DTO.ExamTypeDTO;
import com.codelabs.examtype.Service.ExamTypeService;
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
 * @author puzansakya
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/examtypes")
public class ExamTypeController {

    @Autowired
    private ExamTypeService es;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ExamTypeDTO>> getAll() {
        return new ResponseEntity<List<ExamTypeDTO>>(
                es.getAll(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ExamTypeDTO> insert(@RequestBody ExamTypeDTO t) {
        return new ResponseEntity<ExamTypeDTO>(es.insert(t), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(
            @PathVariable("id") int id,
            @RequestBody ExamTypeDTO t) {
        t.setExamTypeId(id);
        es.update(id, t);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id) {
        es.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ExamTypeDTO> getById(@PathVariable("id") int id) {
        ExamTypeDTO et = es.getById(id);
        if (et == null) {
            return new ResponseEntity<ExamTypeDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ExamTypeDTO>(et, HttpStatus.OK);
    }
}
