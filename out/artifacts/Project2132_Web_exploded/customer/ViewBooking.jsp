<%@ page import="entity.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TRY
  Date: 2023/3/31
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Booking</title>
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
    <% for (Book book : (List<Book>) request.getAttribute("bookings")) { %>
    <tr>
        <td><%= book.getHotelId() %></td>
        <td><%= book.getCustomerName() %></td>
        <td><%= book.getSinNumber() %></td>
        <td><%= book.getRoomId() %></td>
        <td><%= book.getBookingDate() %></td>
        <td><%= book.getNights() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>