<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="modele.Fermier" %>
<%@ page import="dao.FermierDAO" %>
<%@ page import="utils.DBConnection" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    FermierDAO dao = new FermierDAO(DBConnection.getConnection());
    Fermier f = dao.getFermier(id);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un fermier</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        form {
            width: 300px;
        }
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 8px;
            margin: 6px 0;
        }
        input[type="submit"] {
            padding: 10px 16px;
            background-color: #e67e22;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h2>Modifier le fermier</h2>

<form action="<%= request.getContextPath() %>/fermier" method="post">
    <input type="hidden" name="id" value="<%= f.getId() %>">

    <label for="nom">Nom :</label>
    <input type="text" name="nom" id="nom" value="<%= f.getNom() %>" required>

    <label for="email">Email :</label>
    <input type="email" name="email" id="email" value="<%= f.getEmail() %>" required>

    <input type="submit" value="Mettre à jour">
</form>

</body>
</html>