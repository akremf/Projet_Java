<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modele.Fermier" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des fermiers</title>
    <style>
        table {
            border-collapse: collapse;
            width: 90%;
            margin: auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f8f8f8;
        }
        a.button {
            padding: 6px 12px;
            margin: 2px;
            text-decoration: none;
            color: white;
            border-radius: 4px;
        }
        .edit { background-color: #2980b9; }
        .delete { background-color: #c0392b; }
        .add { background-color: #27ae60; display: inline-block; margin: 20px; }
    </style>
</head>
<body>

<h2 style="text-align: center;">Liste des fermiers</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <%
        List<Fermier> fermiers = (List<Fermier>) request.getAttribute("fermiers");
        if (fermiers != null && !fermiers.isEmpty()) {
            for (Fermier f : fermiers) {
    %>
    <tr>
        <td><%= f.getId() %></td>
        <td><%= f.getNom() %></td>
        <td><%= f.getEmail() %></td>
        <td>
            <a class="button edit" href="<%= request.getContextPath() %>/jsp/updateFermier.jsp?id=<%= f.getId() %>">Modifier</a>
            <a class="button delete" href="<%= request.getContextPath() %>/fermier?action=delete&id=<%= f.getId() %>"
               onclick="return confirm('Supprimer ce fermier ?');">Supprimer</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="4">Aucun fermier trouvé.</td>
    </tr>
    <%
        }
    %>
</table>

<div style="text-align: center;">
    <a class="button add" href="<%= request.getContextPath() %>/jsp/createFermier.jsp">➕ Ajouter un nouveau fermier</a>
</div>

</body>
</html>
