<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String loginEmployeeName=(String)session.getAttribute("loginemployeeName"); %>
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
                        <li><a href="Employee_queryHomeStatus.action"><i class="icon-font"></i>查询房间状态</a></li>
                        <li><a href="Employee_dealOrder.action"><i class="icon-font"></i>处理预定订单</a></li>
                        <li><a href="Employee_dealLivein.action"><i class="icon-font"></i>处理入住申请</a></li>
                        <li><a href="Employee_NowStatus.action"><i class="icon-font"></i>查看目前住房状态</a></li>    
                        <li><a href="Employee_updateRoom.action"><i class="icon-font"></i>修改房间信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>员工进行操作前请先阅读员工使用须知</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>员工使用须知：</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">1、</label><span class="res-info">员工可以查询所有房间当前的状态；</span>
                    </li>
                    <li>
                        <label class="res-lab">2、</label><span class="res-info">当客户预订房间后员工可以处理预订申请；</span>
                    </li>
                    <li>
                        <label class="res-lab">3、</label><span class="res-info">用户可以提出入住申请供员工处理；</span>
                    </li>
                    <li>
                        <label class="res-lab">4、</label><span class="res-info">员工可以查看当前的房间住宿信息；</span>
                    </li>
                    <li>
                        <label class="res-lab">5、</label><span class="res-info">员工可以修改未入住房间的具体信息。</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>