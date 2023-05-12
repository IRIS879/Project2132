package Database;

import java.sql.*;

public class MainDatabase {

    private final String url = "jdbc:mysql://localhost:3306/project";
    private String username = "root";
    private String password = "123456";

    protected Connection conn;
    private Statement statement;
    private ResultSet resultSet;
    public MainDatabase() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
;
    }

    public void closeAll(){
        try{
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}