package com.jiker.book.service;

import com.jiker.book.vo.Record;

import java.util.List;

public interface RecordService {

    public void borrowBook(Record record);

    public void returnBook(Record record);

    public List<Record> selectAll();
}
