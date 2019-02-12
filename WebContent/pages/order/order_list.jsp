<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%@include file="/pages/common/head.jsp" %>
<div id="box">
<div id="order_left">
<div id="order_left_list"><s:a action="cart_list" namespace="/product">我的購物車</s:a></div>
<div id="order_left_list"><s:a action="order_findByCustomer" namespace="/product">我的訂單</s:a></div>
</div>
<div id="order_right">
<div id="right_title">我的訂單</div>
<div id="right_table">
<table width="100%"  cellpadding="0" cellspacing="0">
<tr>
<td bgcolor="#fff8ad">
<table width="100%" cellpadding="0" cellspacing="0" class="yellow" >
<tr>
<td width="170px" height="30px">訂單號碼</td>
<td width="50px">總金額</td>
<td width="50px">收貨人</td>
<td width="50px">收貨地址</td>
<td width="90px">支付方式</td>
<td width="190px">建立時間</td>
<td width="70px">訂單狀態</td>
</tr>
</table>
</td>
</tr>
<s:iterator value="pagemodel.list">
<tr>
<td>
<table  width="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="170px" height="40px"><s:property value="orderId"/></td>
<td width="50px"><s:property value="totalPrice"/></td>
<td width="50px"><s:property value="name"/></td>
<td width="50px"><s:property value="address"/></td>
<td width="90px"><s:property value="paymentWay"/></td>
<td width="190px"><s:date name="createtime"/></td>
<td width="70px"><s:property value="orderState"/></td>
</tr>
</table>
</td>
</tr>
</s:iterator>
</table>
</div>


<s:url var="first" action="order_findByCustomer" namespace="/product">
<s:param name="pageNo" value="1"></s:param>


</s:url>
<s:url var="next" action="order_findByCustomer" namespace="/product">
<s:param name="pageNo" value="pagemodel.pageNo+1"></s:param>


</s:url>
<s:url var="previous" action="order_findByCustomer" namespace="/product">
<s:param name="pageNo" value="pagemodel.pageNo-1"></s:param>


</s:url>
<s:url var="last" action="order_findByCustomer" namespace="/product">
<s:param name="pageNo" value="pagemodel.getLastPageNo"></s:param>


</s:url>

<%@ include file="/pages/common/page.jsp"%>

</div>
</div>
</body>
</html>