/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.Controller;

import com.codelabs.teacher.DTO.TeacherDTO;
import com.codelabs.teacher.Service.TeacherService;
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
@RequestMapping(value = "/teachers")
public class TeacherController {

    @Autowired
    private TeacherService tService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<TeacherDTO>> getAll() {
        return new ResponseEntity<List<TeacherDTO>>(
                tService.getAll(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TeacherDTO> insert(@RequestBody TeacherDTO t) {
        return new ResponseEntity<TeacherDTO>(tService.insert(t), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(
            @PathVariable("id") int id,
            @RequestBody TeacherDTO t) {
        t.setTeacherId(id);
        tService.update(id, t);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id) {
        tService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<TeacherDTO> getById(@PathVariable("id") int id) {
        TeacherDTO teacher = tService.getById(id);
        if (teacher == null) {
            return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TeacherDTO>(teacher, HttpStatus.OK);
    }

}
