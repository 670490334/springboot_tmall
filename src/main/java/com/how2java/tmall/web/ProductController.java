package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * ClassName:ProductController
 * Package:com.how2java.tmall.web
 * Description:
 *
 * @date:2019/5/31 20:24
 * @author:廖凡
 */
@RestController
public class ProductController {
        @Autowired
        private CategoryService categoryService;

        @Autowired
        private ProductService productService;

        @GetMapping("/product")
        public Page4Navigator<Product> list(@RequestParam(value = "cid",defaultValue = "0") int cid,@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
            start = start<0?0:start;
            Page4Navigator<Product> page =productService.list(cid,start, size, 5);  //5表示导航分页最多有5个，像 [1,2,3,4,5] 这样
            return page;
        }
        @GetMapping("/product/{id}")
        public Product get(@PathVariable("id") int id) throws Exception {
            Product bean=productService.get(id);
            return bean;
        }

        @PostMapping("/product/{id}")
        public Object update(@PathVariable(value = "id") int id, Product bean,HttpServletRequest request) throws Exception {
            System.out.println(request.getParameter("name"));
            productService.update(bean);
            return null;
        }
        @DeleteMapping("/product/{id}")
        public String delete(@PathVariable("id") int id){
            productService.delete(id);
            return null;
        }
        @PostMapping("/product")
        public Object add(Product bean, int cid){
            bean.setCategory(categoryService.get(cid));
            productService.add(bean);
            return bean;
        }



    }
