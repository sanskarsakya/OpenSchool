/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author puzansakya
 */
@Data
public class TeacherDTO {

    private Integer teacherId;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private String email;
    private String username;
//    private String password;
    private Date createdDate;
    private Boolean status;

}
