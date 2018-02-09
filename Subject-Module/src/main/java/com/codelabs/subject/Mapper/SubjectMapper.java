/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Mapper;

import com.codelabs.entity.Subject;
import com.codelabs.subject.DTO.SubjectDTO;

/**
 *
 * @author Anuzaa_2
 */
public class SubjectMapper {

    public SubjectDTO toDTO(Subject s) {
        SubjectDTO sd = new SubjectDTO();
        sd.setSubjectId(s.getSubjectId());
        sd.setSubjectName(s.getSubjectName());
        sd.setCreatedDate(s.getCreatedDate());
        sd.setModifiedDate(s.getModifiedDate());
        sd.setStatus(s.getStatus());

        return sd;

    }

    public Subject toEntity(Subject subject, SubjectDTO s) {
        Subject sd = new Subject();
        if (subject != null) {
            sd = subject;
        }
        if (s.getSubjectId() != null) {
            sd.setSubjectId(s.getSubjectId());
        }
        if (s.getSubjectName() != null) {
            sd.setSubjectName(s.getSubjectName());
        }
        if (s.getCreatedDate() != null) {
            sd.setCreatedDate(s.getCreatedDate());
        }
        
        if (s.getStatus() != null) {
            sd.setStatus(s.getStatus());
        }

        return sd;

    }
}
