package servlets;

import dao.Dao;
import dao.UserMySql;
import entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Dao dao = new UserMySql();
            User addUser = new User(
                    req.getParameter("name"),
                    Integer.parseInt(req.getParameter("age"))
            );
            dao.insert(addUser);
            req.setAttribute("users", dao.getAll());
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        }catch (Exception ex){
            PrintWriter writer = resp.getWriter();
            writer.write(ex.getMessage());
        }
    }
}
