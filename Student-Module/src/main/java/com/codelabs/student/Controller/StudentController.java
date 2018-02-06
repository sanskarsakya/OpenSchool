/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.Controller;

import com.codelabs.student.DTO.StudentDTO;
import com.codelabs.student.Service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService ss;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<StudentDTO> getAll() {
        return ss.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public StudentDTO save(@RequestBody StudentDTO stdDTO) {
        return ss.insert(stdDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody StudentDTO stdDTO) {
        ss.update(id, stdDTO);
        return "Success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentDTO getById(@PathVariable("id") int id) {
        return ss.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        ss.delete(id);
        return "{response:\"success\"}";
    }

    
}
