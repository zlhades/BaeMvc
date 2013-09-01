package com.demo.action.product;


import com.demo.action.BasicAction;
import com.demo.dao.BaseUserDao;
import com.demo.dao.ProductDao;
import com.demo.domain.BaseUser;
import com.demo.domain.Product;
import com.demo.domain.ProductDetail;
import com.demo.utils.Constants;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.logging.Level;

@Controller
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductAction extends BasicAction {

    private Product product;
    private ProductDetail productDetail;
    private List<ProductDetail> productDetails;
    private String message;

    private ProductDao productDao;
    private BaseUserDao baseUserDao;


    public String index() throws Exception {

        return Constants.ACTION_RESULT_DEFAULT+ "/jsp/demo/product/create.jsp";
    }


    public String proC() throws Exception {
        if (productDao == null) {
            logger.log(Level.WARNING, " =======production dao null======= ");
        }
        if (product == null) {
            logger.log(Level.WARNING, " =======production null======= ");
        }   else {
            logger.log(Level.WARNING, " =======production not null======= "+ product.getName());
        }
        try{
        Product exist = productDao.findByName(product.getName());

        if (exist != null) this.product = exist;
        else productDao.persist(product);

        if (this.getSessionUserId() != null) {
            BaseUser baseUser = baseUserDao.findById(this.getSessionUserId());
            productDetail.setCreator(baseUser);
        }
        productDetail.setProduct(this.product);
        super.getModelDao().persist(productDetail);
//        this.setProduct(null);
//        this.setProductDetail(null);
        }catch (Exception e ) {
            logger.log(Level.WARNING, " =======eeee in proc==== ", e);
        }

        return  Constants.ACTION_RESULT_REDIRECT + "/Product!index";
    }


    public String list() throws Exception {
        String name = "%";
        if (this.getProduct() != null && this.getProduct().getName() != null)
            name = "%" + this.getProduct().getName() + "%";
        this.productDetails = super.getModelDao().find("From ProductDetail p where p.product.name like ? group by p.id order by p.id desc ", this.getPagination(), name);
//        this.productDetails = super.getModelDao().find("From ProductDetail p where p.product.name like ? order by p.id desc",  name);
        return  "/jsp/demo/product/list.jsp";
//        return Constants.ACTION_RESULT_DEFAULT+ "/jsp/demo/product/list.jsp";
    }


    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseUserDao getBaseUserDao() {
        return baseUserDao;
    }

    public void setBaseUserDao(BaseUserDao baseUserDao) {
        this.baseUserDao = baseUserDao;
    }
}
