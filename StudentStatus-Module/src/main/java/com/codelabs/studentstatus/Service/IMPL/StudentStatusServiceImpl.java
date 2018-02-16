/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.studentstatus.Service.Impl;

import com.codelabs.core.Wrapper.ParamWrapper;
import com.codelabs.entity.StudentStatus;
import com.codelabs.studentstatus.DAO.StudentStatusDAO;
import com.codelabs.studentstatus.DTO.StudentStatusDTO;
import com.codelabs.studentstatus.Mapper.StudentStatusMapper;
import com.codelabs.studentstatus.Service.StudentStatusService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "StudentStatusService")
public class StudentStatusServiceImpl implements StudentStatusService {

    @Autowired
    private StudentStatusDAO dao;

    private StudentStatusMapper mapper;

    public StudentStatusServiceImpl() {
        mapper = new StudentStatusMapper();
    }

    @Override
    public List<StudentStatusDTO> getAll(ParamWrapper pw, int offset, int limit) {
        List<StudentStatusDTO> dtoList = new ArrayList<>();
        for (StudentStatus entity : dao.getAll(pw, offset, limit)) {
            dtoList.add(mapper.toDTO(entity));
        }
        return dtoList;
    }

    @Override
    public StudentStatusDTO insert(StudentStatusDTO dto) {
        dto.setStudentStatusId(dao.insert(mapper.toEntity(null, dto)).getStudentStatusId());
        return dto;
    }

    @Override
    public void update(int id, StudentStatusDTO dto) {
        StudentStatus entity = dao.getById(id);
        dao.update(mapper.toEntity(entity, dto));
    }

    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public StudentStatusDTO getById(int id) {
        StudentStatus entity = dao.getById(id);
        if (entity == null) {
            return null;
        }
        return mapper.toDTO(entity);
    }

    @Override
    public Long count(ParamWrapper pw) {
        return dao.count(pw);
    }

}
