package com.jiker.book.dao.impl;

import com.jiker.book.dao.RecordDao;
import com.jiker.book.util.JDBCUtil;
import com.jiker.book.vo.Book;
import com.jiker.book.vo.Record;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.*;
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
            String sql = "INSERT INTO jk_pro_db.record(book_id, type, person) values (?,?,?)";
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, record.getBookId());
            ps.setString(2, record.getType());
            ps.setString(3, record.getPerson());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                record.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
    }

    @Override
    public void update(Record record) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            String sql = "UPDATE jk_pro_db.record SET relate_id=? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, record.getRelateId());
            ps.setLong(2, record.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4 关闭连接
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
    public List<Record> query(Record record, boolean isReturn) {
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
            if (!isReturn) {
                sql.append("  and record.relate_id is null");
            }
            System.out.println(sql.toString());
            //3 操作数据库——查询一条数据记录
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            //4 处理返回数据——将返回的一条记录封装到一个JavaBean对象
            while (rs.next()) {
                Record vo = new Record();
                vo.setId(rs.getLong("id"));
                vo.setBookId(rs.getLong("book_id"));
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
