package com.lanle.annotation;

import java.util.Date;

public class Book {

    @LanAnnotation(remark = "书名")
    private String bookName;
    @LanAnnotation(remark = "作者")
    private String bookAuthor;
    @Deprecated
    @LanAnnotation(remark = "出版日期")
    private Date  bookCreateTime;
    @LanAnnotation(remark = "版本号",show = false)
    private Integer version;

    public String getBookName() {
        return bookName;
    }

    @LanAnnotation(remark = "JAVA软件工程")
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Date getBookCreateTime() {
        return bookCreateTime;
    }

    public void setBookCreateTime(Date bookCreateTime) {
        this.bookCreateTime = bookCreateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookCreateTime=" + bookCreateTime +
                ", version=" + version +
                '}';
    }
}
