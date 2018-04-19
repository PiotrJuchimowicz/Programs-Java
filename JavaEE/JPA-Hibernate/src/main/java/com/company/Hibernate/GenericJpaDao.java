package com.company.Hibernate;

import com.company.JPA.GenericDao;

public class GenericJpaDao<T,K> implements GenericDao<T,K> {

       public  void save(T t){}
       public  void delete(T t){}
       public void update(T t){}
       public  T findById(K id){return T;}
}
