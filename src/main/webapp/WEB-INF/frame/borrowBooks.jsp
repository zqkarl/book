<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

    <link rel="stylesheet" href="<%=basePath%>/css/book.css">
    <title>用户借书</title>

</head>
<script type="text/javascript">
        function toVaild(){
            var name = document.getElementById("name").value;
            if(name == null || name == "" ){
                msg = document.getElementById("nameMsg")
                msg.innerHTML = '借书人不能为空';
                msg.style.color = 'red';
                return false;
            }
            return true;
        }
    </script>

<body>
        <div class="w">
            <header>
                <span class="title">用户借书</span>
            </header>
            <form action="${pageContext.request.contextPath }/record/borrow" method="post" accept-charset="UTF-8">

                <div class="section" style="padding-top: 20px;">
                    <ul class="form-list">
                        <li>
                            <label class="label">借书人</label>
                            <input type="text" id="name" name="name">
                            <span id="nameMsg"></span>
                        </li>
                        <li>
                            <label class="label">书名</label>
                            <select name="type" >
                                <c:forEach items="${list}" var="item">
                                    <option value="${item.id}">${item.name}</option>
                                </c:forEach>
                            </select>
                        </li>

                    </ul>
                </div>
                <div class="btn-group">
                    <button class="btn submit" type="submit" onclick="return toValid(this.form)">确认</button>
                    <a href="${pageContext.request.contextPath }/book/queryList">
                        <input type="button" value="取消" class="btn">
                    </a>
                </div>
            </form>
        </div>
</body>
</html>
