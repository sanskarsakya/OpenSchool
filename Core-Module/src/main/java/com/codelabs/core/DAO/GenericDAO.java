/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.core.DAO;

import java.util.List;

/**
 *
 * @author koirala
 */
public interface GenericDAO<T> {

    List<T> getAll();

    T insert(T t);

    void update(T t);

    boolean delete(int id);

    T getById(int id);
}
