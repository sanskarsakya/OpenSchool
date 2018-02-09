/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Controller;

import com.codelabs.subject.DTO.SubjectDTO;
import com.codelabs.subject.Service.SubjectService;
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
 * @author Anuzaa_2
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/subjects")
public class SubjectController {
   @Autowired
    private SubjectService ss;
    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<SubjectDTO> getAll() {
        return ss.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public SubjectDTO save(@RequestBody SubjectDTO sDTO) {
        return ss.insert(sDTO);        
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody SubjectDTO sDTO) {
        sDTO.setSubjectId(id);
        ss.update(id, sDTO);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        ss.delete(id);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<SubjectDTO> getById(@PathVariable("id") int id) {
        SubjectDTO s = ss.getById(id);
        if (s == null) {
            return new ResponseEntity<SubjectDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SubjectDTO>(s, HttpStatus.OK);
    }
 
}
