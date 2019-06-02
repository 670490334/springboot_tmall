package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.how2java.tmall.pojo.Property;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:PropertyDao
 * Package:com.how2java.tmall.dao
 * Description:
 *
 * @date:2019/5/30 21:40
 * @author:廖凡
 */
public interface PropertyDao extends JpaRepository<Property,Integer> {
    Page<Property> findByCategory(Category category , Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update Property p set p.name=:name where p.id=:id")
    void update(@Param("name") String name,@Param("id") int id);
}
