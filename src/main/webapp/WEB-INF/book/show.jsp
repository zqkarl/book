<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%=basePath%>/css/book.css">
        <title>book</title>
    </head>
    <body>
        <div class="w">
            <header>
                <span class="title">书本详情</span>
            </header>
            <input type="text" name="id" value="${book.id } " style="display: none">
            <div class="section" style="padding-top: 20px;">
                    <ul class="form-list">
                        <li>
                            <label class="label">书名</label>
                            <input type="text" id="name" name="name" value="${book.name}" readonly="readonly">
                            <span id="nameMsg"></span>
                        </li>
                        <li>
                            <label class="label">作者</label>
                            <input type="text" name="author" value="${book.author}" readonly="readonly">
                        </li>
                        <li>
                            <label class="label">出版社</label>
                            <input type="text" name="publishingHouse" value="${book.publishingHouse}" readonly="readonly">
                        </li>
                        <li>
                            <label class="label">价格</label>
                            <input type="text" id="price" name="price" value="${book.price}" readonly="readonly">
                            <span id="priceMsg"></span>
                        </li>
                        <li>
                            <label class="label">类目</label>
                            <select name="type" style="..." readonly="readonly">
                                <option value="1" <c:if test="${book.type == '1'}">selected</c:if>>文化类</option>
                                <option value="2" <c:if test="${book.type == '2'}">selected</c:if>>科技类</option>
                                <option value="3" <c:if test="${book.type == '3'}">selected</c:if>>生活类</option>
                                <option value="4" <c:if test="${book.type == '4'}">selected</c:if>>少儿类</option>
                                <option value="5" <c:if test="${book.type == '5'}">selected</c:if>>综合类</option>
                            </select>
                        </li>
                        <li>
                            <label class="label">库存总量</label>
                            <input type="text" id="inventory" name="inventory" value="${book.inventory}" readonly="readonly">
                            <span id="inventoryMsg"></span>
                        </li>
                        <li>
                            <label class="label">所在位置</label>
                            <input type="text" name="location" value="${book.location}" readonly="readonly">
                        </li>
                        <li>
                            <label class="label">书本详情</label>
                            <textarea type="text" rows="5" cols="40" name="description" readonly="readonly">${book.description}</textarea>
                        </li>
                    </ul>
            </div>
            <div class="btn-group">
                <a href="${pageContext.request.contextPath }/book/queryList" >
                    <input type="button" value="返回" class="btn">
                </a>
            </div>
        </div>
    </body>
</html>