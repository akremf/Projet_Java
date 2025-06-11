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
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FermeDAO dao;

    public void init() {
        try {
            dao = new FermeDAO(DBConnection.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteFerme(id);
                response.sendRedirect(request.getContextPath() + "/ferme");
                return;
            }

            List<Ferme> fermes = dao.getAllFermes();
            request.setAttribute("fermes", fermes);
            request.getRequestDispatcher("jsp/listFermes.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Erreur GET ferme");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nom = request.getParameter("nom");
        String localisation = request.getParameter("localisation");
        int idFermier = Integer.parseInt(request.getParameter("idFermier"));

        try {
            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                dao.updateFerme(new Ferme(id, nom, localisation, idFermier));
            } else {
                dao.addFerme(new Ferme(0, nom, localisation, idFermier));
            }
            response.sendRedirect(request.getContextPath() + "/ferme");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Erreur POST ferme");
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
