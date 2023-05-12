package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.room;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/SearchRoom"})
public class SearchRoom extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";
    // Handles GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the hotel ID from the request parameters
        int hotel_id = Integer.parseInt(request.getParameter("id"));
        // Create a list of rooms to hold the results
        List<room> roomList = new ArrayList<room>();
        // Establish a database connection
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Prepare a SQL statement to select all rooms with the given hotel ID
            String query = "SELECT * FROM room WHERE hotel_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, hotel_id);
            ResultSet rs = ps.executeQuery();
            // Iterate through the result set and add each room to the list
            while (rs.next()) {
                room room = new room();
                room.setHotelId(rs.getInt("hotel_id"));
                room.setRoom_id(rs.getInt("room_id"));
                room.setPrice(rs.getDouble("price"));
                room.setAmenities(rs.getString("amenities"));
                room.setCapacity(rs.getString("capacity"));
                room.setHasSeaView(rs.getBoolean("has_sea_view"));
                room.setHasMountainView(rs.getBoolean("has_mountain_view"));
                room.setCanBeExtended(rs.getBoolean("can_be_extended"));
                room.setProblems(rs.getString("problems"));
                System.out.println(room);
                roomList.add(room);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Set the list of rooms as an attribute of the request
        request.setAttribute("roomList", roomList);
        // Forward the request to the hotelhome.jsp page for display
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/hotelhome.jsp");
        dispatcher.forward(request, response);
    }
    // Handles POST requests
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
