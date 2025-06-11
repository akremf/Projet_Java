package dao;


import java.sql.*;
import java.util.*;

import modele.SiteApiculture;

public class SiteApicultureDAO {
 private Connection con;

 public SiteApicultureDAO(Connection con) {
     this.con = con;
 }

 // Ajouter un site
 public void addSite(SiteApiculture s) throws SQLException {
     String sql = "INSERT INTO site_apiculture (latitude, longitude, altitude, dateMiseEnService, idFerme) VALUES (?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setDouble(1, s.getLatitude());
     ps.setDouble(2, s.getLongitude());
     ps.setDouble(3, s.getAltitude());
     ps.setString(4, s.getDateMiseEnService());
     ps.setInt(5, s.getIdFerme());
     ps.executeUpdate();
 }

 // Obtenir un site par ID
 public SiteApiculture getSite(int id) throws SQLException {
     String sql = "SELECT * FROM site_apiculture WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     if (rs.next()) {
         SiteApiculture s = new SiteApiculture(id, id, id, id, sql, id);
         s.setId(rs.getInt("id"));
         s.setLatitude(rs.getDouble("latitude"));
         s.setLongitude(rs.getDouble("longitude"));
         s.setAltitude(rs.getDouble("altitude"));
         s.setDateMiseEnService(rs.getString("dateMiseEnService"));
         s.setIdFerme(rs.getInt("idFerme"));
         return s;
     }
     return null;
 }

 // Modifier un site
 public void updateSite(SiteApiculture s) throws SQLException {
     String sql = "UPDATE site_apiculture SET latitude = ?, longitude = ?, altitude = ?, dateMiseEnService = ?, idFerme = ? WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setDouble(1, s.getLatitude());
     ps.setDouble(2, s.getLongitude());
     ps.setDouble(3, s.getAltitude());
     ps.setString(4, s.getDateMiseEnService());
     ps.setInt(5, s.getIdFerme());
     ps.setInt(6, s.getId());
     ps.executeUpdate();
 }

 // Supprimer un site
 public void deleteSite(int id) throws SQLException {
     String sql = "DELETE FROM site_apiculture WHERE id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, id);
     ps.executeUpdate();
 }

 // Lister tous les sites
 public List<SiteApiculture> getAllSites() throws SQLException {
     List<SiteApiculture> list = new ArrayList<>();
     String sql = "SELECT * FROM site_apiculture";
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery(sql);
     while (rs.next()) {
         SiteApiculture s = new SiteApiculture(0, 0, 0, 0, sql, 0);
         s.setId(rs.getInt("id"));
         s.setLatitude(rs.getDouble("latitude"));
         s.setLongitude(rs.getDouble("longitude"));
         s.setAltitude(rs.getDouble("altitude"));
         s.setDateMiseEnService(rs.getString("dateMiseEnService"));
         s.setIdFerme(rs.getInt("idFerme"));
         list.add(s);
     }
     return list;
 }
}
