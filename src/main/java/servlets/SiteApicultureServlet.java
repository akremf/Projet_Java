// --- Fichier Java : SiteApicultureServlet.java ---
package servlets;

import dao.SiteApicultureDAO;
import modele.SiteApiculture;
import utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/site")
public class SiteApicultureServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SiteApicultureDAO dao;

    @Override
    public void init() {
        try {
            Connection con = DBConnection.getConnection();
            dao = new SiteApicultureDAO(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ajouter un site
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            double altitude = Double.parseDouble(request.getParameter("altitude"));
            String date = request.getParameter("dateMiseEnService");
            int idFerme = Integer.parseInt(request.getParameter("idFerme"));

            SiteApiculture site = new SiteApiculture(idFerme, altitude, altitude, altitude, date, idFerme);
            site.setLatitude(latitude);
            site.setLongitude(longitude);
            site.setAltitude(altitude);
            site.setDateMiseEnService(date);
            site.setIdFerme(idFerme);

            dao.addSite(site);
            response.sendRedirect("listSites.jsp");
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de l'ajout du site.");
            e.printStackTrace();
        }
    }

    // Lister les sites
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<SiteApiculture> sites = dao.getAllSites();
            request.setAttribute("sites", sites);
            request.getRequestDispatcher("listSites.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de la récupération des sites.");
            e.printStackTrace();
        }
    }

    // Mettre à jour un site
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            double latitude = Double.parseDouble(request.getParameter("latitude"));
            double longitude = Double.parseDouble(request.getParameter("longitude"));
            double altitude = Double.parseDouble(request.getParameter("altitude"));
            String date = request.getParameter("dateMiseEnService");
            int idFerme = Integer.parseInt(request.getParameter("idFerme"));

            SiteApiculture site = new SiteApiculture(id, latitude, longitude, altitude, date, idFerme);
            dao.updateSite(site);
            response.getWriter().write("Site mis à jour avec succès.");
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de la mise à jour.");
            e.printStackTrace();
        }
    }

    // Supprimer un site
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteSite(id);
            response.getWriter().write("Site supprimé avec succès.");
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de la suppression.");
            e.printStackTrace();
        }
    }
}
