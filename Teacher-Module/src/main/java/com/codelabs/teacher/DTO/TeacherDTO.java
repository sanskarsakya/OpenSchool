/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 *
 * @author puzansakya
 */
@Data
@JsonInclude(Include.NON_NULL)
public class TeacherDTO {

    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private String email;
    private String contactNo;
    private String username;
    @JsonInclude(Include.NON_DEFAULT)
    private int genderId;
    private String gender;
    @JsonIgnore
    private String password;
    private String socialLink;
    private Boolean status;

}
