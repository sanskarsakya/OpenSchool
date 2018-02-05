/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.status.Controller;

import com.codelabs.status.DTO.StatusDTO;
import com.codelabs.status.Service.StatusService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author puzansakya
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/statuses")
public class StatusController {

    @Autowired
    private StatusService ss;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<StatusDTO> getAll() {
        return ss.getAll();
    }
}
