/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs._class.Mapper;

import com.codelabs._class.DTO._ClassDTO;
import com.codelabs.entity._Class;

/**
 *
 * @author puzansakya
 */
public class _ClassMapper {

    public _ClassDTO toDTO(_Class entity) {
        _ClassDTO dtoMapped = new _ClassDTO();
        dtoMapped.setClassId(entity.getClassId());
        dtoMapped.setClassName(entity.getClassName());
        dtoMapped.setCreatedDate(entity.getCreatedDate());
        dtoMapped.setModifiedDate(entity.getModifiedDate());

        return dtoMapped;
    }

    public _Class toEntity(_Class entity, _ClassDTO dto) {
        _Class entityMapped = new _Class();
        if (dto.getClassId() != null) {
            entityMapped.setClassId(dto.getClassId());
        }
        if (dto.getClassName() != null) {
            entityMapped.setClassName(dto.getClassName());
        }

        return entityMapped;
    }
}
