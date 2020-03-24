package com.jiker.book.dao.impl;

import com.jiker.book.dao.RecordDao;
import com.jiker.book.util.JDBCUtil;
import com.jiker.book.vo.Book;
import com.jiker.book.vo.Record;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RecordDaoImpl implements RecordDao {

    @Override
    public void insert(Record record) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            //3 操作数据库——查询一条数据记录
            String sql = "INSERT INTO jk_pro_db.record(bookId, type, person) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, record.getBookId());
            ps.setString(2, record.getType());
            ps.setString(3, record.getPerson());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
    }

    @Override
    public List<Record> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Record> recordList = new ArrayList<Record>();
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            StringBuffer sql = new StringBuffer();
            sql.append("select record.*, book.`name` from record left JOIN book on record.book_id = book.id");

            //3 操作数据库——查询一条数据记录
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            //4 处理返回数据——将返回的一条记录封装到一个JavaBean对象
            while (rs.next()) {
                Record vo = new Record();
                vo.setBookId(rs.getLong("id"));
                vo.setPerson(rs.getString("person"));
                vo.setBookName(rs.getString("name"));
                vo.setTime(rs.getTimestamp("time"));
                vo.setType(rs.getString("type"));
                recordList.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
        return recordList;
    }

    @Override
    public List<Record> query(Record record) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Record> recordList = new ArrayList<Record>();
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            StringBuffer sql = new StringBuffer();
            sql.append("select record.*, book.`name` from record left JOIN book on record.book_id = book.id where 1 = 1 ");
            if(!StringUtils.isEmpty(record.getPerson())){
                sql.append("  and record.person = '").append(record.getPerson()).append("'");
            }
            if(!StringUtils.isEmpty(record.getBookId())){
                sql.append("  and record.book_id = '").append(record.getBookId()).append("'");
            }
            if(!StringUtils.isEmpty(record.getType())){
                sql.append("  and record.type='").append(record.getType()).append("'");
            }
            //3 操作数据库——查询一条数据记录
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            //4 处理返回数据——将返回的一条记录封装到一个JavaBean对象
            while (rs.next()) {
                Record vo = new Record();
                vo.setBookId(rs.getLong("id"));
                vo.setPerson(rs.getString("person"));
                vo.setBookName(rs.getString("name"));
                vo.setTime(rs.getTimestamp("time"));
                vo.setType(rs.getString("type"));
                recordList.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
        return recordList;
    }

}
