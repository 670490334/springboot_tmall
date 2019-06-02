package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:PropertyController
 * Package:com.how2java.tmall.web
 * Description:
 *
 * @date:2019/5/30 21:55
 * @author:廖凡
 */
@RestController
public class PropertyController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    public Page4Navigator<Property> list(@RequestParam(value = "cid" ,defaultValue = "2") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Property> page =propertyService.list(cid,start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
        return page;
    }
    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id") int id) throws Exception {
        Property bean=propertyService.get(id);
        return bean;
    }

    @PostMapping("/properties/{id}")
    public Object update(Property bean, HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        bean.setName(name);
        propertyService.update(bean);
        return bean;
    }
    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") int id){
        propertyService.delete(id);
        return null;
    }
    @PostMapping("/properties")
    public Object add(Property bean,int cid){
        bean.setCategory(categoryService.get(cid));
        propertyService.add(bean);
        return bean;
    }



}
