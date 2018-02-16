/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Mapper;

import com.codelabs.entity.Subject;
import com.codelabs.entity.Teacher;
import com.codelabs.entity._Class;
import com.codelabs.subject.DTO.SubjectDTO;

/**
 *
 * @author Anuzaa_2
 */
public class SubjectMapper {

    public SubjectDTO toDTO(Subject entity) {
        SubjectDTO dtoMapped = new SubjectDTO();
        dtoMapped.setSubjectId(entity.getSubjectId());
        dtoMapped.setSubjectName(entity.getSubjectName());
        dtoMapped.setCreatedDate(entity.getCreatedDate());
        dtoMapped.setModifiedDate(entity.getModifiedDate());
        dtoMapped.setStatus(entity.getStatus());
        dtoMapped.setTeacherId(entity.getTeacherId().getTeacherId());
        dtoMapped.setTeacherFirstName(entity.getTeacherId().getFirstName());
        dtoMapped.setTeacherLastName(entity.getTeacherId().getLastName());
        dtoMapped.setClassId(entity.getClassId().getClassId());
        dtoMapped.setClassName(entity.getClassId().getClassName());

        return dtoMapped;

    }

    public Subject toEntity(Subject entity, SubjectDTO dto) {
        Subject entityMapped = new Subject();
        if (entity != null) {
            entityMapped = entity;
        }
        if (dto.getSubjectId() != null) {
            entityMapped.setSubjectId(dto.getSubjectId());
        }
        if (dto.getSubjectName() != null) {
            entityMapped.setSubjectName(dto.getSubjectName());
        }
        if (dto.getCreatedDate() != null) {
            entityMapped.setCreatedDate(dto.getCreatedDate());
        }
        if (dto.getStatus() != null) {
            entityMapped.setStatus(dto.getStatus());
        }
        if (dto.getTeacherId() != 0) {
            entityMapped.setTeacherId(new Teacher(dto.getTeacherId()));
        }
        if (dto.getTeacherId() != 0) {
            entityMapped.setTeacherId(new Teacher(dto.getTeacherId()));
        }
        if (dto.getClassId() != 0) {
            entityMapped.setClassId(new _Class(dto.getClassId()));
        }

        return entityMapped;

    }
}
