package com.how2java.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * ClassName:Property
 * Package:com.how2java.tmall.pojo
 * Description:属性管理
 *
 * @date:2019/5/30 21:31
 * @author:廖凡
 */
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Category category;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
