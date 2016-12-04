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
            <span class="crumb-name">查看历史订单</span>
            </div>
           </div>
        <div class="result-wrap">
                     <div class="result-title">
                <h1><i class="icon-font">&#xe00a;&nbsp;</i>以下为您所有的历史住房信息：</h1>
            </div> 
            <form action="#" method="post" id="myform" name="myform">
                <div class="config-items">                   
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                         <tr >
									<td>入住人姓名</td>
									<td>预留电话</td>									
									<td>入住房间号</td>
									<td>房间类型</td>
									<td>入住时间</td>
									<td>离开时间</td>	
									<td>状态</td>
									<!-- <td>操作</td> -->								
						 </tr>
						 <!-- 遍历开始 -->
						 <s:iterator value="#session.User_HistoryList" var="history">
								<tr class="list">
									<td><s:property value="#history.user.name" /></td>
									<td><s:property value="#history.user.phone" /></td>                                   
									<td><s:property value="#history.room.roomnumber" /></td>								
									<td><s:property value="#history.room.roomtype" /></td>
									<td><s:date name="#history.timein" format="yyyy年MM月dd日"/></td>
									<td><s:date name="#history.timeout" format="yyyy年MM月dd日"/></td>
									<td><s:property value="#history.status" /></td>	
									<%-- <td><a href="User_giveComment.action?historyCheckId=<s:property value="#history.checkid"/>" class="btn btn-primary btn2"  >评价</a></td>	 --%>						
								</tr>
						 </s:iterator>
						 <!-- 遍历结束 -->
                         </table>
                    </div>
                </div>              
            </form>
        </div>
    </div>
</div>
</body>
</html>