/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.Controller;

import com.codelabs.core.Wrapper.ResponseWrapper;
import com.codelabs.student.DTO.StudentDTO;
import com.codelabs.student.Service.StudentService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author koirala
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseWrapper<StudentDTO>> getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {

        if (page == null || page == 0 || page < 1) {
            page = 1;
        }
        if (limit == null || limit == 0 || limit > 25) {
            limit = 25;
        }
        int offset = (page - 1) * limit;
        ResponseWrapper wrapper = new ResponseWrapper();
        wrapper.setData(service.getAll(null, offset, limit));
        wrapper.setPageSize(limit);
        wrapper.setPageNo(page);
        wrapper.setTotalItems(service.count(null));
        return new ResponseEntity<ResponseWrapper<StudentDTO>>(
                wrapper,
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO dto) {
        return new ResponseEntity<StudentDTO>(service.insert(dto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody StudentDTO dto) {
        service.update(id, dto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<StudentDTO> getById(@PathVariable("id") int id) {
        StudentDTO teacher = service.getById(id);
        if (teacher == null) {
            return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StudentDTO>(teacher, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
