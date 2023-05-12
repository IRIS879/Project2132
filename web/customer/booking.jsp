<%--
  Created by IntelliJ IDEA.
  User: TRY
  Date: 2023/3/31
  Time: 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Room Booking</title>
</head>
<body>
<h1>Room Booking</h1>
<form action="<%= request.getContextPath() %>/BookingServlet" method="post">
    <input type="hidden" name="room_id" value="<%= request.getParameter("room_id") %>">
    <input type="hidden" name="hotel_id" value="<%= request.getParameter("hotel_id") %>">
    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required /><br>
    <label for="sin">SIN:</label>
    <input type="text" name="sin" id="sin" required /><br>
    <label for="booking_date">Check-in Date:</label>
    <input type="date" name="booking_date" id="booking_date" required /><br>
    <label for="nights">Nights:</label>
    <input type="number" name="nights" id="nights" min="1" required /><br>
    <input type="submit" value="Book Room" />
</form>
</body>
</html>