/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.Controller;

import com.codelabs.core.Wrapper.ResponseWrapper;
import com.codelabs.exam.DTO.ExamDTO;
import com.codelabs.exam.Service.ExamService;
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
 * @author Prachin
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/exams")
public class ExamController {

    @Autowired
    private ExamService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseWrapper<ExamDTO>> getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
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
        return new ResponseEntity<ResponseWrapper<ExamDTO>>(
                wrapper,
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ExamDTO> save(@RequestBody ExamDTO dto) {
        return new ResponseEntity<ExamDTO>(service.insert(dto), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody ExamDTO dto) {
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
    public ResponseEntity<ExamDTO> getById(@PathVariable("id") int id) {
        ExamDTO entity = service.getById(id);
        if (entity == null) {
            return new ResponseEntity<ExamDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ExamDTO>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "/{examId}/class/{classId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ExamDTO>> getByClassAndExamType(@PathVariable("examId") int examId, @PathVariable("classId") int classId) {
        return new ResponseEntity<List<ExamDTO>>(
                service.getByClassAndExamType(examId, classId),
                HttpStatus.OK);
    }

}
