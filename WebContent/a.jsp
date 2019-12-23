<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<script src="/js/jquery-1.9.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#customers").change(function (){
				$.ajax({
					type:"POST",
				    url:"MyServlet2",
				    data:{id:$("#customers").val()},
				    dataType:"text",
				    success:function(rs){
				    	$("#info").html(rs);
				    }
				});
			});
		});
	</script>
</head>
<body>
	<p>请选择一位客户：
	<select id="customers">
		<option value="1001">1001</option>
		<option value="1002">1002</option>
		<option value="1003">1003</option>
		<option value="1004">1004</option>
	</select>
	<div id="info">客户信息将在此处列出 ...</div>
</body>
</html>