package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Définition du type de contenu et de l'encodage
        response.setContentType("text/html;charset=UTF-8");

        // Envoi de la réponse HTML
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Hello World</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Hello the world</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
