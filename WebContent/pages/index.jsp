<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>

</head>
 
<body>

<%@include file="/pages/common/head.jsp" %>

<br/>

<div id="box">


<div id="left">
<div id="left_s01">
<s:a action="customer_login" namespace="/customer"><img alt="" src="<%=path%>/images/index_23.gif"></s:a>
<s:a action="customer_reg" namespace="/customer"><img alt="" src="<%=path%>/images/index_26.gif"></s:a>
<img alt="" src="<%=path%>/images/index_27.gif">
</div>
<div  id="left_s02">
<img alt="" src="<%=path%>/images/index_25.gif">
</div>

<br/>
<br/>
<br/>

<s:iterator value="categories">
<div id="left_x">

<div id="tableleft">
<table id="mytable" style="vertical-align: middle;">

<tr>

<td class="wordtitle" style="width: 22px"><s:property value="name"/></td>
<td style="padding-bottom: 3px;">
<div id="innerleft">

<s:if test="!children.isEmpty">

<s:iterator value="children">

<div id="deepleft">

<b style="color: #990000;"><s:property value="name"/></b>

<s:if test="!children.isEmpty">

<span>

<s:iterator value="children">

<s:a action="product_getByCategoryId" namespace="/product" >
<s:param name="category.id" value="id"></s:param>
<s:property value="name"/>

</s:a>

</s:iterator>


</span>


</s:if>

</div>

</s:iterator>


</s:if>


</div>
</td>


</tr>
</table>
</div>


</div>

</s:iterator>


</div>


<div id="right">

<div id="div_up">

<table>

<tr>
<td>
<img alt="" src="<%=path%>/images/index_28.gif">
</td>
</tr>
<tr>
<td valign="top">
<s:action name="product_findByClick" namespace="/product" executeResult="true"></s:action>
</td>
</tr>


</table>



</div>


<div id="div_middle">

<table>

<tr>
<td>
<img alt="" src="<%=path%>/images/08.gif">
</td>
</tr>
<tr>
<td valign="top">
<s:action name="product_findByCommend" namespace="/product" executeResult="true"></s:action>
</td>
</tr>


</table>


</div>



<div id="div_bottom">


<table>

<tr>
<td>
<img alt="" src="<%=path%>/images/index_47.gif">
</td>
</tr>
<tr>
<td valign="top">
<s:action name="product_findBySellCount" namespace="/product" executeResult="true"></s:action>
</td>
</tr>


</table>


</div>


</div>


</div>

</body>
</html>