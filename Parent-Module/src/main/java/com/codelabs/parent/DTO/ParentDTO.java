/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author kamal
 */
@Data
public class ParentDTO {

    private Integer parentId;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String street;
    private String city;
    private Date createdDate;
    private Boolean status;
    private String username;
}
