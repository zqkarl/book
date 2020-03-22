package com.jiker.book.vo;

import java.math.BigDecimal;

public class Book {

    private Long id;//编号
    private String number;//编号
    private String name;//书名
    private String author;//作者
    private String publishingHouse;//出版社
    private BigDecimal price;//单价
    private String type;//类别
    private Integer inventory;//库存数
    private Integer lendCount;//借出数量
    private String location;//存放位置
    private String description;//书本详情

    public Book() {
    }

    public Book(Long id, String number, String name, String author, String publishingHouse, BigDecimal price, String type, Integer inventory, Integer lendCount, String location, String description) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.price = price;
        this.type = type;
        this.inventory = inventory;
        this.lendCount = lendCount;
        this.location = location;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", inventory=" + inventory +
                ", lendCount=" + lendCount +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getLendCount() {
        return lendCount;
    }

    public void setLendCount(Integer lendCount) {
        this.lendCount = lendCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

