/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.studentstatus.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 *
 * @author sd14d
 */
@Data
@JsonInclude(Include.NON_NULL)
public class StudentStatusDTO {

    private Integer studentStatusId;
    private String status;

}
