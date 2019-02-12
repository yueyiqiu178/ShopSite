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


<table border="0" width="693" height="29" class="word01">

<tr>

<td width="50">ID</td>
<td width="150">類別名稱</td>
<td width="150">子類別</td>
<td width="100">添加子類別</td>
<td width="100">所屬父類</td>
<td width="70">編輯</td>
<td width="70">刪除</td>


</tr>
</table>

</div>


<div id="right_mid">
<div id="tao">
<table width="100%">
<s:iterator value="pagemodel.list">

<tr>

<td width="50px" height="27px"><s:property value="id"/></td>
<td width="150px">
<s:a action="category_add" namespace="/admin/product">
<s:param name="pid" value="id"></s:param>
<s:property value="name"/>
</s:a>
</td>
<td width="150px">
<s:if test="children==null||children.isEmpty">
沒有子類別
</s:if>
<s:else>
<s:a action="category_list" namespace="/admin/product">
<s:param name="pid" value="id"></s:param>
有<s:property value="children.size"/>個子類別
</s:a>
</s:else>

</td>
<td width="100px">
<s:a action="category_add" namespace="/admin/product">
<s:param name="pid" value="id"></s:param>
添加
</s:a>
</td>
<td width="100px">
<s:if test="parent.name!=null">
<s:property value="parent.name"/>
</s:if>
<s:else>
無
</s:else>
</td>
<td width="70px">

<s:a action="category_edit" namespace="/admin/product">
<s:param name="id" value="id"></s:param>
<img alt="" src="${path}/images/rz_15.gif">
</s:a>

</td>
<td width="70px">

<s:a action="category_del" namespace="/admin/product">
<s:param name="id" value="id"></s:param>
<img alt="" src="${path}/images/rz_17.gif">
</s:a>

</td>


</tr>



</s:iterator>
</table>
</div>
</div>


<div id="right_foot">


<s:url action="category_list" namespace="/admin/product" var="first">
<s:param name="pageNo" value="1"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>

<s:url action="category_list" namespace="/admin/product" var="previous">
<s:param name="pageNo" value="pagemodel.pageNo-1"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>

<s:url action="category_list" namespace="/admin/product" var="next">
<s:param name="pageNo" value="pagemodel.pageNo+1"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>

<s:url action="category_list" namespace="/admin/product" var="last">
<s:param name="pageNo" value="pagemodel.getLastPageNo"></s:param>
<s:param name="pid" value="pid"></s:param>
</s:url>





<%@ include file="/pages/common/page.jsp"%>
</div>

</div>

</body>
</html>