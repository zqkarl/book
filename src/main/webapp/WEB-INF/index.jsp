<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>图书馆书籍入库管理系统</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="css/sccl.css" type="text/css"></link>
  <link rel="stylesheet" href="css/skin.css" type="text/css" ></link>
</head>
<body>

<div class="layout-admin">
  <header class="layout-header">
    <span class="header-logo">图书馆书籍入库管理系统</span>
    <a class="header-menu-btn" href="javascript:;"><i class="icon-font">&#xe600;</i></a>
    <ul class="header-bar">
      <li class="header-bar-role"><a href="javascript:;">超级管理员</a></li>
      <li class="header-bar-nav">
        <a href="javascript:;">admin<i class="icon-font" style="margin-left:5px;">&#xe60c;</i></a>
        <ul class="header-dropdown-menu">
          <li><a href="javascript:;">个人信息</a></li>
          <li><a href="javascript:;">切换账户</a></li>
          <li><a href="javascript:;">退出</a></li>
        </ul>
      </li>
    </ul>
  </header>
  <aside class="layout-side">
    <ul class="side-menu">

    </ul>
  </aside>

  <div class="layout-side-arrow"><div class="layout-side-arrow-icon"><i class="icon-font">&#xe60d;</i></div></div>

  <section class="layout-main">
    <div class="layout-main-tab">
      <button class="tab-btn btn-left"><i class="icon-font">&#xe60e;</i></button>
      <nav class="tab-nav">
        <div class="tab-nav-content">
          <a href="javascript:;" class="content-tab active" data-id="<%=basePath%>jsp/frame/statistics.jsp">首页</a>
        </div>
      </nav>
      <button class="tab-btn btn-right"><i class="icon-font">&#xe60f;</i></button>
    </div>
    <div class="layout-main-body">
      <iframe class="body-iframe" id="iframe" name="iframe0" width="100%" height="99%" src="" frameborder="0" data-id="home.html" seamless></iframe>
    </div>
  </section>
</div>
<script type="text/javascript">var _appPath = "<%=basePath%>";</script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/sccl.js"></script>
<script type="text/javascript">
  $(function(){
  });
</script>
</body>
</html>
