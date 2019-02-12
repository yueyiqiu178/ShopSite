<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<style type="text/css">

li{

	list-style: none;
	border-bottom: 1px dashed #99CC66;
	margin-bottom: 20px;
}

</style>
</head>
<body>
<%@include file="/pages/common/head.jsp" %>
<div id="box">
<div id="right">
<!-- 商品排行 -->
 <div>
 <table>
 <tr>
 <td>
 <img alt="" src="<%=path%>/images/index_28.gif">
 </td>
 </tr>
 
 <tr>
 <td>
<s:action name="product_findByClick" namespace="/product" executeResult="true"></s:action>
 </td>
 </tr>
 </table>
 </div>
 <!-- 推薦商品 -->
 <div>
 <table>
 <tr>
 <td>
 <img alt="" src="<%=path%>/images/08.gif">
 </td>
 </tr>

 <tr>
 <td>
 <s:action name="product_findByCommend" namespace="/product" executeResult="true"></s:action>
 </td>
 </tr>
 </table>
 </div>
 <!-- 熱銷商品 -->
 <div>
 <table>
 <tr>
 <td>
 <img alt="" src="<%=path%>/images/08.gif">
 </td>
 </tr>

 <tr>
 <td>
 <s:action name="product_findBySellCount" namespace="/product" executeResult="true"></s:action>
 </td>
 </tr>
 </table>
 </div>

</div>
<div id="right_sp">
<div id="zitao">
<img alt="" src="<%=path%>/images/05.gif"/>
</div>
<div id="product">
<s:push value="product">
<ul>
<li>
<table width="100%" cellpadding="0" cellspacing="0" border="1">
<tr >
<td rowspan="6">
<s:a action="product_select" namespace="/product">
<s:param name="id" value="id"/>
<img alt="" src="<%=path%>/upload/<s:property value="uploadfile.path"/>">
</s:a>
</td>
</tr>
<tr>
<td width="90px" align="right">
商品名稱:
</td>
<td>
<s:a action="product_select" namespace="/product">
<s:param name="id" value="id"></s:param>
<s:property value="name"/>
</s:a>
</td>
</tr>
<tr>
<td align="right" valign="top">
商品描述:
</td>
<td>
<s:property value="description"/>
</td>
</tr>
<tr>
<td align="right">
市場價格:
</td>
<td>
<s:property value="marketPrice"/>
</td>
</tr>
<tr>
<td align="right">
天下淘價格:
</td>
<td>
<s:property value="salePrice"/>
<s:if test="salePrice<=marketPrice">
<font color="red">節省<s:property value="marketPrice-salePrice"/></font>
</s:if>
</td>
</tr>
<tr>
<td colspan="2">
<s:a action="cart_add" namespace="/product">
<s:param name="productId" value="id"></s:param>
<img alt="" src="<%=path%>/images/gm_06.gif">
</s:a>

<span>[配送說明]</span>
<span>[付款說明]</span>

</td>
</tr>
</table>
</li>
</ul>
</s:push>
</div>
</div>
</div>
</body>
</html>