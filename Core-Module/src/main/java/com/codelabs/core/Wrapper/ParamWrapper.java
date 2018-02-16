/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.core.Wrapper;

import com.codelabs.core.DTO.Parameters;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author puzansakya
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ParamWrapper {

    private List<Parameters> parametersList;
    private int compareType; //<-- 1 = AND , 2 = OR

}
