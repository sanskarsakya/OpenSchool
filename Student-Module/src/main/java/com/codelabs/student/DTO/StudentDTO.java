/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.student.DTO;

import com.codelabs.entity.StudentStatus;
import com.codelabs.entity._Class;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author koirala
 */
@Data
public class StudentDTO {

    private Integer studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private String username;
    private String password;
    private String street;
    private String city;
    private Date createdDate;
    private _Class classId;
    private StudentStatus statusId;
}
