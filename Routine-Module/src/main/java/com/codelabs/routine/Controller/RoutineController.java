/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.routine.Controller;

import com.codelabs.entity.Routine;
import com.codelabs.entity.Subject;
import com.codelabs.entity.Teacher;
import com.codelabs.entity._Class;
import com.codelabs.routine.DTO.RoutineDTO;
import com.codelabs.routine.Service.RoutineService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author koirala
 */
@Controller
@CrossOrigin
@Repository(value = "/routine")
public class RoutineController {

    @Autowired
    private RoutineService rs;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Hello from Routine";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<RoutineDTO> getAll() {
        List<RoutineDTO> rDtoList = new ArrayList<>();
        for (Routine routine : rs.getAll()) {
            RoutineDTO rtnDTO = new RoutineDTO();
            rtnDTO.setRoutineId(routine.getRoutineId());

            //From Class
            _Class cls = new _Class();
            cls.setClassId(routine.getClassId().getClassId());
            cls.setClassName(routine.getClassId().getClassName());
            rtnDTO.setClassId(cls);
            //From Subject
            Subject sub = new Subject();
            sub.setSubjectId(routine.getSubjectId().getSubjectId());
            sub.setSubject(routine.getSubjectId().getSubject());

            rtnDTO.setSubjectId(sub);
            //From Teacher
            Teacher teacher = new Teacher();
            teacher.setTeacherId(routine.getTeacherId().getTeacherId());
            teacher.setFirstName(routine.getTeacherId().getFirstName());
            teacher.setLastName(routine.getTeacherId().getLastName());
            rtnDTO.setTeacherId(teacher);

            //From Time
            rDtoList.add(rtnDTO);
        }
        return rDtoList;
    }

}
