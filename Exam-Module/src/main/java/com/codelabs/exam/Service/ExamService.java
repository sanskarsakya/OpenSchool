/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.Service;

import com.codelabs.core.Service.GenericService;
import com.codelabs.exam.DTO.ExamDTO;
import java.util.List;

/**
 *
 * @author nishesh
 */
public interface ExamService extends GenericService<ExamDTO> {

    List<ExamDTO> getByClassAndExamType(int examTypeId, int classId);
}
