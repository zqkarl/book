package com.jiker.book.service.impl;

import com.jiker.book.dao.BookDao;
import com.jiker.book.service.BookService;
import com.jiker.book.util.Const;
import com.jiker.book.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层，需要根据系统的实际业务需求进行逻辑代码的编写，有些业务逻辑需要通过与数据库交互的，
 * 则业务逻辑层需要调用数据访问层的相关方法实现与数据库的交互，
 * 对于一些不需要与数据库进行交互的，则直接编写业务代码，将执行结果反馈给控制层即可
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDaoImpl;

    @Override
    public List<Book> queryList(Book book) {

        List<Book> bookList = bookDaoImpl.queryList(book);
        for (Book vo : bookList){
            vo.setType(Const.BOOK_TYPE_MAP.get(vo.getType()));
        }
        return bookList;
    }

    @Override
    public void insert(Book book) {
        bookDaoImpl.insert(book);
    }

    @Override
    public void updateById(Book book) {
        bookDaoImpl.updateById(book);
    }

    @Override
    public Book queryById(long id) {
        Book book = bookDaoImpl.queryById(id);
        return book;
    }

    @Override
    public void deleteById(long id) {
        bookDaoImpl.deleteById(id);
    }

    @Override
    public List<Book> selectByUser(String user) {
        List<Book> books = bookDaoImpl.selectUnreturnByUser(user);
        for (Book vo : books){
            vo.setType(Const.BOOK_TYPE_MAP.get(vo.getType()));
        }
        return books;
    }
}
