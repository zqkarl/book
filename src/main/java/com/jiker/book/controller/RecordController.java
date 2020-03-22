package com.jiker.book.controller;

import com.jiker.book.constant.RecordType;
import com.jiker.book.service.BookService;
import com.jiker.book.service.RecordService;
import com.jiker.book.service.impl.BookServiceImpl;
import com.jiker.book.service.impl.RecordServiceImpl;
import com.jiker.book.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "record")
public class RecordController {

    @Autowired
    private RecordService recordServiceImpl;

    @Autowired
    private BookService bookServiceImpl;

    @GetMapping("borrow")
    public String borrowBook(Model model) {
        try {
            model.addAttribute("list", bookServiceImpl.queryList(new Book()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "frame/borrowBooks";
    }

    @GetMapping("searchRecord")
    public String searchRecord(Model model,String user) {
        model.addAttribute("list", bookServiceImpl.selectByUser(user));
        model.addAttribute("user", user);
        return "frame/returnBook";
    }

    @GetMapping("return")
    public String searchRecord() {
        return "frame/returnBook";
    }

}
