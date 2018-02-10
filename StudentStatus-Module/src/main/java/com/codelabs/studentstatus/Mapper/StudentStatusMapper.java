/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.studentstatus.Mapper;

import com.codelabs.entity.StudentStatus;
import com.codelabs.studentstatus.DTO.StudentStatusDTO;

/**
 *
 * @author puzansakya
 */
public class StudentStatusMapper {

    public StudentStatusDTO toDTO(StudentStatus entity) {
        StudentStatusDTO dtoMapped = new StudentStatusDTO();
        dtoMapped.setStudentStatusId(entity.getStudentStatusId());
        dtoMapped.setStatus(entity.getStatus());
        return dtoMapped;
    }

    public StudentStatus toEntity(StudentStatus entity, StudentStatusDTO dto) {
        StudentStatus entityMapped = new StudentStatus();
        if (dto.getStudentStatusId() != null) {
            entityMapped.setStudentStatusId(dto.getStudentStatusId());
        }
        if (dto.getStatus() != null) {
            entityMapped.setStatus(dto.getStatus());
        }

        return entityMapped;
    }
}
