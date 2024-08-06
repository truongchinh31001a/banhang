<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Electronic Store</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Category</th>
            <th>Stock</th>
            <th>Image</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productId}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.category}</td>
                <td>${product.stockQuantity}</td>
                <td><img src="${product.imageUrl}" alt="${product.name}" width="100"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
