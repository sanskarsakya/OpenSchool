/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Anuzaa_2
 */
@Data
public class ClassDTO {

    private Integer classId;

    private String className;

    private Date createdDate;

    private Boolean status;
}
