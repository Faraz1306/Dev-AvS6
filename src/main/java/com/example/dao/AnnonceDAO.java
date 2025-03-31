package com.example.dao;

import com.example.model.Annonce;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAO extends DAO<Annonce> {

    public AnnonceDAO() throws ClassNotFoundException {
        super();
    }

    @Override
    public boolean create(Annonce annonce) throws SQLException {
        String sql = "INSERT INTO annonce (title, description, adress, mail, date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, annonce.getTitle());
        ps.setString(2, annonce.getDescription());
        ps.setString(3, annonce.getAdress());
        ps.setString(4, annonce.getMail());
        ps.setTimestamp(5, annonce.getDate());
        int result = ps.executeUpdate();
        ps.close();
        return result > 0;
    }

    @Override
    public Annonce read(int id) throws SQLException {
        String sql = "SELECT * FROM annonce WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Annonce annonce = null;
        if(rs.next()){
            annonce = new Annonce(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("adress"),
                    rs.getString("mail"),
                    rs.getTimestamp("date")
            );
        }
        rs.close();
        ps.close();
        return annonce;
    }

    @Override
    public boolean update(Annonce annonce) throws SQLException {
        String sql = "UPDATE annonce SET title=?, description=?, adress=?, mail=?, date=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, annonce.getTitle());
        ps.setString(2, annonce.getDescription());
        ps.setString(3, annonce.getAdress());
        ps.setString(4, annonce.getMail());
        ps.setTimestamp(5, annonce.getDate());
        ps.setInt(6, annonce.getId());
        int result = ps.executeUpdate();
        ps.close();
        return result > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM annonce WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        ps.close();
        return result > 0;
    }

    public List<Annonce> list() throws SQLException {
        List<Annonce> annonces = new ArrayList<>();
        String sql = "SELECT * FROM annonce";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Annonce annonce = new Annonce(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("adress"),
                    rs.getString("mail"),
                    rs.getTimestamp("date")
            );
            annonces.add(annonce);
        }
        rs.close();
        stmt.close();
        return annonces;
    }
}
