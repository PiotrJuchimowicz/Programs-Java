package com.company.Hibernate;

import com.company.JPA.ProductDao;
import com.company.Models.ProductDTO;

public class ProductJpaDao extends GenericJpaDao<ProductDTO, Long> implements ProductDao {
}
