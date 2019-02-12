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
<s:set var="sumall" value="%{0}"></s:set>
<div id="box">
<div id="cart_left">
<div id="left_list">
<s:a action="cart_list" namespace="/product">我的購物車</s:a>
</div>
<div id="left_list">
<s:a action="order_findByCustomer" namespace="/product">我的訂單</s:a>
</div>
</div>
<div id="cart_right">
<div id="right_title">我的購物車</div>
<div id="right_content">
<table width="100%">
<tr>
<td width="688px" height="25px" align="right">
總價:<font color="red"><s:property value="#sumall"/></font>
</td>
</tr>
<tr>
<td height="30px" bgcolor="#e7f3c3">
<table width="100%">
<tr>
<td width="213px">商品名稱</td>
<td width="130px">市場價格</td>
<td width="130px">價格</td>
<td width="104px">數量</td>
<td width="111px">刪除</td>
</tr>
</table>
</td>
</tr>
<s:iterator value="#session.cart">
<s:set value="%{#sumall+productPrice*amount}" var="sumall"></s:set>
<tr>
<td>
<div id="itemcontent">
<table width="100%">
<tr>
<td width="213px"><s:property value="productName"/></td>
<td width="130px"><s:property value="productMarketPrice"/></td>
<td width="130px"><s:property value="productPrice"/></td>
<td width="104px"><s:property value="amount"/></td>
<td width="111px">
<s:a action="cart_delete" namespace="/product">
<s:param name="productId" value="productId"></s:param>
<img alt="" src="<%=path%>/images/zh03_03.gif">
</s:a>
</td>
</tr>

</table>
</div>
</td>
</tr>
</s:iterator>

<tr>
<td height="60px" align="center" valign="middle">

<s:a action="cart_clear" namespace="/product">
<img alt="" src="<%=path%>/images/zh03_07.gif"/>
</s:a>
<s:a action="index" namespace="/">
<img alt="" src="<%=path%>/images/zh03_09.gif">
</s:a>
<s:a action="order_add" namespace="/product">
<img alt="" src="<%=path%>/images/zh03_11.gif">
</s:a>

</td>
</tr>
</table>
</div>
</div>
</div>
</body>
</html>