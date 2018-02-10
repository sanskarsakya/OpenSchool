/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.Mapper;

import com.codelabs.entity.Exam;
import com.codelabs.exam.DTO.ExamDTO;

/**
 *
 * @author puzansakya
 */
public class ExamMapper {

    public ExamDTO toDTO(Exam exam) {
        ExamDTO ed = new ExamDTO();
        ed.setExamId(exam.getExamId());
//       ret
        return ed;
    }
}
