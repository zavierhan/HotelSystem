<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <% String loginUserName=(String)session.getAttribute("user_name"); %>
  <% User user=(User)session.getAttribute("user_self"); %>
<html>
<head>
    <title>欢迎光临612酒店</title>
     <script type="text/javascript">
    function check() {
 	   if(document.forms.myform.password.value==""){
 		   alert("密码不能为空！");
 		  document.forms.myform.password.focus();
 		   return false;
 	   }
 	  if(!isNumber(document.forms.myform.phone.value)){
		   alert("请输入正确的电话格式");
		  document.forms.myform.phone.focus();
		   return false;
	   }
	function isNumber(number){
	 var re = new RegExp(/^\d{7,}$/);
	  return re.test(number);
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
            <div class="crumb-list"><i class="icon-font"></i><a href="User_returnToIndex2.action">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">修改个人注册信息</span></div>
        </div>
        <div class="result-wrap">
            <form action="User_saveUpdateOne.action" method="post" id="myform" name="myform">
                <div class="config-items">
                    <div class="config-title">
                        <h1><i class="icon-font">&#xe00a;</i>请修改您的身份信息（姓名与身份证号一经注册不可更改）</h1>
                    </div>
                    <div class="result-content">
                        <table width="100%" class="insert-tab">
                            <tbody><tr>
                                <th width="15%"><i class="require-red">*</i>用户姓名：</th>
                                <td><input type="text" id=""  size="85" name="name" class="common-text" value="<%= user.getName() %>" readonly="readonly"></td>
                            </tr>
                                <tr>
                                    <th><i class="require-red">*</i>身份证号：</th>
                                    <td><input type="text" id=""  size="85" name="idnumber" class="common-text" value="<%= user.getIdnumber() %>" readonly="readonly"></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red"></i>密码：</th>
                                    <td><input type="password" id=""  size="85" name="password" class="common-text" value="<%= user.getPassword() %>"></td>
                                </tr>
                                <tr>
                                    <th><i class="require-red"></i>联系电话：</th>
                                    <td><input type="text" id=""  size="85" name="phone" class="common-text" value="<%= user.getPhone() %>"></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <td>
                                        <input type="submit" value="提交" class="btn btn-primary btn6 mr10"  onclick="return check(this)">
                                        <input type="button" value="返回" onclick="history.go(-1)" class="btn btn6">
                                    </td>
                                </tr>
                            </tbody></table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>