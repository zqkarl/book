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
            <div class="section">
                <!--todo。。。在处添加编辑图书信息的代码。。。-->
            </div>
            <div class="btn-group">
                <a href="${pageContext.request.contextPath }/book/queryList.action" >
                    <input type="button" value="返回" class="btn">
                </a>
            </div>
        </div>
    </body>
</html>