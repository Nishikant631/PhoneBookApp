<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="jquery.dataTables.js"></script>
<script type="text/javascript" src="dataTables.numericComma.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#example').dataTable( {
            "columnDefs": [
                { "type": "numeric-comma", targets: 3 }
            ]
        } );
    } );

function deleteConfirm(){
	return confirm("Are you sure,you want to delete")
	
}

//Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='registration']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      contactName: {
    	  required:true,
    	  minlength: 5
    	  maxlength:10
      }
      
      contactEmail: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        contactEmail: true
      },
      contactNumber:{
    	  required:true,
    	  contactNumber:true
      }
      
    },
    // Specify validation error messages
    messages: {
    	contactName: "Please enter your name",
      
      contactEmail: "Please enter a email address"
      contactNumber:"please enter your 10 digits phone number"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});

</script>

</head>
<body>
<table border="1"  color = "red" id="example">
<thead>
<tr>
<th>Sno</th>
<th>Name</th>
<th>Email</th>
<th>PhoneNumber</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${contactlist}" var="c" varStatus="index">
<tr>
<td>${index.count+1}</td>
<td>${c.contactName}</td>
<td>${c.contactEmail}</td>
<td>${c.contactNumber}</td>
<td><a href="editContact?contactId=${c.contactId}">Edit</a>
<td><a href="deleteContact?contactId=${c.contactId}"onclick="deleteConfirm()">Delete</a>
<tr>
</c:forEach>
</tbody>
</table>
<a href="phonebook">home</a>
</body>
</html>