package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.dao.PropertyDao;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:PropertyService
 * Package:com.how2java.tmall.service
 * Description:
 *
 * @date:2019/5/30 21:44
 * @author:廖凡
 */
@Service
public class PropertyService {
    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private CategoryService categoryService;

    public void add(Property property) {
        propertyDao.save(property);
    }

    public void update(Property property) {
        propertyDao.update(property.getName(),property.getId());
    }

    public void delete(int id) {
        propertyDao.delete(id);
    }

    public Property get(int id) {
        Property property = propertyDao.getOne(id);
        return property;
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        //开始，结束，排序规则
        Pageable pageable = new PageRequest(start,size,sort);
        Page<Property> pageFormJPA = propertyDao.findByCategory(category,pageable);
        //分页每页多少行
        return new Page4Navigator<>(pageFormJPA,navigatePages);
    }
}
