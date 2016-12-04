<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                 <li><a href="User_goto_register.action">注册</a></li>
                <li><a href="User_login.action">登录</a></li>
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
                        <li><a href="User_viewRoom.action"><i class="icon-font"></i>预定房间</a></li> 
                        <li><a href="User_queryMessage.action"><i class="icon-font"></i>查看酒店评价</a></li>            
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
            <a href="User_returnToIndex1.action">首页</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">查看酒店评价</span>
            </div>
           </div>
        <div class="result-wrap">
        <div class="result-title">
                <h1><i class="icon-font">&#xe00a;&nbsp;</i>以下为酒店收到的所有评价：</h1>
            </div> 
            <form action="#" method="post" id="myform" name="myform">
                <div class="config-items">                   
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                         <tr >
									<td>评价人</td>
									<td>评价时间</td>
									<td>评价房型</td>	
									<td>评价描述</td>							
						 </tr>
						 <!-- 遍历开始 -->
						 <s:iterator value="#session.Description_list" var="description">
								<tr class="list">
									<td><s:property value="#description.check.user.name" /></td>
                                    <td><s:date name="#description.time" format="yyyy年MM月dd日"/></td>
									<td><s:property value="#description.check.room.roomtype" /></td>
									<td><s:property value="#description.content" /></td>
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