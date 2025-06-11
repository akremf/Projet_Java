package dao;


import java.sql.*;
import java.util.*;

import modele.Ferme;



public class FermeDAO {
    private Connection con;

    public FermeDAO(Connection con) {
        this.con = con;
    }

    public void addFerme(Ferme f) throws SQLException {
        String sql = "INSERT INTO ferme (nom, localisation, idFermier) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, f.getNom());
        ps.setString(2, f.getLocalisation());
        ps.setInt(3, f.getIdFermier());
        ps.executeUpdate();
    }

    public List<Ferme> getAllFermes() throws SQLException {
        List<Ferme> list = new ArrayList<>();
        String sql = "SELECT * FROM ferme";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Ferme f = new Ferme(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("localisation"),
                rs.getInt("idFermier")
            );
            list.add(f);
        }
        return list;
    }

    public Ferme getFermeById(int id) throws SQLException {
        String sql = "SELECT * FROM ferme WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Ferme(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("localisation"),
                rs.getInt("idFermier")
            );
        }
        return null;
    }

    public void updateFerme(Ferme f) throws SQLException {
        String sql = "UPDATE ferme SET nom = ?, localisation = ?, idFermier = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, f.getNom());
        ps.setString(2, f.getLocalisation());
        ps.setInt(3, f.getIdFermier());
        ps.setInt(4, f.getId());
        ps.executeUpdate();
    }

    public void deleteFerme(int id) throws SQLException {
        String sql = "DELETE FROM ferme WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
