<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Successful</title>
    </head>
    <body>
    <h3>Welcome back <s:property value="#session.loggedUser.firstName" /> </h3>
	<s:form action="logout">
		<s:submit value="log out"></s:submit>
	</s:form>
    </body>
</html>
