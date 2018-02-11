/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author koirala
 */
@Data
@JsonInclude(Include.NON_NULL)
public class StudentDTO {

    private Integer studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String username;
    @JsonIgnore
    private String password;
    private String street;
    private String city;
    private Date createdDate;
    private Date modifiedDate;
    @JsonInclude(Include.NON_DEFAULT)
    private int classId;
    private String _class;
    @JsonInclude(Include.NON_DEFAULT)
    private int genderId;
    private String gender;
    @JsonInclude(Include.NON_DEFAULT)
    private int parentId;
    private String parentName;
    @JsonInclude(Include.NON_DEFAULT)
    private int statusId;
    private String status;
    
    //parent related
    private String parentFirstName;
    private String parentLastName;    
    private String parentGender;        
    private String parentStreet;
    private String parentCity;
    private String parentContactNo;
    private String parentSocialLink;
    
}
