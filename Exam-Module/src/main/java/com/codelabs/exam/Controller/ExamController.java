/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.Controller;

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
    private ExamService eService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ExamDTO> getAll() {
        return eService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ExamDTO save(@RequestBody ExamDTO e) {
        return eService.insert(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody ExamDTO e) {
        e.setExamId(id);
        eService.update(id, e);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        eService.delete(id);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ExamDTO> getById(@PathVariable("id") int id) {
        ExamDTO exam = eService.getById(id);
        if (exam == null) {
            return new ResponseEntity<ExamDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ExamDTO>(exam, HttpStatus.OK);
    }

}
