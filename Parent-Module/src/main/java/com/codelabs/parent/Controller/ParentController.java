/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.Controller;

import com.codelabs.core.Wrapper.ResponseWrapper;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    ParentService service;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResponseWrapper<ParentDTO>> getAll(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit) {

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
        return new ResponseEntity<ResponseWrapper<ParentDTO>>(
                wrapper,
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ParentDTO> save(@RequestBody ParentDTO pd) {
        return new ResponseEntity<ParentDTO>(service.insert(pd), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody ParentDTO pd) {
        pd.setParentId(id);
        service.update(id, pd);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ParentDTO> getById(@PathVariable("id") int id) {
        ParentDTO parent = service.getById(id);
        if (parent == null) {
            return new ResponseEntity<ParentDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ParentDTO>(parent, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") int id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
