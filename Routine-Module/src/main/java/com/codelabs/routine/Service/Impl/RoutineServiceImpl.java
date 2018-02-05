/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.routine.Service.Impl;

import com.codelabs.entity.Routine;
import com.codelabs.routine.DAO.RoutineDAO;
import com.codelabs.routine.Service.RoutineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author koirala
 */
@Service(value = "RoutineService")
public class RoutineServiceImpl implements RoutineService {

    @Autowired
    RoutineDAO rd;

    @Override
    public List<Routine> getAll() {
        return rd.getAll();
    }

    @Override
    public Routine insert(Routine t) {
        return rd.insert(t);
    }

    @Override
    public void update(int id, Routine t) {
        rd.update(t);
    }

    @Override
    public boolean delete(int id) {
        return rd.delete(id);
    }

    @Override
    public Routine getById(int id) {
        return rd.getById(id);
    }

}
