/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.exam.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Prachin
 */
@Data
public class ExamDTO {
    private Integer examId;
    private String examTitle;
    private Date examDate;
    private Date createdDate;
    private Boolean status;
   
}
