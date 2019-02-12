<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link href="<%=path%>/css/style_index.css" type="text/css" rel="stylesheet" />

</head>
<body>

<div id="box">

<div id="dark">

<s:a action="cart_list" namespace="/product"><img alt="" src="<%=path%>/images/index_03.gif">我的購物車</s:a>|
<s:a action="order_findByCustomer" namespace="/product">我的訂單</s:a>|
<s:a href="%{#session.path}/pages/admin/user/user_login.jsp">後臺管理</s:a>


<s:if test="#session.customer!=null">

歡迎:<s:property value="#session.customer.realname" />

<s:a action="customer_logout" namespace="/customer">退出</s:a>

</s:if>

</div>

<div id="logo">

<s:form action="product_findByName" namespace="/product" theme="simple">

<div id="sou">
<s:textfield name="searchname"></s:textfield>
<div style="">
<b>熱門商品</b>
<s:a action="product_getByCategoryId" namespace="/product">
<s:param name="category.id" value="330"></s:param>
軟體</s:a>

</div>
</div>
<div id="sou_zi">

<s:submit type="image" src="%{#session.path}/images/index_09.gif" value="搜索"></s:submit>

</div>
</s:form>


<div id="sou_zi01">

進階搜尋<br/>
使用幫助
</div>


</div>




<div id="menu">
<s:a action="index" namespace="/"><img alt="" src="<%=path%>/images/index_12.gif"></s:a>
<s:a action="product_findNewProduct" namespace="/product"><img alt="" src="<%=path%>/images/index_13.gif"></s:a>
<s:a action="product_findSellProduct" namespace="/product"><img alt="" src="<%=path%>/images/index_14.gif"></s:a>
<s:a action="product_findCommendProduct" namespace="/product"><img alt="" src="<%=path%>/images/index_15.gif"></s:a>
<s:a action="product_findEnjoyProduct" namespace="/product"><img alt="" src="<%=path%>/images/index_16.gif"></s:a>
<img alt="" src="<%=path%>/images/index_19.gif">
</div>
</div>

</body>
</html>