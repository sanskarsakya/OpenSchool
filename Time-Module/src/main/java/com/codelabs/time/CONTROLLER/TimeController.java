/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.time.CONTROLLER;

import com.codelabs.time.DTO.TimeDTO;
import com.codelabs.time.SERVICE.TimeService;
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
 * @author sd14d
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/time")
public class TimeController {

    @Autowired

    TimeService timeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<TimeDTO> getAll() {
        //return timeService.getAll();
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TimeDTO save(@RequestBody TimeDTO timeDTO) {
        return timeService.insert(timeDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody TimeDTO timeDTO) {
        timeDTO.setTimeId(id);
        timeService.update(id, timeDTO);
        return "success";

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<TimeDTO> getById(@PathVariable("id") int id) {
        TimeDTO timeDTO = timeService.getById(id);
        if (timeDTO == null) {
            return new ResponseEntity<TimeDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TimeDTO>(timeDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        timeService.delete(id);
        return "{response:\"success\"}";
    }

}
