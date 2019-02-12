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



<s:form action="product_save" namespace="/admin/product" method="post" enctype="multipart/form-data">

<s:hidden name="product.id"></s:hidden>



<div>
<div>
<img alt="" src="${path}/images/blue.gif">
<span>編輯商品</span>
</div>
<div>
<table>
<tr>
<td>
商品名稱
</td>
<td>
<s:textfield name="product.name"></s:textfield>
</td>
</tr>

<tr>
<td>
選擇類別
</td>
<td>
<s:select list="map" name="product.category.id" value="product.category.id"></s:select>
</td>
</tr>

<tr>
<td>
採購價格
</td>
<td>
<s:textfield name="product.basePrice"></s:textfield>
</td>
</tr>

<tr>
<td>
市場價格
</td>
<td>
<s:textfield name="product.marketPrice"></s:textfield>
</td>
</tr>

<tr>
<td>
銷售價格
</td>
<td>
<s:textfield name="product.salePrice"></s:textfield>
</td>
</tr>

<tr>
<td>
是否為推薦
</td>
<td>
<s:radio list="#{true:'是',false:'否'}" name="product.commend" value="product.commend"></s:radio>
</td>
</tr>

<tr>
<td>
所屬性別
</td>
<td>
<s:select list="@site.yueyiqiu.model.Sex@getValues()" name="product.sexrequest" value="product.sexrequest"></s:select>
</td>
</tr>

<tr>
<td>
上傳圖片
</td>
<td>
<s:file name="file" id="file"></s:file>
</td>
</tr>

<tr>
<td>
商品說明
</td>
<td>
<s:textarea name="product.description" cols="50" rows="6"></s:textarea>
</td>
</tr>
</table>
</div>
<div>
<s:submit type="image" src="%{#session.path}/images/ht_02_18.gif"></s:submit>
</div>
</div>
</s:form>




</body>
</html>