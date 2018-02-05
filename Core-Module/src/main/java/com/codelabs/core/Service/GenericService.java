/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.core.Service;

import java.util.List;

/**
 *
 * @author koirala
 */
public interface GenericService<T> {

    List<T> getAll();

    T insert(T t);

    void update(int id, T t);

    boolean delete(int id);

    T getById(int id);
}
