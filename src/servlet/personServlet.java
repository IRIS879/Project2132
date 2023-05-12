package servlet;

import Database.PersonDB;
import entity.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/person", "/demo"})
public class personServlet extends HttpServlet {
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
       Person person = personDB.getPersonByName(name);
       if(person == null || !person.getPwd().equals(pwd)){
           System.out.println("Error");
       }else {
           req.setAttribute("name", name);
           req.getRequestDispatcher("/customer/customerHome.jsp").forward(req,resp);
       }
    }

    @Override
    public void destroy() {
        personDB.closeAll();
    }
}
