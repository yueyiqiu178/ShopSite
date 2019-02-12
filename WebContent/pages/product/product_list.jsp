<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<style type="text/css">

li{

	list-style: none;
	border-bottom: 1px dashed #99CC66;
	margin-bottom: 20px;
}

</style>
</head>
<body>
<%@include file="/pages/common/head.jsp" %>
新品上市
<div id="box">
<div id="right">
<!-- 商品排行 -->
 <div id="rank">
 <table>
 <tr>
 <td>
 <img alt="" src="<%=path%>/images/index_28.gif">
 </td>
 </tr>
  
 <tr>
 <td>
<s:action name="product_findByClick" namespace="/product" executeResult="true"></s:action>
 </td>
 </tr>
 </table>
 </div>
 <!-- 推薦商品 -->
 <div id="commend">
 <table>
 <tr>
 <td>
 <img alt="" src="<%=path%>/images/08.gif">
 </td>
 </tr>

 <tr>
 <td>
 <s:action name="product_findByCommend" namespace="/product" executeResult="true"></s:action>
 </td>
 </tr>
 </table>
 </div>
 <!-- 熱銷商品 -->
 <div id="hot">
 <table>
 <tr>
 <td>
 <img alt="" src="<%=path%>/images/08.gif">
 </td>
 </tr>

 <tr>
 <td>
 <s:action name="product_findBySellCount" namespace="/product" executeResult="true"></s:action>
 </td>
 </tr>
 </table>
 </div>

</div>


<div id="right_sp">

<div id="zitao">
<img width="676" height="31" alt="" src="../images/<s:property default="02.gif" value="image.url"/>">
</div>
<div id="product">
<s:if test="pagemodel!=null&&pagemodel.list.size()>0">
<s:iterator value="pagemodel.list">
<ul>
  <li>
  <table cellpadding="0" cellspacing="0" width="100%">
  <tr>
  <td rowspan="5" width="160px">
  <s:a action="product_select" namespace="/product">
  <s:param name="id" value="id"></s:param>
  <img alt="" width="150" height="150" src="<%=path%>/upload/<s:property value="uploadfile.path"/>">
  </s:a>
  
 
  </td>
  </tr>
  <tr bgcolor="#f2eec9">
  <td width="90px" align="right">
  商品名稱:
  </td>
  <td>
  <s:a action="product_select" namespace="/product">
  <s:param name="id" value="id"></s:param>
 <s:property value="name"/>
  </s:a>
  </td>
  </tr>
  <tr>
  <td align="right">
  市場價格:
  </td>
  <td>
  <font style="">
  <s:property value="marketPrice"/>
  </font>
  </td>
  </tr>
  <tr bgcolor="#f2eec9">
  <td align="right">
  天下淘價格:
  </td>
  <td>
  <s:property value="salePrice"/>
  <s:if test="salePrice<=marketPrice">
  <font color="red">節省:<s:property value="marketPrice-salePrice"/></font>
  </s:if>
  </td>
  </tr>
  <tr>
  <td colspan="2">
  <s:a action="product_select" namespace="/product">
  <s:param name="id" value="id"></s:param>
  <img alt="" src="<%=path%>/images/gm_06.gif">
  </s:a>
  </td>
  </tr>
  </table>
  </li>
</ul>
</s:iterator>

<s:url var="first" action="product_findNewProduct" namespace="/product">
<s:param name="pageNo" value="1"></s:param>


</s:url>
<s:url var="next" action="product_findNewProduct" namespace="/product">
<s:param name="pageNo" value="pagemodel.pageNo+1"></s:param>


</s:url>
<s:url var="previous" action="product_findNewProduct" namespace="/product">
<s:param name="pageNo" value="pagemodel.pageNo-1"></s:param>


</s:url>
<s:url var="last" action="product_findNewProduct" namespace="/product">
<s:param name="pageNo" value="pagemodel.getLastPageNo"></s:param>


</s:url>

<%@ include file="/pages/common/page.jsp"%>
</s:if>
<s:else>
對不起,沒有找到商品資訊
<s:a action="index">返回主頁</s:a>
</s:else>
</div>

</div>
</div>
</body>
</html>