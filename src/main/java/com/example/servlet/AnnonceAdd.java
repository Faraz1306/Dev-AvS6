package com.example.servlet;

import com.example.dao.AnnonceDAO;
import com.example.model.Annonce;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/AnnonceAdd")
public class AnnonceAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Affiche le formulaire de saisie d'annonce
        request.getRequestDispatcher("AnnonceAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String adress = request.getParameter("adress");
        String mail = request.getParameter("mail");

        // Validation : tous les champs doivent être remplis
        if(title == null || title.trim().isEmpty() ||
                description == null || description.trim().isEmpty() ||
                adress == null || adress.trim().isEmpty() ||
                mail == null || mail.trim().isEmpty()){
            request.setAttribute("error", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("AnnonceAdd.jsp").forward(request, response);
            return;
        }

        // Création de l'objet Annonce avec la date courante
        Annonce annonce = new Annonce(title, description, adress, mail, new Timestamp(new Date().getTime()));
        try {
            AnnonceDAO annonceDAO = new AnnonceDAO();
            boolean success = annonceDAO.create(annonce);
            if(success){
                // Rediriger vers la liste des annonces
                response.sendRedirect("AnnonceList");
            } else {
                request.setAttribute("error", "Erreur lors de l'ajout de l'annonce.");
                request.getRequestDispatcher("AnnonceAdd.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException(e);
        }
    }
}
