package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.dao.ProductDao;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName:ProductService
 * Package:com.how2java.tmall.service
 * Description:ProductService
 *
 * @date:2019/5/31 16:59
 * @author:廖凡
 */
@Service
public class ProductService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDao productDao;

    public Product get(int id) {
        return productDao.getOne(id);
    }

    public void delete(int id) {
        productDao.delete(id);
    }

    public void add(Product product) {
        product.setCreateDate(new Date());
        productDao.save(product);
    }

    public void update(Product product) {
        productDao.update(product.getId(),product.getName(),product.getSubTitle(),product.getOriginalPrice(),product.getPromotePrice(),product.getStock());
    }

    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryDAO.findOne(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //开始，结束，排序规则
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Product> pageFormJPA = productDao.findByCategory(category, pageable);
        return new Page4Navigator<>(pageFormJPA, navigatePages);

    }
}
