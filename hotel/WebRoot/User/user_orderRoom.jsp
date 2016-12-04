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
            <span class="crumb-name">预定房间</span>
            </div>
           </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="User_queryOneTypeHomeAfter.action" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择房间类型:</th>
                            <td>
                                <select name="roomtype" id="1">
                                    <option value="*" >全部</option>
                                    <option value="单人房">单人房</option>
                                    <option value="双人房">双人房</option>
                                    <option value="大床房">大床房</option>
                                    <option value="电脑房">电脑房</option>
                                    <option value="经济房">经济房</option>
                                </select>
                            </td>                           
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="#" method="post" id="myform" name="myform">
                <div class="config-items">                   
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                         <tr >
									<td>房间种类</td>
									<td>价格(元/晚)</td>	
									<td>剩余房间数</td>
									<td>操作</td>							
						 </tr>
						 <!-- 遍历开始 -->
						 <s:iterator value="#request.AllHome_list" var="AllHome">
								<tr class="list">
									<td><s:property value="#AllHome.id.roomtype" /></td>
                                    <td><s:property value="#AllHome.id.price" /></td>
									<td><s:property value="#AllHome.id.count" /></td>
									<td><a href="User_selectOrderRoom.action?roomtype=<s:property value="#AllHome.id.roomtype"/>" class="btn btn-primary btn2"  >预定</a></td>
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