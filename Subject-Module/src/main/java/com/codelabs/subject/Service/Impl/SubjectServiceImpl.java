/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.subject.Service.Impl;

import com.codelabs.entity.Subject;
import com.codelabs.subject.DAO.SubjectDAO;
import com.codelabs.subject.DTO.SubjectDTO;
import com.codelabs.subject.Service.SubjectService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuzaa_2
 */
@Service(value = "SubjectService ")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDAO sd;

    @Override
    public List<SubjectDTO> getAll() {
        List<SubjectDTO> sublist = new ArrayList<>();
        for (Subject subject : sd.getAll()) {
            SubjectDTO sDTO = new SubjectDTO();
            sDTO.setSubjectId(subject.getSubjectId());
            sDTO.setSubject(subject.getSubject());
            sublist.add(sDTO);

        }
        return sublist;
    }

    @Override
    public SubjectDTO insert(SubjectDTO sDto) {
        Subject subject = new Subject();
        subject.setSubjectId(sDto.getSubjectId());
        subject.setSubject(sDto.getSubject());
        Subject retSubject = sd.insert(subject);
        sDto.setSubjectId(retSubject.getSubjectId());
        return sDto;
    }

    @Override
    public void update(int id,SubjectDTO sDto) {
        Subject subject = new Subject();
        subject.setSubjectId(id);
        subject.setSubject(sDto.getSubject());
        sd.update(subject);
      
    }

    @Override
    public boolean delete(int id) {
        return sd.delete(id);
        
    }

    @Override
    public SubjectDTO getById(int id) {
        Subject subject=new Subject();
       SubjectDTO sDTO=new SubjectDTO();
       sDTO.setSubjectId(subject.getSubjectId());
       sDTO.setSubject(subject.getSubject());
       return sDTO;
    }

}
