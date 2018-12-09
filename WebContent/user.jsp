<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Successful</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<s:include value="parts/header.jsp" />
	<section>
		<h3>Search Friends</h3>
		<s:form action="searchFriends">
			<s:textfield name="searchField" />
			<s:submit value="search" />
		</s:form>
		<s:form action="viewAllUsers">
			<s:submit value="View all members"></s:submit>
		</s:form>
		<h3>Post something</h3>
		<s:form action="post">
			<s:textfield name="post.message" maxlength="255" />
			<s:hidden name="post.sender.email"
				value="%{#session['loggedUser'].email}" />
			<s:hidden name="post.receiver.email"
				value="%{#session['loggedUser'].email}" />
			<s:hidden name="isUser" value="true" />
			<s:submit value="Send"></s:submit>
		</s:form>
		<h3>Your wall</h3>
		<s:iterator value="#session.loggedUser.wall">
			<div class="post">
				<s:a href="viewUser.action?email=%{sender.email}">
					<s:property value="sender.firstName" />
					<s:property value="sender.lastName" />
				</s:a>
				<br />
				<s:property value="message" />
			</div>
		</s:iterator>

		<h3>Your friends</h3>
		<s:iterator value="#session.loggedUser.friends">
			<div>
				<s:a href="viewUser.action?email=%{email}">
					<s:property value="firstName" />
					<s:property value="lastName" />
				</s:a>
			</div>
		</s:iterator>
	</section>
</body>
</html>
