package servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.hotel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/SearchHotel"})
public class SearchHotel extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // retrieve property and value parameters from user request
        String value = request.getParameter("value");
        String property
                = request.getParameter("property");

        // create SQL statement based on the provided property and value
        String sql = "SELECT * FROM Hotel WHERE ";

        switch (property) {
            case "id":
                sql += "hotel_id = "+value;
                break;
            case "chain":
                sql += "hotel_chain LIKE "+"'"+value+"'";
                break;
            case "address":
                sql += "hotel_address LIKE "+"'"+value+"'";
                break;
            case "categorize1":
                sql += "category LIKE "+"'"+value+"'";
                break;
            case "email":
                sql += "email LIKE "+"'"+value+"'";
                break;
            case "phone":
                sql += "phone LIKE "+"'"+value+"'";
                break;
            case "numRooms":
                sql += "num_rooms = "+value;
                break;
            default:
                throw new IllegalArgumentException("Invalid property: " + property);
        }


        // create a list to store the hotels returned by the SQL query
        List<hotel> hotels = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // establish connection with the database and execute the SQL query
            conn = getConnection();
            stmt = conn.createStatement();
            System.out.println(sql);
            rs = stmt.executeQuery(sql);

            // iterate through the result set and add the hotels to the list
            while (rs.next()) {
                hotel hotel = new hotel();
                hotel.setId(rs.getInt("hotel_id"));
                hotel.setChain(rs.getString("hotel_chain"));
                hotel.setAddress(rs.getString("hotel_address"));
                hotel.setCategory(rs.getString("categorize1"));
                hotel.setEmail(rs.getString("email"));
                hotel.setPhone(rs.getString("phone"));
                hotel.setNumRooms(rs.getInt("num_rooms"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // close the database connection, statement and result set
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // set the retrieved hotels as an attribute of the user request and forward the request to a JSP page for displaying the results
        request.setAttribute("hotels", hotels);
        request.setAttribute("property", property);
        request.setAttribute("value", value);
        request.getRequestDispatcher("/customer/result.jsp").forward(request, response);
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }
}