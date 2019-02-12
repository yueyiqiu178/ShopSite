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
<s:push value="order">
<h3>更新訂單狀態</h3>
<s:form action="order_update" name="/admin/product" method="post">
<s:hidden name="orderId"></s:hidden>
<p>
訂單狀態:
<s:radio name="orderState" list="@site.yueyiqiu.model.OrderState@getValues()" value="getName()"></s:radio>
</p>
<s:submit value="更新訂單狀態"></s:submit>
</s:form>
</s:push>
</body>
</html>