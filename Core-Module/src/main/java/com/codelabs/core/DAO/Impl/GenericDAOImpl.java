/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.core.DAO.Impl;

import com.codelabs.core.DAO.GenericDAO;
import java.util.HashMap;
import com.codelabs.core.DTO.Parameters;
import com.codelabs.core.Wrapper.ParamWrapper;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author koirala
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction transaction;
    private Class<T> paramClass;

    public GenericDAOImpl() {
        paramClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override

    public T insert(T t) {

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
        return t;
    }

    @Override
    public void update(T t) {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    @Override
    public T getById(int id) {
        session = sessionFactory.openSession();
        T t = (T) session.get(paramClass, id);
        session.close();
        return t;

    }

    @Override
    public boolean delete(int id) {
        boolean success = false;
        session = sessionFactory.openSession();
        T t = (T) session.get(paramClass, id);
        if (t != null) {
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
            success = true;
        }
        return success;
    }
  

    @Override
    public List<T> getAll(ParamWrapper pw, int offset, int limit) {
        session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(paramClass).setFirstResult(offset).setMaxResults(limit);
        if (pw != null) {
            if (pw.getCompareType() == 1) {
                Conjunction conjunction = Restrictions.conjunction();
                for (Parameters parameter : pw.getParametersList()) {
                    Criterion crit;
                    if (parameter.getParamType() == 1) {
                        crit = Restrictions.eq(parameter.getParamName(), Integer.parseInt(parameter.getParamValue()));
                    } else {
                        crit = Restrictions.eq(parameter.getParamName(), parameter.getParamValue());
                    }
                    conjunction.add(crit);
                }
                criteria.add(conjunction);
            } else {
                Disjunction disjunction = Restrictions.disjunction();
                for (Parameters parameter : pw.getParametersList()) {
                    Criterion crit;
                    if (parameter.getParamType() == 1) {
                        crit = Restrictions.eq(parameter.getParamName(), Integer.parseInt(parameter.getParamValue()));
                    } else {
                        crit = Restrictions.eq(parameter.getParamName(), parameter.getParamValue());
                    }
                    disjunction.add(crit);
                }
                criteria.add(disjunction);
            }
        }
        List<T> list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public Long count(ParamWrapper pw) {
        session = sessionFactory.openSession();
        Criteria criteriaCount = session.createCriteria(paramClass);
        criteriaCount.setProjection(Projections.rowCount());
        if (pw != null) {
            if (pw.getCompareType() == 1) {
                Conjunction conjunction = Restrictions.conjunction();
                for (Parameters parameter : pw.getParametersList()) {
                    Criterion crit;
                    if (parameter.getParamType() == 1) {
                        crit = Restrictions.eq(parameter.getParamName(), Integer.parseInt(parameter.getParamValue()));
                    } else {
                        crit = Restrictions.eq(parameter.getParamName(), parameter.getParamValue());
                    }
                    conjunction.add(crit);
                }
                criteriaCount.add(conjunction);
            } else {
                Disjunction disjunction = Restrictions.disjunction();
                for (Parameters parameter : pw.getParametersList()) {
                    Criterion crit;
                    if (parameter.getParamType() == 1) {
                        crit = Restrictions.eq(parameter.getParamName(), Integer.parseInt(parameter.getParamValue()));
                    } else {
                        crit = Restrictions.eq(parameter.getParamName(), parameter.getParamValue());
                    }
                    disjunction.add(crit);
                }
                criteriaCount.add(disjunction);
            }
        }
        Long count = (Long) criteriaCount.uniqueResult();
        session.close();
        return count;
    }

}
