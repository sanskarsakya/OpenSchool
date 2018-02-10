/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author kamal
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ParentDTO {

    private Integer parentId;
    private String firstName;
    private String lastName;
    private String username;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int genderId;
    private String gender;
    @JsonIgnore
    private String password;
    private String street;
    private String city;
    private String contactNo;
    private String socialLink;
    private Date createdDate;
    private Date modifiedDate;
    private Boolean status;
}
