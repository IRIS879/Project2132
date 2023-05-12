<%--
  Created by IntelliJ IDEA.
  User: TRY
  Date: 2023/3/30
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Room List</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Hotel ID</th>
        <th>Room ID</th>
        <th>Price</th>
        <th>Amenities</th>
        <th>Capacity</th>
        <th>Sea View</th>
        <th>Mountain View</th>
        <th>Can Be Extended</th>
        <th>Problems</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        java.util.List roomList = (java.util.List)request.getAttribute("roomList");
        for (Object room : roomList) {
                entity.room r = (entity.room) room;
    %>
    <tr>
        <td><%= r.getHotelId() %></td>
        <td><%= r.getRoom_id() %></td>
        <td><%= r.getPrice() %></td>
        <td><%= r.getAmenities() %></td>
        <td><%= r.getCapacity() %></td>
        <td><%= r.hasSeaView() %></td>
        <td><%= r.hasMountainView() %></td>
        <td><%= r.canBeExtended() %></td>
        <td><%= r.getProblems() %></td>
        <td><a href="<%= request.getContextPath() %>/customer/booking.jsp?room_id=<%= r.getRoom_id() %>&hotel_id=<%= r.getHotelId() %>">Book Room</a></td>

    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>