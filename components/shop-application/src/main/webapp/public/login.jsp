<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
	href='/resources/core/css/bootstrap.min.css' 
	rel="stylesheet" />
</head>

<body>
	

	<c:if test="${not empty error}">
		<div>${error}</div>
	</c:if>
	<c:if test="${not empty message}">
		<div>${message}</div>
	</c:if>


	<form action='/login' " 
		method='POST'>
		
		<br><br>

		<table align="center" bgcolor="0099CC" style="background: white;clear: both;border-spacing:14px;border-collapse:separate;border: 1px solid black;">
			<tr>
			<td colspan='2' align="center"><h3>Login to proceed</h3><br>Please enter your user name and password for login.</td>
			
			</tr>
			
			<tr>
				<td>User:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>

			<!-- if this is login for update, ignore remember me check -->
			<c:if test="${empty loginUpdate}">
				<tr>
					<td></td>
					<td> <input type='checkbox' name="remember-me-param"/>Remember me next time.</td>
				</tr>
			</c:if>

			<tr>
				<td colspan='2' align="center"><input name="submit" type="submit"
					value="submit" /></td>
			</tr>

		</table>


		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>
<script src='/resources/js/pages/login.js'></script>