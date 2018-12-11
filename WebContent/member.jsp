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
	
	<s:include value="parts/header.jsp" />
	<h2>
	<section>
		<s:property value="#session.personView.firstName" />
		<s:property value="#session.personView.lastName" />

		<s:form action="addFriend">
			<s:set name="isFriend" value="isFriend"/>
			<s:if test="%{#isFriend==false}">
				<s:submit value="Add"></s:submit>
			</s:if>
			<s:elseif test="%{#isFriend==true}">
				<s:submit value="Add" disabled="true"></s:submit>
			</s:elseif>

		</s:form>
		</h2>
		<h3>Send a message</h3>
		<s:form action="post">
			<s:textfield name="post.message" maxlength="255" />
			<s:hidden name="post.sender.email"
				value="%{#session['loggedUser'].email}" />
			<s:hidden name="post.receiver.email"
				value="%{#session['personView'].email}" />
			<s:submit value="Send"></s:submit>
		</s:form>
		<h3>Wall</h3>
		<s:iterator value="#session.personView.wall">
			<div class="post">
				<s:a href="viewUser.action?email=%{sender.email}">
					<s:property value="sender.firstName" />
					<s:property value="sender.lastName" />
				</s:a>
				<br />
				<s:property value="message" />
			</div>
		</s:iterator>

		<h3>Friends</h3>
		<s:iterator value="#session.personView.friends">
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