/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Anuzaa_2
 */
@Data
public class SubjectDTO {

    private Integer subjectId;

    private String subjectName;

    private Date createdDate;

    private Date modifiedDate;

    private Boolean status;

}
