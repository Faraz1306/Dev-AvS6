package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/helloName")
public class HelloNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Affichage du formulaire
        request.getRequestDispatcher("helloForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération du paramètre "name" envoyé par le formulaire
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");

        // Construction de la réponse HTML avec le message personnalisé
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Résultat</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Hello the world " + name + "</h1>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
