<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un fermier</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }
        h2 {
            color: #2c3e50;
        }
        form {
            width: 300px;
        }
        input[type="text"],
        input[type="email"] {
            width: 100%;
            padding: 8px;
            margin: 6px 0;
        }
        input[type="submit"] {
            padding: 10px 16px;
            background-color: #27ae60;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #219150;
        }
    </style>
</head>
<body>

    <h2>Ajouter un nouveau fermier</h2>

    <form action="<%= request.getContextPath() %>/fermier" method="post">
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" required>

        <label for="email">Email :</label>
        <input type="email" name="email" id="email" required>

        <input type="submit" value="Ajouter">
    </form>

    <br>
    <a href="<%= request.getContextPath() %>/fermier">↩ Retour à la liste des fermiers</a>

</body>
</html>
