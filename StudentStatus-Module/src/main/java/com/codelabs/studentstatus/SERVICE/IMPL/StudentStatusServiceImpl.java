/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.studentstatus.SERVICE.IMPL;

import com.codelabs.entity.StudentStatus;
import com.codelabs.studentstatus.DAO.StudentStatusDAO;
import com.codelabs.studentstatus.DTO.StudentStatusDTO;
import com.codelabs.studentstatus.SERVICE.StudentStatusService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "StudentStatusService")
public class StudentStatusServiceImpl implements StudentStatusService{
@Autowired
private StudentStatusDAO studentStatusDAO;
    @Override
    public List<StudentStatusDTO> getAll() {
List<StudentStatusDTO> studentStatusDTO = new ArrayList<>();
         for(StudentStatus studentStatus :studentStatusDAO.getAll()){
        ModelMapper mapper = new ModelMapper();
             StudentStatusDTO statusDTO = mapper.map(studentStatus, StudentStatusDTO.class);
        studentStatusDTO.add(statusDTO);
   }  
          return studentStatusDTO;
    }

    @Override
    public StudentStatusDTO insert(StudentStatusDTO studentStatusDTO) {
 ModelMapper mapper = new ModelMapper();
        StudentStatus studentStatus = mapper.map(studentStatusDTO, StudentStatus.class);
        StudentStatus ss= studentStatusDAO.insert(studentStatus);
        studentStatusDTO.setStudentStatusId(ss.getStudentStatusId());
        return studentStatusDTO;
    }

    @Override
    public void update(int id, StudentStatusDTO t) {
      StudentStatus studentStatus = new ModelMapper().map(t, StudentStatus.class);
          studentStatusDAO.update(studentStatus);
    }

    @Override
    public boolean delete(int id) {
            return studentStatusDAO.delete(id);
    }

    @Override
    public StudentStatusDTO getById(int id) {
         StudentStatus ss = studentStatusDAO.getById(id);
        if (ss == null) {
            return null;
        }
        return new ModelMapper().map(ss, StudentStatusDTO.class);
    }

    }
    

