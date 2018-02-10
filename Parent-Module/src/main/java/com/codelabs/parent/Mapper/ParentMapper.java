/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.parent.Mapper;

import com.codelabs.entity.Gender;
import com.codelabs.entity.Parent;
import com.codelabs.parent.DTO.ParentDTO;

/**
 *
 * @author puzansakya
 */
public class ParentMapper {

    public ParentDTO toDTO(Parent p) {
        ParentDTO pd = new ParentDTO();
        pd.setParentId(p.getParentId());
        pd.setFirstName(p.getFirstName());
        pd.setLastName(p.getLastName());
        pd.setUsername(p.getUsername());
        pd.setPassword(p.getPassword());
        pd.setGender(p.getGenderId().getGender());
        pd.setCity(p.getCity());
        pd.setStreet(p.getStreet());
        pd.setContactNo(p.getContactNo());
        pd.setSocialLink(p.getSocialLink());
        pd.setStatus(p.getStatus());
        return pd;
    }

    public Parent toEntity(Parent parent, ParentDTO p) {
        Parent pd = new Parent();
        if (parent != null) {
            pd = parent;
        }
        if (p.getParentId() != null) {
            pd.setParentId(p.getParentId());
        }
        if (p.getFirstName() != null) {
            pd.setFirstName(p.getFirstName());
        }
        if (p.getLastName() != null) {
            pd.setLastName(p.getLastName());
        }
        if (p.getCity() != null) {
            pd.setCity(p.getCity());
        }
        if (p.getStreet() != null) {
            pd.setStreet(p.getStreet());
        }
        if (p.getContactNo() != null) {
            pd.setContactNo(p.getContactNo());
        }
        if (p.getUsername() != null) {
            pd.setUsername(p.getUsername());
        }
        if (p.getPassword() != null) {
            pd.setPassword(p.getPassword());
        }
        if (p.getSocialLink() != null) {
            pd.setSocialLink(p.getSocialLink());
        }
        if (p.getStatus() != null) {
            pd.setStatus(p.getStatus());
        }
        if (p.getGenderId() != 0) {
            pd.setGenderId(new Gender(p.getGenderId()));
        }
        return pd;

    }

}
