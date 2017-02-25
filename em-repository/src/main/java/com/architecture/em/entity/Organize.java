package com.architecture.em.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "organize")
//组织表
public class Organize extends BaseEntity{

    private static final long serialVersionUID = 7324633359558190969L;

    @Column(name = "organize_name")
    private String organizeName;

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }
}
