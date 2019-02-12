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

<s:form action="category_save" namespace="/admin/product">


<s:hidden name="pid"></s:hidden>
<s:hidden name="level"></s:hidden>

<div>
<div>
<img alt="" src="${path}/images/blue.gif">
<span>新增商品類別</span>
</div>
<div>
<table>

<tr>

<td colspan="2">
<span style="color:red;"><s:fielderror></s:fielderror></span>
</td>

</tr>
<tr>

<td>類別名稱</td>
<td><s:textfield name="name"></s:textfield></td>

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