<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link href="<%=path%>/css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>


<div id="right">

<div id="right_top">




<table border="1" width="693px" height="29px">

<tr>

<td width="50px">ID</td>
<td width="180px">商品名稱</td>
<td width="120px">所屬類別</td>
<td width="100px">採購價格</td>
<td width="100px">銷售價格</td>
<td width="70px">推薦</td>
<td width="70px">性別</td>
<td width="70px">編輯</td>
<td width="70px">刪除</td>


</tr>
</table>

</div>

<div id="right_mid">
<table width="693px" border="1">
<s:iterator value="pagemodel.list">

<tr>

<td width="50px"><s:property value="id"/></td>
<td width="180px">
<s:a action="product_edit" namespace="/admin/product">
<s:param name="id" value="id"></s:param>
<s:property value="name"/>
</s:a>

</td>
<td width="120px">
<s:property value="category.name"/>
</td>
<td width="100px">
<s:property value="basePrice"/>
</td>
<td width="100px">
<s:property value="salePrice"/>
</td>
<td width="70px">

<s:property value="commend"/>

</td>
<td width="70px">

<s:property value="sexrequest.name"/>

</td>


<td width="70px">

<s:a action="product_edit" namespace="/admin/product">

<s:param name="id" value="id"></s:param>
<img alt="" src="${path}/images/rz_15.gif">
</s:a>

</td>

<td width="70px">

<s:a action="product_del" namespace="/admin/product">

<s:param name="id" value="id"></s:param>
<img alt="" src="${path}/images/rz_17.gif">
</s:a>

</td>

</tr>

</s:iterator>
</table>
</div>


<div id="right_foot">

<s:property value="pid"/>

<s:url action="product_list" namespace="/admin/product" var="first">
<s:param name="pageNo" value="1"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>

<s:url action="product_list" namespace="/admin/product" var="previous">
<s:param name="pageNo" value="pagemodel.pageNo-1"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>

<s:url action="product_list" namespace="/admin/product" var="next">
<s:param name="pageNo" value="pagemodel.pageNo+1"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>

<s:url action="product_list" namespace="/admin/product" var="last">
<s:param name="pageNo" value="pagemodel.getLastPageNo"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>





<%@ include file="/pages/common/page.jsp"%>
</div>

</div>


</body>
</html>