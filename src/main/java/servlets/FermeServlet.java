package servlets;

import dao.FermeDAO;
import modele.Ferme;
import utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/ferme")
public class FermeServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
	private FermeDAO dao;

    @Override
    public void init() {
        try {
            Connection con = DBConnection.getConnection();
            dao = new FermeDAO(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ajouter une ferme
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String localisation = request.getParameter("localisation");
        int idFermier = Integer.parseInt(request.getParameter("idFermier"));

        Ferme f = new Ferme(idFermier, localisation, localisation, idFermier);
        f.setNom(nom);
        f.setLocalisation(localisation);
        f.setIdFermier(idFermier);

        try {
            dao.addFerme(f);
            response.sendRedirect("listFermes.jsp"); 
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de l'ajout de la ferme.");
            e.printStackTrace();
        }
    }

    // Lister toutes les fermes
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Ferme> fermes = dao.getAllFermes();
            request.setAttribute("fermes", fermes);
            request.getRequestDispatcher("listFermes.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de la récupération des fermes.");
            e.printStackTrace();
        }
    }

    // Modifier une ferme
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String localisation = request.getParameter("localisation");
            int idFermier = Integer.parseInt(request.getParameter("idFermier"));

            Ferme f = new Ferme(id, nom, localisation, idFermier);
            dao.updateFerme(f);
            response.getWriter().write("Ferme mise à jour avec succès.");
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de la mise à jour.");
            e.printStackTrace();
        }
    }

    // Supprimer une ferme
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.deleteFerme(id);
            response.getWriter().write("Ferme supprimée avec succès.");
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de la suppression.");
            e.printStackTrace();
        }
    }
}
