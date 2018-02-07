/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.attendance.Controller;

import com.codelabs.attendance.DTO.AttendanceDTO;
import com.codelabs.attendance.Service.AttendanceService;
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
@RequestMapping(value = "/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService aService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<AttendanceDTO> getAll() {
        return aService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public AttendanceDTO save(@RequestBody AttendanceDTO a) {
        return aService.insert(a);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@PathVariable("id") int id, @RequestBody AttendanceDTO a) {
        a.setAttendanceId(id);
        aService.update(id, a);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        aService.delete(id);
        return "{\"response\":\"success\"}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<AttendanceDTO> getById(@PathVariable("id") int id) {
        AttendanceDTO attendance = aService.getById(id);
        if (attendance == null) {
            return new ResponseEntity<AttendanceDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AttendanceDTO>(attendance, HttpStatus.OK);
    }

}
