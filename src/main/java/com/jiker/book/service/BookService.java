package com.jiker.book.service;

import com.jiker.book.vo.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {

    List<Book> queryList(Book book) throws SQLException;

    void insert(Book book);

    void updateById(Book book);

    Book queryById(long id) throws SQLException;

    void deleteById(long id);

    List<Book> selectByUser(String user);

}
