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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AttendanceDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
