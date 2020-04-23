<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
 <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
  rel="stylesheet" />
 <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
 <div class="container">
 
	<form:form method="post" modelAttribute="userProfile"  action="/create-user">
		<form:hidden path="id" />
		<form:hidden path="userCredId" /> 
		<fieldset class="form-group">
			<form:label path="address">Address: </form:label>
			<form:input path="address" type="text" class="form-control"
				required="required" />
			<form:errors path="address" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="phoneNumber">Phone Number</form:label>
			<form:input path="phoneNumber" type="text" class="form-control"
				required="phoneNumber" />
			<form:errors path="phoneNumber" cssClass="text-warning" />
		</fieldset>

		<button type="submit"  href="./create-user" class="btn btn-success">Save</button>
	</form:form>

	
	
</div>
</body>
</html>