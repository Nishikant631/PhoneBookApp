<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style='color-red;text-align:center'>PhoneBookApp</h1>
<p><font color="green">${SucessMsg}</font>
</p>
<p><font color="red">${ErrorMsg}</font>
</p>
<form:form action="savecontact" modelAttribute="ContactDTO" method="POST">
<table>
<td><form:hidden path="contactId"/></td>
<tr>
<td>Contact Name :: </td>
<td><form:input path="contactName"/></td>
</tr>
<tr>
<td>contact Email :: </td>
<td><form:input path="contactEmail"/></td>
</tr>
<tr>
<td>contact Number :: </td>
<td><form:input path="contactNumber"/></td>
</tr>
<tr>
<td><input type="reset" value="Reset"></td>
<td><input type="submit" value="Submit"></td>
</tr>
</table>
</form:form>

<a href="ViewContacts">All Records are displayed</a>
</body>
</html>