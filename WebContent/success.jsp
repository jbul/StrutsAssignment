<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Successful</title>
    </head>
    <body>
        <h3>Thank you for registering <s:property value="person.firstName"/>! </h3>
    <s:a href="index.jsp" >Return home page to log in</s:a>
<%--     <s:action name="index">Return home page</s:action> --%>
    </body>
</html>
