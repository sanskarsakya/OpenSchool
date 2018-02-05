/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.teacher.Builder;

import com.codelabs.entity.Teacher;
import com.codelabs.teacher.DTO.TeacherDTO;

/**
 *
 * @author puzansakya
 */
public class TeacherBuilder {

    private int id;
    private String firstName, lastName, contactNo, address;

    private TeacherBuilder() {

    }

    public static TeacherBuilder create() {
        return new TeacherBuilder();
    }

    public TeacherBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TeacherBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TeacherBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public TeacherBuilder setContactNo(String contactNo) {
        this.contactNo = contactNo;
        return this;
    }

    public TeacherBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Teacher build() {
        return new Teacher(id, firstName, lastName, contactNo, address);

    }

    public TeacherDTO buildDTO() {
        return new TeacherDTO(id, firstName, lastName, contactNo, address);
    }

}
