/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.time.SERVICE.IMPL;

import com.codelabs.entity.StudentStatus;
//import com.codelabs.entity.Time;
import com.codelabs.time.DAO.TimeDAO;
import com.codelabs.time.DTO.TimeDTO;
import com.codelabs.time.SERVICE.TimeService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "TimeService")
public class TimeServiceImpl implements TimeService {

    @Autowired
    TimeDAO timeDAO;

    @Override
    public List<TimeDTO> getAll() {
//        List<TimeDTO> timeDTO = new ArrayList<>();
//        for (Time time : timeDAO.getAll()) {
//            ModelMapper mapper = new ModelMapper();
//            TimeDTO tDTO = mapper.map(time, TimeDTO.class);
//            timeDTO.add(tDTO);
//        }
        return null;
    }

    @Override
    public TimeDTO insert(TimeDTO timeDTO) {
//        ModelMapper mapper = new ModelMapper();
//        Time time = mapper.map(timeDTO, Time.class);
//        Time t = timeDAO.insert(time);
//        timeDTO.setTimeId(t.getTimeId());
        return null;
    }

    @Override
    public void update(int id, TimeDTO t) {
//        Time time = new ModelMapper().map(t, Time.class);
//        timeDAO.update(time);
    }

    @Override
    public boolean delete(int id) {
//        return timeDAO.delete(id);
        return false;
    }

    @Override
    public TimeDTO getById(int id) {
//        Time t = timeDAO.getById(id);
//        if (t == null) {
//            return null;
//        }
//        return new ModelMapper().map(t, TimeDTO.class);
        return null;
    }

}
