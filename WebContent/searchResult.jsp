<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h3>Search Result</h3>
	<s:iterator value="pers">
		<s:a href="viewUser.action?email=%{email}">
			<s:property value="firstName" />
			<s:property value="lastName" />
		</s:a>
	</s:iterator>
</body>
</html>