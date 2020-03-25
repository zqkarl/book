package com.jiker.book.controller;

import com.jiker.book.service.BookService;
import com.jiker.book.service.impl.BookServiceImpl;
import com.jiker.book.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookServiceImpl;

    @RequestMapping(value = "queryList")
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

    @RequestMapping("insertOrUpdate")
    public String insert(Book book) {
        if (book.getId()!= null) {
            bookServiceImpl.updateById(book);
        } else {
            bookServiceImpl.insert(book);
        }
        return "redirect:/book/queryList";
    }

    @RequestMapping("show")
    public ModelAndView show(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = null;
        try {
            book = bookServiceImpl.queryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("book",book);
        modelAndView.setViewName("book/show");
        return modelAndView;
    }

    @RequestMapping("queryById")
    public ModelAndView queryById(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        if (id != null) {
            Book book = null;
            try {
                book = bookServiceImpl.queryById(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            modelAndView.addObject("book",book);
        }
        modelAndView.setViewName("book/book");
        return modelAndView;
    }

    @RequestMapping("deleteById")
    public ModelAndView deleteById(Long id) {
        bookServiceImpl.deleteById(id);
        Book book = new Book();
        return queryList(book);
    }


}
