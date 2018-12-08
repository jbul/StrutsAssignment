<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:property value="#session.personView.firstName" />
	<s:property value="#session.personView.lastName" />
	<s:form action="addFriend">
		<s:submit value="Add"></s:submit>
	</s:form>
	<h3>Wall</h3>
	<s:iterator value="#session.personView.wall">
		<s:property value="sender" />
		<s:property value="message" />
	</s:iterator>
	<h3>Friends</h3>
	<s:iterator value="#session.personView.friends">
		<div>
			<s:property value="firstName" />
			<s:property value="lastName" />
		</div>
	</s:iterator>
</body>
</html>