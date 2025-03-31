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
        // Affiche le formulaire via la JSP (qui inclut le bouton Retour)
        request.getRequestDispatcher("helloForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération du paramètre "name"
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");

        // Génération de la réponse HTML avec bouton Retour
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Résultat</title>");
        response.getWriter().println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body class='container mt-4'>");
        response.getWriter().println("<h1>Hello the world " + name + "</h1>");
        response.getWriter().println("<div class='mt-3'>");
        response.getWriter().println("<a href='index.jsp' class='btn btn-secondary'>Retour à l'accueil</a>");
        response.getWriter().println("</div>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
