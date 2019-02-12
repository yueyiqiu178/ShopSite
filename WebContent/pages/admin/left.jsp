<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>


<s:url var="category_add" action="category_add" namespace="/admin/product"></s:url>
<s:url var="category_list" action="category_list" namespace="/admin/product"></s:url>

<s:url var="product_add" action="product_add" namespace="/admin/product"></s:url>
<s:url var="product_list" action="product_list" namespace="/admin/product"></s:url>

<s:url var="order_list" action="order_list" namespace="/admin/product"></s:url>
<s:url var="order_query" action="order_query" namespace="/admin/product"></s:url>


<div id="left">

<div id="lefttop"></div>


<div id="leftmid">
<div>類別管理</div>
<div><a href="${category_add}" target="abc">添加類別</a></div>
<div><a href="${category_list}" target="abc">查看所有類別</a></div>
<div>商品管理</div>
<div><a href="${product_add}" target="abc">添加商品</a></div>
<div><a href="${product_list}" target="abc">查看所有商品</a></div>
<div>訂單管理</div>
<div><a href="${order_list}" target="abc">查看訂單</a></div>
<div><a href="${order_query}" target="abc">訂單查詢</a></div>

</div>
</div>