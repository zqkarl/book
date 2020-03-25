package com.jiker.book.dao;

import com.jiker.book.vo.Record;

import java.util.List;

public interface RecordDao {

    public void insert(Record record);

    public void update(Record record);

    public List<Record> selectAll();

    public List<Record> query(Record record, boolean isReturn);
}
