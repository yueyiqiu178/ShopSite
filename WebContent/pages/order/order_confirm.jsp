<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/pages/common/head.jsp"%>

<div id="box">
<div id="cart_left">
<div id="left_list"><s:a action="cart_list" namespace="/product">我的購物車</s:a></div>
<div id="left_list"><s:a action="order_findByCustomer" namespace="/product">我的訂單</s:a></div>
</div>
<div id="cart_right">
<div id="right_title">訂單確認</div>
<div id="ban">
<s:form action="order_save" namespace="/product">
<s:hidden name="name"></s:hidden>
<s:hidden name="address"></s:hidden>
<s:hidden name="mobile"></s:hidden>



<s:set var="sumall" value="%{0}"></s:set>
<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td>
<table width="100%" cellpadding="0" cellspacing="0">
<tr height="35px" bgcolor="#e7f3c3">
<td width="240px">商品名稱</td>
<td width="50px">市場價格</td>
<td width="50px">價格</td>
<td width="50px">數量</td>
</tr>
</table>
</td>
</tr>
<s:iterator value="#session.cart">
<s:set var="sumall" value="%{#sumall+productPrice*amount}"></s:set>
<tr>
<td>
<div id="innertable">
<table width="100%">
<tr>
<td width="250px"><s:property value="productName"/></td>
<td width="50px"><s:property value="productMarketPrice"/></td>
<td width="50px"><s:property value="productPrice"/></td>
<td width="50px"><s:property value="amount"/></td>
</tr>
</table>
</div>
</td>
</tr>
</s:iterator>
<tr>
<td align="right">
總價:<span class="red"><s:property value="#sumall"/></span>
</td>
</tr>
<tr>
<td>
<div id="message_title">
我的訊息
</div>
</td>
</tr>
<tr>
<td>
<table width="100%">
<tr height="40px">
<td width="120px" align="right">收貨人姓名:</td>
<td style="padding-left: 5px"><s:property value="name"/></td>
</tr>
<tr height="40px">
<td width="120px" align="right">收貨人地址:</td>
<td style="padding-left: 5px"><s:property value="address"/></td>
</tr>
<tr height="40px">
<td width="120px" align="right">收貨人電話:</td>
<td style="padding-left: 5px"><s:property value="mobile"/></td>
</tr>
<tr height="40px">
<td width="120px" align="right">貨款支付方式:</td>
<td style="padding-left: 5px"><s:property value="paymentWay"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<s:submit type="image" value="付款" src="%{#session.path}/images/zh01_03.gif"></s:submit>
</td>
</tr>
</table>
</td>
</tr>
<tr>
<td>

</td>
</tr>
</table>
</s:form>
</div>
</div>
</div>

</body>
</html>