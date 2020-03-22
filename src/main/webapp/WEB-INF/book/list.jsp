<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/list.css">
    <title>维护图书</title>
</head>
<body>
<div class="w">
    <header>
        <a href="${pageContext.request.contextPath }/book/queryById.action" >
            <input type="button" οnclick="javascrtpt:window.location.href='${pageContext.request.contextPath}/book/queryById.action'" value="添加" class="btn">
        </a>
    </header>
    <form action="${pageContext.request.contextPath }/book/queryList.action" method="post">
        <div class="form">
            <div class="form-item">
                <label>书名</label>
                <input type="text" name="name">
            </div>
            <div class="form-item">
                <label>作者</label>
                <input type="text" name="author">
            </div>
            <div class="form-item">
                <label>类目</label>
                <select style="height:30px;" name="type">
                    <option value="">请选择</option>
                    <option value="1">文化类</option>
                    <option value="2">科技类</option>
                    <option value="3">生活类</option>
                    <option value="4">少儿类</option>
                    <option value="5">综合类</option>
                </select>
            </div>
        </div>
        <div class="btn-group">
            <button class="btn inquire" type="submit">查询</button>
            <button class="btn reset" type="reset">重置</button>
        </div>
    </form>
    <div class="list">
        <div class="list-bd">
            <!-- todo 在此处添加列表展示的html代码-->
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                <tr>
                    <th width="18%">书名</th>
                    <th width="5%">作者</th>
                    <th width="10%">出版社</th>
                    <th width="5%">价格</th>
                    <th width="10%">类目</th>
                    <th width="7%">库存总量</th>
                    <th width="7%">借出总量</th>
                    <th width="7%">剩余总量</th>
                    <th width="12%">所在位置</th>
                    <th width="9%">操作</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.author}</td>
                        <td>${item.publishingHouse}</td>
                        <td>${item.price}</td>
                        <td>${item.type}</td>
                        <td>${item.inventory}</td>
                        <td>${item.lendCount}</td>
                        <td>${item.inventory - item.lendCount}</td>
                        <td>${item.location}</td>
                        <td>
                            <a href="${pageContext.request.contextPath }/book/show?id=${item.id}">查看</a>
                            <a href="${pageContext.request.contextPath }/book/queryById?id=${item.id}">|修改</a>
                            <a href="${pageContext.request.contextPath }/book/deleteById?id=${item.id}">|删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>