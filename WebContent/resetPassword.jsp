<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
	<s:form action="reset">
		<s:label for="person.email" value="Email address"/><s:textfield name="person.email" value="%{#parameters.email}" />
		<s:label for="person.password" value="New password"/><s:textfield name="person.password" />
		<s:submit value="Reset password" />
	</s:form>

</body>
</html>