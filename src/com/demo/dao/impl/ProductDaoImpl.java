package com.demo.dao.impl;

import com.demo.dao.ProductDao;
import com.demo.domain.Product;
import org.springframework.stereotype.Repository;


@Repository("productDao")
public class ProductDaoImpl extends ModelDaoImpl<Product> implements ProductDao {

    public Product findByName(String name){
        Product p = new Product();
        p.setName(name);
        return super.findByFistExample(p);
    }

}
