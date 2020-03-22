package com.jiker.book.controller;

import com.jiker.book.service.BookService;
import com.jiker.book.service.impl.BookServiceImpl;
import com.jiker.book.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    private BookService bookServiceImpl = new BookServiceImpl();

    @RequestMapping("queryList")
    public ModelAndView queryList(Book book) {
        List<Book> list = null;
        try{
            list = bookServiceImpl.queryList(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("book/list");
        return modelAndView;
    }
}
