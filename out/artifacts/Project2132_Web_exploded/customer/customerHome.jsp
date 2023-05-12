<%@ page import="jakarta.servlet.annotation.WebServlet" %><%--
  Created by IntelliJ IDEA.
  User: TRY
  Date: 2023/3/29
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hotel Search</title>
</head>
<body>
<h1>Hello, <%= request.getAttribute("name") %>!</h1>
<h1>Hotel Search</h1>
<form action="SearchHotel" method="get">
    <select name="property">
        <option value="id">Hotel ID</option>
        <option value="chain">Hotel Chain</option>
        <option value="address">Hotel Address</option>
        <option value="category">Category</option>
        <option value="email">Email</option>
        <option value="phone">Phone</option>
        <option value="num_rooms">Number of Rooms</option>
    </select>
    <input type="text" name="value">
    <input type="submit" value="Search">
</form>
<h1>Booking View:</h1>
<form <%= request.getContextPath() %> action="ViewBooking" method="post">
    <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
    <input type="submit" value="ViewBooking">
</form>

</body>
</html>