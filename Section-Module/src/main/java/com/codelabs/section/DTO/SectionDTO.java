/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.section.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author puzansakya
 */
@Data
public class SectionDTO {

    private Integer sectionId;
    private String sectionName;
    private Date createdDate;    
    private Boolean status;

}
