package com.example.servlet;

import com.example.dao.AnnonceDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AnnonceDelete")
public class AnnonceDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération du paramètre "id" dans l'URL
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                AnnonceDAO annonceDAO = new AnnonceDAO();
                // Suppression de l'annonce correspondante
                annonceDAO.delete(id);
            } catch (NumberFormatException e) {
                throw new ServletException(e);
            }
        }
        // Redirection vers la liste après la suppression
        response.sendRedirect("AnnonceList");
    }
}
