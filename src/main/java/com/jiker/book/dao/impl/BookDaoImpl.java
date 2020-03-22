package com.jiker.book.dao.impl;

import com.jiker.book.dao.BookDao;
import com.jiker.book.util.JDBCUtil;
import com.jiker.book.vo.Book;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据层，只负责与数据库的数据交互，将数据进行存储读取操作
 */
public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> queryList(Book book) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<Book>();
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT id,number,name,author,publishingHouse,price,type,inventory,lendCount,location,description FROM book where 1=1");
            if(!StringUtils.isEmpty(book.getName())){
                sql.append("  and name like '%").append(book.getName()).append("%'");
            }
            if(!StringUtils.isEmpty(book.getAuthor())){
                sql.append("  and author like '%").append(book.getAuthor()).append("%'");
            }
            if(!StringUtils.isEmpty(book.getType())){
                sql.append("  and type='").append(book.getType()).append("'");
            }
            //3 操作数据库——查询一条数据记录
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            //4 处理返回数据——将返回的一条记录封装到一个JavaBean对象
            while (rs.next()) {
                Book vo = new Book(rs.getLong("id"),
                        rs.getString("number"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("publishingHouse"),
                        rs.getBigDecimal("price"),
                        rs.getString("type"),
                        rs.getInt("inventory"),
                        rs.getInt("lendCount"),
                        rs.getString("location"),
                        rs.getString("description")
                );
                bookList.add(vo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
        return bookList;
    }

    @Override
    public void insert(Book book) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            //3 操作数据库——查询一条数据记录
            String sql = "INSERT INTO jk_pro_db.book(number, name, author, publishingHouse, price, type, inventory, lendCount, location, description) values (?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getNumber());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublishingHouse());
            ps.setBigDecimal(5, book.getPrice());
            ps.setString(6, book.getType());
            ps.setInt(7, book.getInventory());
            ps.setInt(8, 0);
            ps.setString(9, book.getLocation());
            ps.setString(10, book.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
    }

    @Override
    public void updateById(Book book) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            String sql = "UPDATE jk_pro_db.book SET number = ?, name = ?, author = ?, publishingHouse = ?, price = ?, type = ?, inventory = ?, lendCount = ?, location = ?, description = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getNumber());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublishingHouse());
            ps.setBigDecimal(5, book.getPrice());
            ps.setString(6, book.getType());
            ps.setInt(7, book.getInventory());
            ps.setInt(8, 0);
            ps.setString(9, book.getLocation());
            ps.setString(10, book.getDescription());
            ps.setLong(11, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
    }

    @Override
    public Book queryById(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = null;
        try {
            //1 加载数据库驱动  2 获取数据库连接
            conn = JDBCUtil.getMysqlConn();
            String sql = "SELECT id,number,name,author,publishingHouse,price,type,inventory,lendCount,location,description FROM book where id=?";
            //3 操作数据库——查询一条数据记录
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            //4 处理返回数据——将返回的一条记录封装到一个JavaBean对象
            while (rs.next()) {
                book = new Book(rs.getLong("id"),
                        rs.getString("number"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("publishingHouse"),
                        rs.getBigDecimal("price"),
                        rs.getString("type"),
                        rs.getInt("inventory"),
                        rs.getInt("lendCount"),
                        rs.getString("location"),
                        rs.getString("description")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5 关闭连接
            JDBCUtil.close(rs, ps, conn);
        }
        return book;
    }

    @Override
    public int deleteById(long id) {
        //1. 获得数据库连接
        Connection conn = JDBCUtil.getMysqlConn();
        int rs = 0;
        Statement stmt = null;
        try {
            //2. 操作数据库，实现增删改查
            stmt = conn.createStatement();
            String sql = "delete from book where id = "+id;
            rs = stmt.executeUpdate(sql);
            //3. 处理返回数据——如果有数据，rs为更新的行数
            System.out.println("更新了"+rs+"条记录！");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4关闭连接
            JDBCUtil.close(null, stmt, conn);
        }
        return rs;
    }
}
