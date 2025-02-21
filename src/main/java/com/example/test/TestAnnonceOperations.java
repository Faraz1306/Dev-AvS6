package com.example.test;

import com.example.db.ConnectionDB;
import java.sql.*;

public class TestAnnonceOperations {
    public static void main(String[] args) {
        try {
            // Obtention de la connexion
            Connection connection = ConnectionDB.getInstance();

            // --- INSERT : Ajout d'une nouvelle annonce ---
            String insertSql = "INSERT INTO annonce (title, description, adress, mail, date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psInsert = connection.prepareStatement(insertSql);
            psInsert.setString(1, "Titre Test");
            psInsert.setString(2, "Description Test");
            psInsert.setString(3, "Adresse Test");
            psInsert.setString(4, "email@test.com");
            psInsert.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            int rowsInserted = psInsert.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);

            // --- UPDATE : Mise à jour de l'annonce ajoutée ---
            String updateSql = "UPDATE annonce SET title = ? WHERE title = ?";
            PreparedStatement psUpdate = connection.prepareStatement(updateSql);
            psUpdate.setString(1, "Titre Modifié");
            psUpdate.setString(2, "Titre Test");
            int rowsUpdated = psUpdate.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);

            // --- DELETE : Suppression de l'annonce modifiée ---
            String deleteSql = "DELETE FROM annonce WHERE title = ?";
            PreparedStatement psDelete = connection.prepareStatement(deleteSql);
            psDelete.setString(1, "Titre Modifié");
            int rowsDeleted = psDelete.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);

            // Fermeture des statements (la connexion sera fermée lors de l'arrêt de l'application)
            psInsert.close();
            psUpdate.close();
            psDelete.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
