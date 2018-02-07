/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.attendance.DTO;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Prachin
 */
@Data
public class AttendanceDTO {

    private Integer attendanceId;
    private Date attendanceDate;
    private Boolean attendanceStatus;
//    private StudentDTO student;

}
