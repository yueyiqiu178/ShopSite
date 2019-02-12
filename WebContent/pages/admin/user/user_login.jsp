<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
</head>

<body>

<s:form action="user_logon" namespace="/admin/user" method="post">

<div id="boxadmin">

<table id="admintable">


<tr>
<td>
管理員:

</td>
<td>
<s:textfield name="username" value="supercygnus"></s:textfield>

</td>
</tr>

<tr>
<td>
密碼:

</td>
<td>

<s:password name="password"></s:password>
</td>
</tr>

<tr>
<td colspan="2" align="right">

<s:submit type="image" src="%{#session.path}/images/an_06.gif"></s:submit>

</td>
</tr>

<tr>
<td colspan="2">
<s:fielderror></s:fielderror>
</td>
</tr>
</table>
</div>


</s:form>


</body>
</html>