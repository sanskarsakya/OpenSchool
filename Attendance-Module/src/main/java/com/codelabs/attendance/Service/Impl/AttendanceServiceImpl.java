/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.attendance.Service.Impl;

import com.codelabs.attendance.DAO.AttendanceDAO;
import com.codelabs.attendance.DTO.AttendanceDTO;
import com.codelabs.attendance.Service.AttendanceService;
import com.codelabs.entity.Attendance;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prachin
 */
@Service(value = "AttendanceService")
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceDAO aDAO;

    @Override
    public List<AttendanceDTO> getAll() {
        List<AttendanceDTO> aDTOList = new ArrayList<>();
        for (Attendance a : aDAO.getAll()) {
            ModelMapper mapper = new ModelMapper();
            AttendanceDTO adto = mapper.map(a, AttendanceDTO.class);
            aDTOList.add(adto);
        }
        return aDTOList;
    }

    @Override
    public AttendanceDTO insert(AttendanceDTO a) {
        ModelMapper mapper = new ModelMapper();
        Attendance attendance = mapper.map(a, Attendance.class);
        Attendance rt = aDAO.insert(attendance);
        a.setAttendanceId(rt.getAttendanceId());
        return a;
    }

    @Override
    public void update(int id, AttendanceDTO t) {
        Attendance attendance = new ModelMapper().map(t, Attendance.class);
        aDAO.update(attendance);
    }

    @Override
    public boolean delete(int id) {
        return aDAO.delete(id);
    }

    @Override
    public AttendanceDTO getById(int id) {
        Attendance a = aDAO.getById(id);
        if (a == null) {
            return null;
        }
        return new ModelMapper().map(a, AttendanceDTO.class);
    }

}
