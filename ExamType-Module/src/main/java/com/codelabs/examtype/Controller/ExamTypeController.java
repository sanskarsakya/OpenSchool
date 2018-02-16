/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.examtype.Controller;

import com.codelabs.core.Wrapper.ResponseWrapper;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    private ExamTypeService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseWrapper<ExamTypeDTO>> getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {
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
        return new ResponseEntity<ResponseWrapper<ExamTypeDTO>>(
                wrapper,
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ExamTypeDTO> insert(@RequestBody ExamTypeDTO t) {
        return new ResponseEntity<ExamTypeDTO>(service.insert(t), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(
            @PathVariable("id") int id,
            @RequestBody ExamTypeDTO t) {
        t.setExamTypeId(id);
        service.update(id, t);
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
    public ResponseEntity<ExamTypeDTO> getById(@PathVariable("id") int id) {
        ExamTypeDTO et = service.getById(id);
        if (et == null) {
            return new ResponseEntity<ExamTypeDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ExamTypeDTO>(et, HttpStatus.OK);
    }
}
