<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<script type="text/javascript">

function closewindow(){

	if(window.opener){

		window.opener.location.reload(true);
		window.close();

		}
}


function clock(){

	i=i-1;
	if(i>0){
		setTimeout("clock();",1000);
		}	
	else{
		closewindow();
		}
}

var i=3;

clock();

</script>
</head>
<body>
<p style="font-size: 14px;color: red;">��s���\</p>
<div style="font-size: 12px;">
�������N�b�T�������
</div>
<input type="button" value="��������" onclick="closewindow()"/>
</body>
</html>