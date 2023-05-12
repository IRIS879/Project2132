package servlet;

import entity.Book;
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

@WebServlet ("/BookingServlet")
public class BookingServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String sin = request.getParameter("sin");
        String booking_date = request.getParameter("booking_date");
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
        saveBooking(name, sin, booking_date, nights, room_id, hotel_Id);

        // Get all bookings for the given SIN
        List<Book> bookings = getBookingsBySin(sin);

        // Redirect to booking confirmation page with all bookings
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/customer/ViewBooking.jsp").forward(request, response);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    private void saveBooking(String name, String sin, String booking_date, int nights, int room_id,int hotel_Id) {
        String sql = "INSERT INTO Book (customer_name, sin_number, room_id, booking_date, nights, hotel_id) VALUES (?, ?, ?, ?, ?,?)";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, sin);
            stmt.setInt(3, room_id);
            stmt.setString(4, booking_date);
            stmt.setInt(5, nights);
            stmt.setInt(6, hotel_Id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Book> getBookingsBySin(String sin) {
        List<Book> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE sin_number = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, sin);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int bookid = resultSet.getInt("bookid");
                String customer_name = resultSet.getString("customer_name");
                int room_id = resultSet.getInt("room_id");
                Date booking_date = Date.valueOf(resultSet.getString("booking_date"));
                int nights = resultSet.getInt("nights");
                int hotelID = resultSet.getInt("hotel_id");
                System.out.println(room_id);
                Book book = new entity.Book(bookid, customer_name, sin, room_id, booking_date, nights, hotelID);
                bookings.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}
