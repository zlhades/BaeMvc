package com.demo.dao;

import com.demo.domain.Product;


public interface ProductDao extends ModelDao<Product>{

    public Product findByName(String name);


}
