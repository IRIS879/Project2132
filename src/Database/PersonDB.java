package Database;

import entity.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PersonDB extends MainDatabase {
    Statement statement = null;
    ResultSet resultSet = null;

    public Person getPersonByName(String name) {
        Person person = null;

        try {

            statement = conn.createStatement();
            String sql = "select * from person where name = '" + name + "'";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String address = resultSet.getString(2);
                String sin = resultSet.getString(3);
                Date registration_date = resultSet.getDate(4);
                String pwd = resultSet.getString(5);
                person = new Person(name, address,sin,registration_date,pwd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;

    }

    public void savePerson(Person person) {
        try {
            String sql = "INSERT INTO person(name, address, sin, registration_date, password) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getAddress());
            ps.setString(3, person.getSin());
            ps.setDate(4, new java.sql.Date(person.getRegistrationDate().getTime()));
            ps.setString(5, person.getPwd());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeAll() {
        try{
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
