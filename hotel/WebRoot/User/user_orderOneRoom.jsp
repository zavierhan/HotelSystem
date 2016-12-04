<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <% String loginUserName=(String)session.getAttribute("user_name"); %>
  <% User user=(User)session.getAttribute("user_self"); %>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>欢迎光临612酒店</title>
    <script type="text/javascript">
    function check() {
 	   if(document.forms.myform.timein.value==""){
 		   alert("请输入住房日期！");
 		  document.forms.myform.timein.focus();
 		   return false;
 	   }	
 	  if(document.forms.myform.timeout.value==""){
		   alert("请输入离开日期！");
		  document.forms.myform.timeout.focus();
		   return false;
	   }
 	
 }
</script>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" >612酒店</a></li>            
            </ul>          
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">        
                  <li><%= loginUserName %>,欢迎你&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li><a href="User_logout.action">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                        <li><a href="User_orderRoom.action"><i class="icon-font"></i>预定房间</a></li>
                         <li><a href="User_queryOrder.action"><i class="icon-font"></i>查询预订信息</a></li>
                        <li><a href="User_historyRoom.action"><i class="icon-font"></i>历史住房记录</a></li>
                        <li><a href="User_giveComment.action"><i class="icon-font"></i>未评价订单</a></li>
                        <li><a href="User_queryMessageAfter.action"><i class="icon-font"></i>查看酒店评价</a></li>
                        <li><a href="User_updateUser.action"><i class="icon-font"></i>修改个人信息</a></li>               
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list">
            <i class="icon-font"></i>
            <a href="User_returnToIndex2.action">首页</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">预定房间</span>
            </div>
           </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="User_saveOrderRoom.action" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120">选择房间号：</th>
                            <td>
                                 <s:select   theme = "simple" name="roomnumber"  list="%{#session.OrderRoomNumberList}" listKey="roomnumber" listValue="roomnumber">                                               
                            </s:select> 
                            </td>
                        </tr>
                         <tr>
                                <th>房间类型：</th>
                                <td>
                                    <input class="common-text required" id="title" name="roomtype" size="50" value="<%=session.getAttribute("roomtype") %>" readonly="readonly" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>入住人：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="<%= loginUserName %>" type="text" readonly="readonly">
                                </td>
                            </tr>
                            <tr>
                                <th>入住日期：</th>
                                <td><input class="common-text" name="timein" size="50"  type="date"></td>
                            </tr>
                                <tr>
                                <th>离开日期：</th>
                                <td><input class="common-text" name="timeout" size="50" value="admin" type="date"></td>
                            </tr>
								<tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit" onclick="return check(this)">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
</div>
</body>
</html>