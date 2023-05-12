<%--
  Created by IntelliJ IDEA.
  User: TRY
  Date: 2023/3/31
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rooms</title>
</head>
<body>
<h1>Rooms List</h1>
<table border="1">
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
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="entity.room" %>
    <% ArrayList<room> roomList = (ArrayList<room>) request.getAttribute("roomList"); %>
    <% for (room r : roomList) { %>
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
        <td><a href="<%= request.getContextPath() %>/employee/renting.jsp?room_id=<%= r.getRoom_id() %>&hotel_id=<%= r.getHotelId() %>">Rent Room</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>