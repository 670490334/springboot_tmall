package com.how2java.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName:Product
 * Package:com.how2java.tmall.pojo
 * Description:产品管理
 *
 * @date:2019/5/31 16:52
 * @author:廖凡
 */
@Entity
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;
    private String subTitle;
    private BigDecimal originalPrice;
    private BigDecimal promotePrice;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;
    private Date createDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public Integer getStock() {
        return stock;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
