/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.studentstatus.Controller;

import com.codelabs.core.Wrapper.ResponseWrapper;
import com.codelabs.studentstatus.DTO.StudentStatusDTO;
import com.codelabs.studentstatus.Service.StudentStatusService;
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
 * @author sd14d
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/studentstatuses")
public class StudentStatusController {

    @Autowired
    StudentStatusService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseWrapper<StudentStatusDTO>> getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {

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
        return new ResponseEntity<ResponseWrapper<StudentStatusDTO>>(
                wrapper,
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public StudentStatusDTO save(@RequestBody StudentStatusDTO studentStatusDTO) {
        return service.insert(studentStatusDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody StudentStatusDTO studentStatusDTO) {
        studentStatusDTO.setStudentStatusId(id);

        service.update(id, studentStatusDTO);
        return "success";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<StudentStatusDTO> getById(@PathVariable("id") int id) {
        StudentStatusDTO studentStatusDTO = service.getById(id);
        if (studentStatusDTO == null) {
            return new ResponseEntity<StudentStatusDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<StudentStatusDTO>(studentStatusDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "{response:\"success\"}";
    }

}
