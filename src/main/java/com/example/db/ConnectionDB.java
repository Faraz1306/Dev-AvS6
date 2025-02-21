package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    // URL de connexion à PostgreSQL (adapter le port ou les identifiants si nécessaire)
    private String url = "jdbc:postgresql://localhost:5432/MasterAnnonce";
    private String user = "fsiddiqui";
    private String passwd = "2002";

    // Instance unique de la connexion
    private static Connection connect;

    // Constructeur privé pour empêcher l'instanciation directe
    private ConnectionDB() throws ClassNotFoundException {
        try {
            // Chargement du driver PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Établissement de la connexion
            connect = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour obtenir l'instance de connexion
    public static Connection getInstance() throws ClassNotFoundException {
        if (connect == null) {
            new ConnectionDB();
        }
        return connect;
    }
}
