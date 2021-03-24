package me.danieltujo.BleacherTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import me.danieltujo.MongoInstance.Mongo;

@WebServlet(name = "ViewDataServlet", value = "/ViewDataServlet")
public class ViewDataServlet extends HttpServlet {
    Object Message;

    public void init() {
        Message = Mongo.getInstance().test.find().first();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + Message + "</h1>");
        out.println("<body></html>");
        System.out.println(Message);
    }
}
