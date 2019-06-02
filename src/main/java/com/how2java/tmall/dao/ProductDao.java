package com.how2java.tmall.dao;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * ClassName:PropertyDao
 * Package:com.how2java.tmall.dao
 * Description:
 *
 * @date:2019/5/30 21:40
 * @author:廖凡
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
    Page<Product> findByCategory(Category category, Pageable pageable);

    /*
    *
    * 自定义查询语句更新
    * */
    @Modifying
    @Transactional
    @Query("update Product p set p.name = :name , p.subTitle= :subTitle, p.originalPrice= :originalPrice,p.promotePrice= :promotePrice,p.stock= :stock where p.id = :id")
    void update(@Param("id") int id,@Param("name") String name,@Param("subTitle") String subTitle,@Param("originalPrice") BigDecimal originalPrice,@Param("promotePrice") BigDecimal promotePrice,@Param("stock") Integer stock);

/*    @Query(value = "update produ")
    void updatebypro(Product);*/
}
