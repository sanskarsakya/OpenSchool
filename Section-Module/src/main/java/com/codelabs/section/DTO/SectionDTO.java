/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.section.DTO;

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
public class SectionDTO {

    private Integer sectionId;
    private String sectionName;
    private Date createdDate;
    private Boolean status;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int classId;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int teacherId;
    private String _class;
    private String teacher;

}
