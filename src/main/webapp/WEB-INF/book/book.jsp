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
    <script type="text/javascript">
        function toVaild(){
            var name = document.getElementById("name").value;
            if(name == null || name == "" ){
                msg = document.getElementById("nameMsg")
                msg.innerHTML = '书名不能为空';
                msg.style.color = 'red';
                return false;
            }

            var reg = /^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/;
            var price = document.getElementById("price").value;
            if(price == null || price == "" || !reg.test(price)){
                msg = document.getElementById("priceMsg")
                msg.innerHTML = '价格不能为空，只能输入数字，小数点后保留两位';
                msg.style.color = 'red';
                return false;
            }

            reg = /^[+]{0,1}(\d+)$/;
            var inventory = document.getElementById("inventory").value;
            if(inventory == null || inventory == "" || !reg.test(inventory)){
                msg = document.getElementById("inventoryMsg")
                msg.innerHTML = '库存总量不能为空，只能输入整数';
                msg.style.color = 'red';
                return false;
            }
            return true;
        }
    </script>
    <body>
        <div class="w">
            <header>
                <span class="title">书本详情</span>
            </header>
            <!--todo。。。在处添加编辑图书信息的代码。。。-->
            <form action="${pageContext.request.contextPath }/book/insertOrUpdate" method="post" accept-charset="UTF-8">
                <input type="text" name="id" value="${book.id}" style="display:none">
                <div class="section" style="padding-top: 20px;">
                    <ul class="form-list">
                        <li>
                            <label class="label">书名</label>
                            <input type="text" id="name" name="name" value="${book.name}">
                            <span id="nameMsg"></span>
                        </li>
                        <li>
                            <label class="label">作者</label>
                            <input type="text" name="author" value="${book.author}">
                        </li>
                        <li>
                            <label class="label">出版社</label>
                            <input type="text" name="publishingHouse" value="${book.publishingHouse}">
                        </li>
                        <li>
                            <label class="label">价格</label>
                            <input type="text" id="price" name="price" value="${book.price}">
                            <span id="priceMsg"></span>
                        </li>
                        <li>
                            <label class="label">类目</label>
                            <select name="type" style="...">
                                <option value="1" <c:if test="${book.type == '1'}">selected</c:if>>文化类</option>
                                <option value="2" <c:if test="${book.type == '2'}">selected</c:if>>科技类</option>
                                <option value="3" <c:if test="${book.type == '3'}">selected</c:if>>生活类</option>
                                <option value="4" <c:if test="${book.type == '4'}">selected</c:if>>少儿类</option>
                                <option value="5" <c:if test="${book.type == '5'}">selected</c:if>>综合类</option>
                            </select>
                        </li>
                        <li>
                            <label class="label">库存总量</label>
                            <input type="text" id="inventory" name="inventory" value="${book.inventory}">
                            <span id="inventoryMsg"></span>
                        </li>
                        <li>
                            <label class="label">所在位置</label>
                            <input type="text" name="location" value="${book.location}">
                        </li>
                        <li>
                            <label class="label">书本详情</label>
                            <textarea type="text" rows="5" cols="40" name="description" >${book.description}</textarea>
                        </li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button class="btn submit" type="submit" onclick="return toValid(this.form)" >提交</button>
                    <a href="${pageContext.request.contextPath }/book/queryList">
                        <input type="button" value="取消" class="btn">
                    </a>
                </div>
            </form>
        </div>
    </body>
</html>