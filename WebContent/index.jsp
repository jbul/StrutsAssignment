<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In or Register</title>
</head>
<body>

	<s:property value="returnMessage" />

	<h3>Log in</h3>

	<s:form action="login">
		<s:textfield name="person.email" label="Email"></s:textfield>
		<s:password name="person.password" label="Password"></s:password>

		<s:submit value="log in"></s:submit>
	</s:form>
	<s:a href="sendResetPassword.jsp">forgot password ?</s:a>
	<h3>Register</h3>

	<s:form action="register">
		<s:textfield name="person.firstName" label="Fisrt Name"></s:textfield>
		<s:textfield name="person.lastName" label="Last Name"></s:textfield>
		<s:textfield name="person.email" label="Email"></s:textfield>
		<s:password name="person.password" label="Password"></s:password>
		<s:radio list="{'male','female'}" name="person.gender" label="Gender"></s:radio>

		<s:submit value="register"></s:submit>
	</s:form>
</body>
</html>
