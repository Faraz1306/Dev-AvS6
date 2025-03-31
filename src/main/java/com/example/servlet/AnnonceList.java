package com.example.servlet;

import com.example.dao.AnnonceDAO;
import com.example.model.Annonce;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AnnonceList")
public class AnnonceList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AnnonceDAO annonceDAO = new AnnonceDAO();
            List<Annonce> annonces = annonceDAO.list();
            request.setAttribute("annonces", annonces);
            request.getRequestDispatcher("AnnonceList.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
