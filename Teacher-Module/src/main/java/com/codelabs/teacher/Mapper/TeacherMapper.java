/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.Mapper;

import com.codelabs.entity.Gender;
import com.codelabs.entity.Teacher;
import com.codelabs.teacher.DTO.TeacherDTO;

/**
 *
 * @author puzansakya
 */
public class TeacherMapper {

    public TeacherDTO toDTO(Teacher t) {
        TeacherDTO td = new TeacherDTO();
        td.setTeacherId(t.getTeacherId());
        td.setFirstName(t.getFirstName());
        td.setLastName(t.getLastName());
        td.setCity(t.getCity());
        td.setStreet(t.getStreet());
        td.setEmail(t.getEmail());
        td.setContactNo(t.getContactNo());
        td.setUsername(t.getUsername());
        td.setPassword(t.getPassword());
        td.setSocialLink(t.getSocialLink());
        td.setGender(t.getGenderId().getGender());
        td.setStatus(t.getStatus());

        return td;

    }

    public Teacher toEntity(Teacher teacher, TeacherDTO t) {
        Teacher td = new Teacher();
        if (teacher != null) {
            td = teacher;
        }
        if (t.getTeacherId() != null) {
            td.setTeacherId(t.getTeacherId());
        }
        if (t.getFirstName() != null) {
            td.setFirstName(t.getFirstName());
        }
        if (t.getLastName() != null) {
            td.setLastName(t.getLastName());
        }
        if (t.getCity() != null) {
            td.setCity(t.getCity());
        }
        if (t.getStreet() != null) {
            td.setStreet(t.getStreet());
        }
        if (t.getEmail() != null) {
            td.setEmail(t.getEmail());
        }
        if (t.getContactNo() != null) {
            td.setContactNo(t.getContactNo());
        }
        if (t.getUsername() != null) {
            td.setUsername(t.getUsername());
        }
        if (t.getPassword() != null) {
            td.setPassword(t.getPassword());
        }
        if (t.getSocialLink() != null) {
            td.setSocialLink(t.getSocialLink());
        }
        if (t.getStatus() != null) {
            td.setStatus(t.getStatus());
        }
        if (t.getGenderId() != 0) {          
            td.setGenderId(new Gender(t.getGenderId()));
        }
        return td;

    }
}
