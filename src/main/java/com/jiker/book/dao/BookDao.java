package com.jiker.book.dao;

import com.jiker.book.vo.Book;

import java.util.List;

public interface BookDao {

    public List<Book> queryList(Book book) ;

    public void insert(Book book) ;

    public void updateById(Book book) ;

    public Book queryById(long id) ;

    public int deleteById(long id) ;

    public List<Book> selectUnreturnByUser(String user);
}
