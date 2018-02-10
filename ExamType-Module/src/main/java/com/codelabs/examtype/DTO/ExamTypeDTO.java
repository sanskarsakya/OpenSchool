/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.examtype.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author puzansakya
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ExamTypeDTO {

    private Integer examTypeId;
    private String examType;
    private Date createdDate;
    private Date modifiedDate;
    private Boolean status;

}
