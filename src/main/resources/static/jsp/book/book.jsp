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
        </div>
    </body>
</html>