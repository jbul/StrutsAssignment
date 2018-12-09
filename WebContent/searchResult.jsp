<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<s:include value="parts/header.jsp" />
	<section>
		<h3>Search Result</h3>
		<s:iterator value="pers">
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