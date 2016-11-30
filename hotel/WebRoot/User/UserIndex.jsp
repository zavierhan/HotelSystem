<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                 <li><a href="/dbfinal/Customerindex.jsp">注册</a></li>
                <li><a href="Customer_logout.action">登录</a></li>
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
                        <li><a href="Customer_querySeller.action"><i class="icon-font"></i>查询房间信息</a></li>
                        <li><a href="Customer_queryContract.action"><i class="icon-font"></i>查询预订信息</a></li>
                        <li><a href="Customer_queryBill.action"><i class="icon-font"></i>申请退房</a></li>
                        <li><a href="Customer_queryRepayment.action"><i class="icon-font"></i>住宿评价</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>请先登录或者注册才能使用完整功能</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>612酒店简介</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">1、</label><span class="res-info">每位客户可以查询责任销售人员信息；</span>
                    </li>
                    <li>
                        <label class="res-lab">2、</label><span class="res-info">合同信息记录所有签订的合同资料；</span>
                    </li>
                    <li>
                        <label class="res-lab">3、</label><span class="res-info">每份合同对应一份账单；</span>
                    </li>
                    <li>
                        <label class="res-lab">4、</label><span class="res-info">每次回款将生成一张回款记录表；</span>
                    </li>
                    <li>
                        <label class="res-lab">5、</label><span class="res-info">用户可以修改个人基本信息；</span>
                    </li>
                    <li>
                        <label class="res-lab">6、</label><span class="res-info">点击客户还款可以进行还款操作；</span>
                    </li>
                    <li>
                        <label class="res-lab">7、</label><span class="res-info">请在合同到期之前将欠款还清；</span>
                    </li>
                     <li>
                        <label class="res-lab">8、</label><span class="res-info">本系统最终解释权归软件制作者所有。</span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>