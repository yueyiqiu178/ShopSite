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
<s:form action="order_confirm" namespace="/product">
<div id="cart_right">
<div id="right_title">我的訂單</div>
<div id="ban01">
<table width="100%">
<tr>
<td width="116px" align="right" height="35px">
收貨人姓名:
</td>
<td width="572px" align="left">
<s:textfield name="name" cssClass="cell"></s:textfield>
</td>
</tr>
</table>
</div>
<div id="ban02">
<table width="100%">
<tr>
<td width="116px" align="right" height="35px">
收貨人地址:
</td>
<td width="572px" align="left">
<s:textfield name="address" cssClass="cell"></s:textfield>
</td>
</tr>
</table>
</div>
<div id="ban03">
<table width="100%">
<tr>
<td width="116px" align="right" height="35px">
收貨人電話:
</td>
<td width="572px" align="left">
<s:textfield name="mobile" cssClass="cell"></s:textfield>
</td>
</tr>
</table>
</div>
<div id="ban04">
<table width="100%">
<tr>
<td width="116px" align="right" height="35px">
支付方式:
</td>
<td width="572px" align="left">
<!-- <input type="radio" name="paymentWay" value="NET_BANK"/>
<input type="radio" name="paymentWay" value="支付寶"/>
<input type="radio" name="paymentWay" value="貨到付款"/>
<input type="radio" name="paymentWay" value="郵局匯款"/> -->

<s:radio name="paymentWay" list="@site.yueyiqiu.model.PaymentWay@getValues()"></s:radio>


</td>
</tr>
</table>
</div>
<div id="ban05">
<table width="100%">
<tr>
<td >
<s:submit type="image" src="%{#session.path}/images/zh01_03.gif"></s:submit>
</td>
</tr>
</table>
</div>
</div>
</s:form>
</div>

</body>
</html>