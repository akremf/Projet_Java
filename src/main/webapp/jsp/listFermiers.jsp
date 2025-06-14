<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, modele.Fermier" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des fermiers</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f7f9;
            padding: 30px;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        table {
            width: 90%;
            margin: 30px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 12px;
            border: 1px solid #dee2e6;
            text-align: center;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .actions a {
            text-decoration: none;
            padding: 6px 12px;
            margin: 0 3px;
            border-radius: 5px;
            color: white;
            font-size: 14px;
        }
        .edit-btn {
            background-color: #2980b9;
        }
        .delete-btn {
            background-color: #c0392b;
        }
        .add-btn {
            display: inline-block;
            text-align: center;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #27ae60;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }
    </style>
</head>
<body>

<h2>Liste des fermiers</h2>

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
        <td class="actions">
            <a class="edit-btn" href="<%= request.getContextPath() %>/jsp/updateFermier.jsp?id=<%= f.getId() %>">Modifier</a>
            <a class="delete-btn" href="<%= request.getContextPath() %>/fermier?action=delete&id=<%= f.getId() %>"
               onclick="return confirm('Supprimer ce fermier ?');">Supprimer</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="4">Aucun fermier enregistré.</td>
    </tr>
    <% } %>
</table>

<div style="text-align: center;">
    <a class="add-btn" href="<%= request.getContextPath() %>/jsp/createFermier.jsp">➕ Ajouter un nouveau fermier</a>
</div>

</body>
</html>
