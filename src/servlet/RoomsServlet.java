package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.room;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/rooms")
public class RoomsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotelIdParam = request.getParameter("hotel_id");
        Integer hotel_id = hotelIdParam != null ? Integer.parseInt(hotelIdParam) : null;

        List<room> roomList = new ArrayList<>();

        if (hotel_id != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room WHERE hotel_id = ?");
                preparedStatement.setInt(1, hotel_id);

                ResultSet rs = preparedStatement.executeQuery();

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

                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("roomList", roomList);
        request.getRequestDispatcher("/employee/rooms.jsp").forward(request, response);
    }
}