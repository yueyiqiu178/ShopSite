<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/common/common_admin.jsp"%>


<div id="top">
<div id="toptao">
<img src="${path}/images/flower.gif"/>
您好!!
<s:property value="#session.admin.username"/>!
<s:a action="user_logout" namespace="/admin/user"><img src="<%=path%>/images/ht_02_02.gif"/></s:a>
</div>
</div>
