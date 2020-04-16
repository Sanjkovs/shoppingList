package com.javaguru.shoppinglist.web;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String param = request.getParameter("username");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + "Hello, World from JAVA!" + "/h1");
        out.println("<h1>" + "param-username" + param + "/h1");


    }

}
