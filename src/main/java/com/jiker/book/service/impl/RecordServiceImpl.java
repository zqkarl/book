package com.jiker.book.service.impl;

import com.jiker.book.dao.RecordDao;
import com.jiker.book.dao.impl.RecordDaoImpl;
import com.jiker.book.service.RecordService;
import com.jiker.book.vo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDaoImpl;

    @Override
    public void borrowBook(Record record) {
        if (StringUtils.isEmpty(record.getBookId())) {
            throw new RuntimeException("图书不能为空");
        }
        if (StringUtils.isEmpty(record.getPerson())) {
            throw new RuntimeException("借书人不能为空");
        }

    }

    @Override
    public void returnBook(Record record) {

    }

    @Override
    public List<Record> selectAll() {
        return null;
    }
}
