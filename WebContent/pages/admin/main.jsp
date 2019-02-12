<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>後台管理</title>
<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>

<div id="box">

<s:action name="admin_top" namespace="/admin" executeResult="true"></s:action>

<div id=mid>

<s:action name="admin_left" namespace="/admin" executeResult="true"></s:action>

<iframe name="abc" width="690" height="500" frameborder="1"></iframe>

<!--<s:action name="admin_right" namespace="/admin" executeResult="true"></s:action>-->

</div>

<div id="bottom">

</div>


</div>


</body>
</html>