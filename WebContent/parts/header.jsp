<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<header>
	Logged as:
	<s:a href="login.action">
		<s:property value="#session.loggedUser.firstName" />
		<s:property value="#session.loggedUser.lastName" />
	</s:a>
	(
	<s:a href="logout.action">logout</s:a>
	)
	<div style="float: right">
		<s:form action="searchFriends">
			<s:textfield name="searchField" />
			<s:submit value="search" />
		</s:form>
	</div>
</header>