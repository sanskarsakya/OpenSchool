/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.Controller;

import com.codelabs.parent.DTO.ParentDTO;
import com.codelabs.parent.Service.ParentService;
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
 * @author kamal
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/parents")
public class ParentController {

    /*
    parents->get->getAll
    parents->post->insert
    parents/->patch->update
    parents/{id}->delete->delete
    parents/{id}->get->getById
    
     */
    @Autowired
    ParentService ps;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ParentDTO> getAll() {
        return ps.getAll();

    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ParentDTO save(@RequestBody ParentDTO pd) {
        return ps.insert(pd);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id,@RequestBody ParentDTO pd) {
        pd.setParentId(id);
        ps.update(id, pd);
        return "success";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ParentDTO> getById(@PathVariable("id") int id) {
        ParentDTO parent = ps.getById(id);
        if (parent == null) {
            return new ResponseEntity<ParentDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ParentDTO>(parent, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        ps.delete(id);
        return "{response:\"success\"}";
    }

}
