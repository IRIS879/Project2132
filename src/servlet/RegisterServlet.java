package servlet;

import Database.PersonDB;
import entity.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private PersonDB personDB;

    @Override
    public void init() throws ServletException {
        personDB = new PersonDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String address = req.getParameter("address");
        String sin = req.getParameter("sin");
        String dateString = req.getParameter("registration_date");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date registration_date = null;
        try {
            registration_date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Person person1 = new Person(name,address,sin,registration_date,pwd);
        personDB.savePerson(person1);
        resp.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        personDB.closeAll();
    }
}