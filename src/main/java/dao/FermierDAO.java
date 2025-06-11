package dao;


import java.sql.*;
import java.util.*;

import modele.Fermier;

public class FermierDAO {
 private Connection con;

 	public FermierDAO(Connection con) {
 		this.con = con;
 		}

 // Ajouter un fermier
 	public void addFermier(Fermier f) throws SQLException {
 		String sql = "INSERT INTO fermier (nom, email) VALUES (?, ?)";
 		PreparedStatement ps = con.prepareStatement(sql);
 		ps.setString(1, f.getNom());
 		ps.setString(2, f.getEmail());
 		ps.executeUpdate();
 	}

 // Obtenir un fermier par ID
 public Fermier getFermier(int id) throws SQLException {
     String sql = "SELECT * FROM fermier WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if (rs.next()) {
         Fermier f = new Fermier(id, sql, sql);
         f.setId(rs.getInt("id"));
         f.setNom(rs.getString("nom"));
         f.setEmail(rs.getString("email"));
         return f;
     }
     return null;
 }

 // Modifier un fermier
 public void updateFermier(Fermier f) throws SQLException {
     String sql = "UPDATE fermier SET nom = ?, email = ? WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, f.getNom());
     ps.setString(2, f.getEmail());
     ps.setInt(3, f.getId());
     ps.executeUpdate();
 }

 // Supprimer un fermier
 public void deleteFermier(int id) throws SQLException {
     String sql = "DELETE FROM fermier WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ps.executeUpdate();
 }

 // Lister tous les fermiers
 public List<Fermier> getAllFermiers() throws SQLException {
     List<Fermier> list = new ArrayList<>();
     String sql = "SELECT * FROM fermier";
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery(sql);
     while (rs.next()) {
         Fermier f = new Fermier(0, sql, sql);
         f.setId(rs.getInt("id"));
         f.setNom(rs.getString("nom"));
         f.setEmail(rs.getString("email"));
         list.add(f);
     }
     return list;
 }
}

