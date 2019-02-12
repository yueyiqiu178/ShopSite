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
<div id="zhuce">

<s:form action="customer_save" namespace="/customer" method="post">


<table cellpadding="0" cellspacing="0" width="100%" style="padding-top: 100px;">



<tr height="40px">
<td align="right">
用戶名:
</td>
<td>
<s:textfield name="username" value="tom"></s:textfield>*
</td>
</tr>

<tr height="40px">
<td align="right">
密碼:
</td>
<td>
<s:password name="password" value="123"></s:password>*
</td>
</tr>

<tr height="40px">
<td align="right">
確認密碼:
</td>
<td>
<s:password name="repassword" value="123"></s:password>*
</td>
</tr>

<tr height="40px">
<td align="right">
E-Mail:
</td>
<td>
<s:textfield name="email" value="tom@abc.com"></s:textfield>
</td>
</tr>

<tr height="40px">
<td align="right">
地址:
</td>
<td>
<s:textfield name="address" value="kkk"></s:textfield>
</td>
</tr>

<tr height="40px">
<td align="right">
手機:
</td>
<td>
<s:textfield name="mobile" value="0932528459"/>
</td>
</tr>

<tr height="40px">
<td colspan="2" align="center">

<s:submit value="註冊"></s:submit>

</td>
</tr>
<tr height="40px">
<td colspan="2">
<s:fielderror></s:fielderror>
</td>

</tr>
</table>




</s:form>



</div>
</div>
</div>

</body>
</html>