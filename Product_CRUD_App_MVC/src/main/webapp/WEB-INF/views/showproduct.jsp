<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border='2'>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Quantity</th>
			<th>Product Price</th>
			<th>mfg date</th>
			<th>Action</th>
		</tr>

		<c:forEach var="prod" items="${plist}">
			<tr>
				<td>${prod.pid}</td>
				<td>${prod.pname}</td>
				<td>${prod.qty}</td>
				<td>${prod.price}</td>
				<td>${prod.mfgdate}</td>
				<td> <a href="deleteproduct/${prod.pid}">delete</a> / <a href="editproduct/${prod.pid}">edit</a> </td>
			</tr>
		</c:forEach>

	</table>
	
	<h3> <a href="addProduct">Add New Product</a> </h3>
	
</body>
</html>