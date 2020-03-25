package com.jiker.book.controller;

import com.jiker.book.constant.RecordType;
import com.jiker.book.service.BookService;
import com.jiker.book.service.RecordService;
import com.jiker.book.service.impl.BookServiceImpl;
import com.jiker.book.service.impl.RecordServiceImpl;
import com.jiker.book.vo.Book;
import com.jiker.book.vo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("borrow")
    public String borrowBookPost(Model model, Record record) {
        try {
            model.addAttribute("list", bookServiceImpl.queryList(new Book()));
            recordServiceImpl.borrowBook(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "frame/borrowBooks";
    }

    @GetMapping("searchRecord")
    public String searchRecord(Model model,String user) {
        if (!StringUtils.isEmpty(user)) {
            model.addAttribute("list", bookServiceImpl.selectByUser(user));
            model.addAttribute("user", user);
        }
        return "frame/returnBook";
    }

    @GetMapping("return")
    public String searchRecord(Model model) {
//        model.addAttribute("list", bookServiceImpl.selectByUser(null));
        return "frame/returnBook";
    }

    @GetMapping("returnBook")
    public String returnBook(Model model,String user, Long id) {
        Record record = new Record();
        record.setBookId(id);
        record.setPerson(user);
        recordServiceImpl.returnBook(record);
        model.addAttribute("list", bookServiceImpl.selectByUser(user));
        model.addAttribute("user", user);
        return "frame/returnBook";
    }

}
