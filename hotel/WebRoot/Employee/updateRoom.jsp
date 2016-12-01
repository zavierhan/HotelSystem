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
            <span class="crumb-name">修改房间信息</span>
            </div>
           </div>

        <div class="search-wrap">
                   <div class="config-title">
                        <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="icon-font">&#xe00a;</i>注意：仅可修改没有被预订的房间信息</h1>
                    </div>           
                    <div class="result-wrap">
            <form action="Employee_updateOneRoom.action" method="post" id="myform" name="myform">
                <div class="config-items">
 
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tr>
                                <th width="15%"><i class="require-red"></i>房间号：</th>
                                <td> <s:select theme = "simple" name="roomnumber"  list="%{#session.UnLiveRoomList}" listKey="roomnumber" listValue="roomnumber">                                               
                               </s:select> </td>
                            </tr>
                                <tr>
                                    <th><i class="require-red"></i>房间类型：</th>
                                    <td><select name="roomtype" id="catid" class="required">
                                    <option value="大床房">大床房</option>
                                    <option value="双人房">双人房</option>
                                    <option value="单人房">单人房</option>
                                    <option value="经济房">经济房</option>
                                    <option value="电脑房">电脑房</option>
                                </select></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red"></i>价格(元/晚)：</th>
                                    <td><input type="text" id="" placeholder="请输入数字，例如80或者80.00" size="85" name="price" class="common-text"></td>
                                </tr>                         
                                <tr>
                                    <th></th>
                                    <td>
                                        <input type="hidden" value="siteConf.inc.php" name="file">
                                        <input type="submit" value="提交" class="btn btn-primary btn6 mr10" >
                                        <input type="button" value="返回" onclick="history.go(-1)" class="btn btn6" >
                                    </td>
                                </tr>
                        </table>
                    </div>
                </div>
            </form>
        </div>
        </div>
        
    </div>
</div>
</body>
</html>