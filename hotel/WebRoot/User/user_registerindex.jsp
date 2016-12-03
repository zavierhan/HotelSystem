<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <% String loginUserName=(String)session.getAttribute("user_name"); %>
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
                        <li><a href="User_firstReserve.action"><i class="icon-font"></i>预定房间</a></li>
                         <li><a href="User_firstReserve.action"><i class="icon-font"></i>查询预订信息</a></li>
                        <li><a href="User_firstReserve.action"><i class="icon-font"></i>历史住房记录</a></li>
                        <li><a href="User_firstReserve.action"><i class="icon-font"></i>修改个人信息</a></li>               
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎您光临612酒店，祝您旅途愉快</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>612酒店简介</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">1、</label><span class="res-info">612酒店为武汉理工大学投资成立的五星级国际酒店；</span>
                    </li>
                    <li>
                        <label class="res-lab">2、</label><span class="res-info">本店拥有五种房型，方便您进行多元化的选择；</span>
                    </li>
                    <li>
                        <label class="res-lab">3、</label><span class="res-info">为了您的使用体验以及酒店住房安全，请您先注册录入身份信息；</span>
                    </li>
                    <li>
                        <label class="res-lab">4、</label><span class="res-info">注册成功后，我们将会对您的身份信息严格保密；</span>
                    </li>
                    <li>
                        <label class="res-lab">7、</label><span class="res-info">最后再次感谢您对612酒店的支持；</span>
                    </li>
                     <li>
                        <label class="res-lab">8、</label><span class="res-info">本系统最终解释权归612酒店所有。</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>