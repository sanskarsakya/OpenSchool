/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Anuzaa_2
 */
@Data
@JsonInclude(Include.NON_NULL)
public class SubjectDTO {

    private Integer subjectId;
    private String subjectName;
    private Date createdDate;
    private Date modifiedDate;
    private Boolean status;
    @JsonInclude(Include.NON_DEFAULT)
    private int teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    @JsonInclude(Include.NON_DEFAULT)
    private int classId;
    private String className;
}
