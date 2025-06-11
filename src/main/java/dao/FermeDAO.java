package dao;


import java.sql.*;
import java.util.*;

import modele.Ferme;

public class FermeDAO {
 private Connection con;

 public FermeDAO(Connection con) {
     this.con = con;
 }

 // Ajouter une ferme
 public void addFerme(Ferme f) throws SQLException {
     String sql = "INSERT INTO ferme (nom, localisation, idFermier) VALUES (?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, f.getNom());
     ps.setString(2, f.getLocalisation());
     ps.setInt(3, f.getIdFermier());
     ps.executeUpdate();
 }

 // Obtenir une ferme par ID
 public Ferme getFerme(int id) throws SQLException {
     String sql = "SELECT * FROM ferme WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if (rs.next()) {
         Ferme f = new Ferme(id, sql, sql, id);
         f.setId(rs.getInt("id"));
         f.setNom(rs.getString("nom"));
         f.setLocalisation(rs.getString("localisation"));
         f.setIdFermier(rs.getInt("idFermier"));
         return f;
     }
     return null;
 }

 // Modifier une ferme
 public void updateFerme(Ferme f) throws SQLException {
     String sql = "UPDATE ferme SET nom = ?, localisation = ?, idFermier = ? WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, f.getNom());
     ps.setString(2, f.getLocalisation());
     ps.setInt(3, f.getIdFermier());
     ps.setInt(4, f.getId());
     ps.executeUpdate();
 }

 // Supprimer une ferme
 public void deleteFerme(int id) throws SQLException {
     String sql = "DELETE FROM ferme WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ps.executeUpdate();
 }

 // Lister toutes les fermes
 public List<Ferme> getAllFermes() throws SQLException {
     List<Ferme> list = new ArrayList<>();
     String sql = "SELECT * FROM ferme";
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery(sql);
     while (rs.next()) {
         Ferme f = new Ferme(0, sql, sql, 0);
         f.setId(rs.getInt("id"));
         f.setNom(rs.getString("nom"));
         f.setLocalisation(rs.getString("localisation"));
         f.setIdFermier(rs.getInt("idFermier"));
         list.add(f);
     }
     return list;
 }
}

