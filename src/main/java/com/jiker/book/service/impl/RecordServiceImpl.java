package com.jiker.book.service.impl;

import com.jiker.book.constant.RecordType;
import com.jiker.book.dao.BookDao;
import com.jiker.book.dao.RecordDao;
import com.jiker.book.dao.impl.RecordDaoImpl;
import com.jiker.book.service.RecordService;
import com.jiker.book.vo.Book;
import com.jiker.book.vo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDaoImpl;

    @Autowired
    private BookDao bookDaoImpl;

    @Override
    public void borrowBook(Record record) {
        if (StringUtils.isEmpty(record.getBookId())) {
            throw new RuntimeException("图书不能为空");
        }
        if (StringUtils.isEmpty(record.getPerson())) {
            throw new RuntimeException("借书人不能为空");
        }
        Book book = bookDaoImpl.queryById(record.getBookId());
        if (book.getInventory()-1<0) {
            throw new RuntimeException("库存没有了借不了");
        }
        //TODO 有时间考虑下事务
        book.setInventory(book.getInventory()-1);
        book.setLendCount(book.getLendCount()+1);
        bookDaoImpl.updateById(book);
        record.setType(RecordType.BORROW.toString());
        recordDaoImpl.insert(record);
    }

    @Override
    public void returnBook(Record record) {
        // 先查是不是有这条借书记录

        // 还书
        Book book = bookDaoImpl.queryById(record.getBookId());
        book.setInventory(book.getInventory()+1);
        book.setLendCount(book.getLendCount()-1);
    }

    @Override
    public List<Record> selectAll() {
        return null;
    }
}
