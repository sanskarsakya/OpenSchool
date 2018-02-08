/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.time.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author sd14d
 */
@Data
public class TimeDTO {

    private Integer timeId;
    private String timeName;
    private Date createdDate;
    private Date modifiedDate;
    private Boolean status;
}
