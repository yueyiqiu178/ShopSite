<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>

<div style="width: 195px;">
<s:iterator value="pagemodel.list">
<div>
<s:a action="product_select" name="/product">
<s:param value="id" name="id"></s:param>
<img width="90px" height="90px" src="<%=path%>/upload/<s:property value="uploadfile.path"/>">
<p style="width: 180px"><s:property value="name"/></p>
</s:a>
</div>
</s:iterator>
</div>
</body>
</html>