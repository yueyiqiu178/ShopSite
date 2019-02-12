<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<s:form action="order_list" namespace="/admin/product" method="post">
<div id="right">
<div id="right_top">

</div>
<div id="right_mid">
<table>
<tr>
<td>訂單號:</td>
<td><s:textfield name="orderId"></s:textfield></td>
</tr>
<tr>
<td>訂單狀態:</td>
<td>
<s:radio name="orderState" list="@site.yueyiqiu.model.OrderState@getValues()"></s:radio>
</td>
</tr>
<tr>
<td>會員名:</td>
<td><s:textfield name="customer.username"></s:textfield></td>
</tr>
<tr>
<td>收款人:</td>
<td><s:textfield name="name"></s:textfield></td>
</tr>
</table>
</div>
<div id="right_foot">
<s:submit type="image" src="%{#session.path}/images/ht_02_18.gif"></s:submit>
</div>
</div>
</s:form>
</body>
</html>