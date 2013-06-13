<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<title>Spring MVC</title>   
	<script type="text/javascript" src="<c:url value='/js/jquery.json-2.2.min.js'/>"></script>   
	<script type="text/javascript">		
		   
		$(document).ready(function(){   
		
		      jQuery.ajax( {   
		        type : 'GET',   
		        contentType : 'application/json',   
		        url : '/wits/demo/ajax/user/list',   
		        dataType : 'json',   
		        success : function(data) {   
		          if (data && data.success == "true") {   
		            $('#info').html("共" + data.total + "条数据。<br/>");   
		            $.each(data.data, function(i, item) {   
		              $('#info').append("编号：" + item.id + "，姓名：" + item.name + "，年龄：" + item.age+"<br>");   
		            });   
		          }   
		        },   
		        error : function(e) {   
		          alert("error"+e);   
		        }   
		      });  
		       
		      $("#submit").click(function() {   
		        var jsonuserinfo = $.toJSON($('#form').serializeObject());   
		        alert(jsonuserinfo);   
		        jQuery.ajax( {   
		          type : 'POST',   
		          contentType : 'application/json',   
		          url : '/wits/demo/ajax/user/add',   
		          data : jsonuserinfo,   
		          dataType : 'json',   
		          success : function(data) {   
		             if (data && data.success == "true") {   
			            $('#info').html("共" + data.total + "条数据。<br/>");   
			            $.each(data.data, function(i, item) {   
			              $('#info').append("编号：" + item.id + "，姓名：" + item.name + "，年龄：" + item.age+"<br>");   
			            });
			             alert("新增成功！");      
			          }   		           
		          },   
		          error : function(data) {   
		            alert("error")   
		          }   
		        });   
		      });   
		    });  
		    
		    //将一个表单的数据返回成JSON对象   
			$.fn.serializeObject = function() {   
			  var o = {};   
			  var a = this.serializeArray();   
			  $.each(a, function() {   
			    if (o[this.name]) {   
			      if (!o[this.name].push) {   
			        o[this.name] = [ o[this.name] ];   
			      }   
			      o[this.name].push(this.value || '');   
			    } else {   
			      o[this.name] = this.value || '';   
			    }   
			  });   
			  return o;   
			};   
	</script>
</head>   
<body>   
<div id="info"></div>   
<form action="add" method="post" id="form">   
编号：<input type="text" name="id"/>   
姓名：<input type="text" name="name"/>   
年龄：<input type="text" name="age"/> 
性别: <select name="sex">
          	<option value="1">男</option>
          	<option value="2">女</option>
     </select>
 密码: <input name="password">      
 地址:<input name="address"/>
          
<input type="button" value="提交" id="submit"/>   
</form>   
<hr><br>
<a href="<c:url value='/demo'/>">返回</a>
<hr><br>
</body>   
</html>  