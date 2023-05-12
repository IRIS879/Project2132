package servlet;

import entity.Rent;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/RentingServlet")
public class RentingServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String sin = request.getParameter("sin");
        String rental_date = request.getParameter("rental_date");
        int nights = 0;
        int room_id = 0;
        int hotel_Id=0;
        try {
            nights = Integer.parseInt(Optional.ofNullable(request.getParameter("nights")).orElse("0"));
            room_id = Integer.parseInt(Optional.ofNullable(request.getParameter("room_id")).orElse("0"));
            hotel_Id = Integer.parseInt(Optional.ofNullable(request.getParameter("hotel_id")).orElse("0"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        // Save data to MySQL database
        saveRent(name, sin, rental_date, nights, room_id, hotel_Id);

        // Get all rents for the given SIN
        List<Rent> rents = getRentsByHotelId(hotel_Id);

        // Redirect to rent confirmation page with all rents
        request.setAttribute("rents", rents);
        request.getRequestDispatcher("/employee/ViewRenting.jsp").forward(request, response);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    private void saveRent(String name, String sin, String rental_date, int nights, int room_id, int hotel_Id) {
        String sql = "INSERT INTO Rent (customer_name, sin_number, room_id, rental_date, nights, hotel_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, sin);
            stmt.setInt(3, room_id);
            stmt.setString(4, rental_date);
            stmt.setInt(5, nights);
            stmt.setInt(6, hotel_Id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Rent> getRentsByHotelId(int hotelId) {
        List<Rent> rents = new ArrayList<>();
        String sql = "SELECT * FROM Rent WHERE hotel_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, hotelId);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int rentId = resultSet.getInt("rentId");
                String customer_name = resultSet.getString("customer_name");
                String sin = resultSet.getString("sin_number");
                int room_id = resultSet.getInt("room_id");
                Date rental_date = Date.valueOf(resultSet.getString("rental_date"));
                int nights = resultSet.getInt("nights");
                System.out.println(room_id);
                Rent rent = new entity.Rent(rentId, customer_name, sin, room_id, rental_date, nights, hotelId);
                rents.add(rent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rents;
    }
}