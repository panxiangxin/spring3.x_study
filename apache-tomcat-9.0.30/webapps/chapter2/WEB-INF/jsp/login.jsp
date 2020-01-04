<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>宝宝淘论坛登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63999",secure:"64226"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/chapter2/WebRoot/WEB-INF/jsp/login.jsp">
    <c:if test="${!empty error}">
    	<font color="red"><c:out value="${error}" /></font>
    </c:if>
    <form action="<c:url value="/loginCheck.html"/>" method="post" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/chapter2/WebRoot/WEB-INF/jsp/login.jsp">
    	用户名：
    	<input type="text" name="userName">
    	<br>
    	密码：
    	<input type="password" name="password">
    	<br>
    	<input type="submit" value="登录">
    	<input type="reset" value="重置">
    </form>
  </body>
</html>
