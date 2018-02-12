/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.Mapper;

import com.codelabs.entity.Exam;
import com.codelabs.entity.ExamType;
import com.codelabs.entity.Subject;
import com.codelabs.entity._Class;
import com.codelabs.exam.DTO.ExamDTO;

/**
 *
 * @author puzansakya
 */
public class ExamMapper {

    public ExamDTO toDTO(Exam entity) {
        ExamDTO dtoMapped = new ExamDTO();

        dtoMapped.setExamId(entity.getExamId());
        dtoMapped.setExamDate(entity.getExamDate());
        dtoMapped.setFullMark(entity.getFullMark());
        dtoMapped.setPassMark(entity.getPassMark());
        dtoMapped.setCreatedDate(entity.getCreatedDate());
        dtoMapped.setModifiedDate(entity.getModifiedDate());
        dtoMapped.set_class(entity.getClassId().getClassName());
        dtoMapped.setExamType(entity.getExamTypeId().getExamType());
        dtoMapped.setSubject(entity.getSubjectId().getSubjectName());

        return dtoMapped;
    }

    public Exam toEntity(Exam entity, ExamDTO dto) {
        Exam entityMapped = new Exam();
        if (entity != null) {
            entityMapped = entity;
        }
        if (dto.getExamId() != null) {
            entityMapped.setExamId(dto.getExamId());
        }
        if (dto.getExamDate() != null) {
            entityMapped.setExamDate(dto.getExamDate());
        }
        if (dto.getFullMark() != null) {
            entityMapped.setFullMark(dto.getFullMark());
        }
        if (dto.getPassMark() != null) {
            entityMapped.setPassMark(dto.getPassMark());
        }
        if (dto.getClassId() != 0) {
            entityMapped.setClassId(new _Class(dto.getClassId()));
        }
        if (dto.getExamTypeId() != 0) {
            entityMapped.setExamTypeId(new ExamType(dto.getExamTypeId()));
        }
        if (dto.getSubjectId() != 0) {
            entityMapped.setSubjectId(new Subject(dto.getSubjectId()));
        }

        return entityMapped;
    }
}
