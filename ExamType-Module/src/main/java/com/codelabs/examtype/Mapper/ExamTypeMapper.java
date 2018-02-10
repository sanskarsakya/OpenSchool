/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.examtype.Mapper;

import com.codelabs.entity.ExamType;
import com.codelabs.examtype.DTO.ExamTypeDTO;

/**
 *
 * @author puzansakya
 */
public class ExamTypeMapper {

    public ExamTypeDTO toDTO(ExamType et) {
        ExamTypeDTO ed = new ExamTypeDTO();
        ed.setExamTypeId(et.getExamTypeId());
        ed.setExamType(et.getExamType());
        ed.setCreatedDate(et.getCreatedDate());
        ed.setModifiedDate(et.getModifiedDate());
        ed.setStatus(et.getStatus());

        return ed;
    }

    public ExamType toEntity(ExamType examtype, ExamTypeDTO eDTO) {
        ExamType etMapped = new ExamType();
        if (examtype != null) {
            etMapped = examtype;
        }
        if (eDTO.getExamTypeId() != null) {
            etMapped.setExamTypeId(eDTO.getExamTypeId());
        }
        if (eDTO.getExamType() != null) {
            etMapped.setExamType(eDTO.getExamType());
        }
        if (eDTO.getStatus() != null) {
            etMapped.setStatus(eDTO.getStatus());
        }
        return etMapped;
    }

}
