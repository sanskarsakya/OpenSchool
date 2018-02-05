/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.Controller;

import com.codelabs._class.DTO.ClassDTO;
import com.codelabs._class.Service.ClassService;
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
@RequestMapping(value = "/classes")
public class ClassController {

    @Autowired
    ClassService cs;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ClassDTO> getAll() {
        return cs.getAll();

    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ClassDTO save(ClassDTO cDTO) {
        return cs.insert(cDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, ClassDTO cDTO) {
        cs.update(id, cDTO);
        return "success";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ClassDTO getById(@PathVariable("id") int id) {
        return cs.getById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        cs.delete(id);
        return "{response:\"success\"}";
    }

}
