<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>

<div id="right">
<s:form action="product_save" namespace="/admin/product" method="post" enctype="multipart/form-data">

<!--<s:iterator value="map">

<s:property value="key"/>
<s:property value="value"/>

</s:iterator>
-->

<div id="right_top">
<img alt="" src="${path}/images/blue.gif">
<span class="word01">新增商品</span>
</div>
<div id="right_mid">
<table width="100%">
<tr>
<td colspan="2">
<span style="color: red;">
<s:fielderror></s:fielderror>
</span>
</td>
</tr>
<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">商品名稱</td>
<td>
<s:textfield name="name"></s:textfield>
</td>
</tr>

<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">類別選擇</td>
<td>
<s:select list="map" name="category.id"></s:select>
</td>
</tr>


<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">採購價格</td>
<td>
<s:textfield name="basePrice"></s:textfield>
</td>
</tr>
<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">市場價格</td>
<td>
<s:textfield name="marketPrice"></s:textfield>
</td>
</tr>
<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">銷售價格</td>
<td>
<s:textfield name="salePrice"></s:textfield>
</td>
</tr>



<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">是否為推薦</td>
<td>
<s:radio list="#{true:'是',false:'否'}" name="commend" value="true"></s:radio>
</td>
</tr>

<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">所屬性別</td>
<td>
<s:select list="@site.yueyiqiu.model.Sex@getValues()" name="sexrequest"></s:select>
</td>
</tr>


<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">上傳圖片</td>
<td>
<s:file name="file" id="file"></s:file>
</td>
</tr>


<tr>
<td width="105px" height="22px" bgcolor="#c6e8ff" align="right">商品說明</td>
<td>
<s:textarea name="description" cols="50" rows="6"></s:textarea>
</td>
</tr>
</table>
</div>

<div id="right_foot">

<s:submit type="image" src="%{#session.path}/images/ht_02_18.gif"></s:submit>
</div>

</s:form>


</div>
</body>
</html>