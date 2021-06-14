<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
		<form action="${pageContext.request.contextPath}/operation" method="post">
		Username: <input type="text" name="name" required="required"/><br/>
		Email: <input type="email" name="email" required="required"/><br/>
		Password: <input type="password" name="password" required="required"/><br/>
		Type: <label for="user">User</label><input type="radio" name="type" checked value="user"/>
		<label for="org">Organisation</label><input type="radio" name="type" value="org"/><br/>
		<input type="hidden" name="form" value="addUserOperation">
		<input type="submit" value="Add User">
		</form>
		</div>
	</div>
</div>
</body>
</html>