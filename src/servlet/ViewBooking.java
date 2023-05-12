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

@WebServlet ("/ViewBooking")
public class ViewBooking extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/project";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);
        List<Book> bookings = getBookingsByName(name);

        // Redirect to booking confirmation page with all bookings
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/customer/ViewBooking.jsp").forward(request, response);
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    private List<Book> getBookingsByName(String name) {
        List<Book> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Book WHERE customer_name = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int bookid = resultSet.getInt("bookid");
                String customer_name = resultSet.getString("customer_name");
                String sin = resultSet.getString("sin_number");
                int room_id = resultSet.getInt("room_id");
                Date booking_date = Date.valueOf(resultSet.getString("booking_date"));
                int nights = resultSet.getInt("nights");
                int hotelID = resultSet.getInt("hotel_id");
                Book book = new Book(bookid, customer_name, sin, room_id, booking_date, nights, hotelID);
                bookings.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookings;
    }
}