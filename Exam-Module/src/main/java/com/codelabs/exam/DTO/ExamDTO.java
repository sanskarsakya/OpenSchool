/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Prachin
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ExamDTO {

    private Integer examId;
    private Date examDate;
    private Double fullMark;
    private Double passMark;
    private Date createdDate;
    private Date modifiedDate;
    @JsonInclude(Include.NON_DEFAULT)
    private int classId;
    private String _class;
    @JsonInclude(Include.NON_DEFAULT)
    private int examTypeId;
    private String examType;
    @JsonInclude(Include.NON_DEFAULT)
    private int subjectId;
    private String subject;

}
