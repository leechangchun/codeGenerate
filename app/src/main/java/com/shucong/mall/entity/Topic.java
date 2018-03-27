package com.shucong.mall.entity;

public class Topic{
    private Integer id;
    private String name;
    private String banner;
    private String slogen;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner() {
        return this.banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSlogen() {
        return this.slogen;
    }

    public void setSlogen(String slogen) {
        this.slogen = slogen;
    }

    @Override
    public String toString() {
        return "Topic{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", banner='" + banner + '\'' +
                ", slogen='" + slogen + '\'' +
                '}';
    }
}