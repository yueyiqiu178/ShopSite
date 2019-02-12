<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div>

<s:if test="pagemodel.pageNo>1">
<a href="${first}">首頁</a><a href="${previous}">上一頁</a>
</s:if>
<s:else>
首頁 上一頁
</s:else>

<span style="color:red;">[<s:property value="pagemodel.pageNo"/>]</span>

<s:if test="pagemodel.pageNo<pagemodel.LastPageNo">
<a href="${next}">下一頁</a><a href="${last}"></a>
</s:if>
<s:else>
下一頁 頁尾
</s:else>

</div>