/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.core.DTO;

import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author puzansakya
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Parameters {

    private String paramName;
    private String paramValue;
    private int paramType; //<-- 1 = int 2 = string

}
