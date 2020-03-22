<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" href="../css/list.css">
    <title>用户还书</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

</head>

<body>
<div class="w">
    <header>
        <span class="title">用户还书</span>
    </header>
    <form action="${pageContext.request.contextPath }/record/searchRecord" method="GET">
        <div class="form">
            <div class="form-item">
                <label>借书人</label>
                <input type="text" name="user" value="${user}">
                <button class="btn inquire" type="submit">查询</button>
            </div>
        </div>
    </form>
    <div class="list">
        <div class="list-bd">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
                <tr>
                    <th width="18%">书名</th>
                    <th width="5%">作者</th>
                    <th width="10%">出版社</th>
                    <th width="5%">价格</th>
                    <th width="10%">类目</th>
                    <th width="9%">操作</th>
                </tr>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.author}</td>
                        <td>${item.publishingHouse}</td>
                        <td>${item.price}</td>
                        <td>${item.type}</td>
                        <td>
                            <a href="${pageContext.request.contextPath }/book/returnBook?id=${item.recordId}">还书</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
