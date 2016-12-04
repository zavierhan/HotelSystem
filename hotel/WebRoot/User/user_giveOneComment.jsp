<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="entity.Check"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.User"%>
    <% Date date=new Date();
       SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <% String loginUserName=(String)session.getAttribute("user_name"); %>
  <% Check check=(Check)session.getAttribute("Commentcheck"); %>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>欢迎光临612酒店</title>
    <script type="text/javascript">
    function check() {
 	   if(document.forms.myform.content.value==""){
 		   alert("评价内容分不能为空！");
 		  document.forms.myform.content.focus();
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
            <span class="crumb-name">未评价订单</span>
            </div>
           </div>
        <div class="result-wrap">
                     <div class="result-title">
                <h1><i class="icon-font">&#xe00a;&nbsp;</i>请写下您的评价，我们将会更加努力：</h1>
            </div> 
                <form action="User_saveComment.action" method="post" id="myform" name="myform" enctype="multipart/form-data">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr><td><input type="text" style="display:none" name="checkid" value="<%=check.getCheckid()%>"/></td></tr>
                            <tr>
                                <th>房型：</th>
                                <td>
                                    <input class="common-text required" id="title" name="roomtype" size="50" readonly="readonly" value="<%=check.getRoom().getRoomtype() %>" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>房间号：</th>
                                <td><input class="common-text" name="roomnumber" size="50" value="<%=check.getRoom().getRoomnumber()%>" readonly="readonly" type="text"></td>
                            </tr>
                            <tr>
                                <th>评价人：</th>
                                <td><input class="common-text" name="name" size="50" value="<%=check.getUser().getName()%>" readonly="readonly" type="text"></td>
                            </tr>
                            <tr>
                                <th>评价时间：</th>
                                <td><input class="common-text" name="time" size="50" value="<%=df.format(date) %>" readonly="readonly" type="text"></td>
                            </tr>
                            <tr>
                                <th>评价内容：</th>
                                <td><textarea name="content" class="common-textarea" id="content" cols="30" style="width: 98%;" rows="10"></textarea></td>
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
</body>
</html>