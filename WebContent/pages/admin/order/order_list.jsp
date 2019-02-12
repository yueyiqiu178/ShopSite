<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<script type="text/javascript">

function openWindow(url,w,h){

	var left=(screen.width-w)/2;
	var top=(screen.height-h)/2;

	features= "left="+ left +",top="+ top +",height="+ h +",width="+ w
	+ ",center=1,scrollbars=0,status=0,directories=0,channelmode=0";

	var openwin=window.open(url,'window',features);
	openwin.focus();
	
}

</script>
</head>
<body>
<div id="right">
<div id="right_top">
<table>

<tr>
<td>訂單號</td>
<td>總金額</td>
<td>消費者</td>
<td>支付方式</td>
<td>創建時間</td>
<td>訂單狀態</td>
<td>修改</td>
</tr>
</table>
</div>
<div id="right_mid">
<table>
<s:iterator value="pagemodel.list">
<tr>
<td><s:property value="orderId"/></td>
<td><s:property value="totalPrice"/></td>
<td><s:property value="customer.realname"/></td>
<td><s:property value="paymentWay"/></td>
<td><s:date name="createtime" format="yyyy年MM月d日  HH:mm" /></td>
<td><s:property value="orderState"/></td>
<td>
<s:url var="order_select" action="order_select" namespace="/admin/product">
<s:param name="orderId" value="orderId"></s:param>
</s:url>
<input type="button" value="更新訂單狀態" onclick="openWindow('${order_select}',350,150);"/>
</td>
</tr>
</s:iterator>
</table>

</div>
<div id="right_foot">

<s:url action="order_list" namespace="/admin/product" var="first">
<s:param name="pageNo" value="1"></s:param>
<s:param name="orderId" value="orderId"></s:param>
<s:param name="orderState" value="orderState"></s:param>
<s:param name="customer.username" value="customer.username"></s:param>
<s:param name="name" value="name"></s:param>
</s:url>

<s:url action="order_list" namespace="/admin/product" var="previous">
<s:param name="pageNo" value="pagemodel.pageNo-1"></s:param>
<s:param name="orderId" value="orderId"></s:param>
<s:param name="orderState" value="orderState"></s:param>
<s:param name="customer.username" value="customer.username"></s:param>
<s:param name="name" value="name"></s:param>
</s:url>

<s:url action="order_list" namespace="/admin/product" var="next">
<s:param name="pageNo" value="pagemodel.pageNo+1"></s:param>
<s:param name="orderId" value="orderId"></s:param>
<s:param name="orderState" value="orderState"></s:param>
<s:param name="customer.username" value="customer.username"></s:param>
<s:param name="name" value="name"></s:param>
</s:url>

<s:url action="order_list" namespace="/admin/product" var="last">
<s:param name="pageNo" value="pagemodel.getLastPageNo"></s:param>
<s:param name="orderId" value="orderId"></s:param>
<s:param name="orderState" value="orderState"></s:param>
<s:param name="customer.username" value="customer.username"></s:param>
<s:param name="name" value="name"></s:param>
</s:url>

<%@ include file="/pages/common/page.jsp"%>

</div>
</div>
</body>
</html>