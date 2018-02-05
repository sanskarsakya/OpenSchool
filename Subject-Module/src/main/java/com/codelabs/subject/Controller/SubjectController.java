/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Controller;

import com.codelabs.entity.Subject;
import com.codelabs.subject.DTO.SubjectDTO;
import com.codelabs.subject.Service.SubjectService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Anuzaa_2
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/subjects")

public class SubjectController {

    @Autowired
    SubjectService ss;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<SubjectDTO> getAll() {

        return ss.getAll();

    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public SubjectDTO save(SubjectDTO sd) {
        return ss.insert(sd);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, SubjectDTO sd) {
        ss.update(id, sd);
        return "success";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SubjectDTO getById(@PathVariable("id") int id) {
        return ss.getById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        ss.delete(id);
        return "{response:\"success\"}";
    }

}
