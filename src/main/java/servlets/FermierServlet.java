package servlets;

import dao.FermierDAO;
import modele.Fermier;
import utils.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(urlPatterns = "/fermier")
public class FermierServlet extends HttpServlet {
private static final long serialVersionUID = 1L;


private FermierDAO dao;

 @Override
 public void init() {
     try {
         Connection con = DBConnection.getConnection();
         dao = new FermierDAO(con);
     } catch (Exception e) {
         e.printStackTrace();
     }
 }


 
 // Ajouter un fermier
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     String nom = request.getParameter("nom");
     String email = request.getParameter("email");

     Fermier f = new Fermier(0, email, email);
     f.setNom(nom);
     f.setEmail(email);

     try {
         dao.addFermier(f);
         response.sendRedirect(request.getContextPath() + "/fermier"); 
     } catch (Exception e) {
         response.getWriter().write("Erreur lors de l'ajout du fermier.");
         e.printStackTrace();
     }
 }

 // Afficher tous les fermiers
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	 try {
	        String action = request.getParameter("action");
	        if ("delete".equals(action)) {
	            int id = Integer.parseInt(request.getParameter("id"));
	            dao.deleteFermier(id);
	            response.sendRedirect(request.getContextPath() + "/fermier");
	            return;
	        }

	        List<Fermier> fermiers = dao.getAllFermiers();
	        request.setAttribute("fermiers", fermiers);
	        request.getRequestDispatcher("jsp/listFermiers.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().write("Erreur lors du traitement.");
	    }
	}


 // Supprimer un fermier
 @Override
 protected void doDelete(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     try {
         int id = Integer.parseInt(request.getParameter("id"));
         dao.deleteFermier(id);
         response.getWriter().write("Fermier supprimé avec succès.");
     } catch (Exception e) {
         response.getWriter().write("Erreur lors de la suppression.");
         e.printStackTrace();
     }
 }
 
 
 

 // Modifier un fermier
 @Override
 protected void doPut(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
	 String idStr = request.getParameter("id");
	    String nom = request.getParameter("nom");
	    String email = request.getParameter("email");

	    try {
	        if (idStr != null && !idStr.isEmpty()) {
	            
	            int id = Integer.parseInt(idStr);
	            Fermier f = new Fermier(id, nom, email);
	            dao.updateFermier(f);
	        } else {
	            
	            Fermier f = new Fermier(0, email, email);
	            f.setNom(nom);
	            f.setEmail(email);
	            dao.addFermier(f);
	        }

	        
	        response.sendRedirect(request.getContextPath() + "/fermier");

	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().write("Erreur lors du traitement.");
	    }
	}
}

