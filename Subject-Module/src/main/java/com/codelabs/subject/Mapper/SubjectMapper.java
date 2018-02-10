/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Mapper;

import com.codelabs.entity.Subject;
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

        return entityMapped;

    }
}
