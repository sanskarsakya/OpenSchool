/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.attendance.DAO.Impl;

import com.codelabs.attendance.DAO.AttendanceDAO;
import com.codelabs.core.DAO.Impl.GenericDAOImpl;
import com.codelabs.entity.Attendance;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prachin
 */
@Repository(value = "AttendanceDAO")
public class AttendanceDAOImpl extends GenericDAOImpl<Attendance> implements AttendanceDAO {

}
