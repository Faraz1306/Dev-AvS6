package com.example.servlet;

import com.example.dao.AnnonceDAO;
import com.example.model.Annonce;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/AnnonceUpdate")
public class AnnonceUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération du paramètre "id" dans l'URL
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                AnnonceDAO annonceDAO = new AnnonceDAO();
                Annonce annonce = annonceDAO.read(id);
                if (annonce != null) {
                    // Passage de l'annonce à la JSP pour pré-remplir le formulaire
                    request.setAttribute("annonce", annonce);
                    request.getRequestDispatcher("AnnonceUpdate.jsp").forward(request, response);
                    return;
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                throw new ServletException(e);
            }
        }
        // Si l'id n'est pas fourni ou invalide, rediriger vers la liste
        response.sendRedirect("AnnonceList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String idStr = request.getParameter("id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String adress = request.getParameter("adress");
        String mail = request.getParameter("mail");

        // Validation de base : tous les champs doivent être remplis
        if (idStr == null || title == null || description == null || adress == null || mail == null ||
                title.trim().isEmpty() || description.trim().isEmpty() || adress.trim().isEmpty() || mail.trim().isEmpty()) {
            request.setAttribute("error", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("AnnonceUpdate.jsp").forward(request, response);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            AnnonceDAO annonceDAO = new AnnonceDAO();
            // Création de l'objet Annonce avec la date courante
            Annonce annonce = new Annonce(id, title, description, adress, mail, new Timestamp(new Date().getTime()));
            boolean success = annonceDAO.update(annonce);
            if (success) {
                // Redirection vers la liste si la mise à jour est réussie
                response.sendRedirect("AnnonceList");
            } else {
                request.setAttribute("error", "Erreur lors de la mise à jour de l'annonce.");
                request.getRequestDispatcher("AnnonceUpdate.jsp").forward(request, response);
            }
        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
}
