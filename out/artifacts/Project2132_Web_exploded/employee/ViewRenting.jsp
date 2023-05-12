<%--
  Created by IntelliJ IDEA.
  User: TRY
  Date: 2023/3/31
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="entity.Rent" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Rent</title>
</head>
<body>
<table>
    <tr>
        <th>Hotel ID</th>
        <th>Customer Name</th>
        <th>SIN</th>
        <th>Room ID</th>
        <th>Booking Date</th>
        <th>Nights</th>
    </tr>
    <% for (Rent rent : (List<Rent>) request.getAttribute("rents")) { %>
    <tr>
        <td><%= rent.getHotelId() %></td>
        <td><%= rent.getCustomerName() %></td>
        <td><%= rent.getSinNumber() %></td>
        <td><%= rent.getRoomId() %></td>
        <td><%= rent.getRentalDate() %></td>
        <td><%= rent.getNights() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>