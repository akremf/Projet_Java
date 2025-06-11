<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="dao.FermeDAO, modele.Ferme, utils.DBConnection" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Ferme ferme = new FermeDAO(DBConnection.getConnection()).getFermeById(id);
%>
<form action="<%= request.getContextPath() %>/ferme" method="post">
    <input type="hidden" name="id" value="<%= ferme.getId() %>">
    <label>Nom :</label>
    <input type="text" name="nom" value="<%= ferme.getNom() %>" required>

    <label>Localisation :</label>
    <input type="text" name="localisation" value="<%= ferme.getLocalisation() %>" required>

    <label>ID Fermier :</label>
    <input type="number" name="idFermier" value="<%= ferme.getIdFermier() %>" required>

    <input type="submit" value="Modifier">
</form>


</body>
</html>