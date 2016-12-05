<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String loginEmployeeName=(String)session.getAttribute("loginemployeeName"); %>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>酒店后台管理系统</title>
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
                <li><%= loginEmployeeName %>,欢迎你&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                <li><a href="Employee_logout.action">退出</a></li>
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
                        <li><a href="Employee_queryHomeStatus.action"><i class="icon-font"></i>查询所有房间状态</a></li>
                        <li><a href="Employee_dealOrder.action"><i class="icon-font"></i>处理预定订单</a></li>
                        <li><a href="Employee_dealLivein.action"><i class="icon-font"></i>处理入住</a></li>
                        <li><a href="Employee_NowStatus.action"><i class="icon-font"></i>查看目前住房状态</a></li>
                        <li><a href="Employee_historyStatus.action"><i class="icon-font"></i>查看历史入住信息</a></li>     
                        <li><a href="Employee_updateRoom.action"><i class="icon-font"></i>修改房间信息</a></li>
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
            <a href="Employee_returnToIndex.action">首页</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">处理入住</span>
            </div>
           </div>
        <div class="result-wrap">
         <div class="result-title">
                <h1><i class="icon-font">&#xe00a;&nbsp;</i>请仔细核对客户身份信息：</h1>
            </div>
            <form action="Employee_confirmOrder.action" method="post" id="myform" name="confirmOrderList">
                <div class="config-items">                   
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                         <tr >
                                    <td>入住人姓名</td>
									<td>入住人电话</td>
									<td>入住时间</td>
									<td>离开时间</td>
									<td>房间类型</td>
									<td>房间号</td>
									<td>入住状态</td>
									<td>入住操作</td>								
						 </tr>
						 <!-- 遍历开始 -->
						 <s:iterator value="#session.UnLiveList" var="UnLive">
								<tr class="list">
								    <td><s:property value="#UnLive.user.name" /></td>
									<td><s:property value="#UnLive.user.phone" /></td>
									<td><s:date name="#UnLive.timein" format="yyyy年MM月dd日"/></td>
									<td><s:date name="#UnLive.timeout" format="yyyy年MM月dd日"/></td>
									<td><s:property value="#UnLive.room.roomtype" /></td>
									<td><s:property value="#UnLive.room.roomnumber" /></td>
									<td><s:property value="#UnLive.status" /></td>
	                                <td><a href="Employee_confirmLiveIn.action?liveConfirmcheckid=<s:property value="#UnLive.checkid"/>" class="btn btn-primary btn2"  >确认入住</a></td>							
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