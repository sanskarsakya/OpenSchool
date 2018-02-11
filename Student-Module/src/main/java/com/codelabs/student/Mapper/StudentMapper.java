/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.Mapper;

import com.codelabs.entity.Gender;
import com.codelabs.entity.Parent;
import com.codelabs.entity.Student;
import com.codelabs.entity.StudentStatus;
import com.codelabs.entity._Class;
import com.codelabs.student.DTO.StudentDTO;

/**
 *
 * @author puzansakya
 */
public class StudentMapper {

    public StudentDTO toDTO(Student entity) {
        StudentDTO dtoMapped = new StudentDTO();
        dtoMapped.setStudentId(entity.getStudentId());
        dtoMapped.setFirstName(entity.getFirstName());
        dtoMapped.setLastName(entity.getLastName());
        dtoMapped.setEmail(entity.getEmail());
        dtoMapped.setContactNo(entity.getContactNo());
        dtoMapped.setUsername(entity.getUsername());
        dtoMapped.setStreet(entity.getStreet());
        dtoMapped.setCity(entity.getCity());
        dtoMapped.setCreatedDate(entity.getCreatedDate());
        dtoMapped.set_class(entity.getClassId().getClassName());
        dtoMapped.setStatus(entity.getStatusId().getStatus());
        dtoMapped.setGender(entity.getGenderId().getGender());
        dtoMapped.setCity(entity.getCity());

        //parent related
        dtoMapped.setParentFirstName(entity.getParentId().getFirstName());
        dtoMapped.setParentLastName(entity.getParentId().getLastName());
        dtoMapped.setParentGender(entity.getParentId().getGenderId().getGender());
        dtoMapped.setParentStreet(entity.getParentId().getStreet());
        dtoMapped.setParentCity(entity.getParentId().getCity());
        dtoMapped.setParentContactNo(entity.getParentId().getContactNo());
        dtoMapped.setParentSocialLink(entity.getParentId().getSocialLink());

        return dtoMapped;
    }

    public Student toEntity(Student entity, StudentDTO dto) {
        Student entityMapped = new Student();
        if (entity != null) {
            entityMapped = entity;
        }
        if (dto.getStudentId() != null) {
            entityMapped.setStudentId(dto.getStudentId());
        }
        if (dto.getFirstName() != null) {
            entityMapped.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            entityMapped.setLastName(dto.getLastName());
        }
        if (dto.getEmail() != null) {
            entityMapped.setEmail(dto.getEmail());
        }
        if (dto.getContactNo() != null) {
            entityMapped.setContactNo(dto.getContactNo());
        }
        if (dto.getUsername() != null) {
            entityMapped.setUsername(dto.getUsername());
        }
        if (dto.getStreet() != null) {
            entityMapped.setStreet(dto.getStreet());
        }
        if (dto.getCity() != null) {
            entityMapped.setCity(dto.getCity());
        }
        if (dto.getClassId() != 0) {
            entityMapped.setClassId(new _Class(dto.getClassId()));
        }
        if (dto.getGenderId() != 0) {
            entityMapped.setGenderId(new Gender(dto.getGenderId()));
        }
        if (dto.getParentId() != 0) {
            entityMapped.setParentId(new Parent(dto.getParentId()));
        }
        if (dto.getStatusId() != 0) {
            entityMapped.setStatusId(new StudentStatus(dto.getStatusId()));
        }

        return entityMapped;
    }
}
