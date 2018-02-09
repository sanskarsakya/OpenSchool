/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.section.Mapper;

import com.codelabs.entity.Section;
import com.codelabs.entity.Teacher;
import com.codelabs.entity._Class;
import com.codelabs.section.DTO.SectionDTO;

/**
 *
 * @author puzansakya
 */
public class SectionMapper {
    
    public SectionDTO toDTO(Section s) {
        SectionDTO sd = new SectionDTO();
        
        sd.setSectionId(s.getSectionId());
        sd.setSectionName(s.getSectionName());
        sd.setStatus(s.getStatus());
        sd.set_class(s.getClassId().getClassName());
        sd.setTeacher(s.getTeacherId().getFirstName() + " " + s.getTeacherId().getLastName());
        
        return sd;
    }
    
    public Section toEntity(Section section, SectionDTO s) {
        Section sd = section;
        if (sd == null) {
            sd = new Section();
        }
        if (s.getSectionId() != null) {
            sd.setSectionId(s.getSectionId());
        }
        if (s.getSectionName() != null) {
            sd.setSectionName(s.getSectionName());
        }
        if (s.getStatus() != null) {
            sd.setStatus(s.getStatus());
        }
        if (s.getClassId() != 0) {
            sd.setClassId(new _Class(s.getClassId()));
        }
        if (s.getTeacherId() != 0) {
            sd.setTeacherId(new Teacher(s.getTeacherId()));
        }
        return sd;
    }
    
}
