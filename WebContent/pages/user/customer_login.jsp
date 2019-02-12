<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>

</head>
<body>



<%@include file="/pages/common/head.jsp" %>




<div id="box">
<div id="mid">
<div id="denlu">


<s:fielderror></s:fielderror>
<s:form action="customer_logon" namespace="/customer" method="post">

<table cellpadding="0" cellspacing="0" style="padding-left: 75px;padding-top: 70px;">

<tr height="30px">
<td>
會員名:
</td>
<td>
<s:textfield name="username"></s:textfield>
</td>
</tr>

<tr height="30px">
<td>
密碼:
</td>
<td>
<s:password name="password"></s:password>
</td>
</tr>

<tr>
<td colspan="2" align="center">

<s:submit value="登入" type="image" src="%{#session.path}/images/dl_06.gif"></s:submit>
<s:a action="customer_reg" namespace="/customer">
<img alt="" src="<%=path%>/images/dl_08.gif">
</s:a>
</td>
</tr>


</table>




</s:form>

</div>
</div>
</div>
</body>
</html>