<%@ page import="entity.hotel" %><%--
  Created by IntelliJ IDEA.
  User: TRY
  Date: 2023/3/30
  Time: 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel Search Results</title>
</head>
<body>
<h1>Search Results</h1>
<p>You searched for hotels where <strong>${property}</strong> contains <strong>${value}</strong>.</p>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Chain</th>
        <th>Address</th>
        <th>Category</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Number of Rooms</th>
        <th>View Details</th>
    </tr>
    </thead>
    <tbody>
    <%
        java.util.List hotels = (java.util.List)request.getAttribute("hotels");
        for (Object hotel : hotels) {
            entity.hotel h = (entity.hotel) hotel;
    %>
    <tr>
        <td><%= h.getId() %></td>
        <td><%= h.getChain() %></td>
        <td><%= h.getAddress() %></td>
        <td><%= h.getCategory() %></td>
        <td><%= h.getEmail() %></td>
        <td><%= h.getPhone() %></td>
        <td><%= h.getNumRooms() %></td>
        <td>
            <a href="<%= request.getContextPath() %>/SearchRoom?id=<%= h.getId() %>">
                GotoHotels
            </a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
<%
    out.println("<h2>Debug Information:</h2>");
    out.println("<ul>");
    out.println("<li>Property: " + request.getAttribute("property") + "</li>");
    out.println("<li>Value: " + request.getAttribute("value") + "</li>");
    out.println("<li>hotels: " + request.getAttribute("hotels") + "</li>");
    out.println("</ul>");
%>
</body>
</html>