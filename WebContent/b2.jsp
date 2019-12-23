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
			$("#btn1").click(function (){
				$.ajax({
					//提交给服务器的处理者[请求地址]
					url:"MyServlet3",
					//请求方式
					type:"post",
					//请求的媒体类型[编码]
	           		//contentType: "application/json;charset=UTF-8",
	           		//数据[json字符串]
	           		//data:JSON.stringify(list),
	           		data:{deptid:$("#txtDeptId").val()},
	           		//请求成功
	                success : function(result) {
	                	var result=eval("("+result+")");
	                	$("#mydiv").html(result[0].name);
	                },
	                //请求失败，包含具体的错误信息
	                error : function(e){
	                	$("#mydiv").html(e.status+"<br>"+e.responseText);
	                }
				});
			});
		});
	</script>

</head>
<body>
	<p>输入部门编号：<input type="text" id="txtDeptId" />
	<input type="button" id="btn1" value="异步提交给服务器" />
	<hr>
	<div id="mydiv"></div>
</body>
</html>